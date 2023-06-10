package Practice;

import java.util.Scanner;

public class RationalCalculator {
    public static Rational getRational(String str){
        long numerator,denominator;
        if (str.charAt(0) == '-') {
            numerator = (long)Integer.parseInt(new String(String.valueOf(str.charAt(1))));
            denominator = (long)Integer.parseInt(new String(String.valueOf(str.charAt(3))));
        } else {
            numerator = (long)Integer.parseInt(new String(String.valueOf(str.charAt(0))));
            denominator = (long)Integer.parseInt(new String(String.valueOf(str.charAt(2))));
        }
        return new Rational(numerator,denominator);
    }

    public static void main(String[] args) {
        System.out.print("请输入要计算的表达式(操作数和操作符用空格隔开):");
        Scanner input = new Scanner(System.in);
        String format = input.nextLine();
        String[] list =  format.split(" ");
        Rational n1 = getRational(list[0]);
        Rational n2 = getRational(list[2]);
        Rational result;
        if (list[1].equals("+")) {
            result = n1.add(n2);
        } else if (list[1].equals("-")) {
            result = n1.subtract(n2);
        } else if (list[1].equals("*")) {
            result = n1.multiply(n2);
        } else {
            result = n1.divide(n2);
        }
        System.out.print(format+" = "+result.toString());
    }
}
