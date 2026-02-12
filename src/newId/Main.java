package newId;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
       Solution sol = new Solution();

        System.out.println("Caso 1");
        System.out.println(Arrays.toString(sol.requestsByServers(2, new int[]{20, 10}, new int[]{10, 20}, new int[]{20, 1})));
        System.out.println("Resposta");
        System.out.println(Arrays.toString(new int[]{40, 2}));

        System.out.println("Caso 2");
        System.out.println(Arrays.toString(sol.requestsByServers(3, new int[]{2,5,2}, new int[]{2,5,3}, new int[]{3,1,5})));
        System.out.println("Resposta");
        System.out.println(Arrays.toString(new int[]{11,7,11}));

    }
}
