
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//排列：考虑先后次序    组合：不考虑先后次序 (排列也不需要所有数用完，考虑先后顺序即可)
public class Main {
    //无论是在六角还是矩阵(幻方填空)等图形上填空或排列，均采用该思想，先编号，然后全排列，再验证数据是否满足要求
    static int sum = 0;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();//编号：list有序(可以重复)，set(集合)无序(不能重复)
        boolean[] visited = new boolean[9];
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};//备选数字(不用指定数组大小)
        dfs(nums, list, visited);
        System.out.println(sum/2);//考虑交换律
    }

    private static void dfs(int[] nums, List<Integer> list, boolean[] visited) {//全排列
        //递归+剪枝+回溯
        if (list.size() == 9) {
            check(list);
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

    private static void check(List<Integer> list) {
        char[] ret0;
        int[] ret;
        int k = 0;
        for (int i = 0; i <= 7; i++) {
            String s1 = "";//每次循环都要初始化！！！
            String s2 = "";
            for (int j = 0; j <= i; j++) {
                s1 = s1 + list.get(j);
            }
            for (int j = i + 1; j <= 8; j++) {
                s2 = s2 + list.get(j);
            }
            BigInteger score = new BigInteger(s1).multiply(new BigInteger(s2));
            ret0 = score.toString().toCharArray();
            if(ret0.length!=9)  //不是9位数舍去
                continue;
            ret=new int[ret0.length];
            for (k = 0; k <ret0.length; k++) {
                ret[k]=ret0[k]-'0';
            }
            for (k = 0; k <ret.length; k++) { //含0则舍去
                if(ret[k]==0)
                    break;
            }
            if(k<ret.length){
                continue;
            }
                for (k = 1; k <= 9; k++) {
                    int count = 0;
                    int j;
                    for (j = 0; j <= 8; j++) {
                        if (ret[j] == k) {
                            count++;
                            if (count >= 2) {
                                break;
                            }
                        }
                    }
                    if (j <= 8) {
                        break;
                    }
                }
                if (k > 9) {
                    sum++;
                }
        }
    }
}

