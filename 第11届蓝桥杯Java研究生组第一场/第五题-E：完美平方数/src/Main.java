public class Main {
    //若发现程序短时间内不结束，将数据替换成很小的数，验证是否是死循环
    public static void main(String[] args) {
 System.out.println(Long.MAX_VALUE);
        System.out.println("190058124828649");
        int sum = 0;
        Long start = 0L;//start需要每次循环加1
        Long temp=0L;
        for (; sum != 2020; start++) {//逆向思维
            temp = start * start;
            char[] ch =(temp+"").toCharArray();
            int i;
            for (i = 0; i < ch.length; i++) {
                if(ch[i]!='0'&&ch[i]!='1'&&ch[i]!='4'&&ch[i]!='9'){
                    break;
                }
            }
            if(i==ch.length){
                sum++;
            }
        }
        System.out.println(temp);
        System.out.println(start);

        //1990944400
        //1949990009
        //1499441040
    }
}
