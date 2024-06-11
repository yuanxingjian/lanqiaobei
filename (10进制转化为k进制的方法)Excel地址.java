import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 TODO Auto-generated method stub
		int num;
		String s =;
		Scanner scanner=new Scanner(System.in);
		num=scanner.nextInt();
		int temp;
		int k=26;
		while (num0) {10进制转化为k进制的方法
			p[i++] = (m - 1) % 26 + CH;     计算最后那个字母
			m -= (m - 1) % 26 + 1;          把它的前一列数字去掉之后所剩下的
			m = 26;  
			temp=(num-1)%k;
			s=s+(char)('A'+temp);
			num=num-((num-1)%k+1);
			num=numk;
		}
		for (int i = s.length()-1; i =0 ; i--) {
			System.out.print(s.charAt(i));
		}

	}

}
