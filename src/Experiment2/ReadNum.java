package Experiment2;

import java.util.Arrays;
import java.util.Scanner;

public class ReadNum {
    /**
     * 输出每个不同的数字出现次数
     */
    public static void printTimes(int[] nums_list, int len) {
        int[][] temp_list = new int[len + 1][2]; // 构建二维数组存储不同数字及其出现的次数
        int temp_ptr = 0; // 指向temp_list中每个存储单元
        int pre_ptr = 0; // 前指针
        int next_ptr = pre_ptr; // 后指针
        while (pre_ptr < len) {
            // 忽略为0的元素
            if (nums_list[pre_ptr] == 0) {
                pre_ptr += 1;
                next_ptr = pre_ptr;
            } else {
                // 前指针作为基准，后指针向后移动，遇到相同元素对次数+1
                while (nums_list[pre_ptr] == nums_list[next_ptr]) {
                    temp_list[temp_ptr][0] = nums_list[pre_ptr];
                    temp_list[temp_ptr][1] += 1;
                    next_ptr += 1; // 后指针向后移动
                    if (next_ptr == len) {
                        break;
                    }
                }
                pre_ptr = next_ptr;
                temp_ptr += 1; // 向后移一位，存储新的数字
                if (pre_ptr == len) {
                    break;
                }
            }
        }
        // 输出每个不同的数字及其出现次数
        for (int k = 0; k < len; k++) {
            int number = temp_list[k][0];
            int times = temp_list[k][1];
            if (number != 0) {
                System.out.print(number);
                System.out.print(" 出现 ");
                System.out.print(times);
                System.out.println(" 次");
            }
        }
    }
    /**/

    /**
     * 主程序，接受数字
     */
    public static void main(String[] args) {
        int[] nums_list = new int[50];
        int ptr = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入1-100之间的整数:");

//        测试大量数据，采用生成随机数的方法
//        for (int i = 0; i < 500; i++) {
//            int num = (int)(1 + Math.random()*100);
//                if (num == 0) {
//                    System.out.println("输入结束！");
//                    break;
//                }
//
//                if (num > 100) {
//                    System.out.println("请输入1-100之间的整数！");
//                    continue;
//                }/
//
//                // 数组扩容
//                if (ptr == nums_list.length-1) {
//                    nums_list = Arrays.copyOf(nums_list,nums_list.length*2);
//                }
//
//                nums_list[ptr] = num;
//                ptr += 1;
//        }
//
//        for (int i : nums_list) {
//            if (i != 0) {
//                System.out.println(i);
//            }
//        }

        while (true) {
            if (input.hasNextInt()) {
                int num = input.nextInt();
                if (num == 0) {
                    System.out.println("输入结束！");
                    break;
                }

                if (num > 100 || num < 0) {
                    System.out.println("请输入1-100之间的整数！");
                    continue;
                }

                // 数组扩容
                if (ptr == nums_list.length - 1) {
                    nums_list = Arrays.copyOf(nums_list, nums_list.length * 2);
                }

                nums_list[ptr] = num;
                ptr += 1;
            } else {
                System.out.println("请输入1-100之间的整数！");
            }
        }
//
        printTimes(Arrays.stream(nums_list).sorted().toArray(), nums_list.length);

        // 测试接收
        /*
        for (int i = 0;i < nums_list.length;i++) {
            System.out.println(nums_list[i]);
        }
         */

    }
}
