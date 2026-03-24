package interfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import sistema.EstadoLetra;

public class bloque_Letra extends JLabel{
	public static void main(String[] args) {
		new bloque_Letra();
	}
	
	public bloque_Letra() {
		Font miFuente = new Font("Arial", Font.BOLD, 20);
		this.setPreferredSize(new Dimension(50, 50));
		Color colorBloque = new Color(0, 173, 181);
		setOpaque(true);
		setBackground(colorBloque);
		setFont(miFuente);
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void cargarLetra(char letra, EstadoLetra estado) {
		setText(String.valueOf(letra));
		
		switch(estado) {
		case VERDE:
			setBackground(Color.GREEN);
            break;
        case AMARILLO:
            setBackground(Color.YELLOW);
            break;
        case GRIS:
            setBackground(Color.GRAY);
            break;
		}
	}
	
}
