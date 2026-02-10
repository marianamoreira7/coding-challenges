package common;

import java.io.*;
import java.util.*;

public class OutputReader {

    public static Object read(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        br.close();

        if (line.startsWith("[") && line.endsWith("]")) {
            return parseArray(line);
        }
        return line;
    }

    private static List<Object> parseArray(String line) {
        line = line.substring(1, line.length() - 1);
        List<Object> result = new ArrayList<>();

        if (line.isEmpty()) return result;

        for (String s : line.split(",\\s*")) {
            result.add(s.equals("null") ? null : Integer.parseInt(s));
        }
        return result;
    }
}
