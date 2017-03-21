import java.util.List;

/**
 * Created by Wei Shi on 3/20/17.
 */
public class P2_3 {
    /**
     * delete the given node in a singly linked list
     * @param curt
     * @return
     */
    static boolean deleteNode(ListNode curt) {
        if (curt == null || curt.next == null) {
            return false;
        }

        curt.val = curt.next.val;
        curt.next = curt.next.next;
        return true;
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
        deleteNode(n3);
        ListNode res = n1;
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
