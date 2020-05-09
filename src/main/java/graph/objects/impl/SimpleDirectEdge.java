package graph.objects.impl;

import graph.objects.DirectedEdge;

public class SimpleDirectEdge implements DirectedEdge {
    @Override
    public int getFirstVertexId() {
        return 0;
    }

    @Override
    public int getSecondVertexId() {
        return 0;
    }
}
