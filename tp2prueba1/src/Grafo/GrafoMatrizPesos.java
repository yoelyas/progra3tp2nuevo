package Grafo;

public class GrafoMatrizPesos {
	public static int valorMax = 0xFFFF;
	private int[][] matPesos;
	private Vertice[] vertices;
	private int numVerts;

	public GrafoMatrizPesos(int tama�o) {
		matPesos = new int[tama�o][tama�o];
		vertices = new Vertice[tama�o];
		for (int i = 0; i < tama�o; i++)
			for (int j = 0; j < tama�o; j++)
				matPesos[i][j] = valorMax;
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

	// Retorna el valor del peso entre las aristas
	public int pesoArco(String a, String b) {
		int numA;
		int numB;
		numA = numVertice(a);
		numB = numVertice(b);
		return matPesos[numA][numB];
	}

	// retorna el numero de vertices
	public int numeroDeVertices() {
		return numVerts;
	}

	// retorna el arreglo de vertices
	public Vertice[] vertices() {
		return vertices;
	}

	// crea un nuevo arco entre 2 vertices con un peso recibido por parametro
	public void nuevoArco(String a, String b, int peso) {
		int numA;
		int numB;
		numA = numVertice(a);
		numB = numVertice(b);
		matPesos[numA][numB] = peso;
		matPesos[numB][numA] = peso;
	}

	// valida que exista el vertices con el nombre que recibe en el parametro y lo retorna
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

	public void quitarElementoMasGrande() {
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
					return;
				}

			}
		}

	}
	public void separarEnRegiones(int n) {
		for(int i = 0; i < n-1; i++)
			quitarElementoMasGrande();
		
	}
}
