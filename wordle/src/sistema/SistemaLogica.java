package sistema;

public class SistemaLogica {
	private String palabraSecreta;
	private int intentos;
	private final int max_intentos = 5;
	
	public SistemaLogica(String palabraSecreta) {
		this.palabraSecreta = palabraSecreta;
		this.intentos = 0;
	}
	
	public EstadoLetra[] intentar(String palabra) {
        intentos++;
        ComparadorPalabras comp = new ComparadorPalabras(palabraSecreta);
        return comp.comparar(palabra);
    }

    public boolean victoria(String palabra) {
        return palabra.equalsIgnoreCase(palabraSecreta);
    }

    public boolean derrota() {
        return intentos >= max_intentos;
    }

	public String getPalabraSecreta() {
		return palabraSecreta;
	}
}
