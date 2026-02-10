package serversId;

public class Solution {

    public int[] serverId (int numServers, int n, int[] request) {
        int[] serverIds = new int[n];
        int[] serverAllocation = new int[numServers];

        for(int i=0;i<n;i++){
            int minServer = serverAllocation[0];
            int minAllocationId=0;

            for(int j=0;j<=request[i];j++){
                if(serverAllocation[j]<minServer) {
                    minServer = serverAllocation[j];
                    minAllocationId=j;
                }
            }

            serverIds[i]=minAllocationId;
            serverAllocation[minAllocationId]++;

        }
        
        return serverIds;
    }

}
