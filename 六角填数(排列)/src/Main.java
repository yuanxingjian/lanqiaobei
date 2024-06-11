
import java.util.ArrayList;
import java.util.List;

//排列：考虑先后次序    组合：不考虑先后次序 (排列也不需要所有数用完，考虑先后顺序即可)
public class Main {
//无论是在六角还是矩阵(幻方填空)等图形上填空或排列，均采用该思想，先编号，然后全排列，再验证数据是否满足要求
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();//编号：list有序(可以重复)，set(集合)无序(不能重复)
        boolean[] visited = new boolean[9];
        int[] nums = new int[]{2, 4, 5, 6, 7, 9, 10, 11, 12};//备选数字(不用指定数组大小)
        dfs(nums, list, visited);
    }

    private static void dfs(int[] nums, List<Integer> list, boolean[] visited) {//全排列
                                                                        //递归+剪枝+回溯
        if (list.size() == 9) {
            if (check(list)) {
                System.out.println(list.get(3));
            }
            return;//递归结束出口
        }
        for (int i = 0; i < nums.length; i++) {
//            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {//找出重复数字，过滤重复的情况
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
        int[] nums = new int[6];
        int i;
        nums[0] = 8 + list.get(0) + list.get(1) + list.get(2);
        nums[1] = 3 + list.get(2) + list.get(4) + list.get(7);
        nums[2] = list.get(5) + list.get(6) + list.get(7) + list.get(8);
        nums[3] = 8 + list.get(3) + list.get(6) + 3;
        nums[4] = 1 + list.get(0) + list.get(3) + list.get(5);
        nums[5] = 1 + list.get(1) + list.get(4) + list.get(8);
        for (i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                break;
        }
        if (i == nums.length)
            return true;
        return false;
    }
}

