package graph.objects.impl;

import graph.objects.Edge;

import java.util.Objects;

/**
 * This Simple undirected edge fully identified by it's vertexes ids.
 */
public class SimpleEdge implements Edge {

    private final int firstVertex;
    private final int secondVertex;

    public SimpleEdge(int firstVertex, int secondVertex) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
    }

    @Override
    public int getFirstVertexId() {
        return firstVertex;
    }

    @Override
    public int getSecondVertexId() {
        return secondVertex;
    }

    @Override
    public boolean isDirect() {
        return false;
    }

    public static SimpleEdge of(int firstVertex, int secondVertex) {
        return new SimpleEdge(firstVertex, secondVertex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleEdge that = (SimpleEdge) o;
        return (firstVertex == that.firstVertex &&
                secondVertex == that.secondVertex) ||
                (secondVertex == that.firstVertex &&
                        firstVertex == that.secondVertex);
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
