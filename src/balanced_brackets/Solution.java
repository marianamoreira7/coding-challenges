import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {

        char[] close = {']', '}', ')'};
        char[] open = {'[', '{', '('};
        char[] stack = new char[s.length()];
        int size =0;

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i)==open[0] || s.charAt(i)==open[1]||s.charAt(i)==open[2]) {
                stack[size] = s.charAt(i);
                size++;
            }
            else if (s.charAt(i)==close[0] && stack[size-1] == open[0]
                    || s.charAt(i)==close[1] && stack[size-1] == open[1]
                    || s.charAt(i)==close[2] && stack[size-1] == open[2]) {
                stack[size-1]=' ';
                size--;
            } else {return "NO";}

        }

        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
