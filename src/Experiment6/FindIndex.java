package Experiment6;

import java.util.Scanner;

public class FindIndex {

    public static int getNumber(int[] list) throws ArrayIndexOutOfBoundsException{
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        return list[index];
    }

    public static void main(String[] args) {
        int[] list = new int[100];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int)(Math.random()*214748);
        }
        System.out.print("Please enter a index:");
        try {
            System.out.println(getNumber(list));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("out of bounds");
        }
    }
}
