package InterfazGrafica;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelBotones extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private VentanaLightsOut Ventana;

	public PanelBotones(VentanaLightsOut Ventana) {
		this.Ventana = Ventana;
		// Crear botones y panel de centro
		JPanel panelcentro = new JPanel();
		panelcentro.setLayout(new GridLayout(4, 1, 0, 5));
		JButton boton1 = new JButton("NUEVO");
		boton1.addActionListener(this); 
		panelcentro.add(boton1);
		JButton boton2 = new JButton("REINICIAR");
		boton2.addActionListener(this); 
		panelcentro.add(boton2);
		JButton boton3 = new JButton("TOP-10");
		boton3.addActionListener(this); 
		panelcentro.add(boton3);
		JButton boton4 = new JButton("CAMBIAR JUGADOR");
		boton4.addActionListener(this); 
		panelcentro.add(boton4);
		panelcentro.setPreferredSize(new Dimension(250, 250));
		JPanel paneldemo = new JPanel();
		JPanel paneldemo2 = new JPanel();
		// Establecer layout del panel principal
		setLayout(new GridLayout(3, 1));
		add(paneldemo);
		add(panelcentro);
		add(paneldemo2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Aqu� puedes definir lo que debe hacer el panel cuando se presiona uno de los
		// botones
		if (e.getActionCommand().equals("NUEVO")) {
			// c�digo para el bot�n "NUEVO"
			Ventana.ConfiguracionaPanel();
		} else if (e.getActionCommand().equals("REINICIAR")) {
			// c�digo para el bot�n "REINICIAR"
			Ventana.reinicio();
		} else if (e.getActionCommand().equals("TOP-10")) {
			// c�digo para el bot�n "TOP-10"
			Ventana.MostrarTop10();
		} else if (e.getActionCommand().equals("CAMBIAR JUGADOR")) {
			// c�digo para el bot�n "CAMBIAR JUGADOR"
			String nombreNuevoJugador = JOptionPane.showInputDialog(this, "Ingrese el Nombre del Nuevo jugador",
					"Cambio de Jugador", JOptionPane.QUESTION_MESSAGE);
			if (nombreNuevoJugador != null) { // si el usuario ingres� un valor v�lido
				Ventana.actualizar_NombreJugador(nombreNuevoJugador); // actualiza el valor en el panel
			}

		}
	}

}

// aca para cambiar el nombre del jugador opcion 2
// JOptionPane.showInputDialog(this, "Mensaje","titulo", JoptionPane.QUESTION_MESSAGE) -> abre ventana para pedir info al jugador
// devuelve String convertir a numero -> Integer.parseInt(respuesta)

//JFileChooser fc = new FIleChooser("."); esto hace que se seleccione un archivo
//fc.setFileFilter()// para solo seleccionar un tipo de datos espc
//int resultado = fc.showOpenDialog(this);
//if (resutlado == Jfilechooser.APPROVE_OPTION)
//File archivo = fc.getSelectedFile();
