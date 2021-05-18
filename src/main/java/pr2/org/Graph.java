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
import java.util.*;

/**
 * Clase Graph que tiene los metodos que generan los vertices, annaden adyacentes y consiguen caminos entre vertices
 * @author Pablo Rivero
 * @version 21.2, 19/05/2021
 */
public class Graph<V> {

        //*Lista de adyacencia.
        private HashMap<V, Set<V>> adjacencyList = new HashMap<>();

        /*****************************************************************
        * Añade el vértice ‘v‘ al grafo.
        *
        * @param v vértice a añadir.
        * @return ‘true‘ si no estaba anteriormente y ‘false‘ en caso
        * contrario.
         * Complejidad espacial: (O)1
         * Complejidad temporal: (O)1
        *******************************************************************/
        public boolean addVertex(V v){
                if(!this.adjacencyList.containsKey(v)){
                        this.adjacencyList.put(v, new TreeSet<V>());
                        return true;
                } else {
                        return false;
                }
        }


        /******************************************************************
         * Añade un arco entre los vértices ‘v1‘ y ‘v2‘ al grafo.
         *
         * @param v1 el origen del arco.
         * @param v2 el destino del arco.
         * @return ‘true‘ si no existía el arco y ‘false‘ en caso
        contrario.
         * Complejidad espacial: (O)1
         * Complejidad temporal: (O)1
         ******************************************************************/
        public boolean addEdge(V v1, V v2) {
              Set<V> edges = adjacencyList.get(v1);
              if (edges.contains(v2)){
                      return false;
              } else{
                      edges.add(v2);
                      return true;
              }
        }
        /******************************************************************
         * Obtiene el conjunto de vértices adyacentes a ‘v‘.
         *
         * @param v vértice del que se obtienen los adyacentes.
         * @return conjunto de vértices adyacentes.
         * Complejidad espacial: (O)1
         * Complejidad temporal: (O)1
         ******************************************************************/
        public Set<V> obtainAdjacents(V v) throws Exception{
                if(this.adjacencyList.containsKey(v)){
                        return this.adjacencyList.get(v);
                }else {
                        throw new Exception("No existe el vertice del que quieres sacar los adyacentes.");
                }
        }

        /******************************************************************
         * Comprueba si el grafo contiene el vértice dado.
         *
         * @param v vértice para el que se realiza la comprobación.
         * @return ‘true‘ si ‘v‘ es un vértice del grafo.
         * Complejidad espacial: (O)1
         * Complejidad temporal: (O)1
         ******************************************************************/
        public boolean containsVertex(V v){
                if(this.adjacencyList.containsKey(v)) {
                        return true;
                } else {return false;}
        }

        /******************************************************************
         * Método ‘toString()‘ reescrito para la clase ‘Grafo.java‘.
         * @return una cadena de caracteres con la lista de adyacencia
        .
         *Complejidad espacial: (O)n
         * Complejidad temporal: (O)n
         ******************************************************************/


        @Override
        public String toString(){
                StringBuilder output = new StringBuilder();
                output.append("Vertex\t Edge\n");
                for (V vertices: this.adjacencyList.keySet()) {
                        output.append(vertices.toString());
                        output.append(adjacencyList.get(vertices).toString() + "\n");
                }
                return output.toString();
        }

        /******************************************************************
         * Obtiene, en caso de que exista, un camino entre ‘v1‘ y ‘v2
         ‘. En
         * caso contrario, devuelve ‘null‘.
         *
         * @param v1 el vértice origen.
         * @param v2 el vértice destino.
         * @return lista con la secuencia de vértices desde ‘v1‘ hasta
        ‘v2‘
         * pasando por arcos del grafo.
         * Complejidad espacial: (O)n
         * Complejidad temporal: (O)n^2
         ******************************************************************/
        public List<V> onePath(V v1, V v2) {
                List<V> traza = new ArrayList<>();
                Stack<V> abierta = new Stack<>();
                abierta.push(v1);
                boolean encontrado = false;
                while (!abierta.isEmpty() && !encontrado) {
                        V verticeVisitando =  abierta.pop();
                        traza.add(verticeVisitando);
                        if(verticeVisitando.equals(v2)){
                                encontrado = true;
                        } else {
                                for(V adjacentsVisit : this.adjacencyList.get(verticeVisitando)){
                                        abierta.push(adjacentsVisit);
                                }
                        }
                        if (encontrado) {
                                return traza;
                        }
                } return null;
        }
}

