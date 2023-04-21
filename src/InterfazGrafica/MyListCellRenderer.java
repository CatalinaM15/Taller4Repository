package InterfazGrafica;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

public class MyListCellRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object> {
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		JLabel c = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		c.setOpaque(true);
		c.setBackground(Color.WHITE);
		c.setForeground(Color.BLACK);
		c.setFont(new Font("Dialog", Font.PLAIN, 23));
		c.setHorizontalAlignment(SwingConstants.CENTER);
		if (isSelected) {
			
			c.setBackground(Color.BLACK);
			c.setForeground(Color.WHITE);
			
		}
		return c;
	}

}
