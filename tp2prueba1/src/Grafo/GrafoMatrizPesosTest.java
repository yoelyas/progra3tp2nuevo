package Grafo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;



public class GrafoMatrizPesosTest {
	
	
	
	@Test(expected = NegativeArraySizeException.class)
	public void verticeNegativoFailTest() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(-1);
		
	}
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void GetPesosFailTest() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(5);
		grafo.getPeso(-1, 0);
	}

	@Test
	public void testNuevoVertice() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(5);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		assertEquals(2, grafo.numeroDeVertices());
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void nuevoVerticeExsedidoTest() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(3);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoVertice("Perú");
		grafo.nuevoVertice("colombia");
	}
	@Test
	public void testPesoArco() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(5);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoArco("Argentina", "Chile", 4);
		assertEquals(4, grafo.pesoArco("Argentina", "Chile"));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void nuevoArcoInexistenteTest() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(3);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoArco("Argentina", "Perú", 1);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void nuevoArcoNegativoTest() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(3);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoArco("Argentina", "Perú", -1);
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
		grafo.nuevoArco("Argentina", "Uruguay", 2);
		grafo.nuevoArco("Chile", "Uruguay", 2);
		grafo.separarEnRegiones(2);
		grafo.separarEnRegiones(-3);
		assertFalse(grafo.existeArco("Argentina", "Chile"));
	}
	
	@Test
	public void testComponentesConexas() {
		GrafoMatrizPesos grafo = new GrafoMatrizPesos(4);
		grafo.nuevoVertice("Argentina");
		grafo.nuevoVertice("Chile");
		grafo.nuevoVertice("Uruguay");
		grafo.nuevoVertice("Perú");
		grafo.nuevoArco("Argentina", "Chile", 4);
		grafo.nuevoArco("Argentina", "Uruguay", 2);
		grafo.nuevoArco("Chile", "Uruguay", 2);
		ArrayList<ArrayList<String>> ret = new ArrayList<>();
		ArrayList<String> reguion1 = new ArrayList<>();
		ArrayList<String> reguion2 = new ArrayList<>();
		reguion1.add("Argentina");
		reguion1.add("Chile");
		reguion1.add("Uruguay");
		
		reguion2.add("Perú");
		ret.add(reguion1);
		ret.add(reguion2);

		assertEquals(ret, grafo.componentesConexas());
		
		
	}

}
