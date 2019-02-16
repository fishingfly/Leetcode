package leetcode;


//  Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

/**
 * @Auther: user
 * @Date: 2019/2/12 22:02
 * @Description:
 */


public class AddTwoNumbers {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int jinwei = 0;
            ListNode result = null;
            ListNode lastNode = null;
            while (l1 != null || l2 != null || jinwei != 0) {
                lastNode = result;
                int sum = 0;
                if (l1 != null && l2 != null){
                    sum = l1.val + l2.val + jinwei;
                    result = new ListNode(sum%10);
                } else if (l1 != null && l2 == null) {
                    sum = l1.val + jinwei;
                    result = new ListNode(sum%10);
                } else if (l2 != null && l1 == null) {
                    sum = l2.val + jinwei;
                    result = new ListNode(sum%10);
                } else {
                    if (jinwei != 0) {
                        sum = jinwei;
                        result = new ListNode(jinwei%10);
                    }
                }
                jinwei = sum / 10;
                if (result != null)
                    result.next = lastNode;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            return reverseNode(result);
        }
//标准答案；我的运行时间超过68%
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;
//    }

        public ListNode reverseNode(ListNode l1) {
            ListNode node1 = null;
            ListNode last = null;
            while (l1 != null) {
                last = node1;
                node1 = new ListNode(l1.val);
                l1 = l1.next;
                node1.next = last;
            }
            return node1;
        }

        public static void main(String[] args) {
            AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
            ListNode n1 = new ListNode(1);
            n1.next = new ListNode(8);
            ListNode n2 = new ListNode(0);
            ListNode result = addTwoNumbers.addTwoNumbers(n1,n2);
            while (result != null){
                System.out.println(result.val+",");
                result = result.next;
            }
        }
}
