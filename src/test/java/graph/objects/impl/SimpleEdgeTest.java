package graph.objects.impl;

import graph.objects.Edge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleEdgeTest {

    Edge edge;

    private int firstId = 1;

    private int secondId = 2;

    @BeforeEach
    void setUp() {
        edge = new SimpleEdge(firstId, secondId);
    }

    @Test
    void getFirstVertexId() {
        int firstVertexId = edge.getFirstVertexId();
        Assertions.assertEquals(firstId, firstVertexId);
    }

    @Test
    void getSecondVertexId() {
        int secondVertexId = edge.getSecondVertexId();
        Assertions.assertEquals(secondId, secondVertexId);
    }
}