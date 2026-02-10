package common;

import java.io.*;
import java.util.*;

public class InputReader {

    public static List<String> readLines(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<String> lines = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();
        return lines;
    }
}
