package Grafo;

public class Vertice {
	String nombre;
	int numVertice;

	public Vertice(String s) {
		nombre = s;
		numVertice = -1;
	}

	// Retorna el nombre del vertice
	public String nomVertice() {
		return nombre;
	}

	// Compara el vertice actual con el recibido por parametro
	public boolean equals(Vertice v) {
		return nombre.equals(v.nombre);
	}

	// Asigna al numero de vertice el valor que recibe en el parameteo
	public void asigVert(int n) {
		numVertice = n;
	}
}