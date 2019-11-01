package a;

import java.util.Scanner;

public class Main{

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    int end2 = 3;
    int[][] mas = new int[number][3];

    for (int k = 0; k < number; k++) {
      mas[k][0]=1;
      for (int j = 1; j < end2; j++) {
        mas[k][j]=0;

      }
    }
    for (int k = 0; k < number; k++) {
      for (int j = 0; j < end2; j++) {
        System.out.print(mas[k][j]+" ");

      }
      System.out.println();
    }

  }
}