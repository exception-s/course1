package Client;

import CollectionObject.Objects.Organization;
import CollectionObject.Request;
import Client.ConsoleProcessing.Parser;
import CollectionObject.Exceptions.*;
import CollectionObject.Response;
import CollectionObject.Status;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.*;

public class Client {
    private final InetAddress host;
    private final TreeSet<String> files = new TreeSet<>();
    private final int port;
    private SocketChannel channel;
    private Response response;
    private final String[] commands = {"help", "info", "show", "add", "update", "remove_by_id", "clear", "execute_script",
                                "exit", "add_if_min", "remove_greater", "history", "average_of_annual_turnover",
                                "print_descending", "print_unique_full_name"};
    public Client(InetAddress host, int port) {
        this.host = host;
        this.port = port;
    }
    public void initialize() {
        try {
            SocketAddress address = new InetSocketAddress(host, port);
            channel = SocketChannel.open();
            channel.socket().setSoTimeout(15000);
            channel.connect(address);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Добро пожаловать в консольное приложение TheCollection! Чтобы увидеть список команд," +
                    " введите help.");
            while (true) {
                System.out.print("$ ");
                try {
                    String line = scanner.nextLine().trim();
                    String[] input = line.split("\\s+");
                    String command = input[0];
                    try {
                        if (command.isEmpty()) {
                            throw new NullFieldException();
                        } else {
                            if (!Arrays.asList(commands).contains(command)) {
                                throw new NoSuchCommandException();
                            } else if (command.equals("add") || command.equals("update") || command.equals("add_if_min") ||
                                    command.equals("remove_greater")) {
                                Parser parser = new Parser();
                                Organization org = parser.parseOrg();
                                Request userRequest = new Request(input, org);
                                response = connect(userRequest);
                            } else if (command.equals("execute_script")) {
                                executeScript(input);
                                continue;
                            } else {
                                Request userRequest = new Request(input);
                                response = connect(userRequest);
                            }
                            if (response.getStatus() == Status.OK) {
                                System.out.println(response.getMessage());
                                if (command.equals("exit")) {
                                    break;
                                }
                            } else {
                                System.out.println(response.getMessage());
                            }
                        }
                    } catch(NullFieldException e) {
                        System.out.println("Вы не ввели команду.");
                    } catch (NoSuchCommandException e) {
                        System.out.println("Команды {" + command + "} нет в списке команд. Чтобы вывести список, введите {help}.");
                    } catch (IncorrectArgumentsException | EmptyCollectionException | IOException | ClassNotFoundException e) {
                        //e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                } catch (ExitRequested | NoSuchElementException e) {
                    System.out.println ("Завершение работы консольного приложения...");
                    break;
                }
            }
        } catch (java.net.ConnectException e) {
            System.out.println("Ошибка соединения. Соединение не установлено или возникла проблема со " +
                    "стороны сервера, повторите попытку позже.");
        } catch (SocketTimeoutException e) {
            System.out.println("Превышено время ожидания.");
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("IO error");
        }
    }

    private Response connect(Request request) throws IOException, ClassNotFoundException {
        try (ByteArrayOutputStream byteArr = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(byteArr)) {
            out.writeObject(request);
            ByteBuffer toSend = ByteBuffer.wrap(byteArr.toByteArray());
            channel.write(toSend);
        }
        ByteBuffer toReceive = ByteBuffer.allocate(4096);
        channel.read(toReceive);
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(toReceive.array()))) {
            return (Response) in.readObject();
        }
    }

    private void executeScript(String[] input) {
        if (input.length < 2) {
            throw new IncorrectArgumentsException("Вы не ввели имя файла.");
        }
        //final String path = "/home/studs/s408321/"; //for helios
        final String path = "C:\\Users\\flqme\\IdeaProjects\\course1\\Lab6\\Client\\";
        Scanner scanner = new Scanner(System.in);
        BufferedReader buf;
        String scriptName = input[1];
        File file = new File(path + scriptName);
        String newScriptName;
        while (!file.exists()) {
            System.out.print("Файла с таким именем нет в директории, попробуйте повторить ввод имени файла: ");
            newScriptName = scanner.nextLine();
            file = new File(path + newScriptName);
            scriptName = newScriptName;
        }
        if (files.contains(scriptName)) {
            System.out.println("Файл уже был исполнен, чтение его повторно может вызвать бесконечную рекурсию.");
            return;
        }
        files.add(scriptName);
        try {
            buf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            StringBuilder sb = new StringBuilder();
            List<String> commandList = Arrays.asList(commands);
            while (buf.ready()) {
                String line = buf.readLine();
                String[] fileInput = line.trim().split("\\s+");
                String command = fileInput[0];
                try {
                    if (command.isEmpty()) {
                        throw new NullFieldException();
                    }
                    else {
                        if (!commandList.contains(command)) {
                            throw new NoSuchCommandException();
                        }
                        else {
                            if (command.equals("add") || command.equals("add_if_min") || command.equals("remove_greater")
                                || command.equals("update")) {
                                sb.append(command).append(" ");
                                for (int i = 0; i < 9; i++) {
                                    sb.append(buf.readLine());
                                    sb.append(" ");
                                }
                                Request request = new Request(sb.toString().trim().split("\\s+"));
                                response = connect(request);
                            } else if (command.equals("execute_script")) {
                                executeScript(input);
                                continue;
                            } else {
                                Request request = new Request(fileInput);
                                response = connect(request);
                            }
                            if (response.getStatus() == Status.OK) {
                                System.out.println(response.getMessage());
                                if (command.equals("exit")) {
                                    break;
                                }
                            } else {
                                System.out.println(response.getMessage());
                            }
                        }
                    }
                } catch(NullFieldException e) {
                    System.out.println("Вы не ввели команду.");
                } catch (NoSuchCommandException e) {
                    System.out.println("Команды {" + command + "} нет в списке команд. " +
                            "Чтобы вывести список, введите {help}.");
                } catch (IncorrectArgumentsException | EmptyCollectionException e) {
                    System.out.println(e.getMessage());
                } catch (ClassNotFoundException e) {
                    System.out.println("Класс не найден");;
                }
                System.out.println("-".repeat(100));
                sb.setLength(0);
            }

        } catch (IOException e) {
            System.out.println("IO error");
        } finally {
            files.remove(scriptName);
        }
    }
}
