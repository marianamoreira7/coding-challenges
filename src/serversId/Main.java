package serversId;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
       Solution sol = new Solution();

        System.out.println("Caso 1");
        System.out.println(Arrays.toString(sol.serverId(5, 5, new int[]{3, 2, 3, 2, 4})));
        System.out.println("Resposta");
        System.out.println(Arrays.toString(new int[]{0, 1, 2, 0, 3}));

        System.out.println("Caso 2");
        System.out.println(Arrays.toString(sol.serverId(5, 4, new int[]{4, 0, 2, 2})));
        System.out.println("Resposta");
        System.out.println(Arrays.toString(new int[]{0, 0, 1, 2}));

        System.out.println("Caso 3");
        System.out.println(Arrays.toString(sol.serverId(5, 4, new int[]{0, 1, 2, 3})));
        System.out.println("Resposta");
        System.out.println(Arrays.toString(new int[]{0, 1, 2, 3}));
    }
}
