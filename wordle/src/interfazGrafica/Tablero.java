package interfazGrafica;
import javax.swing.*;

import sistema.*;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Tablero extends JPanel{
	
    private Menu ventana;
	private SistemaLogica juego;
	
	private ComplementoVisual complementoVisual;
    private Cuadricula cuadricula;
    private EntradaDatos entradaDatos;    
    
    private int pistas = 0;
	private final int max_pistas = 2;
	private boolean[] reveladas = new boolean[5];
	private String idioma;
	private String dificultad;

    public Tablero(String idiomaRecibido, String dificultad, Menu ventana) {
    	this.idioma =idiomaRecibido;
    	this.ventana=ventana;
    	this.dificultad = dificultad;
		setBackground(new Color(24, 24, 27));
        setLayout(new BorderLayout(0, 0));
        generarEntorno();
    }
    
    public void procesarEntrada(String palabra) {
        this.procesarPalabra(palabra);
    }
    
    public void generarEntorno() {
    	complementoVisual= new ComplementoVisual(); 
    	cuadricula= new Cuadricula(); 
    	entradaDatos = new EntradaDatos(); 
        
        String palabra = palabras_jugables.seleccionarPalabra(this.idioma);
        
        this.juego = new SistemaLogica(palabra);
        entradaDatos.setTablero(this);
        
        add(complementoVisual, BorderLayout.NORTH); 
        add(cuadricula, BorderLayout.CENTER); 
        add(entradaDatos, BorderLayout.SOUTH);
        
        complementoVisual.iniciarCronometro();
        complementoVisual.setTablero(this);
    }

	public void procesarPalabra(String palabra) {
		int filaActual = juego.getIntentoActual();
		EstadoLetra[] resultado = juego.intentar(palabra);
		cuadricula.mostrarResultado(palabra, resultado,filaActual);

		if(juego.victoria(palabra)) {
		    complementoVisual.pararCronometro();
		    String tiempoFinal = complementoVisual.getTiempo();
		    String nombreDelGanador = JOptionPane.showInputDialog(this, "¡Victoria! Ingresá tu nombre:");
		    
		    if(nombreDelGanador != null && !nombreDelGanador.trim().isEmpty()) {
		        juego.cargarRanking(nombreDelGanador + " - " + tiempoFinal);
		    }
		    finalizarPartida();
		}
		
		if(juego.derrota()) {
			JOptionPane.showMessageDialog(this, 
					"Perdiste, la palabra era: " +juego.getPalabraSecreta() + 
					"\nTiempo: " + complementoVisual.getTiempo());
			complementoVisual.pararCronometro();
			 finalizarPartida();
		}
	}
	
	private void finalizarPartida() {
	    String mensajeFinal = "--- TOP RANKING ---\n" 
	                        + juego.getRanking() 
	                        + "\n\n¿Deseas volver al menú principal?";

	    int opcion = JOptionPane.showConfirmDialog(
	            this, 
	            mensajeFinal, 
	            "Fin de la partida",
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.INFORMATION_MESSAGE
	        );        
	    
	    if (opcion == JOptionPane.YES_OPTION) {
	        ventana.mostrarMenuPrincipal();
	    } else {
	        System.exit(0);
	    }
	}
	
	public void darPista() {
		
		if (dificultad.equals("Difícil")) {
	        JOptionPane.showMessageDialog(this, "las pistas no estan disponibles en modo difícil");
	        return;
	    }
		
	    if (pistas >= max_pistas) {
	        JOptionPane.showMessageDialog(this, "no quedan mas pistas");
	        return;
	    }
	    
	    String palabra = juego.getPalabraSecreta();
	    ArrayList<Integer> disponibles = new ArrayList<>();
	    int fila = juego.getIntentoActual();

	    for (int i = 0; i < palabra.length(); i++) {
	        if (!reveladas[i] && cuadricula.grillaestaVacia(fila, i) && !cuadricula.letraEsVerde(i)) {
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
	    cuadricula.revelarLetra(fila, columna, letra);
	    pistas++;
	}
	
	public int darIntentosMaximos() {
		return juego.INTENTOS_MAXIMOS();
	}

	public int darLongitudPalabra() {
		return juego.getPalabraSecreta().length();
	}
	
}
