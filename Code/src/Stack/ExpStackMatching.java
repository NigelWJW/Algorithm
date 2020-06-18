package Stack;
import java.util.Stack;
/**
 * ʹ��java��װջ��ʵ�ֵݹ�Ƕ�׵�����ƥ��
 */
public class ExpStackMatching {
    public boolean Matching(String exp){
        Stack<Character> stack  = new Stack<Character>();
        for (int i = 0;i< exp.length();i++){
            switch (exp.charAt(i)){//�ж���ǰ�ַ��������������ջ����Ȼ�ж��Ƿ��Ƕ�Ӧ������
                case '(': case '[': case '{': stack.push(exp.charAt(i));System.out.print(exp.charAt(i));System.out.println(i + " ");break;
                case ')': if ( !(stack.empty()) && (stack.peek()== '(') ){System.out.print(i + " ");System.out.println(")���سɹ� "); stack.pop();}break;
                case '}': if (!(stack.empty()) && (stack.peek()== '{') ){ System.out.print(i + " ");System.out.println("}���سɹ� "); stack.pop();}break;
                case ']': if (!(stack.empty()) && (stack.peek()== '[') ){ System.out.print(i + " ");System.out.println("]���سɹ� "); stack.pop();}break;
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
        { System.out.println("ƥ��ɹ���");}
        else
        { System.out.println(" ƥ��ʧ�� ");}
    }
}
