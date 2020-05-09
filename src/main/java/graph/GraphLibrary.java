package graph;

import graph.objects.Edge;
import graph.objects.Vertex;

import java.util.List;

public interface GraphLibrary {

    /**
     * Adds vertex to the graph
     *
     * @return true if added successfully
     */
    boolean addVertex(Vertex vertex);

    /**
     * Adds edge to the graph
     *
     * @return true if added successfully
     */
    boolean addEdge(Edge edge);

    /**
     * @return a list of edges between 2 vertices (path doesn’t have to be optimal)
     */
    List<Edge> getPath(Vertex from, Vertex to);
}
