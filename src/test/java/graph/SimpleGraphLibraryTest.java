package graph;

import graph.objects.Edge;
import graph.objects.Vertex;
import graph.objects.impl.SimpleDirectEdge;
import graph.objects.impl.SimpleEdge;
import graph.objects.impl.SimpleVertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleGraphLibraryTest {

    private GraphLibrary graphLibrary;

    @BeforeEach
    void setUp() {
        graphLibrary = new SimpleGraphLibrary();
        IntStream.range(1, 7).forEach(id -> graphLibrary.addVertex(SimpleVertex.of(id)));
        graphLibrary.addEdge(SimpleEdge.of(1, 2));
        graphLibrary.addEdge(SimpleEdge.of(2, 3));
        graphLibrary.addEdge(SimpleDirectEdge.of(4, 3));
        graphLibrary.addEdge(SimpleEdge.of(4, 5));
    }

    @Test
    void addNewVertexSuccessfully() {
        Vertex newVertex = new SimpleVertex(31);
        boolean added = graphLibrary.addVertex(newVertex);
        assertTrue(added, () -> "Vertex " + newVertex + " was not added");
    }

    @Test
    void addAlreadyExistVertexFail() {
        Vertex newVertex = new SimpleVertex(1);
        boolean added = graphLibrary.addVertex(newVertex);
        assertFalse(added, () -> "Vertex " + newVertex + " was added");
    }

    @Test
    void addEdgeSuccessfully() {
        Edge newEdge = SimpleEdge.of(5, 6);
        boolean added = graphLibrary.addEdge(newEdge);
        assertTrue(added, () -> "Edge " + newEdge + " was not added");
    }

    @Test
    void addEdgeWithNoSuchVertex() {
        Edge newEdge = new SimpleEdge(1, 27);
        boolean added = graphLibrary.addEdge(newEdge);
        assertFalse(added, () -> "Edge " + newEdge + " was added");
    }

    @Test
    void getExistUndirectedPath() {
        List<Edge> path = graphLibrary.getPath(SimpleVertex.of(1), SimpleVertex.of(3));
        assertNotNull(path);
        assertEquals(2, path.size());
        assertEquals(SimpleEdge.of(1, 2), path.get(0));
        assertEquals(SimpleEdge.of(2, 3), path.get(1));
    }

    @Test
    void getExistDirectedPath() {
        List<Edge> path = graphLibrary.getPath(SimpleVertex.of(5), SimpleVertex.of(1));
        assertNotNull(path);
        assertEquals(4, path.size());
        assertEquals(SimpleEdge.of(5, 4), path.get(0));
        assertEquals(SimpleDirectEdge.of(4, 3), path.get(1));
        assertEquals(SimpleEdge.of(3, 2), path.get(2));
        assertEquals(SimpleEdge.of(2, 1), path.get(3));
    }

    @Test
    void getWrongWayDirectedPath() {
        List<Edge> path = graphLibrary.getPath(SimpleVertex.of(1), SimpleVertex.of(5));
        assertNotNull(path);
        assertEquals(0, path.size());
    }

    @Test
    void getEmptyPath() {
        List<Edge> path = graphLibrary.getPath(SimpleVertex.of(1), SimpleVertex.of(4));
        assertNotNull(path);
        assertThat(path, empty());
    }

}