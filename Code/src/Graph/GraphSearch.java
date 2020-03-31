package Graph;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现图的广度遍历算法BFS和深度遍历算法DFS（无向图）
 */
public class GraphSearch {
    public char[] vertix;//节点信息
    public int[][] edge;//边信息
    public int verticeNum;//节点个数
    public boolean[] visited;//是否遍历

    /**
     * 初始化图
     */
    public GraphSearch(){
        int MAXNUM = 20;
        init(MAXNUM);
    }

    public GraphSearch(int n){
        init(n);
    }

    public void init(int n){
        verticeNum = n;
        vertix = new char[verticeNum];
        edge = new int[verticeNum][verticeNum];
        visited = new boolean[verticeNum];
        for (int i = 0;i<verticeNum;i++){
            for (int j=0;j<verticeNum;j++){
                edge[i][j] = 0;
            }
        }
        Arrays.fill(visited, false);
    }

    /**
     * 增加边
     */
    public void insertEdge(int i,int j){
        if (i==j){
            return;
        }
        edge[i][j] = 1;
        edge[j][i] = 1;
    }

    /**
     *加载节点
     */
    public void setVertice(char[] vertice){
        this.vertix = vertice;
    }

    /**
     *加载访问情况
     */
    public void setVisited(boolean[] visited){
        this.visited = visited;
    }

    /**
     *打印矩阵
     */
    public void print(int[][] edge){
        for (int i=0;i<edge.length;i++){
            for (int j=0;j<edge.length;j++){
                System.out.print(edge[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 广度优先遍历(队列)，越早被访问到的先选用
     */
    public void bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0;i<verticeNum;i++){//以此遍历所有节点，防止遗漏
            if (!visited[i]){//当没有遍历的节点
                visited[i] = true;
                System.out.print(vertix[i] + " ");
                q.add(i);//将当前没有遍历的节点加入队列
                while(!q.isEmpty()){//当队列不为空
                    int temp = q.poll();//取出队首
                    for (int j = 0;j<verticeNum;j++){//依次遍历有关系的边
                        if ((edge[temp][j] == 1)&&(!visited[j])){
                            visited[j] = true;//更新有关系的点访问情况
                            System.out.print(vertix[j] + " ");
                            q.add(j);//将新节点加入队列
                        }
                    }
                }
            }
        }
        System.out.println();
        print(edge);
    }


    /**
     * 深度优先遍历（递归）
     */
    public void dfs(){
        for (int i = 0;i<verticeNum;i++){//依次遍历所有节点
            if (!visited[i]){//当没有遍历的节点就访问
               traverse(i);
            }
        }
        System.out.println();
        print(edge);
    }

    public void traverse(int i){
        visited[i] = true;//更新访问情况
        System.out.print(vertix[i]);
        for (int j = 0;j<verticeNum;j++){
            if ((edge[i][j] == 1)&&(!visited[j])){
                traverse(j);//递归该节点，在这个节点继续找附近节点
            }
        }
    }
}
