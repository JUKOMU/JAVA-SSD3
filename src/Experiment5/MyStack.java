package Experiment5;

import java.util.ArrayList;
import java.util.Scanner;

public class MyStack extends ArrayList<String> {
    @Override
    public boolean add(String s) {
        return super.add(s);
    }

    @Override
    public void add(int index, String element) {
    }

    @Override
    public String remove(int index) {
        return super.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    MyStack(){
        super(new ArrayList<String>());
    }
    public void push(String value) {
        add(value);
    }
    public void pop() {
        System.out.println(get(size() - 1));
        remove(size() - 1);
    }

    public void printStack() {
        for (int i = size() - 1; i > -1; i--) {
            System.out.println(get(i));
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Scanner input = new Scanner(System.in);
        String str;
        System.out.println("输入五个字符串：");
        for(int i = 0; i<5; i++) {
            str = input.next();
            if (str.equals("0")) {
                break;
            }
            stack.push(str);
        }
        System.out.println("逆序输出为：");
        stack.printStack();
    }
}
