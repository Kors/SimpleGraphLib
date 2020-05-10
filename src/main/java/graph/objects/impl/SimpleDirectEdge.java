package graph.objects.impl;

import graph.objects.Edge;

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

    @Override
    public String toString() {
        return "SimpleDirectEdge{" +
                "vertexFrom=" + vertexFrom +
                ", vertexTo=" + vertexTo +
                '}';
    }
}
