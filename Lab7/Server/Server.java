package Server;

import CollectionObjects.Objects.Organization;
import CollectionObjects.Request;
import CollectionObjects.Response;
import CollectionObjects.Status;
import CollectionObjects.User;
import Server.CommandsProcessing.CommandHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class Server {
    private final InetSocketAddress address;
    private final CommandHandler handler;
    private final Logger logger = (Logger) LoggerFactory.getLogger("Logger");
    private final ForkJoinPool threadPool = ForkJoinPool.commonPool();;
    private Request request;
    private volatile Response response;
    public Server(InetSocketAddress address, CommandHandler handler) {
        this.address = address;
        this.handler = handler;
    }
    public void launch() {
        logger.info("Сервер начал работу");
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.bind(address);
            logger.info("Канал открыт и подключен по адресу");
            channel.configureBlocking(false);
            logger.info("Канал начал работу в неблокирующем режиме");
            Selector selector = Selector.open();
            logger.info("Селектор открыт");
            channel.register(selector, SelectionKey.OP_ACCEPT);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                selector.select();
                logger.info("Набор готовых к работе ключей получен");
                Iterator<SelectionKey> selKeys = selector.selectedKeys().iterator();
                while (selKeys.hasNext()) {
                    SelectionKey key = selKeys.next();
                    logger.info("Ключ обрабатывается");
                    try {
                        if (key.isValid()) {
                            if (key.isAcceptable()) {
                                ServerSocketChannel keyChannel = (ServerSocketChannel) key.channel();
                                SocketChannel socket = keyChannel.accept();
                                logger.info("Соединение с клиентом " + socket.getLocalAddress() + " установлено");
                                socket.configureBlocking(false);
                                socket.register(selector, SelectionKey.OP_READ);
                            }
                            if (key.isReadable()) {
                                SocketChannel socket = (SocketChannel) key.channel();
                                socket.configureBlocking(false);
                                threadPool.submit(() -> {
                                    try {
                                        readRequest(socket);
                                    } catch (IOException e) {
                                        logger.error("IO error");
                                    }

                                }).join();
                                ExecutorService executor = Executors.newFixedThreadPool(2);
                                executor.submit(this::requestProcessing);
                                socket.register(selector, SelectionKey.OP_WRITE);
                            }
                            if (key.isWritable()) {
                                SocketChannel socket = (SocketChannel) key.channel();
                                socket.configureBlocking(false);
                                Thread thread = new Thread(() -> {
                                    try {
                                        writeResponse(socket);

                                    } catch (SocketException e) {
                                        logger.info("Клиент " + key.channel().toString() + " отключился");
                                        key.cancel();

                                    } catch (IOException e) {
                                        logger.error("IO error");
                                        e.printStackTrace();
                                    }
                                });
                                thread.start();
                                thread.join();
                                socket.register(selector, SelectionKey.OP_READ);
                            }
                        }
                    } catch (SocketException | CancelledKeyException e) {
                        logger.error("Соединение с клиентом " + key.channel().toString() + " разорвано");
                        response = new Response(Status.CONNECTION_ERROR, Status.CONNECTION_ERROR.getMessage());
                        key.cancel();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    selKeys.remove();
                    if (console.ready()) {
                        String input = console.readLine();
                        if (input.equals("save")) {
                            logger.info("Collection is saved");
                        }
                    }
                }
            }
        } catch (IOException e) {
            logger.error("Ошибка ввода/вывода");
        }
    }

    private synchronized void readRequest(SocketChannel channel) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(1500);
        channel.read(buf);
        logger.info("Чтение запроса клиента");
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.array()))) {
            request = (Request) in.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Class is not found");
            logger.error("Класс не найден");
        } catch (IOException e) {
            throw new SocketException();
        }
        logger.info("Обработка клиентского запроса");
    }
    private synchronized void requestProcessing() {
        String[] input = request.getInput();
        if (input[0].equals("check")) {
            User user = request.getUser();
            if (DataBase.checkUser(user)) {
                if (DataBase.checkPassword(user)) {
                    response = new Response(Status.USER_IS_REGISTERED, "Вы вошли в систему.");
                } else {
                    response = new Response(Status.INCORRECT_PASSWORD, "Неверный пароль.");
                }
            } else {
                if (DataBase.addUser(user)) {
                    response = new Response(Status.USER_IS_NOT_REGISTERED, "Пользователя с таким именем не существует, " +
                            "поэтому Вы были зарегистрированыв системе.");
                } else {
                    response = new Response(Status.USER_ERROR, "Пользователя с таким именем не существует, " +
                            "регистрация не удалась ввиду неизвестной ошибки.");
                }
            }
        } else {
            if (Objects.nonNull(request.getOrg())) {
                Organization org = request.getOrg();
                String[] modInput = new String[input.length + 9];
                System.arraycopy(input, 0, modInput, 0, input.length);
                modInput[input.length] = org.getName();
                modInput[input.length + 1] = String.valueOf(org.getCoordinates().getX());
                modInput[input.length + 2] = String.valueOf(org.getCoordinates().getY());
                modInput[input.length + 3] = String.valueOf(org.getAnnualTurnover());
                modInput[input.length + 4] = org.getFullName();
                modInput[input.length + 5] = String.valueOf(org.getEmployeesCount());
                modInput[input.length + 6] = String.valueOf(org.getType());
                modInput[input.length + 7] = org.getPostalAddress().getStreet();
                modInput[input.length + 8] = org.getPostalAddress().getZipCode();
                response = handler.processInput(modInput, request.getUser());
            } else {
                response = handler.processInput(input, request.getUser());
            }
        }
    }

    private synchronized void writeResponse(SocketChannel channel) throws IOException {
        logger.info("Начата запись ответа для клиента");
        try (ByteArrayOutputStream bytes = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bytes)) {
            out.writeObject(response);
            ByteBuffer buf = ByteBuffer.wrap(bytes.toByteArray());
            channel.write(buf);
            Thread.sleep(300);
            buf.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Ответ записан и отправлен");
    }
}
