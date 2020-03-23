package Stack;
import java.util.Scanner;
import java.util.Stack;
import java.io.IOException;

/**
 * 栈的延迟缓冲的表达式求值
 */
public class EvaluateExpression {
    /**主函数*/
    public static void main (String[] args){
        String exp = "(3*2)/2#";
        float result = evaluate(exp);
        System.out.println(exp + " = " + result);
    }
    /**核心函数，设置两个栈分别存储数字和符号*/
    public static float evaluate(String exp){
        Stack<Integer> opnd = new Stack<>();//运算数栈
        Stack<Character> optr = new Stack<>();//运算符栈
        int index = 0;
        optr.push('#');//将结束符提前压入栈
        while ((exp.charAt(index)!= '#') || (optr.peek()!='#')){//字符未结束就继续循环
            if (isDigit(exp.charAt(index))){//判定是否是数字
                opnd.push((int) exp.charAt(index)-48);//字符类型转整型ASCII码压栈
                index++;//下一个字符
            }
            else {//当是运算符时
                switch (orderBetween(exp.charAt(index),optr)){//比较优先级
                    case '<': optr.push(exp.charAt(index)); index++;  System.out.println("2");break;//当前符号优先级低
                    case '=': optr.pop();index++;break;//优先级相等：右括号或者#时，脱括号接收下一个字符
                    case '>':int b = opnd.pop(),a=opnd.pop();opnd.push(calcu(a,b,optr.pop()));break;//优先级高，实施运算并重新入栈
                }
            }
        }
        return opnd.pop();//将最后的运算结果出栈
    }

    /**
     *返回当前操作符和栈顶操作符的优先级
     */
    public static char orderBetween(char now,Stack<Character> tr){
        char pred = tr.peek();//获得栈顶运算符
        int nowop = transPri(now);
        int predop = transPri(pred);
        return tablePri(predop,nowop);
    }

    /**
     * 将对应运算符转换成对应优先级数组下标
     */
    public static int transPri(char op){
        switch (op){
            case '+' : return 0;
            case '-' : return 1;
            case '*' : return 2;
            case '/' : return 3;
            case '^' : return 4;
            case '!' : return 5;
            case '(' : return 6;
            case ')' : return 7;
            case '#' : return 8;
            default:break;
        }
        return -1;
    }

    /**
     *优先级对比表
     */
    public static char tablePri(int predop,int nowop){
        char[][] pri = new char[][]{
         // 当前： +   -   *   /   ^   !   (   )   #
                {'>','>','<','<','<','<','<','>','>'},
                {'>','>','<','<','<','<','<','>','>'},
                {'>','>','>','>','<','<','<','>','>'},
                {'>','>','>','>','<','<','<','>','>'},
                {'>','>','>','>','>','<','<','>','>'},
                {'>','>','>','>','>','>','<','>','>'},
                {'<','<','<','<','<','<','<','=',' '},
                {' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {'<','<','<','<','<','<','<',' ','='},
        };
        return pri[predop][nowop];
    }

    /**
     * 根据元素的操作符计算对应值
     */
    public static int calcu(int a, int b, char op){
        switch (op){
            case '+' : return a+b;
            case '-' : return a-b;
            case '*' : return a*b;
            case '/' : return a/b;
            default:break;
        }
        return 0;
  }

    /**
     * 判断是数字或者是运算符
     */
    public static boolean isDigit(char c){
        return c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')' && c!= '#';
    }
}
