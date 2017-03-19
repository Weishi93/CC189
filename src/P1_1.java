/**
 * Created by Wei Shi on 3/19/17.
 */
public class P1_1 {
    /**
     * time: O(N), space: O(1)
     * @param s
     * @return
     */
    static boolean isUnique_1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean[] map = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]) {
                return false;
            }
            map[s.charAt(i)] = true;
        }
        return true;
    }

    /**
     * if input string only contains lowercase letters(or in other words, less 32 possibilities), we can use
     * only a variable to check instead of an array
     * @param s
     * @return
     */
    static boolean isUnique_2(String s) {
        int check = 0;
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if ((check & (1 << pos)) > 0) {
                return false;
            }
            check |= 1 << pos;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("asdfghjk: " + isUnique_2("asdfghjk"));
        System.out.println("aas: " + isUnique_2("aas"));
    }
}
