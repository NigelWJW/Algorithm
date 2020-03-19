package Stack;

/**
 * 使用自建结点单链表来实现栈
 */
public class LinkedListStack<T> {
    public  StackNode<T> stacktop;
    public int size ;

    /**
     * 初始化链表栈
     */
    public LinkedListStack(){
        stacktop = new StackNode<T>();
        size = 0;
    }

    public LinkedListStack(T e){
        stacktop = new StackNode<T>(e);
        size ++;
    }

    public LinkedListStack(T e,StackNode<T> succ){
        stacktop = new StackNode<T>(e,succ);
        size++;
    }

    /**
     *判断是否为空栈
     */
    public boolean isEmpty(){
        return this.size==0;
    }

    /**
     *压栈操作
     */
    public boolean push(T data){
        stacktop = new StackNode<T>(data, stacktop);
        System.out.println(data+" ");
        size++;
        return true;
    }

    /**
     * 出栈操作
     */
    public T pop(){
        StackNode<T> oldTop = stacktop;
        stacktop = stacktop.succ;
        oldTop.succ = null;
        size--;
        return oldTop.data;
    }

    /**
     *获取当前栈容量
     */
    public int getSize(){
        return this.size;
    }

    public T getStack(){
        return stacktop.data;
    }



    @Override
    public String toString() {
        return stacktop.toString();
    }
}
