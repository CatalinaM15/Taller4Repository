package InterfazGrafica;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelConfiguracion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> SeleccionSize = null;
	private JRadioButton SeleccionFacil;
	private JRadioButton SeleccionMedio;
	private JRadioButton SeleccionDificil;

	public PanelConfiguracion() {

		// Opciones de tamaños

		String[] Sizes = { "5x5", "6x6", "7x7", "8x8", "9x9", "10x10" };

		JLabel Size = new JLabel("Tamaño:");
		Size.setForeground(Color.WHITE);
		Size.setFont(new Font("Dialog", Font.BOLD, 14));

		JLabel Dificultad = new JLabel("Dificultad: ");
		Dificultad.setForeground(Color.WHITE);
		Dificultad.setFont(new Font("Dialog", Font.BOLD, 14));

		SeleccionFacil = new JRadioButton("Fácil");
		SeleccionFacil.setForeground(Color.WHITE);

		SeleccionMedio = new JRadioButton("Medio");
		SeleccionMedio.setForeground(Color.WHITE);

		SeleccionDificil = new JRadioButton("Difícil");
		SeleccionDificil.setForeground(Color.WHITE);

		SeleccionSize = new JComboBox<String>(Sizes);
		add(Size);

		add(SeleccionSize);
		add(Dificultad);
		ButtonGroup grupoDificultad = new ButtonGroup();
		grupoDificultad.add(SeleccionFacil);
		grupoDificultad.add(SeleccionMedio);
		grupoDificultad.add(SeleccionDificil);
		SeleccionFacil.setSelected(true);

		add(SeleccionFacil);
		add(SeleccionMedio);
		add(SeleccionDificil);

	}

	public String getSelectedSize() {
		return (String) SeleccionSize.getSelectedItem();
	}

	public String getSelectedDifficulty() {
		String selectedDifficulty = "";
		if (SeleccionFacil.isSelected()) {
			selectedDifficulty = "Fácil";
		} else if (SeleccionMedio.isSelected()) {
			selectedDifficulty = "Medio";
		} else if (SeleccionDificil.isSelected()) {
			selectedDifficulty = "Difícil";
		}
		return selectedDifficulty;
	}

}
