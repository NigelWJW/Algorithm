package Graph;
import java.util.Arrays;
/**
 * 普利姆算法生成最小生成树(完全图到最小生成树)-村庄修路-点优先
 */
public class Prim {
        public static void main(String[] args) {
            char[] data = new char[]{'A','B','C','D','E','F','G'};//数组包含顶点
            int verxs = data.length;
            //邻接矩阵的关系使用二维数组表示,10000这个大数表示两个点不联通
            int [][]weight=new int[][]{
                    //A B C D E F G
                    {10000,5,7,10000,10000,10000,2},//A
                    {5,10000,10000,9,10000,10000,3},//B
                    {7,10000,10000,10000,8,10000,10000},//C
                    {10000,9,10000,10000,10000,4,10000},//D
                    {10000,10000,8,10000,10000,5,4},//E
                    {10000,10000,10000,4,5,10000,6},//f
                    {2,3,10000,10000,4,6,10000},};//G
            //创建MGraph对象
            MGraph graph = new MGraph(verxs);
            //创建一个MinTree对象
            MinTree minTree = new MinTree();
            minTree.createGraph(graph, verxs, data, weight);
            //输出
            minTree.showGraph(graph);
            //测试普利姆算法
            minTree.prim(graph, 1);
        }
    }

    //创建最小生成树->村庄的图
    class MinTree {
        //创建图的邻接矩阵
        /**
         * @param graph 图对象
         * @param verxs 图对应的顶点个数
         * @param data 图的各个顶点的值
         * @param weight 图的邻接矩阵
         */
        public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
            int i, j;
            for(i = 0; i < verxs; i++) {//顶点
                graph.data[i] = data[i];//赋值
                for(j = 0; j < verxs; j++) {
                    graph.weight[i][j] = weight[i][j];
                }
            }
        }
        //输出图的邻接矩阵
        public void showGraph(MGraph graph) {
            for(int[] link: graph.weight) {
                System.out.println(Arrays.toString(link));
            }
        }
        //编写prim算法，得到最小生成树
        /**
         * @param graph 图
         * @param v 表示从图的第几个顶点开始生成'A'->0 'B'->1...
         */
        public void prim(MGraph graph, int v) {
            //visited[] 标记结点(顶点)是否被访问过
            int visited[] = new int[graph.verxs];
            //visited[] 默认元素的值都是0, 表示没有访问过，java省略
//		for(int i =0; i <graph.verxs; i++) {
//			visited[i] = 0;
//		}
            //把当前这个结点标记为已访问
            visited[v] = 1;
            //h1 和 h2 记录两个顶点的下标
            int h1 = -1;
            int h2 = -1;
            int minWeight = 10000; //将minWeight初始成一个大数，后面在遍历过程中，会被替换
            for(int k = 1; k < graph.verxs; k++) {//因为有 graph.verxs顶点，普利姆算法结束后，有 graph.verxs-1边(最小生成树定义n的节点n-1个边)
                //这个是确定每一次生成的子图 ，和哪个结点的距离最近
                for(int i = 0; i < graph.verxs; i++) {// i结点表示被访问过的结点
                    for(int j = 0; j< graph.verxs;j++) {//j结点表示还没有访问过的结点
                        if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                            //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                            minWeight = graph.weight[i][j];
                            h1 = i;
                            h2 = j;
                        }
                    }
                }
                //找到一条边是最小
                System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
                //将当前这个结点标记为已经访问
                visited[h2] = 1;
                //minWeight 重新设置为最大值 10000
                minWeight = 10000;
            }

        }
    }

    class MGraph {//定义图类
        int verxs; //表示图的节点个数
        char[] data;//存放顶点字符数据
        int[][] weight; //存放对应边的权值，就是我们的邻接矩阵
        public MGraph(int verxs) {
            this.verxs = verxs;
            data = new char[verxs];
            weight = new int[verxs][verxs];
        }
    }


