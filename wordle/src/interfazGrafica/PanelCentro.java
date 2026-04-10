package interfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import sistema.EstadoLetra;

public class PanelCentro extends Panel {
	
	private bloque_Letra[][] grilla;
    
    public static void main(String[] args) {
		new PanelCentro();
	}
    
	public PanelCentro() {
	    Color colorCuadrilla = new Color(30, 30, 30);
		JPanel centrado = new JPanel();		
		
		//le da tamaño y margen de acomodo a los bloques generados por el metodo generarGrilla
        centrado.setLayout(new GridLayout(0, 5, 2, 2));		
        centrado.setPreferredSize(new Dimension(400, 400));
        centrado.setBackground(colorCuadrilla);
        
        this.add(centrado);
        grilla = new bloque_Letra[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bloque_Letra bloque = new bloque_Letra();
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

        filaActual++;
    }
	
	public void revelarLetra(int fila, int columna, char letra) {
	    if (fila >= 5) {
	    	return;
	    }
	    grilla[fila][columna].cargarLetra(letra, EstadoLetra.VERDE);
	}
	
	public boolean estaVacia(int fila, int columna) {
	    return grilla[fila][columna].getText().isEmpty();
	}
	
	public boolean esVerde(int columna) {
	    for (int i = 0; i < grilla.length; i++) {
	        if (grilla[i][columna].getBackground().equals(new Color(83, 141, 78))) {
	            return true;
	        }
	    }
	    return false;
	}
}
