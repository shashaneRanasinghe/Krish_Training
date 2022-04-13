package com.company;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {

        //Creating the Graph
        int noOfVertices = 8;

        Graph graph = new Graph(noOfVertices);

        graph.addEdge(0,3);
        graph.addEdge(3,5);
        graph.addEdge(3,7);
        graph.addEdge(5,6);
        graph.addEdge(6,2);
        graph.addEdge(2,1);
        graph.addEdge(7,4);

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter a Vertex to start Traversal");
        int startVertex = sc.nextInt();

        System.out.println(graph);

        //Traversing the Graph
        depthFirstSearch(startVertex,graph);
    }

    public static void depthFirstSearch(int startVertex,Graph graph){
        boolean visited[] = new boolean[graph.getNoOfVertices()];

        Stack<Integer> stack = new Stack<>();

        visited[startVertex] = true;
        stack.push(startVertex);

        while (stack.size() != 0){
            startVertex = stack.pop();
            System.out.print(startVertex+" ");
            for (int n : graph.getAdjlist()[startVertex]) {
                if (!visited[n]) {
                    visited[n] = true;
                    stack.push(n);
                }
            }
        }
    }
}
