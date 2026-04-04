package interfazGrafica;

import java.awt.*;

import javax.swing.*;

import sistema.SistemaLogica;

public class PanelBajo extends Panel{
	
	private EscuchadorJuego escuchador;

	public static void main(String[] args) {
		new PanelBajo();
	}
	
	public PanelBajo() {
	    Color colorSeccionBaja = new Color(37, 37, 37);
	    this.setPreferredSize(new Dimension(500, 100));
		this.setLayout(new BorderLayout());

		generarSeccionBaja(this,colorSeccionBaja);
	}

	
	//no se como acomodar el de ingresar palabra y el aceptar sin acomodarlos en el metodo directamente. Si pudiera lo haria
	private void generarSeccionBaja(JPanel panelBajo,Color color ) {
		//El cuadro donde el usuario escribira el texto y el formato
		JTextField campoTexto = new JTextField();
		campoTexto.setFont(new Font("Arial", Font.BOLD, 20));
		campoTexto.setHorizontalAlignment(JTextField.CENTER);
		campoTexto.setPreferredSize(new Dimension(250, 50));

		//Boton para enviar y verificar la palabra
		JButton botonAceptar = new JButton("ENVIAR");
		botonAceptar.setPreferredSize(new Dimension(120, 50));
		botonAceptar.setBackground(new Color(83, 141, 78));
		botonAceptar.setForeground(Color.WHITE);
		botonAceptar.setFocusPainted(false);

		//Verifica que la palabra sea de 5 letras
		botonAceptar.addActionListener(e -> {
			String palabra = campoTexto.getText().toUpperCase();
			if (palabra.length() == escuchador.darLongitudPalabra()) {
				 if (escuchador != null) {
					 escuchador.procesarPalabra(palabra);
	                }
				 campoTexto.setText(""); //limpia el cuadro una vez se envia la palabra
			} else {
				JOptionPane.showMessageDialog(this, "La palabra debe tener 5 letras");
			}
		});

		panelBajo.add(campoTexto, BorderLayout.CENTER);
		panelBajo.add(botonAceptar, BorderLayout.EAST);

		panelBajo.revalidate();
		panelBajo.repaint();
	}
	

	public void setReceptor(EscuchadorJuego r) {
        this.escuchador = r;
    }

}
