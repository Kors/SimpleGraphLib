package graph.objects;

/**
 * Undirected edge. Suitable for use with any objects as a vertex
 */
public interface Edge<V> {

    V getFirstVertex();

    V getSecondVertex();

    /**
     * @return true if edge is directed and false if it's undirected/bidirectional
     */
    boolean isDirected();
}
