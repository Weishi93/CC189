import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Wei Shi on 3/27/17.
 */
public class P2_7 {
    /**
     * check if two linked lists have intersection.
     * 1 -> 2 -> 3 -> 4 -> 5 ->
     *                           9 -> null
     *                      8 ->
     * @param l1
     * @param l2
     * @return
     */
    static ListNode intersection_1(ListNode l1, ListNode l2) {
        Set<ListNode> set = new HashSet<>();
        while (l1 != null && l2 != null) {
            if (!set.add(l1)) {
                return l1;
            }
            if (!set.add(l2)) {
                return l2;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }

    static ListNode intersection_2(ListNode l1, ListNode l2) {
        ListNode a = l1, b = l2;
        while (a != b) {
            a = a == null ? l2 : a.next;
            b = b == null ? l1 : b.next;
        }
        return a;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(66);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(7);
        ListNode n6 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n3;

        System.out.println(intersection_2(n1, n4).val);
    }
}
