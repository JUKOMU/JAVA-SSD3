package Experiment7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class MakeFile {
    /**
     * 向file写入10个0~10000的整数
     * @param writer
     */
    public static void writeData(PrintWriter writer){
        for (int i = 0; i < 10; i++) {
            writer.print((int) (Math.random() * 10000));
            writer.print(" ");
        }
    }

    /**
     * 从file中读取10个整数
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static int[] readData(File file) throws FileNotFoundException {
        int[] numbers = new int[10];
        try (Scanner input = new Scanner(file)) {
            for (int i = 0; i < 10; i++) {
                numbers[i] = input.nextInt();
            }
        }
        Arrays.sort(numbers);
        return numbers;
    }
    public static void main(String[] args) throws IOException {
        File file = new File("src\\Experiment7\\Exercise9_19.txt");
        // 判断文件存在，否则创建文件
        if (file.exists()) {
            try (PrintWriter writer = new PrintWriter(file)) {
                writeData(writer);
            }
        } else {
            file.createNewFile();
            try (PrintWriter writer = new PrintWriter(file)) {
                writeData(writer);
            }
        }
        // 从file中读取数据
        int[] numbers = readData(file);

        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }
}
