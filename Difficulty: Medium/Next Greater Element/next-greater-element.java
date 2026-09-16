class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> nge = new ArrayList<>();
        for(int i=0;i<arr.length;i++)nge.add(-1);
        stack.push(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--){
            int el = arr[i];
            if(el<stack.peek()){
                nge.set(i,stack.peek());
            }else{
                while(!stack.isEmpty() && stack.peek()<=el){
                    stack.pop();
                }
                if(stack.isEmpty())nge.set(i,-1);
                else nge.set(i,stack.peek());
            }
            stack.push(el);
        }
        return nge;
    }
}