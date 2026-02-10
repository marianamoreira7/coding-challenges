package strength_of_wizards;

import common.ChallengeRunner;

import java.util.List;

public class Runner extends ChallengeRunner<String> {

    @Override
    protected String execute(List<String> input) {
        String line = input.get(0)
                .replace("[", "")
                .replace("]", "");

        String[] parts = line.split(",");
        int[] arr = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }

        Solution solution = new Solution();
        return String.valueOf(solution.totalStrength(arr));
    }
}
