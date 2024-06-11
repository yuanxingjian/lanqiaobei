public class Main {
    //509
    static int num=0;
    static int[][] visit=new int[7][7];
    public static void main(String[] args) {
        dfs(3,3,visit);
        System.out.println(num/4);  //四个象限对称，结果需要➗4
    }

    private static void dfs(int i, int j, int[][] visit) {

        if(i==0||j==0||i==6||j==6){  //当走到边界时，方格分割完毕
           num++;
            return;
        }
        if(visit[i][j]==1)  //当走到已被访问的点后，则返回上一步再选择另一个方向遍历(上下左右需要标记回溯，下右不需要标记回溯)
            return;
        visit[i][j]=1;
        visit[6-i][6-j]=1;
        dfs(i-1,j,visit);
        dfs(i+1,j,visit);
        dfs(i,j-1,visit);
        dfs(i,j+1,visit);
        visit[6-i][6-j]=0;//回溯
        visit[i][j]=0;
    }
}
