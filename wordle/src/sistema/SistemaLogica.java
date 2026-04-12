package sistema;

public class SistemaLogica {
	private String palabraSecreta;
	private int intentoActual;
	private final int max_intentos = 6;
	
	public SistemaLogica(String palabraSecreta) {
		this.palabraSecreta = palabraSecreta;
		this.intentoActual = 0;
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
