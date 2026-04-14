package interfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import sistema.EstadoLetra;

public class Cuadricula extends JPanel {
	
	private BloqueLetra[][] grilla;

	public Cuadricula() {
	    Color colorCuadrilla = new Color(24, 24, 27);
		JPanel centrado = new JPanel();		
		
        centrado.setLayout(new GridLayout(0, 5, 2, 2));
        centrado.setPreferredSize(new Dimension(400, 400));
        centrado.setBackground(colorCuadrilla);
        
        this.add(centrado);
        grilla = new BloqueLetra[6][5];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                BloqueLetra bloque = new BloqueLetra();
                grilla[i][j] = bloque;
                centrado.add(bloque);
            }
        }
	}
	
	public void mostrarResultado(String palabra, EstadoLetra[] estados,int filaActual) {
		if (filaActual >= 6) return;
		
		int limite = Math.min(palabra.length(), 5);
		
        for (int i = 0; i < limite; i++) {
        	if (grilla[filaActual][i].getText().isEmpty()) {
        	    grilla[filaActual][i].cargarLetra(palabra.charAt(i), estados[i]);
        	}        
        }
    }
	
	public void revelarLetra(int fila, int columna, char letra) {
	    if (fila >= 5) {
	    	return;
	    }
	    grilla[fila][columna].cargarLetra(letra, EstadoLetra.VERDE);
	}

	public boolean grillaestaVacia(int fila, int columna) {
	    return grilla[fila][columna].getText().isEmpty();
	}

	public boolean letraEsVerde(int columna) {
	    for (int i = 0; i < grilla.length; i++) {
	        if (grilla[i][columna].getBackground().equals(new Color(83, 141, 78))) {
	            return true;
	        }
	    }
	    return false;
	}
}
