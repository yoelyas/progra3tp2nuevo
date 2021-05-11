package AlgoritmoKruskal;

import static org.junit.Assert.*;

import org.junit.Test;

import Grafo.GrafoMatrizPesos;

public class AlgoritmoKruskalTest {
	
	@Test
	public void transoformarEnArbolTest() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(3);
		
		// Creamos los vertices
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Uruguay");
		grafo.nuevoVertice("Chile");
		
		// Unimos los vertices / crear aristas 
		grafo.nuevoArco("Argentina", "Uruguay", 1);
		grafo.nuevoArco("Argentina", "Chile", 3);
		grafo.nuevoArco("Uruguay", "Chile", 4);
		AlgoritmoKruskal instancia = new AlgoritmoKruskal(grafo, grafo.vertices());
		GrafoMatrizPesos arbol = instancia.transoformarEnArbol();
		
		assertFalse(arbol.existeArco("Uruguay", "Chile"));

	}

}
