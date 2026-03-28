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
		EstadoLetra[] resultado = juego.intentar(palabra);
		int intentos = juego.getIntentos();
		panelCentro.mostrarResultado(palabra, resultado,intentos);
		juego.sumarIntento();

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
	
	@Override
	public int darIntentosMaximos() {
		return juego.INTENTOS_MAXIMOS();
	}

}