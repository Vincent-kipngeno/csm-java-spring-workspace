import java.util.*;

public class Graph<T> {
    private Map<T, List<T>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Adds a vertex (node) to the graph
    public void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new LinkedList<>());
    }

    // Adds an edge between two vertices
    public void addEdge(T source, T destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
    }

    // Returns the number of vertices in the graph
    public int getVertexCount() {
        return adjacencyList.keySet().size();
    }

    // Returns the number of edges from the given vertex
    public int getEdgeCount(T vertex) {
        if (adjacencyList.containsKey(vertex)) {
            return adjacencyList.get(vertex).size();
        } else {
            return 0;
        }
    }

    // Prints the adjacency list representation
    public void printGraph() {
        for (T vertex : adjacencyList.keySet()) {
            System.out.println(vertex + " -> " + adjacencyList.get(vertex));
        }
    }

    public void depthFirstTraversal(T startVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Start vertex not found!");
            return;
        }

        // 'visited' set to keep track of visited nodes
        java.util.Set<T> visited = new java.util.HashSet<>();

        // Stack for the DFS algorithm
        java.util.Stack<T> stack = new java.util.Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            T currentVertex = stack.pop();
            if (!visited.contains(currentVertex)) {
                System.out.print(currentVertex + " ");
                visited.add(currentVertex);

                // Get neighbors and push in reverse order
                // to maintain DFS exploration
                List<T> neighbors = adjacencyList.get(currentVertex);
                Collections.reverse(neighbors);
                for (T neighbor : neighbors) {
                    stack.push(neighbor);
                }
                Collections.reverse(neighbors);
            }
        }
    }

    public void depthFirstTraversalRecursive(T startVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Start vertex not found!");
            return;
        }

        java.util.Set<T> visited = new java.util.HashSet<>();
        dfsRecursiveHelper(startVertex, visited);
    }

    private void dfsRecursiveHelper(T vertex, java.util.Set<T> visited) {
        System.out.print(vertex + " ");
        visited.add(vertex);

        for (T neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsRecursiveHelper(neighbor, visited);
            }
        }
    }

    public void breadthFirstTraversal(T startVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Start vertex not found!");
            return;
        }

        // 'visited' set to keep track of visited nodes
        java.util.Set<T> visited = new java.util.HashSet<>();

        // Queue for the BFS algorithm
        java.util.Queue<T> queue = new java.util.LinkedList<>();
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            T currentVertex = queue.poll();
            if (!visited.contains(currentVertex)) {
                System.out.print(currentVertex + " ");
                visited.add(currentVertex);

                for (T neighbor : adjacencyList.get(currentVertex)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph<String> socialNetwork = new Graph<>();

        socialNetwork.addEdge("Alice", "Bob");
        socialNetwork.addEdge("Alice", "Claire");
        socialNetwork.addEdge("Bob", "Dave");
        socialNetwork.addEdge("Claire", "Bob");
        socialNetwork.addEdge("Claire", "Eve");

        socialNetwork.printGraph();
        socialNetwork.breadthFirstTraversal("Alice");
    }
}