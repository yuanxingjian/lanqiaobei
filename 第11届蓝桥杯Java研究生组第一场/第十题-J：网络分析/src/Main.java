import java.util.ArrayList;
import java.util.Scanner;

//画图有助于理解(图)，便于调试
//逐字逐句仔细读题，将题意理解正确
//信息会发送到每个相邻的节点，之后这些节点又会转发到自己相邻的节点，
//直到所有直接或间接相邻的节点都收到了信息。(利用dfs深搜)
//所有发送和接收的节点都会将信息存储下来。一条信息只存储一次(当前发送信息的结点也要存储该信息)。
public class Main {
    static class vertex{
        int info=0;
        int num;
        boolean visit;//访问标记
        ArrayList<edge> edges=new ArrayList<>();//边为集合,需要初始化，否则为空指针(异常)
        public vertex(int num){
            this.num=num;
        }
    }
    static class edge{
        vertex linked;
        public edge(vertex linked) {
            this.linked = linked;
        }
    }

//       static boolean flag1=false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        vertex[] a=new vertex[n+1];//数组a应该空余一个元素，大小为n+1
        for (int i = 1; i <= n; i++) {
            a[i]=new vertex(i);//从1开始编号
        }
        int x,y,z;
        for (int i = 0; i < m; i++) {
            x=sc.nextInt();
            y=sc.nextInt();
            z=sc.nextInt();
            if(x==1){
                if(y==z){
                    continue;
                }else {
//                    boolean flag=true;
//                    //判断顶点啊a[y]和a[z]是否连通，联通则不相连
//                    for (int j = 1; j <=n ; j++) {
//                        a[j].visit=false;
//                    }
//                    flag1=false;
                    //dfs1(a[y],a[z]);
                   // if(flag1==false){//不连通
                        a[y].edges.add(new edge(a[z]));//对象为引用类型，每次生成都是全新的
                        a[z].edges.add(new edge(a[y]));//无向图，互相连接
                   // }
                }
            }
            if(x==2){
                for (int j = 1; j <=n ; j++) {
                    a[j].visit=false;//还原访问标记位
                }
//                a[y].info=a[y].info+z;   //当前发送信息的结点也要存储该信息
                dfs(a[y],z);      //图的深度遍历
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i].info+" ");             //从1开始编号
        }
    }

    private static void dfs(vertex vertex, int z) {  //图的深搜(顶点)
        vertex.visit=true;
        vertex.info=vertex.info+z;//！！！！当前发送信息的结点也要存储该信息
        for (edge edge : vertex.edges) {
            if(edge.linked.visit==false){
//                edge.linked.info=edge.linked.info+z;
                dfs(edge.linked,z);
            }

        }
    }

    //    private static void dfs1(vertex vertex1, vertex vertex2) {
//        vertex1.visit=true;
//        if(vertex1.equals(vertex2)){
//            flag1=true;
//        }
//        for (edge edge : vertex1.edges) {
//            if(edge.linked.visit==false){
//                dfs1(edge.linked,vertex2);
//            }
//
//        }
//    }
}
