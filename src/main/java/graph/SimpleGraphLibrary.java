package graph;

import graph.objects.Edge;
import graph.objects.Vertex;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleGraphLibrary implements GraphLibrary {

    private final Map<Integer, Vertex> vertexes = new HashMap<>();

    private final Set<Edge> edges = new HashSet<>();

    @Override
    public boolean addVertex(Vertex vertex) {
        int id = vertex.getId();
        if (vertexes.containsKey(id))
            return false;
        vertexes.put(id, vertex);
        return true;
    }

    @Override
    public boolean addEdge(Edge edge) {
        if (!vertexes.containsKey(edge.getFirstVertexId()) || !vertexes.containsKey(edge.getSecondVertexId()))
            return false;
        return edges.add(edge);
    }

    @Override
    public List<Edge> getPath(Vertex from, Vertex to) {
        return Collections.emptyList();
    }
}
