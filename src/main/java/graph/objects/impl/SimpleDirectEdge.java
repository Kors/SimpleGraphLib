package graph.objects.impl;

import graph.objects.DirectedEdge;

public class SimpleDirectEdge implements DirectedEdge {

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
}
