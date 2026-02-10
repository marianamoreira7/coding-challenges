# Maximum Consecutive ON Servers

## Problem Description

Amazon has a cluster of `n` servers. Some servers are **ON** while others are **OFF**.  
The developers responsible for maintaining the servers can perform a special operation:

- **Flip Operation**: Choose a contiguous sequence of servers and flip their status (`ON` ↔ `OFF`).
- **Constraint**: This operation can be performed **at most `k` times**.

Given a **binary string** `server_states` of length `n`, where `'1'` represents an **ON** server and `'0'` represents **OFF**, and an integer `k`, **find the maximum possible number of consecutive ON servers** after performing at most `k` flip operations.

---

## Function Signature

```java
int getMaxConsecutiveOn(String server_states, int k)
```
Parameters
```
server_states: A string representing the states of the servers, e.g., "1010".

k: Maximum number of flip operations allowed.

Returns
An integer representing the maximum number of consecutive ON servers after performing at most k operations.

Constraints
1 <= n <= 10^5

1 <= k <= n

server_states contains only '0' and '1'.

Example 1
Input:

server_states = "1001"
k = 2
Output:

4
```
Explanation:

Flip indices [1..2] → "1001" becomes "1111".

Maximum consecutive ON servers = 4.

Only 1 operation is needed, which is within the limit k = 2.

Example 2
Input:

server_states = "00010"
k = 1
Output:

4
Explanation:

Flip indices [0..2] → "00010" becomes "11110".

Maximum consecutive ON servers = 4.

Only 1 operation is needed.

Notes
The goal is to maximize consecutive '1's using at most k contiguous flips.

Optimal solutions often use sliding window or two-pointer techniques for efficiency.

Time complexity target: O(n).