class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ch=s.toCharArray();
        char[] ch1=t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch);
        if(ch1.length!=ch.length)return false;
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]!=ch1[i])return false;
        }
        return true;
    }
}