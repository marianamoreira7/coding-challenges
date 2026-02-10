package stock_price_fluctuation;

import java.util.*;

class StockPrice {

    HashMap<Integer, Integer> priceByTime;
    TreeMap<Integer, Integer> qtyByPrice;
    int latestTimestamp;

    public StockPrice() {
        this.latestTimestamp = 0;
        priceByTime = new HashMap<>();
        qtyByPrice = new TreeMap<>();
    }

    private void updateLatestTimestamp(int timestamp) {
        if (timestamp > this.latestTimestamp) {
            this.latestTimestamp = timestamp;
        }
    }

    private void updateIfContains(int timestamp) {
        if (priceByTime.containsKey(timestamp)) {
            int oldPrice = priceByTime.get(timestamp);
            int newQty = qtyByPrice.get(oldPrice) - 1;

            if (newQty == 0) {
                qtyByPrice.remove(oldPrice);
            } else {
                qtyByPrice.put(oldPrice, newQty);
            }
        }
    }

    public void update(int timestamp, int price) {

        updateIfContains(timestamp);

        priceByTime.put(timestamp, price);
        qtyByPrice.put(price, qtyByPrice.getOrDefault(price, 0) + 1);

        updateLatestTimestamp(timestamp);

    }

    public int current() {
        return priceByTime.get(latestTimestamp);
    }

    public int maximum() {
        return qtyByPrice.lastKey();
    }

    public int minimum() {
        return qtyByPrice.firstKey();
    }
}
