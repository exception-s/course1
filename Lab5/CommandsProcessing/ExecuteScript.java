package CommandsProcessing;

import AppProcessing.TheCollection;
import ExceptionsProcessing.EmptyCollectionException;
import ExceptionsProcessing.IncorrectArgumentsException;
import ExceptionsProcessing.NoSuchCommandException;
import ExceptionsProcessing.NullFieldException;
import ExceptionsProcessing.*;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Класс, реализующий команду execute_script
 */
public class ExecuteScript implements Commandable {
    private final String heliosPath = "/home/studs/s408321/lab5/";
    private final String localPath = "C:\\Users\\flqme\\IdeaProjects\\course1\\Lab5\\";
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
        BufferedReader buf;
        String scriptName = input[1];
        //File file = new File(heliosPath + scriptName);  // todo for helios
        File file = new File(localPath + scriptName);
        String newScriptName;
        while (!file.exists()) {
            System.out.print("Файла с таким именем нет в директории, попробуйте повторить ввод имени файла: ");
            newScriptName = scanner.nextLine();
            //file = new File(heliosPath + newScriptName);
            file = new File(localPath + newScriptName);
            scriptName = newScriptName;
        }
        if (files.contains(scriptName)) {
            return;
        }
        files.push(scriptName);
        try {
            buf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            StringBuilder sb = new StringBuilder();
            while (buf.ready()) {
                String line = buf.readLine();
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
                            if (command.equals("add") || command.equals("add_if_min") ||
                                            command.equals("remove_greater")) {
                                for (int i = 0; i < 9; i++) {
                                    sb.append(buf.readLine());
                                    sb.append(" ");
                                }
                                commandList.get(command).execute(sb.toString().trim().split("\\s+"));
                            } else if (command.equals("update")) {
                                sb.append(fileInput[1]).append(" ");
                                for (int i = 0; i < 9; i++) {
                                    sb.append(buf.readLine());
                                    sb.append(" ");
                                }
                                commandList.get(command).execute(sb.toString().trim().split("\\s+"));
                            } else {
                                commandList.get(command).execute(fileInput);
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
    @Override
    public String getName() {
        return "execute_script file_name";
    }

    @Override
    public String getInfo() {
        return "считать и исполнить скрипт из указанного файла";
    }
}
