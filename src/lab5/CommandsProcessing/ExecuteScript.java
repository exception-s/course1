package lab5.CommandsProcessing;

import lab5.AppProcessing.TheCollection;
import lab5.ExceptionsProcessing.*;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Класс, реализующий команду execute_script
 */
public class ExecuteScript implements Commandable {
    private final TheCollection collection;
    private static final Stack<String> files = new Stack<>();

    public ExecuteScript(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public void execute(String[] input) {
        if (input.length < 2) {
            throw new IncorrectArgumentsException("Вы не ввели имя файла.");
        }
        HashMap<String, Commandable> commandList = collection.getCommandsList();
        Scanner scanner = new Scanner(System.in);
        BufferedInputStream buf;
        String fileName = input[1];
        File file = new File("C:\\Users\\flqme\\IdeaProjects\\course1\\src\\lab5\\" + fileName);
        String newFileName = new String();
        while (!file.exists()) {
            System.out.print("Файла с таким именем нет в директории, попробуйте повторить ввод имени файла: ");
            newFileName = scanner.nextLine();
            file = new File("C:\\Users\\flqme\\IdeaProjects\\course1\\src\\lab5\\" + newFileName);
            fileName = newFileName;
        }
        if (files.contains(fileName)) {
            throw new IncorrectArgumentsException("Файл с именем \"" + fileName + "\" уже обрабатывается/обработан. " +
                    "Попробуйте использовать команду с другим именем файла.");
        }
        files.push(fileName);
        try {
            buf = new BufferedInputStream(new FileInputStream(file));
            final String LINE_SEP = System.lineSeparator();
            int read = buf.read();
            char ch = (char) read;
            StringBuilder sb = new StringBuilder();
            sb.append(ch);
            while (read > 0) {
                ch = (char) read;
                String line;
                while (ch != LINE_SEP.charAt(0) && read > 0) {
                    read = buf.read();
                    ch = (char) read;
                    sb.append(ch);
                }
                line = sb.toString();
                if (line.charAt(0) == (char) -1) {
                    break;
                }
                String[] fileInput = line.trim().split("\\s+");
                String command = fileInput[0];
                try {
                    if (command.isEmpty()) {
                        throw new NullFieldException();
                    }
                    else {
                        if (commandList.get(command) == null) {
                            throw new NoSuchCommandException();
                        }
                        else {
                            commandList.get(command).execute(fileInput);
                        }
                    }
                } catch(NullFieldException e) {
                    System.out.println("Вы не ввели команду.");
                } catch (NoSuchCommandException e) {
                    System.out.println("Команды {" + command + "} нет в списке команд. " +
                            "Чтобы вывести список, введите {help}.");
                } catch (IncorrectArgumentsException | EmptyCollectionException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("-".repeat(100));
                sb.setLength(0);
                read = buf.read();
            }

        } catch (IOException e) {
            System.out.println("IO error");
        }
    }
    @Override
    public String getName() {
        return "execute_script file_name";
    }
    @Override
    public String getInfo() {
        return "считать и исполнить скрипт из указанного файла";
    }
}
