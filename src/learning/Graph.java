package learning;

import java.util.*;

// C++ program to print connected components in
// an undirected graph
// Graph class represents a undirected graph
// using adjacency list representation
public class Graph {

    private final int numberOfVertices;
    private List<List<Integer>> adj;

    public Graph(int V) {
        this.numberOfVertices = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // method to add an undirected edge
    public final void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }
    
    // A function used by DFS
    private void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        
        // Recur for all the vertices
        // adjacent to this vertex
        Iterator<Integer> i;
        for (i = adj.get(v).iterator(); i.hasNext();) {
            int current = i.next();
            if (!visited[current]) {
                System.out.print("," + current);
                DFSUtil(current, visited);
            }
        }
    }

    // Method to print connected components in an
    // undirected graph
    public final void connectedComponents() {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[numberOfVertices];
        for (int v = 0; v < numberOfVertices; v++) {
            visited[v] = false;
        }

        for (int v = 0; v < numberOfVertices; v++) {
            if (visited[v] == false) {
                // print all reachable vertices
                // from v
                System.out.print("["+v);
                DFSUtil(v, visited);

                System.out.print("]");
            }
        }
    }
    // Drive program to test above

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph g = new Graph(1000000);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        System.out.print("Following are connected components \n");
        g.connectedComponents();

    }
}
