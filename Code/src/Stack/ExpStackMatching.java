package Stack;
import java.util.Stack;

/**
 * 使用java封装栈类实现递归嵌套的括号匹配
 */
public class ExpStackMatching {
    public boolean Matching(String exp){
        Stack<Character> stack  = new Stack<Character>();
        for (int i = 0;i< exp.length();i++){
            switch (exp.charAt(i)){
                case '(': case '[': case '{': stack.push(exp.charAt(i));System.out.print(exp.charAt(i));System.out.println(i + " ");break;
                case ')': if ( !(stack.empty()) && (stack.peek()== '(') ){System.out.print(i + " ");System.out.println(")返回成功 "); stack.pop();}break;
                case '}': if (!(stack.empty()) && (stack.peek()== '{') ){ System.out.print(i + " ");System.out.println("}返回成功 "); stack.pop();}break;
                case ']': if (!(stack.empty()) && (stack.peek()== '[') ){ System.out.print(i + " ");System.out.println("]返回成功 "); stack.pop();}break;
                default:break;
            }
        }
        System.out.println("end: ");
        return stack.empty();
    }

    public static void main(String[] args){
        ExpStackMatching esm = new ExpStackMatching();
        String expression = "{1+2+[3+5]+{[5+6]+7+(8+9)}}" ;
        boolean flag = esm.Matching(expression) ;
        if(flag)
        { System.out.println("匹配成功！");}
        else
        { System.out.println(" 匹配失败 ");}
    }
}
