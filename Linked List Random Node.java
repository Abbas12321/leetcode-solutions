public class Solution {
 
    Random r = null;
    ListNode h = null;
 
    public Solution(ListNode head) {
        r = new Random();
        h = head;
    }
 
    /** Returns a random node's value. */
    public int getRandom() {
        int count=1;
        ListNode p = h;
        int result = 0;
        while(p!=null){
            if(r.nextInt(count)==0)
                result= p.val;
            count++;
            p = p.next;
        }
        return result;
    }
}
