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
        ComparadorPalabras comp = new ComparadorPalabras(palabra, palabraSecreta);
        return comp.comparar();
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
	
	public int getIntentos() {
	    return this.intentos; 
	}

	public void sumarIntento() {
		this.intentos++;		
	}
}
