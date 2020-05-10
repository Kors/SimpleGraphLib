package graph.objects.impl;

import graph.objects.Edge;

import java.util.Objects;

/**
 * This Simple undirected edge fully identified by it's vertexes. Order is not important.
 */
public class SimpleEdge<V> implements Edge<V> {

    private final V firstVertex;
    private final V secondVertex;

    public SimpleEdge(V firstVertex, V secondVertex) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
    }

    @Override
    public V getFirstVertex() {
        return firstVertex;
    }

    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public V getSecondVertex() {
        return secondVertex;
    }

    /**
     * Check equality. Vertex order is not important.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleEdge<?> that = (SimpleEdge<?>) o;
        return (Objects.equals(firstVertex, that.firstVertex) &&
                Objects.equals(secondVertex, that.secondVertex)) ||
                (Objects.equals(secondVertex, that.firstVertex) &&
                        Objects.equals(firstVertex, that.secondVertex));
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstVertex, secondVertex);
    }

    @Override
    public String toString() {
        return "SimpleEdge{" +
                "firstVertex=" + firstVertex +
                ", secondVertex=" + secondVertex +
                '}';
    }
}
