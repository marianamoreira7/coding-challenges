package sum_of_subarray_minimums;

import java.util.*;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;

        int[] left = new int[length];
        int[] right = new int[length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? length - i : stack.peek() - i;
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < length; i++) {
            sum = (sum + (long) arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) sum;
    }
}
