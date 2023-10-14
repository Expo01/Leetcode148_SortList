public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

// Essentially just recursive merge sort
public class Solution {

    public ListNode sortList(ListNode head) { // if 0 or 1 items, already sorted, so return
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // cut the list in half so list 1 head and tail are head and prev
        // second half head/tail are slow and fast

        // step 2. sort each half
        ListNode l1 = sortList(head); // recursive calls where eventually only 1 node is passed foor
        ListNode l2 = sortList(slow); // base case of head.next == null so node returned

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0), p = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) { // take the lesser node, link preceding node in merged list and
                p.next = l1;
                l1 = l1.next; // increment to next node in that list
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next; // increment p regardless to the newly added node to be ready to point to next merged node
        }
        // one of the two lists will have remaining content. link remaining coontent fromr that list
        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return preHead.next; // return true heead
    }

}













class Solution {
    public ListNode sortList(ListNode head) {
        ListNode cur = head;
        ListNode stored = head;
        while(how to ID cycle?){
            cur = head;
            stored = head;
            while(stored.val > cur.next.val){
                cur = cur.next;
            }
            head = stored.next;
            stored.next = cur.next;
            cur.next = stored;
        }
        // problm of say 1,2,3,5,4 will never get past 1. how to iterate
    }
}

// idea have a dummy head, then take the first node. loop through and compare cur val to next and if higher val foound then link it. will also need lagg to link have the preciding num point to it. then reset the lag to dummy and cur to dummy.next
// at worst this could be O(n2) almost if the whole list is in reverse order
