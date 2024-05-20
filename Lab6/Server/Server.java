package Server;

import CollectionObject.Objects.Organization;
import CollectionObject.Request;
import CollectionObject.Response;
import CollectionObject.Status;
import Server.CommandsProcessing.CommandHandler;
import Server.FileProcessing.WriteToXML;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class Server {
    private final InetSocketAddress address;
    private final Logger logger = (Logger) LoggerFactory.getLogger("Logger");
    private Request request;
    private Response response;
    private ByteBuffer buf;
    public Server(InetSocketAddress address) {
        this.address = address;
    }
    public void launch(CommandHandler handler, TheCollection collection) {
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
                                buf = ByteBuffer.allocate(1024);
                                socket.read(buf);
                                if (!buf.hasRemaining()) {

                                }
                                logger.info("Чтение запроса клиента");
                                try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.array()))) {
                                    request = (Request) in.readObject();
                                } catch (ClassNotFoundException e) {
                                    System.out.println("Class is not found");
                                } catch (IOException e) {
                                    throw new SocketException();
                                }
                                logger.info("Обработка клиентского запроса");
                                String[] input = request.getInput();
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
                                    response = handler.processInput(modInput);
                                } else {
                                    response = handler.processInput(input);
                                }
                                socket.register(selector, SelectionKey.OP_WRITE);
                            }
                            if (key.isWritable()) {
                                SocketChannel socket = (SocketChannel) key.channel();
                                socket.configureBlocking(false);
                                logger.info("Начата запись ответа для клиента");
                                try (ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                                     ObjectOutputStream out = new ObjectOutputStream(bytes)) {
                                            out.writeObject(response);
                                            ByteBuffer buf = ByteBuffer.wrap(bytes.toByteArray());
                                            socket.write(buf);
                                            buf.clear();
                                }
                                logger.info("Ответ записан и отправлен");
                                socket.register(selector, SelectionKey.OP_READ);
                            }
                        }
                    } catch (SocketException | CancelledKeyException e) {
                        logger.error("Соединение с клиентом " + key.channel().toString() + " разорвано");
                        response = new Response(Status.CONNECTION_ERROR, Status.CONNECTION_ERROR.getMessage());
                        WriteToXML writer = new WriteToXML(collection, "collection.xml");
                        writer.write();
                        key.cancel();
                    }
                    selKeys.remove();
                    if (console.ready()) {
                        String input = console.readLine();
                        if (input.equals("save")) {
                            WriteToXML writer = new WriteToXML(collection, "collection.xml");
                            writer.write();
                            System.out.println("Collection is saved");
                        }
                    }
                }
            }
        } catch (IOException e) {
            logger.error("Ошибка ввода/вывода");
            //e.printStackTrace();
            //System.out.println("IO error");
        }
    }
}
