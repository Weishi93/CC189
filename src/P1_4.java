/**
 * Created by Wei Shi on 3/19/17.
 */
public class P1_4 {
    static boolean isPalinPermu(String s) {
        boolean[] map = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)] = !map[s.charAt(i)];
        }
        int res = 0;
        for (boolean b : map) {
            if (b) {
                res++;
            }
        }
        return res <= 1;
    }

    public static void main(String[] args) {
        System.out.println(isPalinPermu("aas"));
        System.out.println(isPalinPermu("tac cta"));
    }
}
