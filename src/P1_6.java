/**
 * Created by Wei Shi on 3/19/17.
 */
public class P1_6 {
    static String compressString(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                sb.append(count);
                count = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aaaabssskkd"));
    }
}
