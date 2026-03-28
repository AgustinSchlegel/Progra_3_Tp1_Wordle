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

public class Panel_Menu extends Panel {
	String idiomaSeleccionado = "Español"; //Lo dejamos asi para que siempre halla un idioma por defecto
	private EscuchadorMenu escuchador;

	public Panel_Menu() {
		
	    setLayout(new GridBagLayout()); 
	    GridBagConstraints configuracion = new GridBagConstraints();
	    configuracion.insets = new Insets(10, 10, 10, 10);
	    configuracion.fill = GridBagConstraints.HORIZONTAL;
	    
	//Implementacion de Botones
	    //Iniciar
	    configuracion.gridy = 0; 												
	    JButton iniciarPartida = crearBotónEstandar("Iniciar Partida");
	    iniciarPartida.addActionListener(e -> {
	        if (escuchador != null) {
	            escuchador.IniciarPartida(idiomaSeleccionado);
	        }
	    });
	    add(iniciarPartida, configuracion);
	    
	    //Elegir idioma
	    configuracion.gridy = 1; 
	    JButton idioma = crearBotónEstandar("Idioma");
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
	        }
	    });
	    add(idioma, configuracion);
	    
	    //Ranking
	    configuracion.gridy = 2;
	    JButton ranking = crearBotónEstandar("Ranking");
	    ranking.addActionListener(e -> {
	        if (escuchador != null) {
	            escuchador.MostrarRanking();
	        }
	    });
	    add(ranking, configuracion);

	    //Salir
	    configuracion.gridy = 3;
	    
	    JButton salir = crearBotónEstandar("Salir");
	    salir.addActionListener(e -> {
	        if (escuchador != null) {
	            escuchador.Salir();
	        }
	    });
	    add(salir, configuracion);	    
	}
	
	public String getIdiomaSeleccionado() {
		return idiomaSeleccionado;
	}
	
	public void setEscuchador(EscuchadorMenu e) {
        this.escuchador = e;
    }
	
	private JButton crearBotónEstandar(String texto) {
	    JButton boton = new JButton(texto);
	    boton.setPreferredSize(new Dimension(200, 50));
	    return boton;
	}	
}
