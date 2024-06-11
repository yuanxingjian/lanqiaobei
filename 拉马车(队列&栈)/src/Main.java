import java.util.*;

public class Main {
    static Stack<Character> stack = new Stack<>();//character是引用类型，不能进行值的比较
    //Java中虽然有Queue接口，但是Java并没有给出具体的实现类（栈是直接给出了Stack实现类），
    // 而是让LinkedList实现了Queue接口，所以一般用LinkedList来实现链表或队列。
    static LinkedList<Character> queue1 = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            queue1.offer(s.charAt(i));//队尾添加元素
            queue1.poll();//队头移除元素
            queue1.peek();//返回队头元素
            stack.pop();
            stack.push('A');
        }
    }
}
