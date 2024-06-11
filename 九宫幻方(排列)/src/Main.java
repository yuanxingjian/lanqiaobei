import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[][] b = new int[3][3];
    static int[][] c = new int[3][3];
    static int[][] d = new int[3][3];
    static int sum = 0;

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();//ArrayList有序(有序号)，hashSet无序
        for (int i = 1; i <= 9; i++) {
            //写法不标准，编译器自动装箱，将元素i从int转化为Integer
            //nums.add(i);
            //标准写法
            nums.add(Integer.valueOf(i));
        }
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = sc.nextInt();
                c[i][j] = b[i][j];
                if (b[i][j] != 0) {
                    //Integer.valueOf(b[i][j])为要移除的元素对象(与ArrayList<Integer> nums的元素的引用类型一致，即Integer，而不能是基本类型，不然就是要移除的元素索引)
                    nums.remove(Integer.valueOf(b[i][j]));
//                    for (int k = 0; k < nums.size(); k++) {
//                        if(nums.get(k)==b[i][j]){
//                            nums.remove(k);//k为基本类型，表示要移除的元素的索引
//                            break;
//                        }
//                    }
                }
            }
        }
        boolean[] visit = new boolean[nums.size()];
        ArrayList<Integer> arrayList = new ArrayList<>();
        dfs(nums, visit, arrayList);
        if (sum > 1) {
            System.out.println("Too Many");
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(d[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void dfs(ArrayList<Integer> nums, boolean[] visit, ArrayList<Integer> arrayList) {
        if (arrayList.size() == nums.size()) {
            if (check(arrayList)) {
                sum++;
            }
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                arrayList.add(nums.get(i));//添加元素到arrayList末尾
                dfs(nums, visit, arrayList);
//nums.get(i)得到的是Integer(引用类型对象)，且arrayList中元素没有不重复，因此从arrayList中remove该元素
//当如果remove()中的值为基本类型，则为移除arrayList中索引为该值的元素，因此这种写法有风险
//                arrayList.remove(nums.get(i));
                //推荐写法：(arrayList.size()-1)是基本类型，因此表示移除元素的索引
                arrayList.remove(arrayList.size() - 1);//移除arrayList最后一个元素，即末尾的元素
                visit[i] = false;
            }
        }
    }

    private static boolean check(ArrayList<Integer> arrayList) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == 0) {
                    b[i][j] = arrayList.get(count);
                    count++;
                }
            }
        }
        int[] sum1 = new int[8];
        for (int i = 0; i < 3; i++) {
            int temp = 0;
            for (int j = 0; j < 3; j++) {
                temp = temp + b[i][j];
            }
            sum1[i] = temp;
        }
        for (int i = 0; i < 3; i++) {
            int temp = 0;
            for (int j = 0; j < 3; j++) {
                temp = temp + b[j][i];
            }
            sum1[i + 3] = temp;
        }
        sum1[6] = b[0][0] + b[1][1] + b[2][2];
        sum1[7] = b[0][2] + b[1][1] + b[2][0];
        int i;
        for (i = 1; i < 8; i++) {
            if (sum1[i] != sum1[i - 1]) {
                break;
            }
        }

        if (sum == 0) {//当sum==0时才更新d数组(sum==1时说明已有正确解，不用更新)
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    d[j][k] = b[j][k];
                }
            }
        }
        //还原b数组
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                b[j][k] = c[j][k];
            }
        }
        if (i == 8) {
            return true;
        } else {
            return false;
        }
    }
}
