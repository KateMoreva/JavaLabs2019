package task4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("9. Вы работаете с приложением, позволяющим просматривать файлы и каталоги файловой " +
                "системы, а также создавать, изменять и удалять текстовые файлы. Введите команду или получите справку" +
                " (help).");
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine())
        {
            Commands.execute(in.nextLine());
        }
    }
}