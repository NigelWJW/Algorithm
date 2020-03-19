package Stack;

/**
 * 使用向量来实现栈
 * @param <T>
 */
public class SeqStack<T> {
    public final int DEFAULTSIZE = 20;
    public int capacity;
    public int size ;
    public Object[] stack;
    public int top;

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
     *获取当前规模
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
     *删除栈顶元素
     */
    public boolean pop(){
        if (top == -1){
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
        if (top ==capacity-1){
            System.out.print(" 栈已满 ");
            return false;
        }
        stack[++top] = e;
        size++;
        return true;
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
