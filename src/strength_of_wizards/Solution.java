package strength_of_wizards;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int totalStrength(int[] strength) {

        int size = strength.length;

        Deque<Integer> stack = new ArrayDeque<>();

        int[] left = new int[size];
        int[] right = new int[size];

        long[] prefix = new long[size+1];
        long[] prefixPrefix = new long[size+2];

        for(int i = 0; i < size; i++){
            prefix[i+1]=(prefix[i]+strength[i])%MOD;
        }

        for(int i = 0; i <= size; i++){
            prefixPrefix[i+1]=(prefixPrefix[i]+prefix[i])%MOD;
        }

        for (int i = 0; i < size; i++) {
            while(!stack.isEmpty() && strength[stack.peek()] > strength[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        for(int i=size-1;i>=0;i--){
            while(!stack.isEmpty() && strength[stack.peek()] >= strength[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? size: stack.peek();
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < size; i++) {
            int r = right[i];
            int l = left[i];
            int leftCount = i-l;
            int rightCount = r-i;

            long sumRight = (prefixPrefix[r+1]-prefixPrefix[i+1]+MOD)%MOD;
            long sumLeft = (prefixPrefix[i+1]-prefixPrefix[l+1]+MOD)%MOD;

            long contribution = (sumRight * leftCount - sumLeft * rightCount % MOD+MOD)%MOD;

            sum = (sum + (long) strength[i]*contribution) % MOD;
        }

        return (int) sum;
    }
}
