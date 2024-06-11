import java.util.Scanner;

public class Main {
    static int n,m;
    static int sum=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        dfs(1,1);
        System.out.println(sum);
    }

    private static void dfs(int i, int j) {
        if(i>n||j>m){
            return;
        }
        if(i==n&&j==m){
            sum++;
        }
        if(!((i+1)%2==0&&j%2==0))dfs(i+1,j);
        if(!(i%2==0&&(j+1)%2==0))dfs(i,j+1);
    }
}
