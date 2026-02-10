package stock_price_fluctuation;

import common.ChallengeRunner;
import java.util.*;

public class StockPriceRunner extends ChallengeRunner<List<Object>> {

    @Override
    protected List<Object> execute(List<String> input) {
        List<String> operations = parseOperations(input.get(0));
        List<List<Integer>> params = parseParams(input.get(1));

        List<Object> results = new ArrayList<>();
        StockPrice stockPrice = null;

        for (int i = 0; i < operations.size(); i++) {
            switch (operations.get(i)) {
                case "StockPrice":
                    stockPrice = new StockPrice();
                    results.add(null);
                    break;
                case "update":
                    stockPrice.update(params.get(i).get(0), params.get(i).get(1));
                    results.add(null);
                    break;
                case "current":
                    results.add(stockPrice.current());
                    break;
                case "maximum":
                    results.add(stockPrice.maximum());
                    break;
                case "minimum":
                    results.add(stockPrice.minimum());
                    break;
            }
        }
        return results;
    }

    private List<String> parseOperations(String line) {
        line = line.replaceAll("\\[|\\]|\"", "");
        return Arrays.asList(line.split(",\\s*"));
    }

    private List<List<Integer>> parseParams(String line) {
        List<List<Integer>> allParams = new ArrayList<>();
        line = line.substring(1, line.length() - 1);
        String[] groups = line.split("\\],\\s*\\[");

        for (String group : groups) {
            group = group.replaceAll("\\[|\\]", "");
            List<Integer> params = new ArrayList<>();

            if (!group.isEmpty()) {
                for (String s : group.split(",")) {
                    params.add(Integer.parseInt(s.trim()));
                }
            }
            allParams.add(params);
        }
        return allParams;
    }
}
