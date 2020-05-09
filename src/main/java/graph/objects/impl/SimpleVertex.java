package graph.objects.impl;

import graph.objects.Vertex;

public class SimpleVertex implements Vertex {

    /**
     * Unique vertex id
     */
    private final int id;

    public SimpleVertex(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
