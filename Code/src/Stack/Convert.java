package Stack;
/**
 * 栈的典型应用-逆序输出的进制转换:十进制转换成base进制(迭代版)
 */
public class Convert {
    public void convert(SeqStack<Integer> s,int n,int base){
        while (n>0){
            int remainer = n % base;//保存每次余数压栈
            s.push(remainer);
            n = n/base;//求商
        }
    }
    public static void main(String[] args){
        Convert c = new Convert();
        SeqStack<Integer> s = new SeqStack<Integer>();
        int base = 2;
        int n = 89;
        c.convert(s,n,base);
        System.out.print("十进制数" + n +  "转换成" + base + "进制的结果是：");
        while (!s.isEmpty()){
            s.pop();
        }
    }
}
