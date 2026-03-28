import javax.swing.JFrame;
import javax.swing.JOptionPane;

import interfazGrafica.EscuchadorMenu;
import interfazGrafica.Panel_Menu;
import interfazGrafica.Tablero;

public class Ventana_Principal extends JFrame implements EscuchadorMenu{
	public Ventana_Principal() {
        setTitle("Wordle Profesional");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
	
	public void mostrarMenu() {
        Panel_Menu menu = new Panel_Menu();
        menu.setEscuchador(this);
        this.setContentPane(menu);
    }
    

	@Override
	public void IniciarPartida(String idioma) {
		Tablero tablero = new Tablero(idioma);
	    this.setContentPane(tablero);
	    this.revalidate();
	    this.repaint();
    }

	@Override
	public void MostrarRanking() {
		JOptionPane.showMessageDialog(this, "Ranking: (Próximamente)");
	}

	@Override
	public void Salir() {
	    int confirm = JOptionPane.showConfirmDialog(this,
	            "¿Seguro que quieres salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
	    if (confirm == JOptionPane.YES_OPTION) {
	        System.exit(0);
	    }
	}
}
