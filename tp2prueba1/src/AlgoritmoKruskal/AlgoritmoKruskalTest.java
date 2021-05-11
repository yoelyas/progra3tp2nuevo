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
		
		GrafoMatrizPesos grafo2 = new GrafoMatrizPesos(3);
		
		grafo2.nuevoVertice("Argentina");
		grafo2.nuevoVertice("Uruguay");
		grafo2.nuevoVertice("Chile");
		
		// Unimos los vertices / crear aristas 
		grafo2.nuevoArco("Argentina", "Uruguay", 1);
		grafo2.nuevoArco("Argentina", "Chile", 3);
		
		assertTrue(esArbol(arbol, grafo2));
		
		

	}
	private Boolean esArbol(GrafoMatrizPesos grafo, GrafoMatrizPesos grafo2) {
		if(grafo.numeroDeVertices() != grafo2.numeroDeVertices()) {
			return false;
		}
		for (int i = 0; i < grafo.numeroDeVertices() ; i++) {
					
			for (int j = 0; j < grafo.numeroDeVertices() ; j++) {
				
				if(grafo.getPeso(i, j) != grafo2.getPeso(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

}
