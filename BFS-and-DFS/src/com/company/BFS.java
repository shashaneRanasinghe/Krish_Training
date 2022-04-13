package com.company;

import java.util.*;

public class BFS {

    public static void main(String[] args) {

        //Creating the Graph
        int noOfVertices = 6;
        Graph graph = new Graph(noOfVertices);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,0);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,0);
        graph.addEdge(2,4);
        graph.addEdge(3,1);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,1);
        graph.addEdge(4,2);
        graph.addEdge(4,3);
        graph.addEdge(4,5);
        graph.addEdge(5,3);
        graph.addEdge(5,4);

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter a Vertex to start Traversal");
        int startVertex = sc.nextInt();

        System.out.println(graph);

        //Traversing the Graph
        breadthFirstSearch(startVertex,graph);
    }

    public static void breadthFirstSearch(int startVertex,Graph graph){

        boolean visited[] = new boolean[graph.getNoOfVertices()];

        Queue<Integer> queue = new LinkedList<>() {
        };

        visited[startVertex] = true;
        queue.add(startVertex);

        while (queue.size() != 0){
            startVertex = queue.poll();
            System.out.print(startVertex+" ");
            for (int n : graph.getAdjlist()[startVertex]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
