package graph.objects.impl;

import graph.objects.Edge;

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
}
