package interfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import sistema.EstadoLetra;

public class BloqueLetra extends JLabel{
	public static void main(String[] args) {
		new BloqueLetra();
	}
	
	public BloqueLetra() {
		
		Font font = new Font("Arial", Font.BOLD, 20);
		Color colorBloque = new Color(0, 173, 181);
		this.setPreferredSize(new Dimension(50, 50));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		setOpaque(true);
		setBackground(colorBloque);
		setFont(font);
	}
	
	public void cargarLetra(char letra, EstadoLetra estado) {
		
		setText(String.valueOf(letra));
		
		switch(estado) {
		case VERDE:
			setBackground(new Color(66, 245, 39));
            break;
        case AMARILLO:
            setBackground(new Color(255, 230, 0));
            break;
        case GRIS:
            setBackground(Color.GRAY);
            break;
		}
	}
	
}
