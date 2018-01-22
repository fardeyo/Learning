package Graphs;

import java.io.*;
import java.util.*;

class testGraph
{
    private int numVertices;
    private LinkedList<Integer> adjLists[];
 
    testGraph(int vertices)
    {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        
        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList();
    }
 
    void addEdge(int src, int dest)
    {
        adjLists[src].add(dest);
    }
 
    public static void main(String args[])
    {
        testGraph g = new testGraph(4);
 
         g.addEdge(0, 1);
         g.addEdge(0, 2);
         g.addEdge(1, 2);
         g.addEdge(2, 3);
         
         
         for (LinkedList<Integer> adjList : g.adjLists) {
             for (Integer integer : adjList) {
                 System.out.print(integer+" ");
             }System.out.println("");
        }
    }
}