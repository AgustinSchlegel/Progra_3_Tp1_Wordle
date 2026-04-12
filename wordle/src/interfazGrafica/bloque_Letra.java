package interfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import sistema.EstadoLetra;

public class bloque_Letra extends JLabel{

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
			setBackground(new Color(83, 141, 78));
            break;
        case AMARILLO:
            setBackground(new Color(181, 159, 59));
            break;
        case GRIS:
            setBackground(Color.GRAY);
            break;
		}
	}
	
}
