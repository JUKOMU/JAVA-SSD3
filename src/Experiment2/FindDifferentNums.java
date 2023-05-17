package Experiment2;
import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class FindDifferentNums {

    /**
     * 判断double型数num是否含有不为0的小数部分
     */
    public static boolean isDecimal(double num) {
        return num % 1 != 0;
    }

    /**
     * 找出nums_list中不同的数，并返回一个新的数组
     * 方法：快慢指针
     */
    public static double[] getDifferentNums(double[] nums_list) {
        int prev = 0; // 前指针
        int cur = 0; // 后指针
        double[] different_nums = new double[1]; // 第一个数字一定不同，故先进入数组
        different_nums[0] = nums_list[prev];
        while (prev < nums_list.length) {
            if (nums_list[prev] != nums_list[cur]) {
                prev = cur; // 遇到不同的数时前指针移动到后指针位置
                different_nums = Arrays.copyOf(different_nums, different_nums.length + 1);
                different_nums[different_nums.length-1] = nums_list[prev]; // 记录不同的数字
            }
            cur += 1; // 后指针移动
            if (cur == nums_list.length) {
                break; // 后指针历遍整个数组，表示所有不同的数字历遍完毕，结束while
            }
        }
        return different_nums;
    }

    /**
     * 主函数，接收数据，输出结果
     */
    public static void main(String[] args) {
        double[] nums_list = getData();
        System.out.print("输入的10个数：");
        for (double m : nums_list) {
            if (isDecimal(m)) {
                System.out.print(m + " ");
            }
            else {
                System.out.print((int) m + " ");
            }
        }
        System.out.println();
        double[] temp = getDifferentNums(Arrays.stream(nums_list).sorted().toArray());
        System.out.print("互不相同的数为：");
        for (double n : temp) {
            if (isDecimal(n)) {
                System.out.print(n + " ");
            }
            else {
                System.out.print((int) n + " ");
            }
        }
    }

    public static double[] getData() {
        double[] nums_list = new double[10];
        Scanner input = new Scanner(System.in);
        System.out.println("输入10个数字:");
        for (int i = 0;i < 10;i++) {
            if (input.hasNextDouble()) {
                double num = input.nextDouble();
                nums_list[i] = num;
            }
            else {
                System.out.println("请输入数字!");
                i--; // 保证用户输入错误数据后i不变
            }
        }
        return nums_list;
    }
}
