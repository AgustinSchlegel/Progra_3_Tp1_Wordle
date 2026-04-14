package interfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

public class Menu extends JFrame {
	
    private String idiomaSeleccionado = "Español";
    private String dificultad = "Normal";
    
    public Menu() {
        setTitle("Wordle UNGS");
        setResizable(false);
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        mostrarMenuPrincipal();
    }

    public void mostrarMenuPrincipal() {
        this.setContentPane(generarPanelMenu());
        this.revalidate();
        this.repaint();
    }

    private JPanel generarPanelMenu() {
        JPanel panelContenedor = new JPanel(new GridBagLayout());
        panelContenedor.setBackground(new Color(18, 18, 18));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0;
        JButton iniciar = crearBotónEstandar("Iniciar Partida");
        iniciar.addActionListener(escucharBoton -> iniciarJuego());
        panelContenedor.add(iniciar, gbc);

        gbc.gridy = 1;
        JButton idioma = crearBotónEstandar("Idioma");
        idioma.addActionListener(escucharBoton -> configurarIdioma());
        panelContenedor.add(idioma, gbc);

        gbc.gridy = 2;
        JButton dificultadBtn = crearBotónEstandar("Dificultad: " + dificultad);
        dificultadBtn.addActionListener(e -> {
            dificultad = dificultad.equals("Normal") ? "Difícil" : "Normal";
            dificultadBtn.setText("Dificultad: " + dificultad);
        });
        panelContenedor.add(dificultadBtn, gbc);
        
        gbc.gridy = 3;
        JButton salir = crearBotónEstandar("Salir");
        salir.addActionListener(escucharBoton -> System.exit(0));
        panelContenedor.add(salir, gbc);

        return panelContenedor;
    }

    private void iniciarJuego() {
        Tablero tablero = new Tablero(idiomaSeleccionado, dificultad, this);
        this.setContentPane(tablero);
        this.revalidate();
        this.repaint();
    }

    private void configurarIdioma() {
        String[] opciones = {"Español", "English", "Português","Deutsch","Avañe'ẽ"};
        int seleccion = JOptionPane.showOptionDialog(this, "Seleccione el idioma:", 
                "Configuración", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                null, opciones, opciones[0]);
        if (seleccion != -1) idiomaSeleccionado = opciones[seleccion];
    }
    
    private JButton crearBotónEstandar(String texto) {
        JButton boton = new JButton(texto);
        boton.setPreferredSize(new Dimension(200, 50));
        boton.setBackground(new Color(58, 58, 60));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        return boton;
    }
}
