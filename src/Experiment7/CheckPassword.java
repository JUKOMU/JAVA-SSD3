package Experiment7;
import java.util.Scanner;

public class CheckPassword {
    public static boolean isNumber(char c) {
        return ((int)c >=48 && (int)c <= 57);
    }
    public static boolean isLetter(char c) {
        return (((int)c >= 65 && (int)c <= 90) || ((int)c >= 97 && (int)c <= 122));
    }
    public static void main(String[] args) {
        System.out.println("输入一个字符串:");
        Scanner input = new Scanner(System.in);
        String pwd = input.next();
        if (pwd.length() < 8 ) {
            System.out.println("Invalid Password");
        } else {
            int m = 0; // 记录字母的个数
            int n = 0; // 记录数字的个数
            for (int i = 0; i < pwd.length(); i++) {
                if (isNumber(pwd.charAt(i))) {
                    n++;
                } else if (isLetter(pwd.charAt(i))) {
                    m++;
                } else { System.out.println("Invalid Password"); return;}
            }
            if (n < 2) { System.out.println("Invalid Password"); }
            else { System.out.println("Valid Password");}
        }
    }
}
