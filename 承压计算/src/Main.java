import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[][] a=new double[30][59];
        int temp=29;//起始点(中点)
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 59; j++) {
                a[i][j]=0;
            }
        }
        for (int i = 0; i < 29; i++) {
            int count=0;
            for (int j = temp; count<=i; j=j+2,count++) {
                    a[i][j]= Double.valueOf(sc.nextInt());
            }
            temp--;
        }
        for (int i = 0; i < 29; i++) {
            for (int j = 0; j < 59; j++) {
                if(a[i][j]!=0){
                    a[i+1][j-1]=a[i+1][j-1]+a[i][j]/2;
                    a[i+1][j+1]=a[i+1][j+1]+a[i][j]/2;
                }
            }
        }
        double min=Double.MAX_VALUE;
        double max=0.0;

        for (int i = 0; i < 59; i=i+2) {
           // System.out.println(a[29][i]);
            min=Math.min(a[29][i],min);
            max=Math.max(a[29][i],max);
        }
        System.out.println(min);
        System.out.println(max);
        System.out.println(String.format("%.0f",max/min*2086458231));
//        System.out.println();
//        for (int i = 0; i < 29; i++) {
//            for (int j = 0; j < 57; j++) {
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
        //填空题也可以格式化输入
//        7
//        5 8
//        7 8 8
//        9 2 7 2
//        8 1 4 9 1
//        8 1 8 8 4 1
//        7 9 6 1 4 5 4
//        5 6 5 5 6 9 5 6
//        5 5 4 7 9 3 5 5 1
//        7 5 7 9 7 4 7 3 3 1
//        4 6 4 5 5 8 8 3 2 4 3
//        1 1 3 3 1 6 6 5 5 4 4 2
//        9 9 9 2 1 9 1 9 2 9 5 7 9
//        4 3 3 7 7 9 3 6 1 3 8 8 3 7
//        3 6 8 1 5 3 9 5 8 3 8 1 8 3 3
//        8 3 2 3 3 5 5 8 5 4 2 8 6 7 6 9
//        8 1 8 1 8 4 6 2 2 1 7 9 4 2 3 3 4
//        2 8 4 2 2 9 9 2 8 3 4 9 6 3 9 4 6 9
//        7 9 7 4 9 7 6 6 2 8 9 4 1 8 1 7 2 1 6
//        9 2 8 6 4 2 7 9 5 4 1 2 5 1 7 3 9 8 3 3
//        5 2 1 6 7 9 3 2 8 9 5 5 6 6 6 2 1 8 7 9 9
//        6 7 1 8 8 7 5 3 6 5 4 7 3 4 6 7 8 1 3 2 7 4
//        2 2 6 3 5 3 4 9 2 4 5 7 6 6 3 2 7 2 4 8 5 5 4
//        7 4 4 5 8 3 3 8 1 8 6 3 2 1 6 2 6 4 6 3 8 2 9 6
//        1 2 4 1 3 3 5 3 4 9 6 3 8 6 5 9 1 5 3 2 6 8 8 5 3
//        2 2 7 9 3 3 2 8 6 9 8 4 4 9 5 8 2 6 3 4 8 4 9 3 8 8
//        7 7 7 9 7 5 2 7 9 2 5 1 9 2 6 5 3 9 3 5 7 3 5 4 2 8 9
//        7 7 6 6 8 7 5 5 8 2 4 7 7 4 7 2 6 9 2 1 8 2 9 8 5 7 3 6
//        5 9 4 5 5 7 5 5 6 3 5 3 9 5 8 9 5 4 1 2 6 1 4 3 5 3 2 4 1

    }
}
