package Graph;
/**
 * 图遍历测试
 */
public class GraphSearchTest {
    public static void main(String[] args) {
        GraphSearch g = new GraphSearch(9);
        char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        // 设置顶点集
        g.setVertice(vertices);
        // 添加边
        g.insertEdge(0, 1);
        g.insertEdge(0, 5);
        g.insertEdge(1, 0);
        g.insertEdge(1, 2);
        g.insertEdge(1, 6);
        g.insertEdge(1, 8);
        g.insertEdge(2, 1);
        g.insertEdge(2, 3);
        g.insertEdge(2, 8);
        g.insertEdge(3, 2);
        g.insertEdge(3, 4);
        g.insertEdge(3, 6);
        g.insertEdge(3, 7);
        g.insertEdge(3, 8);
        g.insertEdge(4, 3);
        g.insertEdge(4, 5);
        g.insertEdge(4, 7);
        g.insertEdge(5, 0);
        g.insertEdge(5, 4);
        g.insertEdge(5, 6);
        g.insertEdge(6, 1);
        g.insertEdge(6, 3);
        g.insertEdge(6, 5);
        g.insertEdge(6, 7);
        g.insertEdge(7, 3);
        g.insertEdge(7, 4);
        g.insertEdge(7, 6);
        g.insertEdge(8, 1);
        g.insertEdge(8, 2);
        g.insertEdge(8, 3);
        System.out.print("广度优先遍历(队列)：");
        g.dfs();
        g.bfs();

    }
}
