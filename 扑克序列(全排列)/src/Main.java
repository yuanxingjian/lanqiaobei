
import java.util.ArrayList;
import java.util.List;

//排列：考虑先后次序    组合：不考虑先后次序 (排列也不需要所有数用完，考虑先后顺序即可)
//无论是在六角还是矩阵(幻方填空)等图形上填空或排列，均采用该思想，先编号，然后全排列，再验证数据是否满足要求
//check可能很复杂繁琐，但也不要怕，能做出来就行(暴力杯)
public class Main {
    static  char[] ch="AA223344".toCharArray();
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();//编号：list有序(可以重复)，set(集合)无序(不能重复)
        boolean[] visited = new boolean[8];
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7};//备选数字(不用指定数组大小)
        dfs(nums, list, visited);
    }

    private static void dfs(int[] nums, List<Integer> list, boolean[] visited) {//全排列
        //递归+剪枝+回溯
        if (list.size() == 8) {
            if (check(list)) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(ch[list.get(i)]);
                }
                System.out.println();
            }
            return;//递归结束出口
        }
        for (int i = 0; i < nums.length; i++) {
//            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {//找出重复数字，过滤重复的情况(需要sort数组)
//                                                                       (先固定前面的相同数字)
//                continue;
//            }
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                dfs(nums, list, visited);
                visited[i] = false;
                list.remove(list.size() - 1);//移除末尾元素
            }
        }
    }

    private static boolean check(List<Integer> list) {
        if(Math.abs(list.indexOf((Object)0)-list.indexOf((Object)1))==2&&
                Math.abs(list.indexOf((Object)2)-list.indexOf((Object)3))==3&&
                Math.abs(list.indexOf((Object)4)-list.indexOf((Object)5))==4&&
                Math.abs(list.indexOf((Object)6)-list.indexOf((Object)7))==5){
            return true;
        };
        return false;
    }
}

