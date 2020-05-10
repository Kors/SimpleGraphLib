package graph;

import graph.objects.Edge;

import java.util.List;

public interface GraphLibrary<V> {

    /**
     * Adds vertex to the graph
     *
     * @return true if added successfully
     */
    boolean addVertex(V vertex);

    /**
     * Adds edge to the graph
     *
     * @return true if added successfully
     */
    boolean addEdge(Edge<V> edge);

    /**
     * @return a list of edges between 2 vertices (path doesn’t have to be optimal)
     */
    List<Edge<V>> getPath(V from, V to);
}
