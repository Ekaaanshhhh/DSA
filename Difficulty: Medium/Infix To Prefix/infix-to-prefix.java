class Solution {
    static String infixToPrefix(String s) {
        // code here
        StringBuilder sb = new StringBuilder("");
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='(')sb.append(')');
            else if(s.charAt(i)==')')sb.append('(');
            else sb.append(s.charAt(i));
        }
        
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder("");
        for(int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);
            if((ch>='a' && ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9')){
                ans.append(ch);
            }
            else if(ch=='('){
                stack.push(ch);
            }
            else if(ch==')'){
                while(stack.peek()!='('){
                    ans.append(stack.pop());
                }
                stack.pop();
            }
            else{
                if(stack.isEmpty())stack.push(ch);
                else {
                    while(!stack.isEmpty() && shouldwepop(stack.peek(),ch)){
                        ans.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
        }
        while(!stack.isEmpty())ans.append(stack.pop());
        return ans.reverse().toString();
    }
    public static int prio(char ch){
        if(ch=='^')return 3;
        if(ch=='*' || ch=='/')return 2;
        if(ch=='+' || ch=='-')return 1;
        return 0;
    }
    public static boolean shouldwepop(char a,char b){
        int p1=prio(a);
        int p2 = prio(b);
        if(p1==p2){
            if(a=='^')return true;
            return false;
        }
        return p1>p2;
    }
}