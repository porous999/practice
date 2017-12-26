package Extra;

/*
This piece of code is not written by me, and is refactored from:
http://www.sanfoundry.com/java-program-represent-graph-adjacency-matrix/
 */

import java.util.Scanner;

public class RepresentGraphFromAdjacencyMatrix {
    private int[][] adjacency_matrix;

    RepresentGraphFromAdjacencyMatrix(int vertices) {
        adjacency_matrix = new int[vertices + 1][vertices + 1];
    }

    private void makeEdge(int to, int from, int edge) {
        try {
            adjacency_matrix[to][from] = edge;
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
    }

    private int getEdge(int to, int from) {
        try {
            return adjacency_matrix[to][from];
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }

    public static void main(String args[]) {
        int v, e, count = 1, to, from;
        Scanner sc = new Scanner(System.in);
        RepresentGraphFromAdjacencyMatrix graph;
        try {
            System.out.println("Enter the number of vertices: ");
            v = sc.nextInt();
            System.out.println("Enter the number of edges: ");
            e = sc.nextInt();

            graph = new RepresentGraphFromAdjacencyMatrix(v);

            System.out.println("Enter the edges: <to> <from>");
            while (count <= e) {
                to = sc.nextInt();
                from = sc.nextInt();

                graph.makeEdge(to, from, 1);
                count++;
            }

            System.out.println("The adjacency matrix for the given graph is: ");
            System.out.print("  ");
            for (int i = 1; i <= v; i++)
                System.out.print(i + " ");
            System.out.println();

            for (int i = 1; i <= v; i++) {
                System.out.print(i + " ");
                for (int j = 1; j <= v; j++)
                    System.out.print(graph.getEdge(i, j) + " ");
                System.out.println();
            }

        } catch (Exception E) {
            System.out.println("Somthing went wrong" + E.getMessage());
        }

        sc.close();
    }
}