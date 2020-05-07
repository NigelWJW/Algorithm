package Stack;
import java.util.LinkedList;
/**
 * 使用List接口类实现链表栈
 * @param <E>
 */
public class ListStack<E> {
    private LinkedList<E> stack;
    public ListStack(){
        stack = new LinkedList<E>();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public void push(E data){
        stack.addFirst(data);
    }
    public E pop() throws Exception{
        if(stack.isEmpty()){
            throw new Exception(" 栈已满 ");
        }
        return stack.pop();
    }
    @Override
    public String toString() {
        return stack.toString();
    }
    public static void main(String[] args) throws Exception {
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
        for (int i= 0;i<10;i++){
            stack.push(i);
        }
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
