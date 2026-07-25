class Solution {
    class Element{
        int row;
        int col;
        int dist;
        public Element(int r,int c,int d){
            row = r;
            col =c;
            dist = d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int ans[][] = new int[mat.length][mat[0].length];
        Queue<Element> q = new LinkedList<>();
        boolean vis[][] = new boolean[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new Element(i,j,0));
                    vis[i][j]=true;
                }
            }
        }

        bfs(mat,ans,q,vis);
        return ans;
    }

    public void bfs(int arr[][],int ans[][],Queue<Element> q,boolean vis[][]){
        while(!q.isEmpty()){
            Element e = q.remove();
            int row = e.row;
            int col = e.col;
            int dist = e.dist;
            ans[row][col]=dist;
            //down
            if(row+1<ans.length && !vis[row+1][col]){
                vis[row+1][col]=true;
                q.add(new Element(row+1,col,dist+1));
            }
            //up
            if(row-1>=0 && !vis[row-1][col]){
                vis[row-1][col]=true;
                q.add(new Element(row-1,col,dist+1));
            }
            //left
            if(col-1>=0 && !vis[row][col-1]){
                vis[row][col-1]=true;
                q.add(new Element(row,col-1,dist+1));
            }
            //right
            if(col+1<ans[0].length && !vis[row][col+1]){
                vis[row][col+1]=true;
                q.add(new Element(row,col+1,dist+1));
            }
        }
    }
}