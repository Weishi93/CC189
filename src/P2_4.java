/**
 * Created by Wei Shi on 3/20/17.
 */
public class P2_4 {
    static ListNode partitionList_1(ListNode head, int pivot) {
        ListNode lessDummy = new ListNode(-1);
        ListNode moreDummy = new ListNode(-1);
        ListNode less = lessDummy, more = moreDummy;

        while (head != null) {
            if (head.val < pivot) {
                less.next = head;
                less = less.next;
            } else {
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }
        less.next = moreDummy.next;
        more.next = null;
        return lessDummy.next;
    }

    static ListNode partitionList_2(ListNode head, int pivot) {
        ListNode start = head, end = head;
        while (head != null) {
            ListNode next = head.next;
            if (head.val < pivot) {
                head.next = start;
                start = head;
            } else {
                end.next = head;
                end = end.next;
            }
            head = next;
        }
        end.next = null;
        return start;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode res = partitionList_2(n1, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
