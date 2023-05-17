package Experiment2;


import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class JudgeSameList {

    /**
     * 输出list信息
     */
    public static void printList(int[] list1, int[] list2) {
        System.out.print("输入list1：");

        for (int m : list1) {
            System.out.print(m + " ");
        }
        System.out.println();
        System.out.print("输入list2：");

        for (int n : list2) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    /**
     * 判断数组包含元素是否相同
     */
    public static boolean equal(int[] list1, int[] list2) {
         // 对数组进行排序
        list1 = Arrays.stream(list1).sorted().toArray();
        list2 = Arrays.stream(list2).sorted().toArray();
        int ptr = 0;

        while (ptr < list1.length) {
            // 排序后的数组若相同，则相同位置的元素相同
            if (list1[ptr] != list2[ptr]) {
                return false;
            }
            ptr += 1;
        }

        return true;
    }

    /**
     * 主函数，接收数据，输出结果
     */
    public static void main(String[] args) {
        int[] list1 = new int[0];
        int[] list2 = new int[0];
        Scanner input = new Scanner(System.in);
        // 接收第一个数组的数据
        System.out.println("输入list1(第一个数字为list元素个数)：");
        list1 = getInts(list1, input);

        // 接收第二个数组的数据
        System.out.println("输入list2(第一个数字为list元素个数)：");
        list2 = getInts(list2, input);

        // 输出结果
        if (list1.length != list2.length) {
            printList(list1, list2);
            System.out.println("这两个数列是不同的");
        } else {
            if (equal(list1, list2)) {
                printList(list1, list2);
                System.out.println("这两个数列是相同的");
            } else {
                printList(list1, list2);
                System.out.println("这两个数列是不同的");
            }
        }
    }

    public static int[] getInts(int[] list, Scanner input) {
        if (input.hasNextInt()) {
            int length = input.nextInt();
            for (int i = 0; i < length; i++) {
                if (input.hasNextInt()) {
                    list = Arrays.copyOf(list, list.length + 1);
                    list[i] = input.nextInt();
                } else {
                    System.out.println("请输入整数！");
                }
            }
        } else {
            System.out.println("请输入整数！");
        }
        return list;
    }
}
