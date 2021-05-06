package AlgoritmoKruskal;

import Grafo.GrafoMatrizPesos;


public class Main_Kruskal {
	public static void main(String[] args) {
		
		// Numero de vertices
		int n = 6;

		GrafoMatrizPesos grafo = new GrafoMatrizPesos(n);
		
		// Creamos los vertices
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Uruguay");
		grafo.nuevoVertice("Chile");
		grafo.nuevoVertice("Paraguay");
		grafo.nuevoVertice("Brasil");
		grafo.nuevoVertice("Bolivia");
		
		// Unimos los vertices / crear aristas 
		grafo.nuevoArco("Argentina", "Uruguay", 1);
		grafo.nuevoArco("Argentina", "Brasil", 2);
		grafo.nuevoArco("Argentina", "Paraguay", 5);
		grafo.nuevoArco("Argentina", "Bolivia", 10);
		grafo.nuevoArco("Argentina", "Chile", 3);
		grafo.nuevoArco("Uruguay", "Brasil", 3);
		grafo.nuevoArco("Uruguay", "Paraguay", 6);
		grafo.nuevoArco("Brasil", "Paraguay", 2);
		grafo.nuevoArco("Bolivia", "Paraguay", 5);
		grafo.nuevoArco("Bolivia", "Chile", 7);
		System.out.println("peso entre arg y chile " + grafo.pesoArco("Argentina", "Chile"));

		grafo.mostrarMatriz(); //grafo original

		AlgoritmoKruskal instancia = new AlgoritmoKruskal(grafo, grafo.vertices());
		GrafoMatrizPesos arbol = instancia.transoformarEnArbol();

		arbol.mostrarMatriz(); //grafo convertido en arbol generador minimo
		
		arbol.separarEnRegiones(3); //cantidad de regiones en las que quiero separar el grafo
		
		arbol.mostrarMatriz(); //grafo separado en regiones
	}
}
