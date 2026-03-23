package interfazGrafica;
import javax.swing.*;

import sistema.*;

import java.awt.*;

// 1. Ahora la clase HEREDA de JPanel
public class Tablero extends JPanel {
	
	private SistemaLogica juego;
	private PanelSuperior panelSuperior;
	private PanelCentro panelCentro;
    // private JFrame frame; <-- ESTO SE BORRA, ya no lo necesitas aquí.

    public Tablero() {
        // 2. Configuramos el layout del propio panel
        setLayout(new BorderLayout());
        generarEntorno();
    }

    private void generarEntorno() {
        panelSuperior = new PanelSuperior(); 
        panelCentro = new PanelCentro(); 
        PanelBajo panelBajo = new PanelBajo(); 
        
        String palabra = palabras_jugables.seleccionarPalabra(palabras_jugables.palabras_español);
        juego = new SistemaLogica(palabra);
        panelBajo.setTablero(this);
        
        // 3. Agregamos directamente al panel (this)
        add(panelSuperior, BorderLayout.NORTH); 
        add(panelCentro, BorderLayout.CENTER); 
        add(panelBajo, BorderLayout.SOUTH);
        
        // 4. Iniciamos el cronómetro
        panelSuperior.iniciarCronometro();
    }

	public void procesarPalabra(String palabra) {
		EstadoLetra[] resultado = juego.intentar(palabra);
		panelCentro.mostrarResultado(palabra, resultado);
		
		if(juego.victoria(palabra)) {
			JOptionPane.showMessageDialog(this, "¡Ganaste!" + 
					"\nTiempo: " + panelSuperior.getTiempo());
			panelSuperior.pararCronometro();
			return;
		}
		
		if(juego.derrota()) {
			JOptionPane.showMessageDialog(this, "Perdiste, la palabra era: " + juego.getPalabraSecreta() + 
					"\nTiempo: " + panelSuperior.getTiempo());
			panelSuperior.pararCronometro();
			
		}
		
	}

}