package interfazGrafica;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import sistema.SistemaLogica;
import sistema.palabras_jugables;

public class Panel_Menu extends Panel{
	String idiomaSeleccionado = "Español"; //Lo dejamos asi para que siempre halla un idioma por defecto
	public Panel_Menu() {
	    setLayout(new GridBagLayout()); 
	    GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(10, 10, 10, 10);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    
	//Implementacion de Botones
	  	    
	    //Elegir idioma
	    JButton idioma = new JButton("Idioma");
	    idioma.setPreferredSize(new Dimension(200, 50));
	    idioma.addActionListener(e -> {
	        String[] opciones = {"Español", "English", "Português","Deutsch","Avañe'ẽ"};
	        int seleccion = JOptionPane.showOptionDialog(
	                this,
	                "Seleccione el idioma de juego:",
	                "Configuración",
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.QUESTION_MESSAGE,
	                null, opciones, opciones[0]);

	        if (seleccion != -1) {
	            idiomaSeleccionado = opciones[seleccion];
	            System.out.println("Idioma guardado: " + idiomaSeleccionado);
	        }
	    });
	    c.gridy = 1; 
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
	    
	    //Iniciar
	    JButton iniciarPartida = new JButton("Iniciar Partida");
	    iniciarPartida.setPreferredSize(new Dimension(200, 50));
	    iniciarPartida.addActionListener(e -> {
	    	JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(this);

	    	Tablero nuevoTablero = new Tablero(idiomaSeleccionado);

	    	ventana.setContentPane(nuevoTablero);            
	    	ventana.revalidate(); 
	    	ventana.repaint();
	    });
	    c.gridy = 0; 
	    add(iniciarPartida, c);

	}
	
	public String getIdiomaSeleccionado() {
		return idiomaSeleccionado;
	}
}
