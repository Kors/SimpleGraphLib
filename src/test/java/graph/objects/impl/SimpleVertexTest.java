package graph.objects.impl;

import graph.objects.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleVertexTest {

    @Test
    void getId() {
        int id = 42;
        Vertex vertex = new SimpleVertex(42);
        int vertexId = vertex.getId();
        assertEquals(id, vertexId);
    }
}