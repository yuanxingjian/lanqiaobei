public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if(k==i||k==j){
                        continue;
                    }
                    for (int l = 1; l <= 9; l++) {
                        if(l==k||l==j||l==i){
                            continue;
                        }
                            if(k==l){
                                continue;
                            }
                            double a=i;//int可以直接转为double
                            double b=j;
                            double c=k;
                            double d=l;
                            double num1=(a/b)*(c/d);
                            double num2=(a*10+c)/(b*10+d);
                            if(Math.abs(num1-num2)<=0.000000001)
                                sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
