package pr2.org;


import java.util.*;

public class Graph<V> {

        //*Lista de adyacencia.
        private HashMap<V, Set<V>> adjacencyList = new HashMap<>();

        /*****************************************************************
        * Añade el vértice ‘v‘ al grafo.
        *
        * @param v vértice a añadir.
        * @return ‘true‘ si no estaba anteriormente y ‘false‘ en caso
        * contrario.
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
         ******************************************************************/
        public boolean addEdge(V v1, V v2) {
              Set<V> edges = adjacencyList.get(v1);
              if (edges.contains(v2)){
                      return false;
              } else{
                      edges.add(v2);
                      edges = adjacencyList.get(v2);
                      edges.add(v1);
                      return true;
              }
        }
        /******************************************************************
         * Obtiene el conjunto de vértices adyacentes a ‘v‘.
         *
         * @param v vértice del que se obtienen los adyacentes.
         * @return conjunto de vértices adyacentes.
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
         ******************************************************************/
        public List<V> onePath(V v1, V v2) {
                List<V> traza = new ArrayList<>();
                List<V> visitados = new ArrayList<>();
                Stack<V> abierta = new Stack<>();
                abierta.push(v1);
                traza.add(v1);
                visitados.add(v1);
                boolean encontrado = false;

                while (!abierta.isEmpty() && !encontrado) {
                        V verticeVisitando =  abierta.pop();

                        for(V adjacents : adjacencyList.get(verticeVisitando)) {
                                visitados.add(verticeVisitando);
                                if (verticeVisitando == v2) {
                                        encontrado = true;
                                } else {
                                        for (V annadirAdyacentes : adjacencyList.get(verticeVisitando)) {
                                                traza.add(verticeVisitando);
                                                visitados.add(annadirAdyacentes);
                                                abierta.push(annadirAdyacentes);
                                        }
                                }

                                if (visitados.contains(verticeVisitando)) {
                                        traza.remove(verticeVisitando);
                                }
                        }
                }

                if (encontrado) {
                        return traza;
                } else {
                        return abierta;
                }
        }


}

