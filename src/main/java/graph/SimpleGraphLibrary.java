package graph;

import graph.objects.Edge;
import graph.objects.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleGraphLibrary implements GraphLibrary {

    /**
     * Vertexes ids
     */
    private final Set<Integer> vertexIds = new HashSet<>();

    /**
     * Map contains Edges for each Vertex
     */
    private final Map<Integer, Map<Integer, Edge>> edges = new HashMap<>();

    @Override
    public boolean addVertex(Vertex vertex) {
        int id = vertex.getId();
        if (vertexIds.contains(id))
            return false;
        vertexIds.add(id);
        return true;
    }

    @Override
    public boolean addEdge(Edge edge) {
        if (!vertexIds.contains(edge.getFirstVertexId()) || !vertexIds.contains(edge.getSecondVertexId()))
            return false;
        addEdgeToLinks(edge);
        return true;
    }

    private void addEdgeToLinks(Edge edge) {
        Integer firstId = edge.getFirstVertexId();
        Integer secondId = edge.getSecondVertexId();
        updateLink(firstId, secondId, edge);
        if (!edge.isDirect())
            updateLink(secondId, firstId, edge);
    }

    private void updateLink(Integer idFrom, Integer idTo, Edge edge) {
        Map<Integer, Edge> edgesOfVertex = edges.computeIfAbsent(idFrom, key -> new HashMap<>());
        edgesOfVertex.put(idTo, edge);
    }

    @Override
    public List<Edge> getPath(Vertex from, Vertex to) {
        int idFrom = from.getId();
        int idTo = to.getId();
        if (!vertexIds.contains(idFrom) || !vertexIds.contains(idTo)) {
            return null;
        }
        return getPathIteratively(new HashSet<>(), idFrom, idTo);
    }

    /**
     * Depth-First Search
     */
    private LinkedList<Edge> getPathIteratively(Set<Integer> markedVertexes, int currentIndex, int finishIndex) {
        if (currentIndex == finishIndex) {
            return new LinkedList<>();
        }
        markedVertexes.add(currentIndex);
        Map<Integer, Edge> linksOfVertex = edges.get(currentIndex);
        for (Map.Entry<Integer, Edge> entry : linksOfVertex.entrySet()) {
            Integer nextId = entry.getKey();
            if (markedVertexes.contains(nextId)) {
                continue;
            }
            LinkedList<Edge> pathIteratively = getPathIteratively(markedVertexes, nextId, finishIndex);
            if (pathIteratively != null) {
                Edge currentEdge = entry.getValue();
                pathIteratively.addFirst(currentEdge);
                return pathIteratively;
            }
        }
        return null;
    }
}
