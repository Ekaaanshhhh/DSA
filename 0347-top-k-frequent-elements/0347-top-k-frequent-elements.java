class Solution {
    class Pair implements Comparable<Pair>{
        int element;
        int freq;
        public Pair(int e,int f){
            element = e;
            freq = f;
        }

        public int compareTo(Pair that){
            return that.freq-this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key:map.keySet()){
            int e = key;
            int f = map.get(key);
            pq.add(new Pair(e,f));
        }

        int ans[] = new int[k];
        int j=0;
        while(k-->0){
            ans[j++] = pq.remove().element;
        }

        return ans;
    }
}