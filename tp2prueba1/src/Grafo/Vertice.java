package Grafo;

public class Vertice {
	private String nombre;
	private int numVertice;

	public Vertice(String s) {
		nombre = s;
		numVertice = -1;
	}

	// Retorna el nombre del vertice
	public String nomVertice() {
		return getNombre();
	}

	// Compara el vertice actual con el recibido por parametro
	public boolean equals(Vertice v) {
		return getNombre().equals(v.getNombre());
	}

	// Asigna al numero de vertice el valor que recibe en el parameteo
	public void asigVert(int n) {
		numVertice = n;
	}
	
	public int getNum() {
		return numVertice;
	}

	public String getNombre() {
		return nombre;
	}
}