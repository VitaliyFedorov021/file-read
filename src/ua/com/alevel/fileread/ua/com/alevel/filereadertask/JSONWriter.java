package ua.com.alevel.fileread.ua.com.alevel.filereadertask;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JSONWriter {
    public static void main(String[] args) {
        JSONWriter jsonWriter = new JSONWriter();
        jsonWriter.run();
    }

    private void run() {
        System.out.println("Please type key-value pair");
        Scanner sc = new Scanner(System.in);
        Map<String, String> pairs = new HashMap<>();
        readData(sc, pairs);
        writeDataToFile(sc, pairs);
    }

    private void writeDataToFile(Scanner sc, Map<String, String> pairs) {
        try (FileWriter fileWriter = new FileWriter("src/ua/com/alevel/fileread/words.txt")) {
            fileWriter.append("{");
            int count = 0;
            for (Map.Entry<String, String> currentEntry:
                 pairs.entrySet()) {
                count++;
                fileWriter.write("\" " + currentEntry.getKey() + "\"" + currentEntry.getValue() + "\"");
                if (count < pairs.size()) {
                    fileWriter.append(",");
                }

            }
            fileWriter.append("}");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readData(Scanner sc, Map<String, String> pairs) {
        while(sc.hasNext()) {
            String line = sc.nextLine();
            if ("end".equalsIgnoreCase(line.trim())) {
                break;
            }
            String[] entry = line.split("=");
            pairs.put(entry[0].trim(), entry[1].trim());
        }
    }

}
