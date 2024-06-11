public class Main {
    static final int length=10000;//大于315即可
    public static void main(String[] args) {
        //210
        int sum = 1;
        int[] a=new int[length];//列举足够多的素数
        a[0]=2;
        int start = 3;
        while (true) {
            int k = (int) Math.sqrt(Double.valueOf(start));
            int i;
            for (i = 2; i <= k; i++) {
                if (start%i==0){
                   // start++;//start需要加1
                    break;
                }
            }
            if(i>k){
                a[sum]=start;
                sum++;
                if (sum == length) {
                   // System.out.println(start);
                    break;
                }
                //start++;
            }
			start++;
        }
        sum=0;
        int gongCha=1;//题目让求最小公差，因此公差的递增作为循环的最外层
                while (true){
                    for (int i = 0; i < a.length; i++) {//从第一个元素开始尝试
                        int temp=a[i];
                        sum=1;
                        while (true){
                            temp=temp+gongCha;
                            int j;
                            for (j = i+1; j <a.length ; j++) {
                                if(a[j]==temp){
                                    sum++;
                                    break;
                                }
                            }
							//找到满足的元素，直接输出，并结束
                            if(sum==10){
                                System.out.println(gongCha);
                                System.out.println(j);
                                return;
                            }
                            //未找到满足的元素，提前退出当前while循环，进行下一次for循环，从下一个元素开始尝试
                            if(j==a.length){
                                break;
                            }
                        }

                    }
                    gongCha++;//此公差找不到长度为10的等差数列，尝试下一个公差，进行下一次外层while循环
                }

//        for (int i = 0; i < 2019; i++) {
//            System.out.print(a[i]+" ");
//        }
    }
}
