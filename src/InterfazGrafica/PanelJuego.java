package InterfazGrafica;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JPanel;

public class PanelJuego extends JPanel implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private double coordenadaxInicio = 10;
	private double coordenadayInicio = 10;
	private double Ancho;
	private double Alto;
	
	private int numerocartas;
	private static final double AnchoPanel = 620;
	private static final double AltoPanel = 590;
	private boolean[][] MatrixActual;
	private VentanaLightsOut Ventana;

	public PanelJuego(boolean[][] matrix, VentanaLightsOut v) {
		Ventana = v;
		MatrixActual = matrix;
		this.numerocartas = matrix.length;
		this.Ancho = AnchoPanel / numerocartas;
		this.Alto = AltoPanel / numerocartas;

		addMouseListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		coordenadaxInicio = 10;
		coordenadayInicio = 10;
		for (int i = 0; i < numerocartas; i++) {
			for (int j = 0; j < numerocartas; j++) {

				boolean booleano = MatrixActual[i][j];
				TarjetaLight rect = new TarjetaLight(coordenadaxInicio, coordenadayInicio, Ancho, Alto, booleano);

				coordenadaxInicio += Ancho + 1;
				rect.draw(g2d);

			}
			coordenadaxInicio = 10;
			coordenadayInicio += Alto + 1;
		}
	}

	
	public void mousePressed(MouseEvent e) {
		int click_x = e.getX();
		int click_y = e.getY();
		int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
		try {
			Ventana.jugar(casilla[0], casilla[1]);
		} catch (FileNotFoundException | UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		repaint();
	}

	private int[] convertirCoordenadasACasilla(int x, int y) {
		int fila = (int) (y / Alto);
		int columna = (int) (x / Ancho);
		return new int[] { fila, columna };
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void actualizarTablero(int size) {
		removeAll();
		numerocartas = size;
		this.Ancho = AnchoPanel / numerocartas;
		this.Alto = AltoPanel / numerocartas;
		revalidate();
		repaint();
	}

	public void actualizar(boolean[][] matrix) {
		this.MatrixActual = matrix;
		actualizarTablero(matrix.length);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
