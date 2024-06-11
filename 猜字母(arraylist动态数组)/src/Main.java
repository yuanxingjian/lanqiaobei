import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        String ch;
        for (int i = 1; i <=106 ; i++) {
            for (int j = 0; j <=18; j++) {
                //int+char->int
                ch=(char)(j+'a')+"";//int->char：(char)j(强制类型转换)      char->Character(基本类型->引用类型：自动装箱)
                array.add(ch);
            }
        }
        while (true){
            if(array.size()==1){
                break;
            }
            ArrayList<String> array2 = new ArrayList<>();
            for (int i = 0; i < array.size(); i=i+2) {
                if(i+1<array.size()){
                    array2.add(array.get(i+1));//存储剩余的元素(非删除元素)
                }
            }
            array=array2;
//            for (int i = 0; i < array.size(); i=i+2) {
//                array.set(i,"Z");//ArrayList是动态数组，实时变更容量和编号，因此先标记所有需要移除的奇数位，然后进行删除
//            }
//            for (int i = 0; i < array.size(); i++) {
//                if(array.get(i).equals("Z")){  //字符串相等用equals，依次寻找需要移除的奇数位
//                    array.remove(i);//只移除一次该索引下的匹配字符串
//                    i--;//arraylist的容量和编号实时变更，即后继编号已全部减一，因此寻找位置也需要减一
//                }
//            }
        }

        System.out.println(array.get(0));
    }
}

