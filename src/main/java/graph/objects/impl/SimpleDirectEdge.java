package graph.objects.impl;

import graph.objects.Edge;

import java.util.Objects;

/**
 * This Simple directed edge fully identified by it's vertexes. Order is important.
 */
public class SimpleDirectEdge<V> implements Edge<V> {

    private final V vertexFrom;
    private final V vertexTo;

    public SimpleDirectEdge(V vertexFrom, V vertexTo) {
        this.vertexFrom = vertexFrom;
        this.vertexTo = vertexTo;
    }

    @Override
    public V getFirstVertex() {
        return vertexFrom;
    }

    @Override
    public boolean isDirected() {
        return true;
    }

    @Override
    public V getSecondVertex() {
        return vertexTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleDirectEdge<?> that = (SimpleDirectEdge<?>) o;
        return Objects.equals(vertexFrom, that.vertexFrom) &&
                Objects.equals(vertexTo, that.vertexTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexFrom, vertexTo);
    }

    @Override
    public String toString() {
        return "SimpleDirectEdge{" +
                "vertexFrom=" + vertexFrom +
                ", vertexTo=" + vertexTo +
                '}';
    }
}
