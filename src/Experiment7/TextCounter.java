import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextCounter {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:\\Java\\JAVA-SSD3\\src\\Experiment7", args[0]);
        byte[] bytes = Files.readAllBytes(path);
        /**
         * 9-Tab
         * 10-换行
         * 13-回车
         * 32-空格
         * 48-57 0-9
         * 65-90 A-Z
         * 97-122 a-z
         */
        int line = 1; // 记录行数，并认为完全空文本为一行
        int words = 0; // 记录单词数
        int chars = 0; // 记录字符数
        boolean isChars = false;
        for (byte b : bytes) {
            if (b == 9 || b == 10 || b == 13 || b == 32) {
                isChars = false;
                if (b == 10) {
                    line++;
                }
            } else {
                chars++;
                // 仅当从非字母字符读到字母字符时读取了一个新单词
                if (!isChars) {
                    words++;
                    isChars = true;
                }
            }
        }
        System.out.println("File " + args[0] + " has");
        System.out.println(chars + " characters");
        System.out.println(words + " words");
        System.out.println(line + " lines");
    }
}
