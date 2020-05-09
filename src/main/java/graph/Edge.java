package graph;

/**
 * Undirected edge. Suitable for use with any objects with unique int id.
 */
public interface Edge {

    int getFirstVertexId();

    int getSecondVertexId();
}
