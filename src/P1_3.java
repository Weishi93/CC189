import java.util.Arrays;

/**
 * Created by Wei Shi on 3/19/17.
 */
public class P1_3 {
    static void replaceSpace(char[] str, int length) {
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        int index = length + spaceCount * 2;
        for (int i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {
        char[] str = new char[]{'a', ' ', 'b', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',};
        replaceSpace(str, 3);
        System.out.println(Arrays.toString(str));
    }
}
