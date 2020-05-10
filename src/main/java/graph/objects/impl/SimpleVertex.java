package graph.objects.impl;

import graph.objects.Vertex;

import java.util.Objects;

/**
 * This Simple vertex fully identified by it's id.
 */
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

    public static SimpleVertex of(int id) {
        return new SimpleVertex(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleVertex that = (SimpleVertex) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SimpleVertex{" +
                "id=" + id +
                '}';
    }
}
