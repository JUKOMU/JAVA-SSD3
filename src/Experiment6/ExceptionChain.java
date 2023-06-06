package Experiment6;

import java.util.ArrayList;
import java.util.Arrays;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class ExceptionChain {
    /**
     * 对数组排序
     * @param list
     * @return
     */
    public static double[] sortList(ArrayList list) {
        double[] sortedList = new double[list.size()];
        int i = 0;
        while (list.size() > 0) {
            int n = 0;
            int min = 2147483647; // 这是int型数据的最大值
            for (int j = 0; j < list.size(); j++) {
                if (isNumber(list.get(j))) {
                    if (min > (int)list.get(j)) {
                        min = (int)list.get(j);
                        n = j;
                    }
                } else {
                    throw new NumberFormatException();
                }
            }
            sortedList[i] = min;
            list.remove(n);
            i++;
        }
        return sortedList;
    }

    /**
     * 把一个数组的元素复制到另一个数组里
     * @param list
     * @param newList
     * @param index
     * @return
     * @throws ArrayIndexOutOfBoundsException
     */
    public static double[] cloneElement(ArrayList list, double[] newList, int index) throws ArrayIndexOutOfBoundsException {
        double[] sortList;
        try {
            sortList = sortList(list);
            for (int i = 0; i < sortList.length; i++) {
                newList[index+i] = sortList[i];
            }
        } catch (NumberFormatException ex) {
            System.out.println("Error3");
            throw ex;
        } finally {
            System.out.println("section2");
        }
        return newList;
    }


    /**
     * 合并两个数组
     * @param l1
     * @param l2
     * @return
     * @throws NullPointerException
     */
    public static double[] mergeList(ArrayList l1, ArrayList l2) throws NullPointerException {
        int len = l1.size() + l2.size();
        double[] newList = new double[len];
        try {
            newList = cloneElement(l1, newList, 0);
            newList = cloneElement(l2, newList, len- l2.size()+1); // 制造out of range 异常
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Error2");
            throw ex;
        } finally {
            System.out.println("section1");
        }
        return newList;
    }

    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        double[] newList;
        list1.add(2);
        list1.add("3");
        list1.add(1);
        list2.add(1);
        list2.add(6);
        list2.add(7);
        list2.add(3);
        try {
            newList = mergeList(list1, list2);
            newList = Arrays.stream(newList).sorted().toArray();
            for(double d:newList) {
                System.out.println(d);
            }
        } catch (NullPointerException ex) {
            System.out.println("Failed to merge list");
        } catch (NumberFormatException ex) {
            System.out.println("Failed to merge list");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Failed to merge list");
        } finally {
            System.out.println("main");
        }
    }
}
