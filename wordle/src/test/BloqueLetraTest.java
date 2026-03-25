package test;
import javax.swing.JFrame;

import interfazGrafica.BloqueLetra;
import sistema.EstadoLetra;

public class BloqueLetraTest {

	public static void main(String[] args) {
        JFrame ventana = new JFrame("Test Bloque");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BloqueLetra bloque = new BloqueLetra();
        bloque.cargarLetra('A', EstadoLetra.VERDE);

        ventana.add(bloque);
        ventana.pack();
        ventana.setVisible(true);
    }
}
