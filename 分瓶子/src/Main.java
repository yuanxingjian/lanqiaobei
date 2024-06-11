import sun.awt.Symbol;

import java.util.Scanner;

public class Main {
    static int[] a;
    static int sum=0;
    public static void main(String[] args) {
        int N;
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        a=new int[N+1];
        for (int i = 1; i <=N; i++) {
            a[i]=sc.nextInt();
        }
        for (int i = 1; i <=N; i++) {
            if(a[i]==i){
                continue;
            } else {
              Swap(findIndex(i),i);
              sum++;
            }
        }
        System.out.println(sum);
    }

    private static void Swap(int j, int i) {
        int temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private static int findIndex(int i) {
        for (int j = 1; j <=a.length; j++) {
            if(a[j]==i){
                return j;
            }
        }
        return -1;
    }
}
