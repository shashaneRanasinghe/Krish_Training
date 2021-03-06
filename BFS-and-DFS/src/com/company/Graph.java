package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private int noOfVertices;
    private LinkedList[] adjlist;

    public Graph(int noOfVertices){
        this.noOfVertices = noOfVertices;
        adjlist = new LinkedList[noOfVertices];

        for (int i = 0; i < noOfVertices; i++){
            adjlist[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex, int nextVertex){
        adjlist[vertex].add(nextVertex);
    }

    public int getNoOfVertices() {
        return noOfVertices;
    }

    public LinkedList<Integer>[] getAdjlist() {
        return adjlist;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "adjlist=" + Arrays.toString(adjlist) +
                '}';
    }
}
