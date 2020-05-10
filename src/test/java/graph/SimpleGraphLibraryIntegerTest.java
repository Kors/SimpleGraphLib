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

class SimpleGraphLibraryIntegerTest {

    private GraphLibrary<Integer> graphLibrary;

    @BeforeEach
    void setUp() {
        graphLibrary = new SimpleGraphLibrary<>();
        IntStream.range(1, 7).forEach(graphLibrary::addVertex);
        graphLibrary.addEdge(edgeOf(1, 2));
        graphLibrary.addEdge(edgeOf(2, 3));
        graphLibrary.addEdge(directEdgeOf(4, 3));
        graphLibrary.addEdge(directEdgeOf(5, 4));
    }

    @Test
    void addNewVertexSuccessfully() {
        Integer newVertex = 31;
        boolean added = graphLibrary.addVertex(newVertex);
        assertTrue(added, () -> "Vertex " + newVertex + " was not added");
    }

    @Test
    void addAlreadyExistVertexFail() {
        Integer newVertex = 1;
        boolean added = graphLibrary.addVertex(newVertex);
        assertFalse(added, () -> "Vertex " + newVertex + " was added");
    }

    @Test
    void addEdgeSuccessfully() {
        Edge<Integer> newEdge = edgeOf(5, 6);
        boolean added = graphLibrary.addEdge(newEdge);
        assertTrue(added, () -> "Edge " + newEdge + " was not added");
    }

    @Test
    void addEdgeWithNoSuchVertex() {
        Edge<Integer> newEdge = edgeOf(1, 27);
        boolean added = graphLibrary.addEdge(newEdge);
        assertFalse(added, () -> "Edge " + newEdge + " was added");
    }

    @Test
    void getExistUndirectedPath() {
        List<Edge<Integer>> path = graphLibrary.getPath(1, 3);
        assertNotNull(path);
        assertEquals(2, path.size());
        assertEquals(edgeOf(1, 2), path.get(0));
        assertEquals(edgeOf(2, 3), path.get(1));
    }

    @Test
    void getExistDirectedPath() {
        List<Edge<Integer>> path = graphLibrary.getPath(5, 1);
        assertNotNull(path);
        assertEquals(4, path.size());
        assertEquals(directEdgeOf(5, 4), path.get(0));
        assertEquals(directEdgeOf(4, 3), path.get(1));
        assertEquals(edgeOf(3, 2), path.get(2));
        assertEquals(edgeOf(2, 1), path.get(3));
    }

    @Test
    void getWrongWayDirectedPath() {
        List<Edge<Integer>> path = graphLibrary.getPath(1, 5);
        assertThat(path, Matchers.nullValue());
    }

    @Test
    void getNotExistedPath() {
        List<Edge<Integer>> path = graphLibrary.getPath(1, 4);
        assertThat(path, Matchers.nullValue());
    }

    @Test
    void getNotExistedPathWithVertexNotInLib() {
        List<Edge<Integer>> path = graphLibrary.getPath(65, 74);
        assertThat(path, Matchers.nullValue());
    }


    /**
     * Create edge for test
     */
    private SimpleEdge<Integer> edgeOf(Integer firstVertex, Integer secondVertex) {
        return new SimpleEdge<>(firstVertex, secondVertex);
    }

    /**
     * Create directed edge for test
     */
    private SimpleDirectEdge<Integer> directEdgeOf(int firstVertex, int secondVertex) {
        return new SimpleDirectEdge<>(firstVertex, secondVertex);
    }

}