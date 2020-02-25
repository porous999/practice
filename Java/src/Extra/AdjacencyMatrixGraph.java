package src.Extra;

/*
This piece of code is not written by me, and is refactored from:
http://www.sanfoundry.com/java-program-represent-graph-adjacency-matrix/
Although some new customized methods were added.
 */

import java.util.Scanner;

public class AdjacencyMatrixGraph {
    private int[][] adjacencyMatrix;
    private AdjacencyMatrixGraph thisGraph;

    AdjacencyMatrixGraph(int vertices) {
        adjacencyMatrix = new int[vertices + 1][vertices + 1];
    }


    private AdjacencyMatrixGraph(int vertices, int[][] adjacencyMatrix) {

    }

    public void makeEdge(int to, int from, int weight) {
        try {
            adjacencyMatrix[to][from] = weight;
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
    }

    private int getEdge(int to, int from) {
        try {
            return adjacencyMatrix[to][from];
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }

    public void printGraph(int vertices, AdjacencyMatrixGraph graph){
        System.out.println("The adjacency matrix for the given graph is: ");
        System.out.print("  ");
        for (int i = 1; i <= vertices; i++)
            System.out.print(i + " ");
        System.out.println();

        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= vertices; j++)
                System.out.print(graph.getEdge(i, j) + " ");
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int vertices, edges, count = 1, to, from;
        Scanner thisScanner = new Scanner(System.in);
        AdjacencyMatrixGraph graph;
        try {
            System.out.println("Enter the number of vertices: ");
            vertices = thisScanner.nextInt();
            System.out.println("Enter the number of edges: ");
            edges = thisScanner.nextInt();

            graph = new AdjacencyMatrixGraph(vertices);

            System.out.println("Enter the edges with spaces: <to> <from>(both int, vertices id starting from 1)");
            while (count <= edges) {
                to = thisScanner.nextInt();
                from = thisScanner.nextInt();
                graph.makeEdge(to, from, 1);
                count++;
            }

            graph.printGraph(vertices, graph);

        } catch (Exception thisException) {
            System.out.println("Somthing went wrong: " + thisException.getMessage());
        }

        thisScanner.close();
    }
}