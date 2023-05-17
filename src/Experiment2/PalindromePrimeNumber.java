import java.util.Scanner;

public class PalindromePrimeNumber {

    /**
     * 为String类提供reverse方法
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuffer(str).reverse().toString();
    }

    /**
     * 判断是否为回文数
     */
    public static boolean isPalindrome(int num) {
        String str = Integer.toString(num);
        String str_sub = reverse(str);
        return str.equals(str_sub);
    }

    /**
     * 判断是否为素数
     */
    public static boolean isPrimeNumber(int num) {
        for (int i = 2;i<num;i++) {
            if (num % i == 0) {
                return false;
            }
        }
        // 完全历遍2-(num-1)才能判断为素数
        return true;
    }

    /**
     * 主函数提供入口，接收要求输出的回文素数个数
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入要输出回文素数的个数:");
        if (input.hasNextInt()) {
            int temp = 0;
            int n = input.nextInt();
            int number = 2;
            int counter = 0;
            // 输出回文素数个数满足要求则停止输出
            while (temp < n) {
                // 先判断是否为素数，再判断是否为回文数
                if (isPrimeNumber(number)) {
                    if (isPalindrome(number)) {
                        // 控制每行输出个数为10个
                        if (counter == 10) {
                            counter = 0;
                            System.out.println();
                        }
                        System.out.print(number+" ");
                        temp += 1;
                        counter += 1;
                    }
                }
                number += 1;
            }
        }
        else {
            System.out.println("请输入一个整数！");
        }
    }
}
