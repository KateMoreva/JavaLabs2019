package b;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String stroka;
        stroka = scanner.nextLine();
        Random random = new Random();
        char repl;
        List<String> splitted = new ArrayList<>();
        for (int i = 0; i < stroka.length(); i += 3) {
            int length = Math.min(3, stroka.length() - i);
           String newString = stroka.substring(i, i + length);
           char[] chars = newString.toCharArray();
          if (chars.length >= 3) {
              repl = (char) random.nextInt();
            while (( repl == chars[0]) || (repl == chars[2])){
                repl= (char) random.nextInt();
            }
            chars[1]=repl;
          }
           splitted.add(String.valueOf(chars));
        }
        splitted.sort(String::compareTo);
        for (String s : splitted) {
            System.out.print(s + " ");
        }

    }
}
