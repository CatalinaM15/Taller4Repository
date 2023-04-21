package InterfazGrafica;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;

public class TarjetaLight extends RoundRectangle2D.Double {
	private static final long serialVersionUID = 1L;
	private Color color;
	public static final String OFF = "./data/LightOFF.png";
	public static final String ON = "./data/LightON.png";
	private boolean estadoActual = true;

	public TarjetaLight(double x, double y, double width, double height, boolean estado) {
		super(x, y, width, height, 10, 10);
		estadoActual = estado;
		Color Gunmetal = new Color(42, 52, 57);
		this.color = Gunmetal;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean contains(double x, double y) {
		return super.contains(x, y);
	}

	public void draw(Graphics2D g2d) {

		String Imagen = ON;
		if (estadoActual) {
			Imagen = OFF;
		}
		g2d.setColor(color);
		g2d.fill(this);

		// Dibujar la imagen dentro del rectángulo redondeado
		Image imagen = new ImageIcon(Imagen).getImage();
		g2d.drawImage(imagen, (int) getX() + 10, (int) getY() + 10, (int) getWidth() - 20, (int) getHeight() - 20,
				null);
	}

}
