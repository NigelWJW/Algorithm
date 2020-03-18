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
        StackNode<T> temp = new StackNode<T>(data);
        temp.succ = stacktop;
        stacktop = temp;
        System.out.print(data+" ");
        size++;
        return true;
    }

    /**
     * 出栈操作
     */
    public T pop(){
        T data = stacktop.data;
        stacktop=stacktop.succ;
        size--;
        return data;
    }

    /**
     *获取当前栈容量
     */
    public int getSize(){
        return this.size;
    }

    @Override
    public String toString() {
        return stacktop.toString();
    }
}
