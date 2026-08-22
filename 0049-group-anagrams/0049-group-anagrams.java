class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        String ch[][] = new String[strs.length][2];
        for(int i=0;i<strs.length;i++){
            char word[] = strs[i].toCharArray();
            Arrays.sort(word);
            ch[i][0]=new String(word);
            ch[i][1]=String.valueOf(i);
        }
       // Shorter modern syntax
        Arrays.sort(ch, (row1, row2) -> row1[0].compareTo(row2[0]));
        int i=0;
        while(i<strs.length){
            String word = ch[i][0];
            List<String> list = new ArrayList<>();
            list.add(strs[Integer.parseInt(ch[i][1])]);
            int j=i+1;
            for(;j<strs.length&&ch[j][0].equals(word);j++){
                list.add(strs[Integer.parseInt(ch[j][1])]);
            }
            i=j;
            ans.add(list);
        }

        return ans;
    }
}