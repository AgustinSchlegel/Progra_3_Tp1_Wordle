package test;

import javax.swing.JFrame;
import interfazGrafica.PanelCentro;
public class PanelCentroTest {

	public static void main(String[] args) {
		
		JFrame ventana = new JFrame("PanelCentro Test");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelCentro panelCentro = new PanelCentro();
		
		ventana.add(panelCentro);
		ventana.pack();
		ventana.setVisible(true);
	}
	
	
}
