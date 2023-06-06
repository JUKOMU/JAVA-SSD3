package Experiment7;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

public class MakeFile {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\Experiment7\\Exercise9_19.txt");
        if (file.exists()) {
            try (PrintWriter writer = new PrintWriter(file)){
                for (int i = 0; i <10;i++) {
                    writer.print((int)(Math.random()*10000));
                    writer.print(" ");
                }
            }
        } else {
            file.createNewFile();
            try (PrintWriter writer = new PrintWriter(file)){
                for (int i = 0; i <10;i++) {
                    writer.print((int)(Math.random()*10000));
                    writer.print(" ");
                }
            }
        }
        int[] numbers = new int[10];
        try (Scanner input = new Scanner(file)){
            for (int i = 0; i < 10;i++) {
                numbers[i] = input.nextInt();
            }
        }
        Arrays.sort(numbers);
        for (int i : numbers) {
            System.out.print(i+" ");
        }
    }
}
