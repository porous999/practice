package extras;

public class ConnectedComponent {

    public static void main(String[] args) {
        //int[][] mygraph = new int[3][3];

        AdjacencyMatrixGraph mygraph = new AdjacencyMatrixGraph(5);
        mygraph.makeEdge(1, 2, 1);
        mygraph.makeEdge(2, 3, 1);
        mygraph.makeEdge(4, 5, 1);

        findConnectedComponents(mygraph);
        /*mygraph.makeEdge(1, 2, 1);
        mygraph.makeEdge(1, 2, 1);
        mygraph.makeEdge(1, 2, 1);
        mygraph.makeEdge(1, 2, 1);*/
    }

    private static void findConnectedComponents(AdjacencyMatrixGraph mygraph) {
        
    }
}
