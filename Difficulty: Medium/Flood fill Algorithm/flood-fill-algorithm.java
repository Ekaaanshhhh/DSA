class Solution {
    class Pair{
        int m;
        int n;
        public Pair(int i,int j){
            m=i;
            n=j;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        int orig = image[sr][sc];
        int m= image.length;
        int n = image[0].length;
        
        boolean vis[][] = new boolean[m][n];
        bfs(image,sr,sc,m,n,vis,orig,newColor);
        
        return image;
    }
    
    public void bfs(int arr[][],int i,int j,int m,int n,boolean vis[][],int orig,int nc){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
            Pair e = q.remove();
            int x = e.m;
            int y = e.n;
            arr[x][y]=nc;
            vis[x][y]=true;
            //up
            if(x-1>=0 && !vis[x-1][y] && arr[x-1][y]==orig){
                vis[x-1][y]=true;
                q.add(new Pair(x-1,y));
                arr[x-1][y]=nc;
            }
            if(x+1<m && !vis[x+1][y] && arr[x+1][y]==orig){
                vis[x+1][y]=true;
                q.add(new Pair(x+1,y));
                arr[x+1][y]=nc;
            }
            if(y-1>=0 && !vis[x][y-1] && arr[x][y-1]==orig){
                vis[x][y-1]=true;
                q.add(new Pair(x,y-1));
                arr[x][y-1]=nc;
            }
            if(y+1<n && !vis[x][y+1] && arr[x][y+1]==orig){
                vis[x][y+1]=true;
                q.add(new Pair(x,y+1));
                arr[x][y+1]=nc;
            }
        }
    }
}