package newId;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public int[] requestsByServers(int n, int[] server, int[] replaceId, int[] newId) {

        HashMap<Integer, Integer> serverMap = new HashMap<>();
        int[] answers = new int[n];

        for (int s : server) {
            serverMap.put(s, serverMap.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < n; i++) {

            int oldIdQuantity = serverMap.getOrDefault(replaceId[i],0);

            if(oldIdQuantity>0){
                serverMap.remove(replaceId[i]);
                serverMap.put(newId[i], serverMap.getOrDefault(newId[i], 0) + oldIdQuantity);
            }

           int total=0;
           for(var entry : serverMap.entrySet()) {
               total+=entry.getKey()*entry.getValue();
           }
           answers[i] = total;
        }

        return answers;
    }
}
