package interfazGrafica;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


public class menu extends JFrame{

    public menu() {

        setTitle("Wordle - Menú Principal");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10); // espacio entre botones

        JButton iniciarPartida = new JButton("Iniciar Partida");

        iniciarPartida.setPreferredSize(new Dimension(200, 50));
        iniciarPartida.addActionListener(e -> {

//      aca se deberia de iniciar el tablero, junto al contador
    });

        JButton idioma = new JButton("Idioma");
        idioma.setPreferredSize(new Dimension(200, 50));
        idioma.addActionListener(e -> {
            //aca se deberia de crear una ventana donde retorne el idioma que se jugara
        });

        JButton ranking = new JButton("Ranking");
        ranking.setPreferredSize(new Dimension(200, 50));
        ranking.addActionListener(e -> {
         //Aca se deberia de mostrar el ranking de mejores tiempos
        });

        JButton salir = new JButton("Salir");
        salir.setPreferredSize(new Dimension(200, 50));
        salir.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Seguro que quieres salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        c.gridy = 0; panel.add(iniciarPartida, c);
        c.gridy = 1; panel.add(idioma, c);
        c.gridy = 3; panel.add(ranking, c);
        c.gridy = 4; panel.add(salir, c);

        add(panel, BorderLayout.CENTER);
    }
}

