/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> arrli=new ArrayList<>();
        int len=0;
        int ans[]=new int[2];
        Arrays.fill(ans,-1);
        if(head==null || head.next==null||head.next.next==null)return ans;
        ListNode travel=head.next;
        ListNode prev=head;
        // ListNode next=null;
        int point =1;
        while(travel.next!=null)
        {
            int curr=travel.val;
            int previous=prev.val;
            int next1=travel.next.val;
            if(curr>previous && curr>next1)
            {
                arrli.add(point);
            }
            if(curr<previous && curr<next1){
                arrli.add(point);
            }
            point++;
            prev=travel;
            travel=travel.next;
        }
        if(arrli.size()==0 || arrli.size()==1)return ans;
        int min=Integer.MAX_VALUE;
        for(int i = 0; i < arrli.size() - 1; i++){
            min = Math.min(min, arrli.get(i + 1) - arrli.get(i));
        }
        ans[0]=min;
        ans[1]=arrli.get(arrli.size()-1)-arrli.get(0);
        return ans;
        
    }
}