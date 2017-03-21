/**
 * Created by Wei Shi on 3/20/17.
 */
public class P2_2 {
    /**
     * return the kth element to the last
     * @param head
     * @param k
     * @return
     */
    static ListNode kthToLast(ListNode head, int k) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                throw new NullPointerException();
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(kthToLast(n1, 5).val);
    }
}
