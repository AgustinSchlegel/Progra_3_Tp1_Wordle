
import javax.swing.SwingUtilities;
import interfazGrafica.Menu;

public class main {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }
}
