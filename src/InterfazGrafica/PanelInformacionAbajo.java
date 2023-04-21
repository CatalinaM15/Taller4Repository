package InterfazGrafica;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInformacionAbajo extends JPanel {
	private static final long serialVersionUID = 1L;
	String NombreJugador = "";
	int NumeroJugadas = 0;
	JTextField NJugadas;
	JTextField NameJugador;

	public PanelInformacionAbajo(String NombreJugador) {
		this.NombreJugador = NombreJugador;
		// Colores usados
		Color Platinum = new Color(229, 228, 226);
		Color Silver = new Color(192, 192, 192);

		// nombre de Jugador
		setLayout(new GridLayout(1, 4, 0, 0));
		JLabel Jugador = new JLabel("  Jugador:");
		Jugador.setBorder(BorderFactory.createLineBorder(Silver));
		NameJugador = new JTextField(NombreJugador);
		NameJugador.setEditable(false);
		NameJugador.setBorder(BorderFactory.createLineBorder(Silver));
		NameJugador.setBackground(Platinum);

		// JUGADAS
		JLabel Jugadas = new JLabel("  Juagadas:");
		Jugadas.setBorder(BorderFactory.createLineBorder(Silver));
		NJugadas = new JTextField(Integer.toString(NumeroJugadas));
		NJugadas.setEditable(false);
		NJugadas.setBorder(BorderFactory.createLineBorder(Silver));
		NJugadas.setBackground(Platinum);

		// agregar elementos
		add(Jugador);
		add(NameJugador);
		add(Jugadas);
		add(NJugadas);
	}

	public void actualizar_NombreJugador(String newName) {
		NombreJugador = newName;

		NameJugador.setText(newName);
		revalidate();
		repaint();
	}
	public void NumeroJugadas() {
		NumeroJugadas += 1;

		NJugadas.setText(Integer.toString(NumeroJugadas));
		revalidate();
		repaint();
	}
	public void reiniciar() {
		NumeroJugadas =0;

		NJugadas.setText(Integer.toString(NumeroJugadas));
		revalidate();
		repaint();
	}
}
