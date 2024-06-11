public class Main {
    public static void main(String[] args) {
        int sum=10000;
        int count=0;
        while (true){
            for (int i = 0; i < 60; i++) {
                sum=sum-10;
                count++;
                if(sum==0){
                    System.out.println(count);
                    return;
                }
            }
                sum=sum+5*60;
                count=count+60;
                }
            }



}
