import java.util.Scanner;

public class Main {
    static int[][] a;
    static int n,m,k;
    static int ret=0;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        k=sc.nextInt();
        a=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j]=sc.nextInt();
            }
        }
        dfs(0,0,a,1,a[0][0]);
        System.out.println(ret);
    }

    private static void dfs(int i, int j, int[][] a,int sum,int max) {
        if(i==n||j==m||sum>k){
            return;
        }
        if(i==n-1&&j==m-1&&sum==k){
            ret++;
            return;
        }
        if(a[i][j]>max){
            sum++;
            max=a[i][j];
        }
        dfs(i+1,j,a,sum,max);//右下一定不会重复路径，不需要标记及回溯
        dfs(i,j+1,a,sum,max);
    }
}
