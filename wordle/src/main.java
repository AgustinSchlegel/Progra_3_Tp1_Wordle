
import javax.swing.JFrame;

import interfazGrafica.Panel_Menu;

public class main {
	public static void main(String[] args) {
        JFrame ventana = new JFrame("Wordle - Proyecto");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Panel_Menu inicio = new Panel_Menu();
        
        ventana.setContentPane(inicio);
        
        ventana.setSize(450, 600); 
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
