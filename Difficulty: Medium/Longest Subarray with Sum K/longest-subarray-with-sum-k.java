class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int pre[] = new int[arr.length];
        pre[0]=arr[0];
        map.put(arr[0],0);
        for(int i=1;i<arr.length;i++){
            pre[i]=pre[i-1]+arr[i];
            if(!map.containsKey(pre[i])){
                map.put(pre[i],i);
            }
        }
        
        
        int lon = 0;
        for(int i=0;i<pre.length;i++){
            if(pre[i]==k)lon=Math.max(i+1,lon);
            int to_find = pre[i]-k;
            if(map.containsKey(to_find)){
                int idx = map.get(to_find);
                int j = idx+1;
                lon = Math.max(lon,i-j+1);
            }
        }
        return lon;
    }
}
