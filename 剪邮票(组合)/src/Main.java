import java.util.ArrayList;

//组合(且没有重复元素)：12选5(联通)
//组合：不考虑元素先后次序(排列需要考虑)
public class Main {
    static int sum = 0;

    public static void main(String[] args) {

        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        dfs(0, candidates, new ArrayList<>());
        System.out.println(sum);
    }

    private static void dfs(int start, int[] candidates, ArrayList<Integer> list) {
        if (list.size() == 5) {
            if (check(list)) {
                sum++;
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {//组合i=start，排列i=0
            //组合时若需要去除重复元素，则需要多设置一个visit数组(排列一定需要visit数组)
//            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
//                continue;
//            }
//            if (!visited[i]) {
            int candidate = candidates[i];
           // visited[i] = true;
            list.add(candidate);
            dfs(i + 1, candidates, list);//若可以重复选择，dfs(i, candidates, list);
            list.remove(list.size() - 1);
           // visited[i] = false;
//          }
        }
    }

    private static boolean check(ArrayList<Integer> list) {
        int[][] g = new int[3][4];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                g[i][j] = 0;
            }
        }
        //将某个组合映射到二维矩阵中(所处位置赋1)
        for (Integer integer : list) {
            g[(integer % 4 == 0) ? (integer / 4 - 1) : (integer / 4)][(integer % 4 == 0) ? 3 : (integer % 4 - 1)] = 1;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (g[i][j] == 1) {//找到第一个结点则进行深度搜索
                    dfs1(g, i, j);
                    count++;//第一次深度搜索结束，搜索次数加一
                    if(count>1){
                        return false;
                    }
                }
            }
        }
        return count == 1;//若一次性联通(深度搜索一次便联通所有结点)，则满足题设条件
    }

    private static void dfs1(int[][] g, int i, int j) {
        g[i][j] = 0;
        //规定递归的条件(完整)：满足边界条件和进入(深度搜索遍历)条件
        if (i >= 1 && g[i - 1][j] == 1) dfs1(g, i - 1, j);//上下左右->搜索
        if (i <= 1 && g[i + 1][j] == 1) dfs1(g, i + 1, j);
        if (j <= 2 && g[i][j + 1] == 1) dfs1(g, i, j + 1);
        if (j >= 1 && g[i][j - 1] == 1) dfs1(g, i, j - 1);
    }

}
