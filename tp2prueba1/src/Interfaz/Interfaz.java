package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Grafo.GrafoMatrizPesos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import AlgoritmoKruskal.AlgoritmoKruskal;

public class Interfaz {

	private JFrame frame;
	private JTextField textFieldCantNodos;
	private JTextField textFieldNombreVertice;
	private GrafoMatrizPesos grafo;
	private int contadorNodos;
	private JTextField textFieldPrimerVertice;
	private JTextField textFieldSegundoVertice;
	private JTextField textFieldPesoArco;
	private JTable tableMatriz;
	private int cantNodos;
	private JTextField textFieldCantRegiones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void mostrarMatriz(int matriz[][], int n) {
		DefaultTableModel model = (DefaultTableModel) tableMatriz.getModel();
		model.setRowCount(n);
		model.setColumnCount(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matriz[i][j] == 0xFFFF) {
					tableMatriz.setValueAt(0, i, j);
				} else {
					tableMatriz.setValueAt(matriz[i][j], i, j);
				}
			}
		}
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 734, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblConfirmacionNodos = new JLabel("Listo \u2713");
		lblConfirmacionNodos.setForeground(Color.GREEN);
		lblConfirmacionNodos.setBounds(401, 11, 66, 14);
		frame.getContentPane().add(lblConfirmacionNodos);
		lblConfirmacionNodos.setVisible(false);

		JLabel lblFaltan = new JLabel("");
		lblFaltan.setBounds(462, 36, 46, 14);
		frame.getContentPane().add(lblFaltan);

		JLabel lblIngreseCantNodos = new JLabel("Ingrese cantidad de nodos:");
		lblIngreseCantNodos.setBounds(22, 11, 255, 14);
		frame.getContentPane().add(lblIngreseCantNodos);

		textFieldCantNodos = new JTextField();
		textFieldCantNodos.setBounds(196, 8, 86, 20);
		frame.getContentPane().add(textFieldCantNodos);
		textFieldCantNodos.setColumns(10);

		JButton btnListo = new JButton("Listo");
		btnListo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantNodos = Integer.parseInt(textFieldCantNodos.getText());
				grafo = new GrafoMatrizPesos(cantNodos);
				contadorNodos = cantNodos;

				textFieldCantNodos.setFocusable(false);
				btnListo.setEnabled(false);
				lblConfirmacionNodos.setVisible(true);
			}
		});
		btnListo.setBounds(287, 7, 89, 23);
		frame.getContentPane().add(btnListo);

		JButton btnAgregarVertice = new JButton("Agregar vertice");

		btnAgregarVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				grafo.nuevoVertice(textFieldNombreVertice.getText());
				textFieldNombreVertice.setText("");
				contadorNodos--;
				lblFaltan.setText("Faltan " + contadorNodos);

				if (contadorNodos == 0) {
					lblFaltan.setText("Listo \u2713");
					lblFaltan.setForeground(Color.GREEN);
					textFieldNombreVertice.setFocusable(false);
					btnAgregarVertice.setEnabled(false);
				}
			}
		});
		btnAgregarVertice.setBounds(287, 35, 149, 23);
		frame.getContentPane().add(btnAgregarVertice);

		textFieldNombreVertice = new JTextField();
		textFieldNombreVertice.setBounds(191, 36, 86, 20);
		frame.getContentPane().add(textFieldNombreVertice);
		textFieldNombreVertice.setColumns(10);

		JLabel lblNombreVertice = new JLabel("Ingrese nombre de vertice:");
		lblNombreVertice.setBounds(10, 36, 164, 14);
		frame.getContentPane().add(lblNombreVertice);

		JLabel lblPrimerVertice = new JLabel("Ingrese primer vertice:");
		lblPrimerVertice.setBounds(10, 101, 174, 14);
		frame.getContentPane().add(lblPrimerVertice);

		textFieldPrimerVertice = new JTextField();
		textFieldPrimerVertice.setBounds(191, 98, 86, 20);
		frame.getContentPane().add(textFieldPrimerVertice);
		textFieldPrimerVertice.setColumns(10);

		JLabel lblCrearArcos = new JLabel("Crear arcos:");
		lblCrearArcos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCrearArcos.setBounds(10, 76, 190, 14);
		frame.getContentPane().add(lblCrearArcos);

		JLabel lblSegundoVertice = new JLabel("Ingrese segundo vertice:");
		lblSegundoVertice.setBounds(10, 125, 164, 14);
		frame.getContentPane().add(lblSegundoVertice);

		textFieldSegundoVertice = new JTextField();
		textFieldSegundoVertice.setBounds(191, 122, 86, 20);
		frame.getContentPane().add(textFieldSegundoVertice);
		textFieldSegundoVertice.setColumns(10);

		JLabel lblIngresePeso = new JLabel("Ingrese peso del arco:");
		lblIngresePeso.setBounds(10, 150, 149, 14);
		frame.getContentPane().add(lblIngresePeso);

		textFieldPesoArco = new JTextField();
		textFieldPesoArco.setBounds(191, 147, 86, 20);
		frame.getContentPane().add(textFieldPesoArco);
		textFieldPesoArco.setColumns(10);

		JButton btnCrearArco = new JButton("Crear arco");
		btnCrearArco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				grafo.nuevoArco(textFieldPrimerVertice.getText(), textFieldSegundoVertice.getText(),
						Integer.parseInt(textFieldPesoArco.getText()));
				textFieldPrimerVertice.setText("");
				textFieldSegundoVertice.setText("");
				textFieldPesoArco.setText("");
			}
		});
		btnCrearArco.setBounds(306, 121, 151, 23);
		frame.getContentPane().add(btnCrearArco);

		JButton btnMostrarMatriz = new JButton("Mostrar Matriz");
		btnMostrarMatriz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarMatriz(grafo.getMatPeso(), cantNodos);
			}
		});
		btnMostrarMatriz.setBounds(20, 175, 149, 23);
		frame.getContentPane().add(btnMostrarMatriz);

		tableMatriz = new JTable();
		tableMatriz.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		tableMatriz.setBounds(10, 206, 698, 211);
		frame.getContentPane().add(tableMatriz);

		JButton btnTransformarEnArbol = new JButton("Transformar en arbol");
		btnTransformarEnArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlgoritmoKruskal instancia = new AlgoritmoKruskal(grafo, grafo.vertices());
				grafo = instancia.transformarEnArbol();
				mostrarMatriz(grafo.getMatPeso(), cantNodos);
				btnTransformarEnArbol.setEnabled(false);
			}
		});
		btnTransformarEnArbol.setBounds(10, 428, 164, 23);
		frame.getContentPane().add(btnTransformarEnArbol);

		JLabel lblSepararEnRegiones = new JLabel("Ingrese numero de regiones:");
		lblSepararEnRegiones.setBounds(10, 462, 164, 14);
		frame.getContentPane().add(lblSepararEnRegiones);

		textFieldCantRegiones = new JTextField();
		textFieldCantRegiones.setBounds(185, 459, 66, 20);
		frame.getContentPane().add(textFieldCantRegiones);
		textFieldCantRegiones.setColumns(10);

		JLabel lblRegionesFormadas = new JLabel("Regiones formadas:");
		lblRegionesFormadas.setBounds(374, 462, 134, 14);
		frame.getContentPane().add(lblRegionesFormadas);

		JLabel lblRegiones = new JLabel("");
		lblRegiones.setBounds(503, 462, 215, 14);
		frame.getContentPane().add(lblRegiones);

		JButton btnSepararEnRegiones = new JButton("Separar");
		btnSepararEnRegiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				grafo.separarEnRegiones(Integer.parseInt(textFieldCantRegiones.getText()));
				mostrarMatriz(grafo.getMatPeso(), cantNodos);
				lblRegiones.setText(grafo.componentesConexas().toString());
				btnSepararEnRegiones.setEnabled(false);
			}
		});
		btnSepararEnRegiones.setBounds(261, 458, 89, 23);
		frame.getContentPane().add(btnSepararEnRegiones);

	}
}
