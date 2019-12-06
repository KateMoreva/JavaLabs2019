package task4;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Commands {
    public interface Command {
        void execute(String[] args) throws Exception;
    }

    static void execute(String line){
        Map<String, Command> commandsMap = new HashMap<>();

        commandsMap.put(
                "help", (String[] args) ->
                {
                    if (args.length != 1) {
                        throw new Exception("Неправильное число аргументов.");
                    }
                    System.out.println("Доступные команды:\n"
                            + "pwd  Просмотр текущей директории." + "\n"
                            + "touch [путь до файла и имя файла]  Создание файла." + "\n"
                            + "ls [директория]  Просмотр содержимого директории." + "\n"
                            + "cat [путь до файла]  Просмотр содержимого файла." + "\n"
                            + "cat > [путь до файла]  Осуществление записи в файл." + "\n"
                            + "cat >> [путь до файла]  Осуществление дозаписи в файл." + "\n"
                            + "rm [путь до файла]  Удаление файла." + "\n"
                            + "[Имя команды] -- help или -h  Вызов справки по каждой команде");
                }
        );
        commandsMap.put(
                "pwd", (String[] args) ->
                {
                    if (args.length == 1) {
                        System.out.println(System.getProperty("user.dir"));
                    } else {
                        if (args[1].equals("--help") || (args[1].equals("-h"))) {
                            System.out.println("Команда 'pwd' позволяет осуществить просмотр пути к текущей директории."
                                    + "\n" + "Для просмотра пути введите команду и нажмите 'Enter'.");

                        } else
                            throw new Exception("Неправильное число аргументов.");
                    }
                }
        );
        commandsMap.put(
                "ls", (String[] args) ->
                {
                    String directory;
                    if (args.length == 1) {
                        directory = System.getProperty("user.dir");
                    } else if (args.length == 2) {
                        directory = args[1];
                    } else {
                        throw new Exception("Неправильное число аргументов.");
                    }
                    File current = new File(directory);
                    if (current.isDirectory()) {
                        File[] files = current.listFiles();
                        if (files != null) {
                            for (File file : files) {
                                if (file != null) {
                                    System.out.println(file.getName());
                                }
                            }
                        }
                    } else {
                        if (args[1].equals("--help") || (args[1].equals("-h"))) {
                            System.out.println("Команда 'ls' позволяет осуществить просмотр содержимого директории."
                                    + "\n" + "Для просмотра текущей директории введите команду и нажмите 'Enter'."
                                    + "\n" + "Для просмотра другой директории введите команду, " +
                                    "путь к директории и нажмите 'Enter'.");

                        } else {
                            System.out.println(args[1]);
                            throw new Exception(directory + " не является директорией.");
                        }
                    }
                }
        );
        commandsMap.put(
                "rm", (String[] args) ->
                {
                    if (args.length == 2) {
                        if (args[1].equals("--help") || (args[1].equals("-h"))) {
                            System.out.println("Команда 'rm' позволяет осуществить удаление файла из каталога."
                                    + "\n" + "Для удаления файла из текущей директории введите команду, " +
                                    "название файла и нажмите 'Enter'."
                                    + "\n" + "Для удаления файла из другой директории введите команду, " +
                                    "путь к файлу и нажмите 'Enter'.");

                        }

                    } else {
                        throw new Exception("Неправильное число аргументов.");
                    }
                    File file = new File(args[1]);
                    if (!file.delete()) {
                        throw new Exception("Файл " + args[1] + " не существует или не может быть удален.");
                    }
                }
        );
        commandsMap.put(
                "cat", (String[] args) ->
                {
                    if (args.length < 2) {
                        throw new Exception("Неправильное число аргументов.");
                    }
                    String path = args[1];
                    if (path.equals(">") || (path.equals(">>"))) {
                        if (args.length != 3) {
                            throw new Exception("Неправильное число аргументов.");
                        }
                        path = args[2];
                        File current = new File(path);
                        if (current.isFile()) {
                            if (current.canWrite()) {
                                FileWriter out;
                                if (args[1].equals(">>")) {
                                    out = new FileWriter(path, true);
                                } else {
                                    out = new FileWriter(path);
                                }
                                Scanner in = new Scanner(System.in);
                                System.out.println("Введите 'ESC' чтобы завершить запись в файл.");
                                while (in.hasNextLine()) {
                                    String tmp = in.nextLine();
                                    if (tmp.equalsIgnoreCase("ESC")) {
                                        break;
                                    }
                                    out.write(tmp + "\n");
                                }
                                System.out.println("Запись в файл завершена");
                                out.close();
                            } else {
                                throw new Exception(path + " не доступен для записи.");
                            }
                        } else {
                            if (args[1].equals("--help") || (args[1].equals("-h"))) {
                                System.out.println("Команда 'cat' позволяет осуществить просмотр содержимого," +
                                        " запись/перезапись, дозапись в файл."
                                        + "\n" + "Для просмотра текста файла введите команду," +
                                        " название файла и нажмите 'Enter'."
                                        + "\n" + "Для записи/перезаписи файла введите команду, символ '>', " +
                                        "название/путь к файлу и нажмите 'Enter'."
                                        + "\n" + "Для дозапси в файл введите команду, символ '>>'," +
                                        " название/путь к файлу и нажмите 'Enter'.");

                            } else {
                                throw new Exception(path + " не является файлом.");
                            }
                        }
                    } else {
                        if (args.length != 2) {
                            throw new Exception("Неправильное число аргументов.");
                        }
                        File current = new File(path);
                        if (current.isFile()) {
                            if (current.canRead()) {
                                FileReader inputFile = new FileReader(path);
                                Scanner in = new Scanner(inputFile);
                                while (in.hasNextLine()) {
                                    System.out.println(in.nextLine());
                                }
                            } else {
                                throw new Exception("Нечитаемый файл.");
                            }
                        } else {
                            if (args[1].equals("--help") || (args[1].equals("-h"))) {
                                System.out.println("Команда 'cat' позволяет осуществить просмотр содержимого," +
                                        " запись/перезапись, дозапись в файл."
                                        + "\n" + "Для просмотра текста файла введите команду, " +
                                        "название файла и нажмите 'Enter'."
                                        + "\n" + "Для записи/перезаписи файла введите команду, символ '>'," +
                                        " название/путь к файлу и нажмите 'Enter'."
                                        + "\n" + "Для дозапси в файл введите команду, символ '>>', " +
                                        "название/путь к файлу и нажмите 'Enter'.");

                            } else {
                                throw new Exception(path + " не является файлом.");
                            }
                        }
                    }

                }
        );
        commandsMap.put(
                "touch", (String[] args) ->
                {

                    if (args[1].equals("--help") || (args[1].equals("-h"))) {
                        System.out.println("Команда 'touch' позволяет осуществить создание файла в каталога."
                                + "\n" + "Для создания файла в текущей директории введите команду, " +
                                "название файла и нажмите 'Enter'."
                                + "\n" + "Для создания файла в другой директории введите команду, " +
                                "путь к файлу и нажмите 'Enter'.");

                    } else if (args.length == 2) {
                        FileWriter out = new FileWriter(args[1]);
                        out.close();
                    } else {
                        throw new Exception("Неправильное число аргументов.");
                    }

                }
        );

        String[] args = line.split(" ");

        Command command = commandsMap.get(args[0]);

        try {
            if (command != null) {
                command.execute(args);
            } else {
                throw new Exception("Несуществующая команда.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Для получения справки по командам введите 'help'.");
        }
    }
}