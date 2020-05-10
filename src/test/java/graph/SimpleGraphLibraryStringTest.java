package graph;

import graph.objects.Edge;
import graph.objects.impl.SimpleDirectEdge;
import graph.objects.impl.SimpleEdge;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleGraphLibraryStringTest {

    private GraphLibrary<String> graphLibrary;

    @BeforeEach
    void setUp() {
        graphLibrary = new SimpleGraphLibrary<>();
        IntStream.range(1, 7).forEach(number -> graphLibrary.addVertex(String.valueOf(number)));
        graphLibrary.addEdge(edgeOf("1", "2"));
        graphLibrary.addEdge(edgeOf("2", "3"));
        graphLibrary.addEdge(directEdgeOf("4", "3"));
        graphLibrary.addEdge(directEdgeOf("5", "4"));
    }

    @Test
    void addNewVertexSuccessfully() {
        String newVertex = "31";
        boolean added = graphLibrary.addVertex(newVertex);
        assertTrue(added, () -> "Vertex " + newVertex + " was not added");
    }

    @Test
    void addAlreadyExistVertexFail() {
        String newVertex = "1";
        boolean added = graphLibrary.addVertex(newVertex);
        assertFalse(added, () -> "Vertex " + newVertex + " was added");
    }

    @Test
    void addEdgeSuccessfully() {
        Edge<String> newEdge = edgeOf("5", "6");
        boolean added = graphLibrary.addEdge(newEdge);
        assertTrue(added, () -> "Edge " + newEdge + " was not added");
    }

    @Test
    void addEdgeWithNoSuchVertex() {
        Edge<String> newEdge = edgeOf("1", "27");
        boolean added = graphLibrary.addEdge(newEdge);
        assertFalse(added, () -> "Edge " + newEdge + " was added");
    }

    @Test
    void getExistUndirectedPath() {
        List<Edge<String>> path = graphLibrary.getPath("1", "3");
        assertNotNull(path);
        assertEquals(2, path.size());
        assertEquals(edgeOf("1", "2"), path.get(0));
        assertEquals(edgeOf("2", "3"), path.get(1));
    }

    @Test
    void getExistDirectedPath() {
        List<Edge<String>> path = graphLibrary.getPath("5", "1");
        assertNotNull(path);
        assertEquals(4, path.size());
        assertEquals(directEdgeOf("5", "4"), path.get(0));
        assertEquals(directEdgeOf("4", "3"), path.get(1));
        assertEquals(edgeOf("3", "2"), path.get(2));
        assertEquals(edgeOf("2", "1"), path.get(3));
    }

    @Test
    void getWrongWayDirectedPath() {
        List<Edge<String>> path = graphLibrary.getPath("1", "5");
        assertThat(path, Matchers.nullValue());
    }

    @Test
    void getNotExistedPath() {
        List<Edge<String>> path = graphLibrary.getPath("1", "4");
        assertThat(path, Matchers.nullValue());
    }

    @Test
    void getNotExistedPathWithVertexNotInLib() {
        List<Edge<String>> path = graphLibrary.getPath("65", "74");
        assertThat(path, Matchers.nullValue());
    }


    /**
     * Create edge for test
     */
    private SimpleEdge<String> edgeOf(String firstVertex, String secondVertex) {
        return new SimpleEdge<>(firstVertex, secondVertex);
    }

    /**
     * Create directed edge for test
     */
    private SimpleDirectEdge<String> directEdgeOf(String firstVertex, String secondVertex) {
        return new SimpleDirectEdge<>(firstVertex, secondVertex);
    }

}