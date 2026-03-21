package tp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class PanelCentro extends Panel {

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
        generarGrilla(centrado); 
	} 
	
	//aprovecha la clase de bloque para crear la tabla
	protected void generarGrilla(JPanel centrado) {
		for(int i=0;i<25;i++) {
			bloque_Letra bloque = new bloque_Letra();
			centrado.add(bloque);
		}	
	}
	
	
}
