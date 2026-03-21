package tp;

import java.awt.Color;
import javax.swing.JPanel;


//dudo si la vamos a mantener. Por buena organizacion de codigo esta bueno, pero no nos suma nada.
abstract class Panel extends JPanel{
	public static void main(String[] args) {
	}
    protected Color colorFondo = new Color(18, 18, 18);
    public Panel() {
        this.setBackground(colorFondo);
    }
	
}
