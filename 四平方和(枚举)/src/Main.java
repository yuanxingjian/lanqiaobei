import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N =sc.nextInt();
        double n=N;//int转为double
//        for (int l = (int) Math.sqrt(n); l >=0; l--) {//double转为int
//            for (int k= (int) Math.sqrt(n/2); k >=0; k--){
//                for (int j= (int) Math.sqrt(n/3); j >=0; j--){
//                    for (int i= (int) Math.sqrt(n/4); i >=0; i--){
//                        if(i*i+j*j+k*k+l*l==N){
//                            System.out.println(i+" "+j+" "+k+" "+l); //结果与答案相反
//                            return;
//                        }
//                    }
//                }
//            }
//        }
        for (int i = 0; i*i<=N/4; i++) {
            for (int j = i; j*j <= N/3 ; j++) {
                for (int k = j; k*k <=N/2 ; k++) {
                    for (int l = k; l*l <=N ; l++) {
                        if(i*i+j*j+k*k+l*l==N){
                            System.out.println(i+" "+j+" "+k+" "+l);//选取第一个满足要求的序列
                            return;
                        }
                    }
                }
            }
        }
    }
}
