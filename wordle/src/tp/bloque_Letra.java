package tp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class bloque_Letra extends JLabel{
	public static void main(String[] args) {
		new bloque_Letra();
	}
	
	public bloque_Letra() {
		//Font miFuente = new Font("Arial", Font.BOLD, 20);
		this.setPreferredSize(new Dimension(50, 50));
		Color colorBloque = new Color(0, 173, 181);
		setOpaque(true);
		setBackground(colorBloque);
		//setFont(miFuente);
	}
}
