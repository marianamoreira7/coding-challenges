package max_consecutive_on;

import java.util.*;

public class Solution {

    public int getMaxConsecutiveON(String serverStates, int k) {
        int n = serverStates.length();
        int maxConsecutive=0;

        List<int[]> zeroIntervals = new ArrayList<>();
        Integer start=null;

        for(int i=0;i<n;i++){
            if(serverStates.charAt(i)=='0'){
                if(start==null){
                    start=i;
                }
            }else if(start!=null) {
                zeroIntervals.add(new int[]{start,i-1});
                start=null;
            }
        }

        if(start!=null){
            zeroIntervals.add(new int[]{start,n-1});
        }

        if (zeroIntervals.size() <= k) return n;

        for(int i=0;i<=zeroIntervals.size()-k;i++){
            int windowStart = (i==0) ? 0 : zeroIntervals.get(i-1)[1]+1;
            int windowEnd = (i+k>=zeroIntervals.size()) ? n-1 : zeroIntervals.get(i+k)[0]-1;

            int currConsecutive = windowEnd-windowStart+1;
            maxConsecutive=Math.max(maxConsecutive,currConsecutive);
        }


        return maxConsecutive;
    }

}
