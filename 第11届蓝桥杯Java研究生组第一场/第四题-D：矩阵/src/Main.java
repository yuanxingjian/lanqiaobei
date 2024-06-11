import java.util.ArrayList;

public class Main {
    //排列问题
    //当排列数过大时，无法求出来，应该考虑用动态规划
    static int[][] a=new int[2][1010];
    static int sum=0;
    public static void main(String[] args) {
        int[] nums= new int[2020];
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean[] visit=new boolean[2020];
        for (int i = 1; i <= 2020; i++) {
            nums[i-1]=i;
        }
        dfs(nums,visit,arrayList);
        System.out.println(sum%2020);
    }

    private static void dfs(int[] nums, boolean[] visit, ArrayList<Integer> arrayList) {
        if(arrayList.size()==2020){
            int start=0;
            for (int i = 0; i <=1; i++) {
                for (int j = 0; j < 1010; j++) {
                    a[i][j]=arrayList.get(start);
                    start++;
                }
            }
            boolean flag=true;
            for (int i = 1; i < 1010; i++) {
                if(a[0][i]<=a[0][i-1]){
                    flag=false;
                    break;
                }
                if(a[1][i]<=a[1][i-1]){
                    flag=false;
                    break;
                }
            }
            for (int i = 0; i <1010 ; i++) {
                if(a[1][i]<=a[0][i]){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                sum++;
            }
            return;//需要return
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visit[i]){
                arrayList.add(nums[i]);
                visit[i]=true;
                dfs(nums, visit, arrayList);
                visit[i]=false;
                arrayList.remove(arrayList.size()-1);
            }
        }
    }
}
