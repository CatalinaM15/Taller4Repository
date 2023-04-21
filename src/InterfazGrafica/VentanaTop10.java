package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Collection;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class VentanaTop10 extends JDialog {
	private VentanaLightsOut padre;
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> modelo;
	private static final MyListCellRenderer nRenderer = new MyListCellRenderer();

	public VentanaTop10(VentanaLightsOut laVentana) {
		padre = laVentana;
		Color AirForceBlue = new Color(93, 138, 168);
		// Creacion panel arriba y elementos
		JPanel Arriba = new JPanel();
		JLabel Nombre = new JLabel("Nombre");
		JLabel Posicion = new JLabel("Posicion");
		JLabel Puntaje = new JLabel("Puntaje");
		JLabel dummy = new JLabel();
		JLabel dummy2 = new JLabel();

		// Modificaciones esteticas
		Arriba.setBackground(AirForceBlue);
		Nombre.setFont(new Font("Dialog", Font.BOLD, 14));
		Nombre.setForeground(Color.WHITE);
		Posicion.setFont(new Font("Dialog", Font.BOLD, 14));
		Posicion.setForeground(Color.WHITE);
		Puntaje.setFont(new Font("Dialog", Font.BOLD, 14));
		Puntaje.setForeground(Color.WHITE);

		// Agregar Labels a panel arriba
		Arriba.setLayout(new GridLayout(1, 5, 2, 0));
		Arriba.add(dummy);
		Arriba.add(Posicion);
		Arriba.add(Nombre);
		Arriba.add(Puntaje);
		Arriba.add(dummy2);

		// Creacion de la lista y el scroll

		modelo = new DefaultListModel<String>();

		JList<String> listaTop = new JList<String>(modelo);
		listaTop.setCellRenderer(nRenderer);

		Collection<RegistroTop10> colecction = padre.darRegistros();
		int i = 1;
		for (RegistroTop10 registro : colecction) {
			String Adicion = registro.toString();
			Adicion = Adicion.replace(".....", "     ");
			if (i != 10) {
				Adicion = " " + String.valueOf(i) + "     " + Adicion;
			} else {
				Adicion = String.valueOf(i) + "    " + Adicion;
			}
			modelo.addElement(Adicion);

			i++;
		}

		JScrollPane Scroll = new JScrollPane();
		Scroll.setViewportView(listaTop);
//		Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		add(Scroll, BorderLayout.CENTER);
		add(Arriba, BorderLayout.NORTH);

	}

}
