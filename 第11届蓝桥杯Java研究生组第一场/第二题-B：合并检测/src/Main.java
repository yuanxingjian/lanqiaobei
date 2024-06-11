public class Main {
    public static void main(String[] args) {
        int min=Integer.MAX_VALUE;
        int index=0;
        int temp;
        int groupNum;
        for (int k = 1; k <=100; k++) {//感染率为1%。相当于检测100个人会有一个阳性
            if(100%k!=0){
                groupNum=100/k+1;
            }else{
                groupNum=100/k;
            }
            //所有组中仅有一组会检测出阳性，需要独立检测(相当于检测了k+1次),其余每组只相当于检测了一次
            temp=(k+1)+(groupNum-1)*1;
            if(temp<min){
                min=temp;
                index=k;
            }

        }
        System.out.println(index);
    }
}
