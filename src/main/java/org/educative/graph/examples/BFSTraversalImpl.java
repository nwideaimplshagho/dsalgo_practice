package org.educative.graph.examples;

import lombok.extern.slf4j.Slf4j;
import org.educative.graph.common.EduLinkedList;
import org.educative.graph.common.Graph;
import org.educative.graph.common.Queue;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BFSTraversalImpl {
    public static List<Integer> bfsTraversal(Graph graph, int source) {

        // Replace this placeholder return statement with your code
        int numVertices = graph.vertices;
        EduLinkedList<Integer> [] adjacencyList = graph.adjacencyList;
        List<Integer> bfsVertexes = new ArrayList<>(numVertices);
        Queue<Integer> bfsHelperQueue = new Queue<>(numVertices);
        boolean[] visited = new boolean[numVertices];
        bfsHelperQueue.enqueue(source);
        visited[source] = true;

        while (!bfsHelperQueue.isEmpty()) {
            int vertex = bfsHelperQueue.dequeue();
            bfsVertexes.add(vertex);
            EduLinkedList<Integer>.Node head = adjacencyList[vertex].getHeadNode();
            while (head != null) {
                int nextVertex = head.data;
                if (!visited[nextVertex]) {
                    bfsHelperQueue.enqueue(nextVertex);
                    visited[nextVertex] = true;
                }

                head = head.nextNode;
            }
        }

        return bfsVertexes;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(2);
//        graph.addEdge(2,1);
//        graph.addEdge(2,3);
//        graph.addEdge(1,0);
//        graph.addEdge(0,4);
//        graph.addEdge(0,2);
//        graph.addEdge(2,1);
//        graph.addEdge(2,3);
        graph.addEdge(1,2);
        graph.addEdge(2,2);
//        graph.addEdge(3,0);
//        graph.addEdge(3,2);

//
        List<Integer> bfsVertexes = bfsTraversal(graph, 0);

        for (int vertex : bfsVertexes) {
            log.info(" Vertex : {}" , vertex);
        }
    }
}
