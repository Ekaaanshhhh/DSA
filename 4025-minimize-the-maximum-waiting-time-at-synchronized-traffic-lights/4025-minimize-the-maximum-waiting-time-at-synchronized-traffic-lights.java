class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        Arrays.sort(lights);
        Arrays.sort(arrivalTime);
        int max_penalty = Integer.MIN_VALUE;
        int i=lights[lights.length-1];
        for(int index=0;index<arrivalTime.length;index++){
            int r = arrivalTime[index]%period;
            if(r<i)continue;
            else{
                max_penalty = Math.max(max_penalty,period-r);
            }
        }
        return max_penalty==Integer.MIN_VALUE?0:max_penalty;
    }
}