package Experiment1;

import java.util.Scanner;

public class AddAllChar {
    public static int addAllChar(int num) {
        String str;
        int sum = 0;
        str = Integer.toString(num);
        // 数字转字符串，每个字符串转数字求和
        for (int i = 0; i < str.length(); i++) {
            sum += (int) str.charAt(i) - 48;
        }
        return sum;
    }

    /**
     * 主程序，接收用户输入，处理错误，输出结果
     * @param args
     */

    public static void main(String[] args) {
        int num = 0;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个0到1000的整数:");
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
            if (num < 0 || num > 1000) {
                System.out.println("输入有误！");
                return;
            }
            sum = addAllChar(num);
            System.out.println("各位数字之和为：" + sum);
        } else {
            System.out.println("输入有误！");
        }
    }
}
