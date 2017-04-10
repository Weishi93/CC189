import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * Created by Wei Shi on 4/9/17.
 */
public class P3_3 {
    public static void main(String[] args) {
        SetOfStack<Integer> stacks = new SetOfStack<>(3);
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.push(6);
        stacks.push(7);
        stacks.push(8);
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
    }
}

/**
 * A set of Stacks
 * @param <T>
 */
class SetOfStack<T> {
    List<Stack<T>> list;
    int capacity;
    public SetOfStack(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>();
    }

    public void push(T val) {
        int lastIndex = list.size() - 1;
        if (lastIndex < 0 || list.get(lastIndex).size() == capacity) {
            list.add(new Stack<T>());
            lastIndex++;
        }
        list.get(lastIndex).push(val);
    }

    public T pop() {
        int lastIndex = list.size() - 1;
        if (lastIndex < 0) {
            throw new EmptyStackException();
        }
        if (list.get(lastIndex).size() == 0) {
            list.remove(lastIndex);
            return pop();
        }
        return list.get(lastIndex).pop();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
