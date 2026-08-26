class Solution {
    class Element{
        int row;
        int col;
        StringBuilder sb;
        public Element(int r,int c,StringBuilder sb){
            this.row = r;
            this.col = c;
            this.sb =new StringBuilder(sb);
        }
    }
    public String alphabetBoardPath(String target) {
       char arr[][] = new char[6][5];
       char ch='a';
       for(int i=0;i<6;i++){
        for(int j=0;j<5;j++){
            if(j==5 && i==1){
                arr[i][j]='z';
            }else if(j==5){
                arr[i][j]='#';
            }else{
                arr[i][j]=ch;
                ch++;
            }
        }
       }

       int index=0;
       StringBuilder ans = new StringBuilder("");
       int startr = 0;
       int startc = 0;
       while(index<target.length()){
            Element e = bfs(arr,startr,startc,ans,target,index);
            startr = e.row;
            startc = e.col;
            index++;
       } 
       return ans.toString();
    }

    public Element bfs(char arr[][],int sr,int sc,StringBuilder ans,String target,int index){
        Queue<Element> q = new LinkedList<>();
        q.add(new Element(sr,sc,new StringBuilder()));
        boolean vis[][] = new boolean[arr.length][arr[0].length];
        vis[sr][sc]=true;
        while(!q.isEmpty()){
            Element e = q.remove();
            int row =e.row;
            int col =e.col;
            StringBuilder semi = e.sb;
            if(arr[row][col]==target.charAt(index)){
                semi.append("!");
                ans.append(new StringBuilder(semi));
                return new Element(row,col,new StringBuilder(semi));
            }

            if(row-1>=0 && arr[row-1][col]!='#' && !vis[row-1][col]){
                vis[row-1][col]=true;
                semi.append('U');
                q.add(new Element(row-1,col,new StringBuilder(semi)));
                semi.setLength(semi.length()-1);
            }
            if(col-1>=0 && arr[row][col-1]!='#' && !vis[row][col-1]){
                vis[row][col-1]=true;
                semi.append('L');
                q.add(new Element(row,col-1,new StringBuilder(semi)));
                semi.setLength(semi.length()-1);
            }
            if(col+1<arr[0].length && arr[row][col+1]!='#' && !vis[row][col+1]){
                vis[row][col+1]=true;
                semi.append('R');
                q.add(new Element(row,col+1,new StringBuilder(semi)));
                semi.setLength(semi.length()-1);
            }
            if(row+1<arr.length && arr[row+1][col]!='#' && !vis[row+1][col]){
                vis[row+1][col]=true;
                semi.append('D');
                q.add(new Element(row+1,col,new StringBuilder(semi)));
                semi.setLength(semi.length()-1);
            }
        }
        return new Element(0,0,new StringBuilder());
    }
}