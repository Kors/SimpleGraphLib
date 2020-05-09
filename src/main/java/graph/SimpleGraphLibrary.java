package graph;

import graph.objects.Edge;
import graph.objects.Vertex;

import java.util.List;

public class SimpleGraphLibrary implements GraphLibrary {
    @Override
    public boolean addVertex(Vertex vertex) {
        return false;
    }

    @Override
    public boolean addEdge(Edge edge) {
        return false;
    }

    @Override
    public List<Edge> getPath(Vertex from, Vertex to) {
        return null;
    }
}
