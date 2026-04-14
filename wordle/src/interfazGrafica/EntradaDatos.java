package interfazGrafica;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;


public class EntradaDatos extends JPanel{
	private Tablero tablero;
	private JTextField campoTexto;
	private JButton botonAceptar;

	
	public EntradaDatos() {
	    Color colorSeccionBaja = new Color(37, 37, 37);
	    this.setPreferredSize(new Dimension(500, 100));
		this.setLayout(new BorderLayout());
		setBackground(new Color(15, 15, 15));


		generarSeccionBaja(this,colorSeccionBaja);
	}

	
	//no se como acomodar el de ingresar palabra y el aceptar sin acomodarlos en el metodo directamente. Si pudiera lo haria
	private void generarSeccionBaja(JPanel panelBajo,Color color ) {
		
		//El input para el usuario
		campoTexto = new JTextField();
		campoTexto.setFont(new Font("Arial", Font.BOLD, 20));
		campoTexto.setHorizontalAlignment(JTextField.CENTER);
		campoTexto.setPreferredSize(new Dimension(250, 50));		
		campoTexto.setBackground(new Color(30, 30, 30)); // 
		campoTexto.setForeground(new Color(83, 141, 78)); 
		campoTexto.setCaretColor(Color.WHITE); 														
		campoTexto.setBorder(BorderFactory.createLineBorder(new Color(58, 58, 60), 2)); 			
		
		//Boton de aceptar para la palabra(cumple una funcion mas que nada estetica al ya disponer del keyListener atento al ENTER)
		botonAceptar = new JButton("ENVIAR");
		botonAceptar.setPreferredSize(new Dimension(120, 50));
		botonAceptar.setBackground(new Color(83, 141, 78));
		botonAceptar.setForeground(Color.WHITE);
		botonAceptar.setFocusPainted(false);
		botonAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonAceptar.setFont(new Font("Arial", Font.BOLD, 14));
		
		


		// Estilo para el botón enviar

		//Verifica que la palabra sea de 5 letras
		botonAceptar.addActionListener(e -> {
			String palabra = campoTexto.getText().toUpperCase();
			if (palabra.length() == tablero.darLongitudPalabra()) {
				 if (tablero != null) {
					 tablero.procesarPalabra(palabra);
	                }
				 campoTexto.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "La palabra debe tener 5 letras");
			}
		});

		panelBajo.add(campoTexto, BorderLayout.CENTER);
        
        eventosDelTeclado(); 

        panelBajo.add(botonAceptar, BorderLayout.EAST);

        panelBajo.revalidate();
        panelBajo.repaint();
	}
	
	private void eventosDelTeclado() {
	    campoTexto.addKeyListener(new KeyAdapter() {
	        //
	        @Override
	        public void keyTyped(KeyEvent teclaPresionada) {
	            char tecla = teclaPresionada.getKeyChar();
	            
	            if (campoTexto.getText().length() >= 5 || !Character.isLetter(tecla)) {
	            	teclaPresionada.consume(); 
	            }
	        }

	        //
	        @Override
	        public void keyPressed(KeyEvent teclaPresionada) {
	            if (teclaPresionada.getKeyCode() == KeyEvent.VK_ENTER) {
	                botonAceptar.doClick(); 
	            }
	        }
	    });
	}
	
	public void setTablero(Tablero r) {
        this.tablero = r;
    }

}
