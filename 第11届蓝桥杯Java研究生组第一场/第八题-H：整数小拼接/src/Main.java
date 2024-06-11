import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int sum = 0;
    static int K;

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        K = sc.nextInt();
        int[] nums = new int[n];
        boolean[] visit = new boolean[n];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(nums, visit, arrayList);
        System.out.println(sum);
    }

    private static void dfs(int[] nums, boolean[] visit, ArrayList<Integer> arrayList) {
        if (arrayList.size() == 2) {
            String s = arrayList.get(0) + "" + arrayList.get(1) + "";
            if ((new BigInteger(s)).compareTo(new BigInteger(K + "")) < 0 || (new BigInteger(s)).equals(new BigInteger(K + ""))) {
                sum++;
            }
            ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]) {
                arrayList.add(nums[i]);
                visit[i] = true;
                dfs(nums, visit, arrayList);
                visit[i] = false;
                arrayList.remove(arrayList.size()-1);
            }
        }
    }
}
