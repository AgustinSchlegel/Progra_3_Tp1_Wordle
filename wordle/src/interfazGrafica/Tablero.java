package interfazGrafica;
import javax.swing.*;

import sistema.*;

import java.awt.*;
import java.util.ArrayList;

// 1. Ahora la clase HEREDA de JPanel
public class Tablero extends JPanel implements EscuchadorJuego {
    private String idioma;
	private SistemaLogica juego;
	private int pistas = 0;
	private final int max_pistas = 2;
	private boolean[] reveladas = new boolean[5];
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
        
        //set tablero para las pistas
        panelSuperior.setTablero(this);
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
	
	public void darPista() {
		
	    if (pistas >= max_pistas) {
	        JOptionPane.showMessageDialog(this, "no quedan mas pistas");
	        return;
	    }
	    
	    String palabra = juego.getPalabraSecreta();
	    ArrayList<Integer> disponibles = new ArrayList<>();
	    int fila = juego.getIntentos();

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
	
	@Override
	public int darIntentosMaximos() {
		return juego.INTENTOS_MAXIMOS();
	}

	@Override
	public int darLongitudPalabra() {
		return juego.getPalabraSecreta().length();
	}

}