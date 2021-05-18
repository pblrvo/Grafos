/*
Copyright [2021] [Pablo Rivero]
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing,
software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
implied.
See the License for the specific language governing permissions
and
limitations under the License.
 */
package pr2.org;

import org.junit.Test;

import org.junit.Before;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Clase GraphTest que contiene una serie de Test que garantizan el funcionamiento optimo del programa
 * @author Pablo Rivero
 * @version 21.2, 19/05/2021
 */
public class GraphTest
{

    private Graph<Integer> graphInts;

    @Before
    public void setUp(){
        this.graphInts = new Graph<>();
    }

    /**
     * Este test comprueba que el registro creado existe
     */
    @Test
    public void registroExistsObject() {
        assertNotNull(this.graphInts);
    }

    /**
     * Este test comprueba que el método 'addVertex(V v)'
     * annade un vertice y cumple con la estructura del toString().
     */
    @Test
    public void addingVertexOk(){
        String expectedOutput = "Vertex\t Edge\n";
        boolean resultado = this.graphInts.addVertex(1);
        assertTrue(resultado);
        assertEquals(expectedOutput + "1[]\n" , graphInts.toString());
    }

    /**
     * Este test comprueba que el método ‘addVertex(V v)'
     * no permite annadir dos vertices con el mismo valor.
     */
    @Test
    public void addingVertexFail(){
        boolean resultado1 = this.graphInts.addVertex(1);
        boolean resultado2 = this.graphInts.addVertex(1);
        assertTrue(resultado1);
        assertFalse(resultado2);
    }

    /**
     * Este test comprueba que el método ‘addEdge(V v1, V v2)'
     * annade un adyacente a un vertice y cumple con la
     * estructura del metodo toString.
     */
    @Test
    public void addingEdgeOk(){
        String expectedOutput = "Vertex\t Edge\n";
        this.graphInts.addVertex(1);
        this.graphInts.addVertex(2);
        boolean resultado = this.graphInts.addEdge(1, 2);
        assertTrue(resultado);
        assertEquals(expectedOutput
                + "1[2]\n"
                + "2[]\n", graphInts.toString());
    }

    /**
     * Este test comprueba que el método ‘addEdge(V v1, V v2)'
     * no permita annadir dos adyacentes con los mismos valores.
     */
    @Test
    public void addingEdgeFail(){
        this.graphInts.addVertex(1);
        this.graphInts.addVertex(2);
        boolean resultado = this.graphInts.addEdge(1, 2);
        boolean resultado2 = this.graphInts.addEdge(1, 2);
        assertTrue(resultado);
        assertFalse(resultado2);
    }


    /**
     * Este test comprueba que el método ‘obtainAdjacents(V v1, V v2)'
     * devuelva el adyacente del vertice.
     */
    @Test
    public void obtainAdjacentsOk() throws Exception {
        this.graphInts.addVertex(1);
        this.graphInts.addVertex(2);
        this.graphInts.addVertex(3);
        boolean resultado = this.graphInts.addEdge(1, 2);
        boolean resultado3 = this.graphInts.addEdge(1, 3);
        this.graphInts.obtainAdjacents(1);
        assertTrue(this.graphInts.obtainAdjacents(1).contains(2));
        assertTrue(this.graphInts.obtainAdjacents(1).contains(3));
    }

    /**
     * Este test comprueba que el método ‘obtainAdjacents(V v1, V v2)'
     * no devuelva adyacentes no creados.
     */
    @Test(expected = Exception.class)
    public void obtainAdjacentsFail() throws Exception {
        this.graphInts.obtainAdjacents(1);

    }

    /**
     * Este test comprueba que el método ‘containsVertex(V v)'
     * devuelve el vertice creado.
     */
    @Test
    public void containsVertexOk(){
        this.graphInts.addVertex(1);
        assertTrue(this.graphInts.containsVertex(1));
    }

    @Test
    public void containsVertexFail(){
        assertFalse(this.graphInts.containsVertex(1));
    }


    /**
     * Este test comprueba que el método ‘onePath(V v1, V v2)‘
     * encuentra un camino entre ‘v1‘ y ‘v2‘ cuando existe.
     */
    @Test
    public void onePathFindsAPath(){
        System.out.println("\nTest onePathFindsAPath");
        System.out.println("----------------------");


        // Se construye el grafo.
        Graph<Integer> g = new Graph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
// Se construye el camino esperado.
        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4);
//Se comprueba si el camino devuelto es igual al esperado.
        assertEquals(expectedPath, g.onePath(1, 4));
    }
}
