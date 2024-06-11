public class Main {
    private static int sum=0;
    public static void f(int k,int count){
        if(k>13||count>13)//当牌号越界或者数量越界时退出循环
            return;
        if(count==13){//当数量等于13时找到一种解(不需要判断k的值)
            sum++;
            return;
        }
        for (int i = 0; i <= 4; i++) {
            f(k+1,count+i);//分别选取k号(1-13)扑克的张数(0-4)
        }
    };
    public static void main(String[] args) {
        f(0,0);
        System.out.println(sum);
    }
}
