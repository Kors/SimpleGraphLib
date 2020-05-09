package graph.objects.impl;

import org.junit.jupiter.api.BeforeEach;

class SimpleDirectEdgeTest extends SimpleEdgeTest {

    @BeforeEach
    @Override
    void setUp() {
        edge = new SimpleDirectEdge(1, 2);
    }

}