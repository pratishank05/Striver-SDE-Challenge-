class Solution {
    public void reverseString(char[] s) {
        int mid=s.length/2;
        int end=s.length-1;
        for(int i=0;i<mid;i++)
        {
            char temp=s[i];
            s[i]=s[end-i];
            s[end-i]=temp;
        }
    }
}