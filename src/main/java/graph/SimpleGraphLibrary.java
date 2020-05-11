package graph;

import graph.objects.Edge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleGraphLibrary<V> implements GraphLibrary<V> {

    /**
     * All vertexes
     */
    private final Set<V> vertexes = new HashSet<>();

    /**
     * Map contains Edges for each Vertex
     */
    private final Map<V, Map<V, Edge<V>>> edges = new HashMap<>();

    @Override
    public boolean addVertex(V vertex) {
        if (vertexes.contains(vertex))
            return false;
        vertexes.add(vertex);
        return true;
    }

    @Override
    public boolean addEdge(Edge<V> edge) {
        if (!vertexes.contains(edge.getFirstVertex()) || !vertexes.contains(edge.getSecondVertex()))
            return false;
        addEdgeToLinks(edge);
        return true;
    }

    private void addEdgeToLinks(Edge<V> edge) {
        V firstVertex = edge.getFirstVertex();
        V secondVertex = edge.getSecondVertex();
        updateLink(firstVertex, secondVertex, edge);
        if (!edge.isDirected())
            updateLink(secondVertex, firstVertex, edge);
    }

    private void updateLink(V from, V to, Edge<V> edge) {
        Map<V, Edge<V>> edgesOfVertex = edges.computeIfAbsent(from, key -> new HashMap<>());
        edgesOfVertex.put(to, edge);
    }

    @Override
    public List<Edge<V>> getPath(V from, V to) {
        if (!vertexes.contains(from) || !vertexes.contains(to)) {
            return null;
        }
        return getPathRecursively(new HashMap<>(), 0, from, to);
    }

    /**
     * Recursive Depth-First Search (find shortest path)
     */
    private LinkedList<Edge<V>> getPathRecursively(Map<V, Integer> pathWeights, int currentWeight, V currentVertex, V requiredVertex) {
        if (currentVertex == requiredVertex) {
            return new LinkedList<>();
        }

        pathWeights.merge(currentVertex, currentWeight,
                (oldValue, newValue) -> oldValue > newValue ? newValue : oldValue);

        int nextWeight = currentWeight + 1;

        LinkedList<Edge<V>> shortestPath = null;
        Map<V, Edge<V>> edgesOfVertex = edges.computeIfAbsent(currentVertex, key -> new HashMap<>());
        for (Map.Entry<V, Edge<V>> entry : edgesOfVertex.entrySet()) {
            V nextVertex = entry.getKey();
            if (nextWeight >= pathWeights.getOrDefault(nextVertex, Integer.MAX_VALUE)) {
                continue;
            }
            LinkedList<Edge<V>> path = getPathRecursively(pathWeights, nextWeight, nextVertex, requiredVertex);
            if (isNewPathShorter(shortestPath, path)) {
                Edge<V> currentEdge = entry.getValue();
                path.addFirst(currentEdge);
                shortestPath = path;
            }
        }
        return shortestPath;
    }

    private boolean isNewPathShorter(LinkedList<Edge<V>> shortestPath, LinkedList<Edge<V>> path) {
        return path != null && (shortestPath == null || path.size() < shortestPath.size());
    }

}
