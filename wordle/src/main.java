
import javax.swing.SwingUtilities;

import interfazGrafica.Panel_Menu;


public class main {
    public static void main(String[] args) {
        //VERIFICAR SI PODEMOS REALIZARLO DE UNA MANERA MAS FACIL DE EXPLICAR
    	SwingUtilities.invokeLater(() -> {
            new Panel_Menu().setVisible(true);
        });
    }
}
