package common;

import java.util.*;

public abstract class ChallengeRunner<T> {

    public void run(String inputPath, String outputPath) throws Exception {
        List<String> input = InputReader.readLines(inputPath);
        T result = execute(input);
        Object expected = OutputReader.read(outputPath);

        if (Objects.equals(result, expected)) {
            System.out.println("✅ TEST PASSED");
        } else {
            System.out.println("❌ TEST FAILED");
            System.out.println("Expected: " + expected);
            System.out.println("Actual  : " + result);
        }
    }

    protected abstract T execute(List<String> input) throws Exception;
}
