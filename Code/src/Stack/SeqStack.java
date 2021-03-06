package Stack;
/**
 * 使用向量来实现栈
 * @param <T>
 */
public class SeqStack<T extends Comparable<T>>{
    public final int DEFAULTSIZE = 20;//默认容量
    public int capacity;//容量
    public int size ;//元素个数
    public Object[] stack;//栈数组
    public int top;//栈顶指针,初始为-1,
    /**
     * 初始化栈结构
     */
    public SeqStack(){
        capacity = DEFAULTSIZE;
        size = 0;
        stack = new Object[capacity];
        top = -1;
    }
    public SeqStack(int maxsize){
        capacity = maxsize;
        size = 0;
        stack = new Object[capacity];
        top = -1;
    }
    /**
     *获取元素个数
     */
    public int getSize(){
        return size;
    }
    /**
     *判断栈是否为空
     */
    public boolean isEmpty(){
        return top == -1;
    }
    /**
     *判断栈是否为满
     */
    public boolean isFull(){
        return top == capacity-1;
    }
    /**
     *删除栈顶元素
     */
    public boolean pop(){
        if (isEmpty()){
            System.out.println(" 栈已空 ");
            return false;
        }
        Object data = stack[top--];
        stack[top+1] = null;
        size--;
        System.out.print(data+" ");
        return true;
    }
    /**
     *将元素插入栈顶
     * @param e
     */
    public boolean push(int e){
        if (isFull()){
            System.out.print(" 栈已满 ");
            return false;
        }
        stack[++top] = e;
        size++;
        return true;
    }
    /**
     * 遍历
     */
    public void list(){
        if (isEmpty()){
            System.out.println("error");
            return;
        }//从栈顶开始遍历
        for (int i = top;i>-1;i++){
            System.out.printf("stack[%d] = %d",i,stack[i]);
        }
    }

    /**
     *打印栈
     */
    public void print (){
        for (Object i:stack
             ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
