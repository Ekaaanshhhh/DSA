class Solution {
    public boolean stoneGame(int[] arr) {
        int i=0;
        int j=arr.length-1;
        int alice_score = 0;
        int bob_score = 0;
        int turn = 1;
        while(i<j){
            if(turn%2!=0){
                if(arr[i]>arr[j]){
                    alice_score+=arr[i];
                    i++;
                }else{
                    alice_score+=arr[j];
                    j--;
                }
            }else{
                if(arr[i]>arr[j]){
                    bob_score+=arr[i];
                    i++;
                }else{
                    bob_score+=arr[j];
                    j--;
                }
            }
        }
        return alice_score>bob_score;
    }
}