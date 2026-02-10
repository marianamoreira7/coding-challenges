# 📈 Stock Price Fluctuation

Solution for **LeetCode 2034 – Stock Price Fluctuation**.

The goal is to design a data structure that handles a stream of stock price updates that may arrive **out of order** and may include **corrections**, while efficiently supporting queries for:

- the latest price
- the maximum price
- the minimum price

---

## 🧠 Problem Overview

You are given a stream of records for a stock.  
Each record contains:

- `timestamp`: the time of the price record
- `price`: the stock price at that time

Challenges:
- Records are **not ordered by timestamp**
- A record with the same timestamp may appear later to **correct** a previous price

The data structure must support the following operations:

- **update(timestamp, price)**  
  Updates or corrects the stock price at the given timestamp

- **current()**  
  Returns the latest stock price (price at the highest timestamp)

- **maximum()**  
  Returns the maximum stock price so far

- **minimum()**  
  Returns the minimum stock price so far

---

## 🛠️ Solution Approach

The solution uses two main data structures:

### 🔹 `HashMap<Integer, Integer>`
- Maps `timestamp → price`
- Allows constant-time updates and lookups

### 🔹 `TreeMap<Integer, Integer>`
- Maps `price → frequency`
- Keeps prices sorted
- Enables efficient retrieval of minimum and maximum prices

Additionally:
- A variable `latestTimestamp` tracks the most recent timestamp

---

## ⏱️ Time Complexity

| Operation | Complexity |
|---------|------------|
| `update` | O(log n) |
| `current` | O(1) |
| `maximum` | O(log n) |
| `minimum` | O(log n) |

This solution efficiently meets the problem constraints.

---

## ✅ Example

### Input
```text
["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
[[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
```
### Output
```text
[null, null, null, 5, 10, null, 5, null, 2]
```
### Explanation
```text
StockPrice stockPrice = new StockPrice();
stockPrice.update(1, 10); // prices: [10]
stockPrice.update(2, 5);  // prices: [10, 5]
stockPrice.current();     // returns 5
stockPrice.maximum();     // returns 10
stockPrice.update(1, 3);  // corrects timestamp 1
stockPrice.maximum();     // returns 5
stockPrice.update(4, 2);  // adds new timestamp
stockPrice.minimum();     // returns 2
```