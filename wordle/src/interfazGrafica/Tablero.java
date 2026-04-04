package interfazGrafica;
import javax.swing.*;

import sistema.*;

import java.awt.*;

// 1. Ahora la clase HEREDA de JPanel
public class Tablero extends JPanel implements EscuchadorJuego {
    private String idioma;
	private SistemaLogica juego;
	PanelSuperior panelSuperior;
	PanelCentro panelCentro;
	PanelBajo panelBajo;

    public Tablero(String idiomaRecibido) {
        this.idioma = idiomaRecibido; 
        setLayout(new BorderLayout());
        generarEntorno();
        panelBajo.setReceptor(this);
    }
    
    public void procesarEntrada(String palabra) {
        this.procesarPalabra(palabra);
    }
    
    public void generarEntorno() {
    	panelSuperior= new PanelSuperior(); 
    	panelCentro= new PanelCentro(); 
        panelBajo = new PanelBajo(); 
        

        String palabra = palabras_jugables.seleccionarPalabra(this.idioma);
        
        this.juego = new SistemaLogica(palabra);
        panelBajo.setReceptor(this);
        
        //Agregamos directamente al panel (this)
        add(panelSuperior, BorderLayout.NORTH); 
        add(panelCentro, BorderLayout.CENTER); 
        add(panelBajo, BorderLayout.SOUTH);
        
        //Iniciamos el cronómetro
        panelSuperior.iniciarCronometro();
    }

	public void procesarPalabra(String palabra) {
		int filaActual = juego.getIntentos();
		EstadoLetra[] resultado = juego.intentar(palabra);
		panelCentro.mostrarResultado(palabra, resultado,filaActual);

		if(juego.victoria(palabra)) {
			JOptionPane.showMessageDialog(this, "¡Ganaste!" + 
					"\nTiempo: " + panelSuperior.getTiempo());
			panelSuperior.pararCronometro();
			System.exit(0);
		}
		
		
		if(juego.derrota()) {
			JOptionPane.showMessageDialog(this, 
					"Perdiste, la palabra era: " +juego.getPalabraSecreta() + 
					"\nTiempo: " + panelSuperior.getTiempo());
			panelSuperior.pararCronometro();
			 System.exit(0);
		}
		
	}
	
	@Override
	public int darIntentosMaximos() {
		return juego.INTENTOS_MAXIMOS();
	}

	@Override
	public int darLongitudPalabra() {
		return juego.getPalabraSecreta().length();
	}

}