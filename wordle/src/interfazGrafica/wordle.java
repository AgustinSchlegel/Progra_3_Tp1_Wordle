package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;


public class wordle {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wordle window = new wordle();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private void generarEntorno() {
		PanelSuperior panelSuperior = new PanelSuperior(); // especifico para el cronometro (por ahora creo)
		Panel panelCentro 	= new PanelCentro(); //especifico para almacenar la grilla donde desp se van a depositar las letras del usuario
		Panel panelBajo 	= new PanelBajo(); //especifico para almacenar la barra de ingreso de texto y el botoncito de aceptar
		
		//lo siguiente acomoda ambos paneles para que convivan entre ellos
		frame.getContentPane().add(panelSuperior);
		frame.getContentPane().add(panelCentro);
		frame.getContentPane().add(panelBajo);
		
		frame.setLayout(new BorderLayout());
		frame.add(panelSuperior, BorderLayout.NORTH); 
		frame.add(panelCentro, BorderLayout.CENTER); 
		frame.add(panelBajo, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
		
		panelSuperior.iniciarCronometro();
	}
	
	/**
	 * Create the application.
	 */
	public wordle() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		generarEntorno();
	}

}
