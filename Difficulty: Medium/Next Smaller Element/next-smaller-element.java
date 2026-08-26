class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++)ans.add(-1);
        stack.push(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--){
            int el = arr[i];
            if(el>stack.peek()){
                ans.set(i,stack.peek());
            }else{
                while(!stack.isEmpty() && el<=stack.peek()){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    ans.set(i,stack.peek());
                }
            }
            stack.push(el);
        }
        return ans;
    }
}