package util;

import java.io.*;
import java.util.*;

public class FileUtil {

    public static void write(String fileName, String data) {

        try {

            FileWriter fw = new FileWriter(fileName, true);
            fw.write(data + "\n");
            fw.close();

        } catch (IOException e) {

            System.out.println("File write error.");
        }
    }

    public static List<String> read(String fileName) {

        List<String> list = new ArrayList<>();

        try {

            File file = new File(fileName);

            if (!file.exists())
                return list;

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {
                list.add(line);
            }

            br.close();

        } catch (IOException e) {

            System.out.println("File read error.");
        }

        return list;
    }
}
