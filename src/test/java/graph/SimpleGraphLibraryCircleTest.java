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

class SimpleGraphLibraryCircleTest {

    private GraphLibrary<Integer> graphLibrary;

    @BeforeEach
    void setUp() {
        graphLibrary = new SimpleGraphLibrary<>();
        IntStream.range(1, 7).forEach(graphLibrary::addVertex);
    }

    @Test
    void getPathDirectedEdgesCircleSuccess() {
        graphLibrary.addEdge(directEdgeOf(2, 1));
        graphLibrary.addEdge(directEdgeOf(3, 2));
        graphLibrary.addEdge(directEdgeOf(4, 3));
        graphLibrary.addEdge(directEdgeOf(5, 4));
        graphLibrary.addEdge(directEdgeOf(6, 5));
        graphLibrary.addEdge(directEdgeOf(1, 6));

        List<Edge<Integer>> path = graphLibrary.getPath(1, 4);
        assertThat(path, Matchers.notNullValue());
        assertThat(path, Matchers.not(Matchers.empty()));
    }

    @Test
    void getPathUndirectedEdgesCircleSuccess() {
        graphLibrary.addEdge(edgeOf(1, 2));
        graphLibrary.addEdge(edgeOf(2, 3));
        graphLibrary.addEdge(edgeOf(3, 4));
        graphLibrary.addEdge(edgeOf(4, 5));
        graphLibrary.addEdge(edgeOf(5, 6));
        graphLibrary.addEdge(edgeOf(6, 1));

        List<Edge<Integer>> path = graphLibrary.getPath(1, 4);
        assertThat(path, Matchers.notNullValue());
        assertThat(path, Matchers.not(Matchers.empty()));
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
