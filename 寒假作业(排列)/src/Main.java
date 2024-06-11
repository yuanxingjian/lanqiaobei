
import java.util.ArrayList;
import java.util.List;

//排列：考虑先后次序    组合：不考虑先后次序 (排列也不需要所有数用完，考虑先后顺序即可)
//暴力全排列求解可能需要花大量时间
public class Main {
    //无论是在六角还是矩阵等图形上填空或排列，均采用该思想，先编号，然后全排列，再验证数据是否满足要求
    static int sum = 0;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();//编号：list有序(可以重复)，set(集合)无序(不能重复)
        boolean[] visited = new boolean[13];
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};//备选数字(不用指定数组大小)
        dfs(nums, list, visited);
        System.out.println(sum);
    }

    private static void dfs(int[] nums, List<Integer> list, boolean[] visited) {//全排列
        //递归+剪枝+回溯
        if (list.size() == 12) {  //不需要塞满(用上所有元素)而提前结束
            if (check(list)) {
                sum++;
            }
            return;//递归结束出口
        }
        for (int i = 0; i < nums.length; i++) {
//            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {//先sort(nums)，找出重复数字，过滤重复的情况
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
        if (list.get(0) + list.get(1) == list.get(2)&&list.get(3) - list.get(4) == list.get(5)&&list.get(6) * list.get(7) == list.get(8)&&list.get(11) * list.get(10) == list.get(9)&&list.get(9) / list.get(10) == list.get(11)) {
                                  return true;}
                            return false;
}}

