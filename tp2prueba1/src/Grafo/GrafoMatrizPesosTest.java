package Grafo;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrafoMatrizPesosTest {

	@Test
	public void testNuevoVertice() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(5);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		assertEquals(2, grafo.numeroDeVertices());
	}
	@Test
	public void testPesoArco() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(5);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoArco("Argentina", "Chile", 4);
		assertEquals(4, grafo.pesoArco("Argentina", "Chile"));
	}
	@Test
	public void testExisteArco() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(5);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoVertice("Uruguay");
		grafo.nuevoArco("Argentina", "Chile", 4);
		assertTrue(grafo.existeArco("Argentina", "Chile"));
		assertFalse(grafo.existeArco("Argentina", "Uruguay"));
	}	

	@Test
	public void testNumVertice() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(5);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoVertice("Uruguay");
		assertEquals(2,grafo.numVertice("Uruguay"));
	}

	@Test
	public void testQuitarAristaMasGrande() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(3);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoVertice("Uruguay");
		grafo.nuevoArco("Argentina", "Chile", 4);
		grafo.nuevoArco("Argentina", "Uruguay", 2);
		grafo.nuevoArco("Chile", "Uruguay", 2);
		grafo.quitarAristaMasGrande();
		
		GrafoMatrizPesos grafo2 = new GrafoMatrizPesos(3);
		grafo2.nuevoVertice("Argentina");
		grafo2.nuevoVertice("Chile");
		grafo2.nuevoVertice("Uruguay");
		grafo2.nuevoArco("Argentina", "Uruguay", 2);
		grafo2.nuevoArco("Chile", "Uruguay", 2);
		assertEquals(grafo2.getMatPeso(),grafo.getMatPeso());
	}

	@Test
	public void testSepararEnRegiones() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(3);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoVertice("Uruguay");
		grafo.nuevoArco("Argentina", "Chile", 4);
		grafo.separarEnRegiones(0);
		assertTrue(grafo.existeArco("Argentina", "Chile"));
		
		
	}

}
