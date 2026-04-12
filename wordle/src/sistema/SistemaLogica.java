package sistema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SistemaLogica {
	private String palabraSecreta;
	private int intentoActual;
	private final int max_intentos = 6;
	private String ranking;
	
	public SistemaLogica(String palabraSecreta) {
		this.palabraSecreta = palabraSecreta;
		this.intentoActual = 0;
	}

	public String getRanking(){
		return ranking;
	}

	public void cargarRanking(String nuevoRanking){
		if (ranking==null){
			this.ranking=nuevoRanking;
		}
		List<String> lineas = new ArrayList<>(Arrays.asList(ranking.split("\n")));

		lineas.add(nuevoRanking);

		if(lineas.size() > 6) lineas.remove(0);

		this.ranking = String.join("\n", lineas);
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
