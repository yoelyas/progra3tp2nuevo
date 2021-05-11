package Grafo;

import java.util.ArrayList;

public class GrafoMatrizPesos {
	public static int valorMax = 0xFFFF;
	private int[][] matPesos;
	private boolean[][] matAdyacencia;
	private Vertice[] vertices;
	private int numVerts;

	public GrafoMatrizPesos(int tamaño) {
		matPesos = new int[tamaño][tamaño];
		matAdyacencia = new boolean[tamaño][tamaño];
		vertices = new Vertice[tamaño];
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tamaño; j++) {
				matPesos[i][j] = valorMax;
				matAdyacencia[i][j] = false;
			}
		}
		numVerts = 0;
	}

	// Crea un nuevo vertice recibiendo su nombre de parametro (nombre provincias)
	public void nuevoVertice(String nom) {
		// Chequea que ese vertice no exista
		boolean existe = numVertice(nom) >= 0;

		// Crea el vertices si no existe
		if (!existe) {
			Vertice v = new Vertice(nom);
			v.asigVert(numVerts); // Le asigna su numero de vertice
			vertices[numVerts++] = v; // Lo coloca en la posicion que le corresponde en el arreglo de vertices
		}
	}

	// crea un nuevo arco entre 2 vertices con un peso recibido por parametro
	public void nuevoArco(String a, String b, int peso) {
		int numA;
		int numB;
		numA = numVertice(a);
		numB = numVertice(b);
		matPesos[numA][numB] = peso;
		matPesos[numB][numA] = peso;
		matAdyacencia[numA][numB] = true;
		matAdyacencia[numB][numA] = true;
	}

	// Retorna el valor del peso entre las aristas
	public int pesoArco(String a, String b) {
		int numA;
		int numB;
		numA = numVertice(a);
		numB = numVertice(b);
		return matPesos[numA][numB];
	}

	public boolean existeArco(String a, String b) {
		int numA;
		int numB;
		numA = numVertice(a);
		numB = numVertice(b);
		return matAdyacencia[numA][numB];
	}

	// retorna el numero de vertices
	public int numeroDeVertices() {
		return numVerts;
	}

	// retorna el arreglo de vertices
	public Vertice[] vertices() {
		return vertices;
	}

	// valida que exista el vertices con el nombre que recibe en el parametro y lo
	// retorna
	public int numVertice(String vs) {
		Vertice v = new Vertice(vs);
		boolean encontrado = false;
		int i = 0;
		for (; (i < numVerts) && !encontrado;) {
			encontrado = vertices[i].equals(v);
			if (!encontrado)
				i++;
		}
		return (i < numVerts) ? i : -1;
	}

	public int[][] getMatPeso() {
		return matPesos;
	}

	// borrar mas adelante
	public void mostrarMatriz() {
		for (int i = 0; i < matPesos.length; i++) {
			for (int j = 0; j < matPesos.length; j++) {
				if (matPesos[i][j] == valorMax)
					System.out.print(0 + " ");
				else
					System.out.print(matPesos[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public void quitarAristaMasGrande() {
		int mayorPeso = 0;
		for (int i = 0; i < matPesos.length; i++) {
			for (int j = 0; j < matPesos.length; j++) {
				if (matPesos[i][j] > mayorPeso && matPesos[i][j] != valorMax) {
					mayorPeso = matPesos[i][j];
				}
			}
		}
		for (int i = 0; i < matPesos.length; i++) {
			for (int j = 0; j < matPesos.length; j++) {
				if (matPesos[i][j] == mayorPeso) {
					matPesos[i][j] = valorMax;
					matPesos[j][i] = valorMax;
					matAdyacencia[i][j] = false;
					matAdyacencia[j][i] = false;
					return;
				}

			}
		}

	}

	public void separarEnRegiones(int n) {
		for (int i = 0; i < n - 1; i++)
			quitarAristaMasGrande();

	}

	private void DFS(int vertice, boolean[] visitados, ArrayList<Integer> region) {
		if (!visitados[vertice]) {
			region.add(vertice);
			visitados[vertice] = true;

			for (int i = 0; i < this.matAdyacencia[1].length; i++) {
				if (this.matAdyacencia[vertice][i]) {
					DFS(i, visitados, region);
				}
			}
		}
	}

	public ArrayList<ArrayList<String>> componentesConexas() {
		boolean[] visitados = new boolean[this.matAdyacencia.length];
		ArrayList<ArrayList<String>> ret = new ArrayList<>();
		for (int i = 0; i < this.matAdyacencia.length; i++) {
			ArrayList<Integer> region = new ArrayList<>();
			if (!visitados[i]) {
				DFS(i, visitados, region);
				ArrayList<String> regionPorNombre = new ArrayList<>();
				for (Integer indiceProvincia : region)
					regionPorNombre.add(vertices[indiceProvincia].getNombre());
				ret.add(regionPorNombre);

			}
		}
		return ret;
	}
}
