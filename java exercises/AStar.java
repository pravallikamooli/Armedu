import java.util.*;

class Edge {
    Node target;
    int weight;

    public Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

class Node implements Comparable<Node> {
    String name;
    List<Edge> edges = new ArrayList<>();
    int distance = Integer.MAX_VALUE;
    int cost = Integer.MAX_VALUE;
    Node parent = null;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}

class Graph {
    List<Node> vertices = new ArrayList<>();

    public void addVertex(Node vertex) {
        vertices.add(vertex);
    }
}

public class AStar {
    public static void main(String[] args) {
        Graph graph = new Graph();

        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");

        A.edges.add(new Edge(B, 3));
        B.edges.add(new Edge(C, 5));
        C.edges.add(new Edge(D, 7));
        D.edges.add(new Edge(A, 3));
        D.edges.add(new Edge(E, 10));

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);

        Node startNode = A;
        Node endNode = E;

        aStar(graph, startNode, endNode);
    }

    public static void aStar(Graph graph, Node startNode, Node endNode) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        Set<Node> closedSet = new HashSet<>();
    
        startNode.distance = 0;
        startNode.cost = 0;
    
        openSet.add(startNode);
    
        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
    
            if (current.equals(endNode)) {
                printPath(current);
                return;
            }
    
            closedSet.add(current);
    
            for (Edge edge : current.edges) {
                Node neighbor = edge.target;
                if (closedSet.contains(neighbor)) {
                    continue; 
                }
    
                int tentativeCost = current.distance + edge.weight;
                if (tentativeCost < neighbor.distance) {
                    neighbor.parent = current;
                    neighbor.distance = tentativeCost;
                    neighbor.cost = tentativeCost;
    
                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }
    
        System.out.println("Path not found");
    }
    

    private static void printPath(Node endNode) {
        List<Node> path = new ArrayList<>();
        Node current = endNode;
        while (current != null) {
            path.add(current);
            current = current.parent;
        }

        Collections.reverse(path);

        System.out.print("Path: ");
        for (Node node : path) {
            System.out.print(node.name + " -> ");
        }
        System.out.println();
        System.out.println("Cost: " + endNode.distance);
    }

    public static int calculateHeuristic(Node node, Node endNode) {
        return Math.abs(parseCoordinate(node, 'x') - parseCoordinate(endNode, 'x'))
            + Math.abs(parseCoordinate(node, 'y') - parseCoordinate(endNode, 'y'));
    }

    private static int parseCoordinate(Node node, char axis) {
        if (node.name.length() == 1) {
            return node.name.charAt(0);
        }
    
        try {
            return Integer.parseInt(node.name);
        } catch (NumberFormatException e) {
            return node.name.charAt(0);
        }
    }
}
