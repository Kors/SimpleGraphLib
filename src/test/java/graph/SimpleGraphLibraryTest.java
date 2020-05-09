package graph;

import graph.objects.Edge;
import graph.objects.Vertex;
import graph.objects.impl.SimpleEdge;
import graph.objects.impl.SimpleVertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SimpleGraphLibraryTest {

    private GraphLibrary graphLibrary;

    private Vertex vertex1 = new SimpleVertex(1);
    private Vertex vertex2 = new SimpleVertex(2);
    private Vertex vertex3 = new SimpleVertex(3);

    private Edge edge1 = new SimpleEdge(1, 2);
    private Edge edge2 = new SimpleEdge(2, 3);

    @BeforeEach
    void setUp() {
        graphLibrary = new SimpleGraphLibrary();
        graphLibrary.addVertex(vertex1);
        graphLibrary.addVertex(vertex2);
        graphLibrary.addVertex(vertex3);
        graphLibrary.addEdge(edge1);
        graphLibrary.addEdge(edge2);
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
        Edge newEdge = new SimpleEdge(1, 2);
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
    void getPath() {
        List<Edge> path = graphLibrary.getPath(vertex1, vertex3);
        assertNotNull(path);
        assertEquals(2, path.size());
        assertEquals(edge1, path.get(0));
        assertEquals(edge2, path.get(1));
    }

}