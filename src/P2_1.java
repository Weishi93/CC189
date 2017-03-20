import java.util.HashSet;
import java.util.Set;

/**
 * Created by Wei Shi on 3/20/17.
 */
public class P2_1 {
    /**
     * Remove duplicates from an unsorted linked list
     * @param head
     * @return
     */
    static ListNode removeDup_1(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode prev = null, curt = head;
        while (curt != null) {
            if (set.contains(curt.val)) {
                prev.next = curt.next;
            } else {
                set.add(curt.val);
                prev = curt;
            }
            curt = curt.next;
        }
        return head;
    }

    static ListNode removeDup_2(ListNode head) {
        ListNode curt = head;
        while (curt != null) {
            ListNode runner = curt;
            while (runner.next != null) {
                if (runner.next.val == curt.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            curt = curt.next;
        }
        return head;
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
        ListNode res = removeDup_2(n1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
