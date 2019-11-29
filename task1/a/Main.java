package a;

import java.util.Scanner;

public class Main{

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int number1 = scanner.nextInt();
    int number2 = scanner.nextInt();
    int end2 = 3;
    int[][] mas = new int[number1][number2];

    for (int k = 0; k < number1; k++) {
      mas[k][0]=1;
      for (int j = 1; j < number2; j++) {
        mas[k][j]=0;

      }
    }
    for (int k = 0; k < number1; k++) {
      for (int j = 0; j < number2; j++) {
        System.out.print(mas[k][j]+" ");

      }
      System.out.println();
    }

  }
}