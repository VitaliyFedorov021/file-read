package ua.com.alevel.fileread;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InputFromFile {
    public static void main(String[] args) {
        String filePath = "src/ua/com/alevel/fileread/words.txt";
        Map<Integer, Integer> count = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int b, countOfWords = 0;
            while( (b = fis.read()) != -1) {
                if (b == '\n') {
                    count.put(count.size() + 1, countOfWords + 1);
                    countOfWords = 0;
                }
                if (b == ' ') {
                    countOfWords++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<Integer, Integer> currentMap:
             count.entrySet()) {
            System.out.println("Line " + currentMap.getKey() + " " + " Words: " + currentMap.getValue());
        }
    }
}
