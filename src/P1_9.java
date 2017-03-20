/**
 * Created by Wei Shi on 2017/3/19.
 */
public class P1_9 {
    /**
     * there is a given function isSubstring(). How can you just use this function once to know if s2 is a
     * rotation of s1
     * @param s1
     * @param s2
     * @return
     */
    static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s1s1 = s1 + s1;
        return isSubstring(s2, s1s1);
    }

    /**
     * check if s1 is a substring of s2
     * @param s1
     * @param s2
     * @return
     */
    static boolean isSubstring(String s1, String s2) {
        return s2.contains(s1);
    }

    public static void main(String[] args) {
        System.out.println(isRotation("abcde", "cdeab"));
        System.out.println(isRotation("abcde", "dceab"));

    }
}
