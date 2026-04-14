package sistema;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SistemaLogica {
	private String palabraSecreta;
	private int intentoActual;
	private final int max_intentos = 6;
	private String ranking;
	
	public SistemaLogica(String palabraSecreta) {
		this.palabraSecreta = palabraSecreta;
		this.intentoActual = 0;
		this.ranking = cargarRankingDesdeArchivo();
	}

	public String getRanking(){
		return ranking;
	}

	public void cargarRanking(String nuevoRanking) {
        if (ranking == null) ranking = "";
        
        List<String> lineas = new ArrayList<>();
        if (!ranking.isEmpty()) {
            lineas.addAll(Arrays.asList(ranking.split("\n")));
        }

        lineas.add(nuevoRanking);
        lineas.sort((a,b) -> {
        	int tiempoA = parsearTiempo(a);
        	int tiempoB = parsearTiempo(b);
        	return Integer.compare(tiempoA, tiempoB);
        });
        
        if (lineas.size() > 6) lineas.remove(lineas.size() -1);
        this.ranking = String.join("\n", lineas);
        guardarRankingEnArchivo(this.ranking);
    }

	private void guardarRankingEnArchivo(String datosDeRanking) {
	    try {
	        FileWriter escritorDeRanking = new FileWriter("ranking.txt");
	        escritorDeRanking.write(datosDeRanking);
	        escritorDeRanking.close(); 
	    } catch (Exception e) {
	        System.out.println("Error: No se pudo actualizar el archivo de ranking.");
	    }
	}

	private String cargarRankingDesdeArchivo() {
	    String rankingAcumulado = "";
	    File archivoRanking = new File("ranking.txt");
	    
	    if (!archivoRanking.exists()) {
	        return "";
	    }

	    try {
	        Scanner escaneadorDeArchivo = new Scanner(archivoRanking);
	        while (escaneadorDeArchivo.hasNextLine()) {
	            rankingAcumulado += escaneadorDeArchivo.nextLine() + "\n";
	        }
	        escaneadorDeArchivo.close();
	    } catch (Exception e) {
	        System.out.println("Error: No se pudo leer el historial de puntajes.");
	    }
	    return rankingAcumulado.trim();
	}
	
	private int parsearTiempo(String entrada) {
	    try {
	        String tiempo = entrada.substring(entrada.lastIndexOf("-") + 1).trim(); // "01:23"
	        String[] partes = tiempo.split(":");
	        int minutos = Integer.parseInt(partes[0]);
	        int segundos = Integer.parseInt(partes[1]);
	        return minutos * 60 + segundos;
	    } catch (Exception e) {
	        return Integer.MAX_VALUE;
	    }
	}
	
	public EstadoLetra[] intentar(String palabra) {
		this.intentoActual++;
        ComparadorPalabras comp = new ComparadorPalabras(palabraSecreta);
        return comp.comparar(palabra);
    }

    public boolean victoria(String palabra) {
        return palabra.equalsIgnoreCase(palabraSecreta);
    }

    public boolean derrota() {
        return intentoActual >= max_intentos;
    }

	public String getPalabraSecreta() {
		return palabraSecreta;
	}
	
	public int getIntentoActual() {
	    return this.intentoActual;
	}

	
	public int INTENTOS_MAXIMOS() {
		return this.max_intentos;
	}
}
