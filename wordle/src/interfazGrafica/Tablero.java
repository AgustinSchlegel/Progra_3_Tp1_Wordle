package interfazGrafica;
import javax.swing.*;
import java.awt.*;

// 1. Ahora la clase HEREDA de JPanel
public class Tablero extends JPanel {

    // private JFrame frame; <-- ESTO SE BORRA, ya no lo necesitas aquí.

    public Tablero() {
        // 2. Configuramos el layout del propio panel
        setLayout(new BorderLayout());
        generarEntorno();
    }

    private void generarEntorno() {
        PanelSuperior panelSuperior = new PanelSuperior(); 
        PanelCentro panelCentro = new PanelCentro(); 
        PanelBajo panelBajo = new PanelBajo(); 
        
        // 3. Agregamos directamente al panel (this)
        add(panelSuperior, BorderLayout.NORTH); 
        add(panelCentro, BorderLayout.CENTER); 
        add(panelBajo, BorderLayout.SOUTH);
        
        // 4. Iniciamos el cronómetro
        panelSuperior.iniciarCronometro();
    }

}