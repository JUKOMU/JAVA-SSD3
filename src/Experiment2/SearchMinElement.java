package Experiment2;

public class SearchMinElement {
    /**
     * 判断double型数num是否含有不为0的小数部分
     */
    public static boolean isDecimal(double num) {
        return num % 1 != 0;
    }


    /**
     * 查找最小元素第一次出现的下标
     */
    public static int indexSmallestElement(double[] array) {
        int index = 0;
        double min = array[index];
        for (int i = 1; i < array.length; i++) {
            // 遇到更小的元素，则更新最小元素min和下标index
            if (min > array[i]) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * 主函数，接收数据，输出结果
     */
    public static void main(String[] args) {
        double[] nums_list = FindDifferentNums.getData();

        int temp = indexSmallestElement(nums_list);
        System.out.print("最小元素的下标是"+temp+"，");
        System.out.print("是数组中第"+(temp+1)+"个元素");
        if (isDecimal(nums_list[temp])) {
            System.out.println("，值为："+nums_list[temp]);
        } else {
            System.out.println("，值为："+(int)nums_list[temp]);
        }
    }
}
