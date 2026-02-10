package max_consecutive_on;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
       Solution sol = new Solution();

        System.out.println("Caso 1");
        System.out.println(sol.getMaxConsecutiveON("00010",1));
        System.out.println("Resposta");
        System.out.println(4);

        System.out.println("Caso 2");
        System.out.println(sol.getMaxConsecutiveON("11101010110011",2));
        System.out.println("Resposta");
        System.out.println(8);

        System.out.println("Caso 3");
        System.out.println(sol.getMaxConsecutiveON("1110010110",2));
        System.out.println("Resposta");
        System.out.println(9);
    }
}
