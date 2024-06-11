import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        int sum=0;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < n-1; i++) {
            sum=sum+a[i]*a[i+1];
            a[i+1]=a[i]+a[i+1];
        }
        System.out.println(sum);
    }

}
