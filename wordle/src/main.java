
import javax.swing.SwingUtilities;

import interfazGrafica.Menu;

public class main {
    public static void main(String[] args) {
        //VERIFICAR SI PODEMOS REALIZARLO DE UNA MANERA MAS FACIL DE EXPLICAR
    	SwingUtilities.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }
}
	