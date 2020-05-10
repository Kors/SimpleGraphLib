package graph;

import graph.objects.Edge;
import graph.objects.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class SimpleGraphLibrary implements GraphLibrary {

    /**
     * Vertexes by their ids
     */
    private final Set<Integer> vertexIds = new HashSet<>();
    /**
     * Map contains indexes by vertex ids and helps find index of Vertex
     */
    private final Map<Integer, Integer> indexesByIds = new HashMap<>();
    /**
     * Map contains Edges for each Vertex
     */
    private final List<List<Edge>> links = new ArrayList<>();
    private int currentIndex = 0;

    @Override
    public boolean addVertex(Vertex vertex) {
        int id = vertex.getId();
        if (vertexIds.contains(id))
            return false;
        vertexIds.add(id);

        indexesByIds.put(vertex.getId(), currentIndex++);
        enlargeLinksMatrix();
        return true;
    }

    private void enlargeLinksMatrix() {
        links.forEach(list -> list.add(null));
        ArrayList<Edge> newRow = new ArrayList<>();
        IntStream.range(0, currentIndex).forEach(number -> newRow.add(null));
        links.add(newRow);
    }

    @Override
    public boolean addEdge(Edge edge) {
        if (!vertexIds.contains(edge.getFirstVertexId()) || !vertexIds.contains(edge.getSecondVertexId()))
            return false;
        addEdgeToLinks(edge);
        return true;
    }

    private void addEdgeToLinks(Edge edge) {
        Integer firstIdx = indexesByIds.get(edge.getFirstVertexId());
        Integer secondIdx = indexesByIds.get(edge.getSecondVertexId());
        updateLink(firstIdx, secondIdx, edge);
        if (!edge.isDirect())
            updateLink(secondIdx, firstIdx, edge);
    }

    private void updateLink(Integer idxFrom, Integer idxTo, Edge edge) {
        List<Edge> linksOfVertex = links.get(idxFrom);
        linksOfVertex.add(idxTo, edge);
    }

    @Override
    public List<Edge> getPath(Vertex from, Vertex to) {
        Integer idxFrom = indexesByIds.get(from.getId());
        Integer idxTo = indexesByIds.get(to.getId());
        if (idxFrom == null || idxTo == null) {
            return Collections.emptyList();
        }
        List<Edge> path = getPathIteratively(new HashSet<>(), idxFrom, idxTo);
        return path != null ? path : Collections.emptyList();
    }

    /**
     * Depth-First Search
     */
    private LinkedList<Edge> getPathIteratively(Set<Integer> markedVertexes, int currentIndex, int finishIndex) {
        if (currentIndex == finishIndex) {
            return new LinkedList<>();
        }
        markedVertexes.add(currentIndex);
        List<Edge> linksOfVertex = links.get(currentIndex);
        for (Edge edge : linksOfVertex) {
            if (edge != null) {
                int nextIdx;
                if (!markedVertexes.contains(indexesByIds.get(edge.getSecondVertexId()))) {
                    nextIdx = indexesByIds.get(edge.getSecondVertexId());
                } else if (!markedVertexes.contains(indexesByIds.get(edge.getFirstVertexId()))) {
                    nextIdx = indexesByIds.get(edge.getFirstVertexId());
                } else {
                    continue;
                }
                LinkedList<Edge> pathIteratively = getPathIteratively(markedVertexes, nextIdx, finishIndex);
                if (pathIteratively != null) {
                    pathIteratively.addFirst(edge);
                    return pathIteratively;
                }
            }
        }
        return null;
    }
}
