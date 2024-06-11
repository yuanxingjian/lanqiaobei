import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //组合问题
    static int min=Integer.MAX_VALUE;
    static int sum=0;
    public static void main(String[] args) {
        int[] nums=new int[15];
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 15; i++) {
            nums[i]=sc.nextInt();
            sum=sum+nums[i];
        }
        for (int k = 1; k <=14; k++) {//分别遍历不同的组合情况
            dfs(0,nums,arrayList, k);
        }
        System.out.println(min);
    }

    private static void dfs(int start, int[] nums, ArrayList<Integer> arrayList,int k) {
        if(arrayList.size()==k)
        {
            int temp=0;
            for (Integer integer : arrayList) {
                temp=temp+integer;
            }
            int ret=Math.abs(sum-temp-temp);//剩下的等于总数减去已组合的总数
            if(ret<min){
                min=ret;
            }
        }
        for (int i = start; i <nums.length ; i++) {
            arrayList.add(nums[i]);
            dfs(i+1,nums,arrayList,k);
            arrayList.remove(arrayList.size()-1);//更稳妥
            //arrayList.remove(Integer.valueOf(nums[i]));//若arrayList中有重复的值(相同的元素对象)，则会出现错误
        }
    }
}
