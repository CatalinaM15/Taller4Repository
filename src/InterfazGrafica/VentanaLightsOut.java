package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class VentanaLightsOut extends JFrame {
	private static final long serialVersionUID = 1L;
	private int Size = 5;
	private int Dificultad = 2;
	private String NombreJugador = "";
	private PanelInformacionAbajo panelAbajo;
	private PanelBotones panelDerecha;
	private PanelConfiguracion panelArriba;
	boolean[][] matrix;
	private PanelJuego panelCentro;
	private Tablero modelo;
	private Top10 top = new Top10();
	private static File archivo;

	/**
	 * La cantidad de tarjetas en el tablero a lo ancho y a lo alto
	 */

	public VentanaLightsOut() {

		// Crear mundo

		nuevomundo();
		// Crea paneles
		panelAbajo = new PanelInformacionAbajo(NombreJugador);
		panelDerecha = new PanelBotones(this);
		panelCentro = new PanelJuego(matrix, this);
		panelArriba = new PanelConfiguracion();
		// Colores usados

		Color AirForceBlue = new Color(93, 138, 168);
		Color Platinum = new Color(229, 228, 226);
		// configurar paneles.

		panelCentro.setBackground(Platinum);
		panelCentro.setOpaque(true);

		add(panelCentro, BorderLayout.CENTER); // conteneder agregue este elemento

		panelArriba.setBackground(AirForceBlue);
		panelArriba.setOpaque(true);
		add(panelArriba, BorderLayout.NORTH);// conteneder agregue este elemento

		panelDerecha.setBackground(Color.GRAY);
		panelDerecha.setOpaque(true);
		add(panelDerecha, BorderLayout.EAST);// conteneder agregue este elemento

		panelAbajo.setBackground(Platinum);
		panelAbajo.setOpaque(true);
		add(panelAbajo, BorderLayout.SOUTH);// conteneder agregue este elemento

		// configuracion ventana
		setSize(900, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("LightsOut");
		setResizable(false);
		setLocationRelativeTo(null);

	}

	public void nuevomundo() {
		modelo = new Tablero(Size);
		modelo.desordenar(Dificultad);
		matrix = modelo.darTablero();

	}

//
	public void jugar(int fila, int columna) {
		modelo.jugar(fila, columna);
		panelCentro.actualizar(modelo.darTablero());
		panelAbajo.NumeroJugadas();
		boolean finJuego = modelo.tableroIluminado();

		if (finJuego) {
			int jugadas = modelo.darJugadas();
			actualizarTop10();
			JOptionPane.showMessageDialog(this, "¡Ganaste en " + jugadas + " jugadas!", "Fin del juego",
					JOptionPane.INFORMATION_MESSAGE);
			int reiniciar = JOptionPane.showConfirmDialog(this, "¿Quieres iniciar un nuevo juego?", "Reiniciar",
					JOptionPane.YES_NO_OPTION);

			if (reiniciar == JOptionPane.YES_OPTION) {
				nuevomundo();
				panelCentro.actualizar(matrix);
				panelAbajo.reiniciar();

			}
		}

	}

	public void actualizar_NombreJugador(String newName) {
		NombreJugador = newName;
		panelAbajo.actualizar_NombreJugador(newName);

	}

	public void ConfiguracionaPanel() {
		Dificultad = leerConfigDificultad();
		Size = leerConfigSize();
		nuevomundo();
		panelCentro.actualizar(matrix);
		panelAbajo.reiniciar();
	}

	public void reinicio() {
		modelo.reiniciar();
		panelCentro.actualizar(matrix);
		panelAbajo.reiniciar();
	}

	public int leerConfigDificultad() {
		String Dificultad = panelArriba.getSelectedDifficulty();
		int nivel = 0;
		if (Dificultad.equals("Fácil")) {
			nivel = 2;
		} else if (Dificultad.equals("Medio")) {
			nivel = 5;
		} else if (Dificultad.equals("Difícil")) {
			nivel = 7;
		}
		return nivel;
	}

	public int leerConfigSize() {
		String Size = panelArriba.getSelectedSize();

		String[] SizeFormat = Size.split("x");
		int Sizes = Integer.parseInt(SizeFormat[0]);
		return Sizes;
	}

	public void MostrarTop10() {
		VentanaTop10 VentanaEmergente = new VentanaTop10(this);
		VentanaEmergente.setVisible(true);
		VentanaEmergente.setSize(350, 300);
		VentanaEmergente.setTitle("TOP10");
		VentanaEmergente.setResizable(false);
		VentanaEmergente.setLocationRelativeTo(null);

	}

	public Collection<RegistroTop10> darRegistros() {
		Collection<RegistroTop10> collection = top.darRegistros();
		return collection;
	}


	public void actualizarTop10() {
		int puntaje = modelo.calcularPuntaje();
		if (top.esTop10(puntaje)) {
			top.agregarRegistro(NombreJugador, puntaje);
		}

	}

	public void inicializa() {

		String Nombre = JOptionPane.showInputDialog(this, "¿Cual es su nombre?", "Seleccion Usuario",
				JOptionPane.QUESTION_MESSAGE);
		actualizar_NombreJugador(Nombre);
		JFileChooser fc = new JFileChooser("./data");
		int resultado = fc.showOpenDialog(this);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			archivo = fc.getSelectedFile();
		}

		top.cargarRecords(archivo);

	}

	public void finalizar() throws FileNotFoundException, UnsupportedEncodingException {
		actualizarTop10();
		top.salvarRecords(archivo);

	}

	public static void main(String[] args) {

		VentanaLightsOut ventana = new VentanaLightsOut();
		ventana.inicializa();
//		FlatLightLaf.install();
	}

}
