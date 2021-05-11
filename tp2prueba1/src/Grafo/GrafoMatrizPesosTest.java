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
	public void testQuitarElementoMasGrande() {
		fail("Not yet implemented");
	}

	@Test
	public void testSepararEnRegiones() {
		fail("Not yet implemented");
	}

	@Test
	public void testComponentesConexas() {
		fail("Not yet implemented");
	}

}
