/**
 * Created by Wei Shi on 3/20/17.
 */
public class P2_5 {
    /**
     * add two lists by digits
     * input: 7 -> 1 -> 6 and 5 -> 9 -> 2 is 617 + 295
     * output: 2 -> 1 -> 9 is 912
     * @param l1
     * @param l2
     * @return
     */
    static ListNode addLists(ListNode l1, ListNode l2) {
        return addLists(l1, l2, 0);
    }

    private static ListNode addLists(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int val = carry;
        if (l1 != null) {
            val += l1.val;
        }
        if (l2 != null) {
            val += l2.val;
        }

        ListNode res = new ListNode(val % 10);
        if (l1 != null || l2 != null) {
            res.next = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, val / 10);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;
        ListNode res = addLists(n1, n4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
