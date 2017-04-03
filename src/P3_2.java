import java.util.Stack;

/**
 * Created by Wei Shi on 4/3/17.
 */
public class P3_2 {
    static class MinStack {
        Stack<Integer> stack, min;
        public MinStack() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int value) {
            stack.push(value);
            if (min.empty()) {
                min.push(value);
            } else {
                min.push(value < min.peek() ? value : min.peek());
            }
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public int getMin() {
            return min.peek();
        }
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(4);
        ms.push(3);
        ms.push(2);
        ms.push(1);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }
}
