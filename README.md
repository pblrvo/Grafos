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
# Grafos:

##Definicion de grafos:
###Representación simbólica de los elementos constituidos de un sistema o conjunto, mediante esquemas gráficos.

## En que consiste el programa?
###El programa consiste en agregar una serie de vertices junto con sus conexiones(o adyacentes) para crear un sistema. Luego se puede conseguir caminos entre un vertice y otro si este existe.

##Funcionalidad:
###El programa esta disennado en Maven, haciendo uso de TDD.

### Para agregar vertices se utiliza el metodo addVertex y luego se utiliza addEdge para agregar sus adyacentes correspondientes

###Luego de haber creado un grafo, se utiliza el metodo onePath() para conseguir caminos entre vertices.

