class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int copy[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            copy[i]=arr[i];
        }

        Arrays.sort(copy);
        HashMap<Integer,Integer> map = new HashMap<>();
        int largest = Integer.MIN_VALUE;
        int rank = 0;
        for(int i=0;i<copy.length;i++){
            if(copy[i]>largest){
                rank++;
                largest = copy[i];
                map.put(copy[i],rank);
            }else{
                map.put(copy[i],rank);
            }
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}