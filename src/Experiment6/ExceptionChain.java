package Experiment6;

import java.util.ArrayList;

public class ExceptionChain {
    public static void method3() {
    }

    public static void method2() {
        try {
            method3();
        } catch (Exception e) {
        }
    }

    public static void mergeList(ArrayList l1, ArrayList l2) {
        try {
            method2();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();

        try {
            mergeList(list1, list2);
        } catch (Exception e) {
        }
    }
}
