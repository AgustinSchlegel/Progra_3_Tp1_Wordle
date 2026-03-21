package tp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBajo extends Panel{

	public static void main(String[] args) {
		new PanelBajo();
	}
	
	public PanelBajo() {
	    Color colorSeccionBaja = new Color(37, 37, 37);
	    setPreferredSize(new Dimension(500, 100));
		JPanel panelBajo = new JPanel();
		generarSeccionBaja(panelBajo,colorSeccionBaja);
	}

	//no se como acomodar el de ingresar palabra y el aceptar sin acomodarlos en el metodo directamente. Si pudiera lo haria
	private void generarSeccionBaja(JPanel panelBajo,Color color ) {
		JTextField ingresarPalabra = new JTextField();
		ingresarPalabra.setPreferredSize(new Dimension(400, 100));
		setOpaque(true);
		setBackground(color);		
		
		JButton aceptar = new JButton();
		aceptar.setPreferredSize(new Dimension(400, 100));
		setOpaque(true);
		setBackground(color);
		
		panelBajo.setLayout(new GridLayout());
		panelBajo.add(ingresarPalabra, BorderLayout.WEST); 
		panelBajo.add(aceptar, BorderLayout.EAST);
	}

	

}
