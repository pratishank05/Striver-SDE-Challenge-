class Solution {
    public boolean isValid(String s) { 
 Stack<Character> stack = new Stack<>();
    for(int i=0;i<s.length();i++){
        char currentElement = s.charAt(i);

        if(isOpening(currentElement)) stack.push(currentElement);
        else{
            if(stack.isEmpty()) return false;
            else if(!isMatching(stack.peek(),currentElement)) return false;
            else stack.pop();
        }
    }
    if(stack.isEmpty()) return true;
    return false;
}

static boolean isOpening(char c){
    return c == '(' || c == '{' || c == '[';
}

static boolean isMatching(char a, char b){
    return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
}


}