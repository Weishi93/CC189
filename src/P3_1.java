import java.util.EmptyStackException;

/**
 * Created by Wei Shi on 3/30/17.
 */
public class P3_1 {
    static class MultiStack {
        int stackNum, stackSize;
        private int[] values;
        private int[] sizes;

        public MultiStack(int stackNum, int stackSize) {
            this.stackNum = stackNum;
            this.stackSize = stackSize;
            values = new int[stackNum * stackSize];
            sizes = new int[stackNum];
        }

        public void push(int num, int value) {
            if (num < 0 || num >= stackNum) {
                throw new IllegalArgumentException();
            }
            if (sizes[num] >= stackSize) {
                System.out.println("Stack " + num + " is full!");
            }
            values[num * stackSize + sizes[num]] = value;
            sizes[num]++;
        }

        public int pop(int num) {
            int res = peek(num);
            sizes[num]--;
            return res;
        }

        public int peek(int num) {
            if (num < 0 || num >= stackNum) {
                throw new IllegalArgumentException();
            }
            if (sizes[num] == 0) {
                throw new EmptyStackException();
            }
            return values[num * stackSize + sizes[num] - 1];
        }

        public boolean isEmpty(int num) {
            if (num < 0 || num >= stackNum) {
                throw new IllegalArgumentException();
            }
            return sizes[num] == 0;
        }
    }

    public static void main(String[] args) {
        MultiStack ms = new MultiStack(3, 5);
        ms.push(0,1);
        ms.push(1,6);
        ms.push(1,7);
        ms.push(2,10);
        System.out.println(ms.isEmpty(0)); // false
        System.out.println(ms.isEmpty(1)); // false
        System.out.println(ms.isEmpty(2)); // false
        System.out.println(ms.peek(0)); // 1
        System.out.println(ms.pop(0)); // 1 out
        System.out.println(ms.isEmpty(0));
        System.out.println(ms.peek(1)); // 7
        System.out.println(ms.pop(1)); // 7 out
        System.out.println(ms.peek(1)); // 6
        System.out.println(ms.peek(2)); // 10
        System.out.println(ms.peek(0)); // EmptyStackException

    }

}
