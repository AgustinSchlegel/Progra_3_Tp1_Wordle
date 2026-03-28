
import javax.swing.SwingUtilities;


public class main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Ventana_Principal ventana = new Ventana_Principal();
            ventana.setVisible(true);
            ventana.mostrarMenu(); 
        });
    }
}
