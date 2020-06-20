package Divide;
/**
 * 汉诺塔问题分治解决，每个子问题相互独立
 */
public class Hanoi {
        public static void main(String[] args) {
            hanoiTower(3, 'A', 'B', 'C');
        }
        //汉诺塔的移动的方法，三步解决，把所有盘分为最下面盘和上面所有盘.1（最上面盘子）
        //使用分治算法，第一个参数是起点，第二个参数是借用的位置，第三个参数是终点
        public static void hanoiTower(int num, char a, char b, char c) {
            //如果只有一个盘
            if(num == 1) {
                System.out.println("第1个盘从 " + a + "->" + c);
            } else {
                //如果我们有 n >= 2 情况，我们总是可以看做是两个盘 1.最下边的一个盘 2. 上面的所有盘
                //1. 先把 最上面的所有盘 A->B， 移动过程会使用到 c
                hanoiTower(num - 1, a, c, b);
                //2. 把最下边的盘 A->C
                System.out.println("第" + num + "个盘从 " + a + "->" + c);
                //3. 把B塔的所有盘 从 B->C , 移动过程使用到 a塔
                hanoiTower(num - 1, b, a, c);
            }
        }
    }
