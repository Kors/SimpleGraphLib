package graph.objects.impl;

import graph.objects.Edge;

import java.util.Objects;

/**
 * This Simple directed edge fully identified by it's vertexes ids.
 */
public class SimpleDirectEdge implements Edge {

    private final int vertexFrom;
    private final int vertexTo;

    public SimpleDirectEdge(int vertexFrom, int vertexTo) {
        this.vertexFrom = vertexFrom;
        this.vertexTo = vertexTo;
    }

    @Override
    public int getFirstVertexId() {
        return vertexFrom;
    }

    @Override
    public int getSecondVertexId() {
        return vertexTo;
    }

    @Override
    public boolean isDirect() {
        return true;
    }

    public static SimpleDirectEdge of(int firstVertex, int secondVertex) {
        return new SimpleDirectEdge(firstVertex, secondVertex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleDirectEdge that = (SimpleDirectEdge) o;
        return vertexFrom == that.vertexFrom &&
                vertexTo == that.vertexTo;
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
