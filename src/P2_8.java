/**
 * Created by Wei Shi on 3/28/17.
 */
public class P2_8 {
    static ListNode detectLoop(ListNode head) {
        ListNode slow = head, fast = head;
        do {
            if (slow == null || fast == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;
        System.out.println(detectLoop(n1).val);
    }
}
