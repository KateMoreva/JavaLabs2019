package task5;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите путь до файла:");
        String path = in.next();
        System.out.println("По-умолчанию символ разделителя '=' . \n" + "Использовать его? [Y/N]");
        String agree = in.next();
        String delimiter;
        if (agree.equals("y") || agree.equals("Y") || agree.equals("yes") || agree.equals("Yes") || agree.equals("YES")) {
            delimiter = "=";
        } else {
            System.out.println("Введите символ разделителя:");
            delimiter = in.next();
        }

        HashMap<String, String> properties = PropertiesParser.parse(path, delimiter);
        if (properties == null)
        {
            System.out.println("Ошибка во время обработки файла.");
            return;
      }

        System.out.println("Введите значение ключа:");
        while (in.hasNext())
        {
            String key = in.next();
            System.out.println(properties.getOrDefault(key, "Некорректное значение ключа."));
            System.out.println("Введите значение ключа:");
        }

    }
}