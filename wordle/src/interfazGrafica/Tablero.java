package interfazGrafica;
import javax.swing.*;

import sistema.*;

import java.awt.*;

// 1. Ahora la clase HEREDA de JPanel
public class Tablero extends JPanel{
	private String idioma;
	private SistemaLogica juego;
	private PanelSuperior panelSuperior;
    private PanelCentro panelCentro;
    private PanelBajo panelBajo;
    private Panel_Menu ventana;

    public Tablero(String idiomaRecibido,Panel_Menu ventana) {
    	this.idioma =idiomaRecibido;
    	this.ventana=ventana;
        setLayout(new BorderLayout());
        generarEntorno();
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
        panelBajo.setTablero(this);
        
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
			finalizarPartida();
		}
		
		
		if(juego.derrota()) {
			JOptionPane.showMessageDialog(this, 
					"Perdiste, la palabra era: " +juego.getPalabraSecreta() + 
					"\nTiempo: " + panelSuperior.getTiempo());
			panelSuperior.pararCronometro();
			 finalizarPartida();
		}
		
	}
	
	private void finalizarPartida() {
		int opcion = JOptionPane.showConfirmDialog(
			    this, 
			    "¿Volver al menú?", 
			    "Fin de la partida", 
			    JOptionPane.YES_NO_OPTION
			);        
		if (opcion == JOptionPane.YES_OPTION) {
            ventana.mostrarMenuPrincipal();
        }else{
        	System.exit(0);
        }
    }
	
	public int darIntentosMaximos() {
		return juego.INTENTOS_MAXIMOS();
	}

	public int darLongitudPalabra() {
		return juego.getPalabraSecreta().length();
	}

}