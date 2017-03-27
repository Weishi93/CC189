import java.util.List;

/**
 * Created by Wei Shi on 3/25/17.
 */
public class P2_6 {
    /**
     * check if the given list is a palindrome
     * @param head
     * @return
     */
    static boolean isPalinList(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode mid = getMid(head);
        ListNode rightHalf = reverseList(mid.next);
        mid.next = null;
        while (head != null && rightHalf != null) {
            if (head.val != rightHalf.val) {
                return false;
            }
            head = head.next;
            rightHalf = rightHalf.next;
        }
        return true;
    }

    static ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static ListNode reverseList(ListNode head) {
        ListNode prev = null, curt = head;
        while (curt != null) {
            ListNode next = curt.next;
            curt.next = prev;
            prev = curt;
            curt = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(7);
        ListNode n6 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        n5.next = n6;
        System.out.println(isPalinList(n1));
    }
}
