import sun.reflect.generics.visitor.Visitor;

public class Main {
    //迷宫：深搜+标记(走过的路)
    static int sum=0;
    static char[][] ch=new char[10][10];//全局变量
    public static void main(String[] args) {

        String[] s=new String[10];
        s[0]="UDDLUULRUL";
        s[1]="UURLLLRRRU";
        s[2]="RRUURLDLRD";
        s[3]="RUDDDDUUUU";
        s[4]="URUDLLRRUU";
        s[5]="DURLRLDLRL";
        s[6]="ULLURLLRDU";
        s[7]="RDLULLRDDD";
        s[8]="UUDDUDUDLL";
        s[9]="ULRDLUURRR";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ch[i][j]=s[i].charAt(j);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int[][] visit=new int[10][10];//每次深搜都需要初始化标记数组(默认值为0)
                    dfs(i,j,visit);
            }
        }
        System.out.println(sum);
    }

    private static void dfs(int i, int j, int[][] visit) {
        if(visit[i][j]==1){//若回到已走过的结点则走不出迷宫
            return;
        }
        if(ch[i][j]=='U'){
            if(i==0){
                sum++;
                return;
            }
            else{
                visit[i][j]=1;
                dfs(i-1,j,visit);
            }
        }
        if(ch[i][j]=='D'){
            if(i==9){
                sum++;
                return;
            }
            else{
                visit[i][j]=1;
                dfs(i+1,j,visit);
            }
        }
        if(ch[i][j]=='L'){
            if(j==0){
                sum++;
                return;
            }
            else{
                visit[i][j]=1;
                dfs(i,j-1,visit);
            }
        }
        if(ch[i][j]=='R'){
            if(j==9){
                sum++;
                return;
            }
            else{
                visit[i][j]=1;
                dfs(i,j+1,visit);
            }
        }
    }


}
