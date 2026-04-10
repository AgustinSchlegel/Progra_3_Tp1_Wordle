package interfazGrafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelSuperior extends Panel{
	
	private JLabel labelTiempoTexto;
    private JLabel labelTiempo;
    private Timer cronometro;
    private int tiempoTranscurrido;
    private Tablero tablero;
    
	public static void main(String[] args) {
		new PanelSuperior();
	}
	
	public PanelSuperior() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		labelTiempoTexto = new JLabel("Tiempo:");
		labelTiempoTexto.setForeground(Color.WHITE);
		add(labelTiempoTexto);
		
		
		labelTiempo = new JLabel("00:00");
		labelTiempo.setFont(new Font("Arial", Font.BOLD, 14));
		labelTiempo.setForeground(Color.GREEN);
		add(labelTiempo);
		
		JButton botonPista = new JButton("Pista");
		botonPista.setBackground(new Color(181, 159, 59));
		botonPista.setForeground(Color.WHITE);
		botonPista.addActionListener(e -> {
		    if (tablero != null) {
		        tablero.darPista();
		    }
		});

		add(botonPista);
	}
	
	public void iniciarCronometro() {
		pararCronometro();
		
		tiempoTranscurrido = 0;
		actualizarTiempo();
		
		TimerTask task = new TimerTask() {
			public void run() {
				tiempoTranscurrido++;
				actualizarTiempo();
			}
		};
		cronometro = new Timer();
		cronometro.scheduleAtFixedRate(task, 1000, 1000);
	}

	public void actualizarTiempo() {
		Runnable runnable = new Runnable() {
			public void run() {
				labelTiempo.setText(getTiempo());
			}
		};
		EventQueue.invokeLater(runnable);	
	}

	public void pararCronometro() {
		if (cronometro != null) {
			cronometro.cancel();
		}
	}

	public String getTiempo() {
		int minutos = tiempoTranscurrido / 60;
	    int segundos = tiempoTranscurrido % 60;
	    return String.format("%02d:%02d", minutos, segundos);
	}
	
	public void setTablero(Tablero tablero) {
	    this.tablero = tablero;
	}
}
