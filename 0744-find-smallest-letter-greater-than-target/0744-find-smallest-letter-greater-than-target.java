class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for(char ch:letters){
            if((int)ch-'a'>(int)target-'a'){
                return ch;
            }
        }
        return letters[0];
    }
}