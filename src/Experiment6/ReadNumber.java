package Experiment6;

import java.util.Scanner;

public class ReadNumber {
    /**
     * 判断double型数num是否含有不为0的小数部分
     */
    public static boolean isDecimal(double num) {
        return num % 1 != 0;
    }

    public static int readNumber() {
        Scanner input = new Scanner(System.in);
        double sum = 0;
        for (int i = 0; i < 2; i++) {
            if (input.hasNextDouble()) { // 判断输入是否为数字
                double x = input.nextDouble();
                if (isDecimal(x)) { // 判断是否为整数
                    input.nextLine();
                    throw new NumberFormatException();
                } else {
                    sum += x;
                }
            } else {
                input.nextLine();
                throw new NumberFormatException();
            }
        }
        return (int)sum;
    }


    public static void main(String[] args) {
        boolean continueInput = true;
        System.out.println("Please enter two integers:");
        do {
            try {
                int sum = readNumber();
                System.out.println("The summa of two integers is "+sum);
                continueInput = false;
            }
            catch (NumberFormatException expected) {
                System.out.println("Incorrect number format,try again!");
            }
        } while (continueInput);
    }
}
