class Solution {
    public int reverse(int x) {
        boolean flag= false;
        if(x<0)
        {
            flag= true;
            x=-x;
        }
        int prev_revnum=0;int rev_num=0; 
     int newnum=0;
        while(x!=0)
        {
            int temp=x%10;
            rev_num= rev_num*10+temp;
            if((rev_num-temp)/10!=prev_revnum)
            {
                return 0;
            }
            prev_revnum= rev_num;
            x=x/10;
        }
         return (flag == true)? -rev_num : rev_num;
    }
}