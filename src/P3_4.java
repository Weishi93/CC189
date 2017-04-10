import java.util.Stack;

/**
 * Created by Wei Shi on 4/10/17.
 */
public class P3_4 {
    /**
     * Implement queue using 2 stacks.
     * @param <T>
     */
    static class MyQueue<T> {
        private Stack<T> s1, s2;
        public MyQueue() {
            s1 = new Stack<T>();
            s2 = new Stack<T>();
        }
        public void push(T val) {
            s1.push(val);
        }

        public T poll() {
            peek();
            return s2.pop();
        }
        public T peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<>();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.poll());
        q.push(4);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}

