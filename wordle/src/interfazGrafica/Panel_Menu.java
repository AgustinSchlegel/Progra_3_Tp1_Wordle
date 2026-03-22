package interfazGrafica;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Panel_Menu extends Panel{
	public Panel_Menu() {
	    // 1. Definir el Layout del Panel
	    setLayout(new GridBagLayout()); 
	    GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(10, 10, 10, 10);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    
	//Implementacion de Botones
	    
	    //Iniciar
	    JButton iniciarPartida = new JButton("Iniciar Partida");
	    iniciarPartida.setPreferredSize(new Dimension(200, 50));
	    iniciarPartida.addActionListener(e -> {
	        JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(this);
	        
	        Tablero nuevoTablero = new Tablero();
	        ventana.setContentPane(nuevoTablero);
	        
	        ventana.revalidate();
	        ventana.repaint();
	        ventana.pack(); 
	        ventana.setLocationRelativeTo(null); 
	    });
	    c.gridy = 0; // Fila 0
	    add(iniciarPartida, c);

	    //Elegir idioma
	    JButton idioma = new JButton("Idioma");
	    idioma.setPreferredSize(new Dimension(200, 50));
	    idioma.addActionListener(e -> {
	        String[] opciones = {"Español", "English", "Português","Deutsch","Avañe'ẽ"};
	        int seleccion = JOptionPane.showOptionDialog(
	                this, // Usa 'this' (el panel) como padre, no el botón
	                "Seleccione el idioma de juego:",
	                "Configuración",
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.QUESTION_MESSAGE,
	                null, opciones, opciones[0]);
	        System.out.println("Seleccionaste: " + seleccion);
	    });
	    c.gridy = 1; // Fila 1
	    add(idioma, c);

	    //Ranking
	    JButton ranking = new JButton("Ranking");
	    ranking.setPreferredSize(new Dimension(200, 50));
	    ranking.addActionListener(e -> {
	        JOptionPane.showMessageDialog(this, "Ranking: (Próximamente)");
	    });
	    c.gridy = 2;
	    add(ranking, c);

	    //Salir
	    JButton salir = new JButton("Salir");
	    salir.setPreferredSize(new Dimension(200, 50));
	    salir.addActionListener(e -> {
	        int confirm = JOptionPane.showConfirmDialog(this,
	                "¿Seguro que quieres salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
	        if (confirm == JOptionPane.YES_OPTION) {
	            System.exit(0);
	        }
	    });
	    c.gridy = 3;
	    add(salir, c);

	}
}
