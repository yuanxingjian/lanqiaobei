import java.util.Scanner;

/**
 * 弗洛伊德算法：
 * 求最长路径本质上与求最短路径一致
 * 最长路径即为从所有距离中选最大的(最短路径为从所有距离中选最小的)
 */

public class Main {
    static int[][] dis;
    static int[][] dis1;
    public static void main(String[] args) {
        int p;
        int q;
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        dis=new int[n][n];
        int max = Integer.MIN_VALUE;//求最长路径
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j){
                    dis[i][j]=0;//对角线为0
                }
                else{
                    dis[i][j]=Integer.MAX_VALUE;//非对角线结点的初始值为无穷大(最大值)
                }
            }
        }
        for (int i = 0; i < n-1; i++) {
                p=sc.nextInt();
                q=sc.nextInt();
                dis[p-1][q-1]=sc.nextInt();
                dis[q-1][p-1]=dis[p-1][q-1];//无向图的邻接矩阵对称
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //与求最短路径一致
                    if(dis[i][k]!=Integer.MAX_VALUE&&dis[k][j]!=Integer.MAX_VALUE&&dis[i][j]>(dis[i][k]+dis[k][j])){
                        dis[i][j]=dis[i][k]+dis[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dis[i][j]+"  ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dis[i][j]!=Integer.MAX_VALUE)
                max=Math.max(max,dis[i][j]);//求最大路径：从所有距离中选最大的
            }
        }
        System.out.println(max);
        int res;
        res=(11+(max-1)/2)*(max);
        System.out.println(res);
    }}