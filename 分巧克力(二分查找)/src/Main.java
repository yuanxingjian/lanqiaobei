import java.util.Scanner;

//2
public class Main {
    //查找最大，可考虑从最大值往下找
    //若时间频数过大，可考虑用二分查找法进行优化
    public static void main(String[] args) {
        int N;//巧克力个数
        int K;//朋友个数
        int ret = 0;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        int[][] a = new int[N][N];
        for (int i = 0; i < N; i++) {
            a[i][0] = scanner.nextInt();//巧克力的长(1-100000)
            a[i][1] = scanner.nextInt();//巧克力的宽(1-100000)
        }
        //查找最大，可考虑从最大值往下找
//        for (int i = 100000; i >=1 ; i--) { //切出的巧克力边长最大值为100000
//            int sum=0;
//            for (int j = 0; j < N; j++) {
//                sum=sum+(a[j][0]/i)*(a[j][1]/i);
//            }
//            if(sum>=K){
//                ret=i;
//                break;
//            }
//        }
        //若时间频数过大，可考虑用二分查找法进行优化
        int l=1;
        int r=100000;   //或者r=100001
        while (l<=r){
            int sum = 0;
            int mid=(l+r)/2;
            for (int j = 0; j < N; j++) {
                sum = sum + (a[j][0] / mid) * (a[j][1] / mid);//分割模式
            }
            if (sum >= K) {
                ret = mid;//得到符合要求的解，记录下来，
                l=mid+1;//然后在右区域中寻找可能的更大解
            }else {//得到的解不符合要求，则在左区域中寻找可能的解
                r=mid-1;
            }
        }
        System.out.println(ret);
    }

}
