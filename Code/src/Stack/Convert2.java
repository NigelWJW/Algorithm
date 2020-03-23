package Stack;
/**
 * 栈的典型应用-逆序输出的进制转换:十进制转换成base进制(递归版)
 */
public class Convert2 {
    public void convert(SeqStack<Integer> s, int n, int base) {
        if (n > 0) {
            s.push(n % base);
            convert(s, n / base, base);
        }
    }
    public static void main(String[] args) {
        Convert c = new Convert();
        SeqStack<Integer> s = new SeqStack<Integer>();
        int base = 2;
        int n = 89;
        c.convert(s, n, base);
        System.out.print("十进制数" + n + "转换成" + base + "进制的结果是：");
        while (!s.isEmpty()) {
            s.pop();
        }
    }
}
