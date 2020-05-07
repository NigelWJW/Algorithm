package Stack;
/**
 * 使用自建单链表来实现栈
 */
public class LinkedListStack<T> {
    public StackNode<T> stackTop;//指向栈顶节点
    public int size ;//栈中元素
    /**
     * 初始化链表栈
     */
    public LinkedListStack(){
        stackTop = new StackNode<T>();
        size = 0;
    }
    public LinkedListStack(T e){
        stackTop = new StackNode<T>(e);
        size ++;
    }
    public LinkedListStack(T e,StackNode<T> succ){
        stackTop = new StackNode<T>(e,succ);
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
        stackTop = new StackNode<T>(data, stackTop);//栈顶作为新节点后继，再把栈顶指向新节点，直接对stacktop进行全局操作
        System.out.println(data+" ");
        size++;
        return true;
    }
    /**
     * 出栈操作
     */
    public T pop(){
        StackNode<T> oldTop = stackTop;//oldTop保存当前栈顶信息
        stackTop = stackTop.succ;
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
        return stackTop.data;
    }
    @Override
    public String toString() {
        return stackTop.toString();
    }
}
