/**
 * Created by Wei Shi on 3/19/17.
 */
public class P1_5 {
    /**
     * check if there is one and only one edit distance between two strings. Edits include insert, delete or
     * change a character
     * @param s
     * @param t
     * @return
     */
    static boolean oneEdit(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

    public static void main(String[] args) {
        System.out.println(oneEdit("asd", "asd"));
        System.out.println(oneEdit("asd", "as"));
        System.out.println(oneEdit("asd", "asdd"));
        System.out.println(oneEdit("asd", "asc"));

    }
}
