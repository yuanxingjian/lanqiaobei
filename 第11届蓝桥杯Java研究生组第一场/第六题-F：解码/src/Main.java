import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String a;
        char[] b;//char数组与int数组不一致，'0'！=0, '9'-'0'==0,'8'-'0'==8;
        String c="";
        Scanner sc = new Scanner(System.in);
        a=sc.next();
        b=a.toCharArray();
        for (int i = 0; i < b.length; i++) {
            if(i>0&&!(b[i]>='0'&&b[i]<='9')&&!(b[i-1]>='0'&&b[i-1]<='9')){
                c=c+b[i-1];
                continue;
            }
            if(b[i]>='0'&&b[i]<='9'){
                for (int j = 1; j <=b[i]-'0'; j++) {//'9'-'0'==9
                    c=c+b[i-1];
                }
            }
        }
        System.out.println(c);
    }
}
