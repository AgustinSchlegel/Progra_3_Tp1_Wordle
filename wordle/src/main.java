
import javax.swing.JFrame;

import interfazGrafica.Panel_Menu;

public class main {
	public static void main(String[] args) {
        // Creamos la única ventana del juego
        JFrame ventana = new JFrame("Wordle - Proyecto");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Instanciamos el panel de inicio
        Panel_Menu inicio = new Panel_Menu();
        
        // Metemos el panel de inicio en la ventana
        ventana.setContentPane(inicio);
        
        // Configuración de visualización
        ventana.setSize(450, 600); // Ajusta según el tamaño de tu tablero
        ventana.setLocationRelativeTo(null); // Centra la ventana
        ventana.setVisible(true);
    }
}
