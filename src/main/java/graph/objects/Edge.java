package graph.objects;

/**
 * Undirected edge. Suitable for use with any objects with unique int id.
 */
public interface Edge {

    int getFirstVertexId();

    int getSecondVertexId();

    /**
     * @return true if edge is direct and false if it's undirected/bidirectional
     */
    boolean isDirect();
}
