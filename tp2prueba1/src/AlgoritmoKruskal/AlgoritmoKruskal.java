package AlgoritmoKruskal;

import Grafo.Vertice;

import Grafo.GrafoMatrizPesos;

public class AlgoritmoKruskal {
	static int valorMax = 0xFFFF;
	private int[][] matriz;
	private int num_vertices;
	private int padres[];
	// vertice origen y numero de vertices
	private Vertice[] vertices;
	private Vertice[] verticesHeredadas;

	public AlgoritmoKruskal(GrafoMatrizPesos gp, Vertice[] verts) {
		this.num_vertices = gp.numeroDeVertices();
		this.matriz = gp.getMatPeso();
		this.vertices = verts;
		this.verticesHeredadas = gp.vertices();
		padres = new int[this.num_vertices + 1];
	}

	public GrafoMatrizPesos transformarEnArbol() {
		int i = 0, j = 0, ne = 1, minimo = 0, a = 0, u = 0, b = 0, v = 0, minimo_costo = 0;
		GrafoMatrizPesos arbol = new GrafoMatrizPesos(num_vertices);
		for (Vertice v1 : verticesHeredadas) {
			arbol.nuevoVertice(v1.nomVertice());
		}
		while (ne < num_vertices) {
			for (i = 1, minimo = valorMax; i <= num_vertices; i++) {
				for (j = 1; j <= num_vertices; j++) {
					if (matriz[i - 1][j - 1] < minimo) {
						minimo = matriz[i - 1][j - 1];
						a = u = i;
						b = v = j;
					}
				}
			}
			u = find(u);
			v = find(v);
			if (union(u, v) > 0) {
				ne++;
				arbol.nuevoArco(this.vertices[a - 1].nomVertice(), this.vertices[b - 1].nomVertice(), minimo);

				minimo_costo = minimo_costo + minimo;
			}
			matriz[a - 1][b - 1] = matriz[b - 1][a - 1] = valorMax;
		}

		return arbol;
	}

	private int find(int i) {
		while (padres[i] > 0) {
			i = padres[i];
		}
		return i;

	}

	private int union(int i, int j) {
		if (i != j) {
			padres[j] = i;
			return 1;
		}
		return 0;
	}

}