package interfazGrafica;
import javax.swing.*;

import sistema.*;

import java.awt.*;
import java.util.ArrayList;

// 1. Ahora la clase HEREDA de JPanel
public class Tablero extends JPanel{
	private String idioma;
	private SistemaLogica juego;
	private PanelSuperior panelSuperior;
    private PanelCentro panelCentro;
    private PanelBajo panelBajo;
    private Panel_Menu ventana;
    private int pistas = 0;
	private final int max_pistas = 2;
	private boolean[] reveladas = new boolean[5];

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
        
        //set tablero para las pistas
        panelSuperior.setTablero(this);
    }

	public void procesarPalabra(String palabra) {
		int filaActual = juego.getIntentoActual();
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
	public void darPista() {
		
	    if (pistas >= max_pistas) {
	        JOptionPane.showMessageDialog(this, "no quedan mas pistas");
	        return;
	    }
	    
	    String palabra = juego.getPalabraSecreta();
	    ArrayList<Integer> disponibles = new ArrayList<>();
	    int fila = juego.getIntentoActual();

	    for (int i = 0; i < palabra.length(); i++) {
	        if (!reveladas[i] && panelCentro.estaVacia(fila, i) && !panelCentro.esVerde(i)) {
	            disponibles.add(i);
	        }
	    }

	    if (disponibles.isEmpty()) {
	    	return;
	    }
 
	    int random = (int) (Math.random() * disponibles.size());
	    int columna = disponibles.get(random);
	    reveladas[columna] = true;

	    char letra = Character.toUpperCase(palabra.charAt(columna));
	    panelCentro.revelarLetra(fila, columna, letra);
	    pistas++;
	}
	
	public int darIntentosMaximos() {
		return juego.INTENTOS_MAXIMOS();
	}

	public int darLongitudPalabra() {
		return juego.getPalabraSecreta().length();
	}

}