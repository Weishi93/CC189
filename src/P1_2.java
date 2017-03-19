import java.util.Arrays;

/**
 * Created by Wei Shi on 3/19/17.
 */
public class P1_2 {
    /**
     * check if one string is another's permutation
     * sort:
     * @param s1
     * @param s2
     * @return
     */
    static boolean isPermutation_1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1_arr = s1.toCharArray();
        char[] s2_arr = s2.toCharArray();
        Arrays.sort(s1_arr);
        Arrays.sort(s2_arr);
        for (int i = 0; i < s1.length(); i++) {
            if (s1_arr[i] != s2_arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutation_1("asd", "das"));
        System.out.println(isPermutation_1("asdqwe", "asdzx"));
        System.out.println(isPermutation_1("asd", "asf"));
    }
}
