package interfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import sistema.EstadoLetra;

public class PanelCentro extends Panel {
	
	private BloqueLetra[][] grilla;
    private int filaActual = 0;
    
    public static void main(String[] args) {
		new PanelCentro();
	}
    
	public PanelCentro() {
	    Color colorCuadrilla = new Color(30, 30, 30); //Azul
		JPanel centrado = new JPanel();		
		
		//le da tamaño y margen de acomodo a los bloques generados por el metodo generarGrilla
        centrado.setLayout(new GridLayout(0, 5, 2, 2));		
        centrado.setPreferredSize(new Dimension(400, 400));
        centrado.setBackground(colorCuadrilla);
        
        this.add(centrado);
        grilla = new BloqueLetra[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                BloqueLetra bloque = new BloqueLetra();
                grilla[i][j] = bloque;
                centrado.add(bloque);
            }
        }
	} 
	
	public void mostrarResultado(String palabra, EstadoLetra[] estados) {
		if (filaActual >= 6) return;
		
		int limite = Math.min(palabra.length(), 5);
		
        for (int i = 0; i < limite; i++) {
            grilla[filaActual][i].cargarLetra(palabra.charAt(i), estados[i]);
        }

        filaActual++;
    }
	
	
	
}
