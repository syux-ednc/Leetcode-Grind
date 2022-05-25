package medium;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode temp = answer;

        int sumValue, storeValue;
        boolean hasCarry = false;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                //Sum the 2 values first
                sumValue = l1.val + l2.val + (hasCarry ? 1 : 0);

                //Check if got carry (means more than 9)
                hasCarry = sumValue > 9;

                //If no carry store sumValue, else store the value w/o carry bit
                storeValue = hasCarry ? sumValue - 10 : sumValue;
                answer.next = new ListNode(storeValue);

                //Shift everything to next node to proceed
                l1 = l1.next;
                l2 = l2.next;
            } else {
                sumValue = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + (hasCarry ? 1 : 0);
                hasCarry = sumValue > 9;
                storeValue = hasCarry ? sumValue - 10 : sumValue;
                answer.next = new ListNode(storeValue);
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            answer = answer.next;
        }

        if (hasCarry) {
            answer.next = new ListNode(1);
        }

        return temp.next;
    }
}
