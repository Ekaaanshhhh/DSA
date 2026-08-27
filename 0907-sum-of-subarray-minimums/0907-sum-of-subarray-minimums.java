import java.util.Stack;

class Solution {
    static int mod = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int nse[] = new int[arr.length];
        int pse[] = new int[arr.length];
        
        findnse(arr, nse);
        findpse(arr, pse);

        long ans = 0; // Use long to prevent integer overflow before applying mod
        for (int i = 0; i < arr.length; i++) {
            int low = (pse[i] == -1 ? 0 : pse[i] + 1);
            int high = (nse[i] == -1 ? arr.length - 1 : nse[i] - 1);
            
            long left_contri = i - low + 1;
            long right_contri = high - i + 1;
            
            // Cast to long during multiplication to avoid overflow
            long total_subarrays = (left_contri * right_contri) % mod;
            long contribution = (arr[i] * total_subarrays) % mod;
            
            ans = (ans + contribution) % mod;
        }
        return (int) ans;
    }

    public void findnse(int arr[], int nse[]) {
        Stack<Integer> stack = new Stack<>();
        // Process from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // Strict inequality (>=) here
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i); // FIXED: Push the index 'i', not the value 'el'
        }
    }

    public void findpse(int arr[], int pse[]) {
        Stack<Integer> stack = new Stack<>();
        // Process from left to right
        for (int i = 0; i < arr.length; i++) {
            // Strict inequality (>) here to perfectly handle duplicate values
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i); // FIXED: Push the index 'i', not the value 'el'
        }
    }
}
