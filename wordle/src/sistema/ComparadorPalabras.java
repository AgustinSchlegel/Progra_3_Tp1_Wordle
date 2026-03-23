package sistema;

import java.util.HashMap;
import java.util.Map;

public class ComparadorPalabras {

	String secreto;
	
	public ComparadorPalabras(String adivinar) {
		
		this.secreto = secreto.toUpperCase();
	}
	
	public EstadoLetra[] comparar(String intento) {

		EstadoLetra[] palabra = new EstadoLetra[secreto.length()];
		
		Map<Character, Integer> contador = contarLetras(intento);
		
		for (int i = 0; i < secreto.length(); i++) {

			char a = secreto.charAt(i);

			if (secreto.charAt(i) == intento.charAt(i)) {
				palabra[i] = EstadoLetra.VERDE;
				contador.put(a, contador.getOrDefault(a, 0) - 1);
			}
		}

		for (int i = 0; i < secreto.length(); i++) {
			char g = secreto.charAt(i);

			if (palabra[i] == null) { // no fue verde

				if (contador.getOrDefault(g, 0) > 0) {
					palabra[i] = EstadoLetra.AMARILLO;

					// Resta la cantidad de veces que aparece
					contador.put(g, contador.getOrDefault(g, 0) - 1);

				} else {
					palabra[i] = EstadoLetra.GRIS;
				}
			}
		}
		return palabra;
	}
	
	public Map<Character,Integer> contarLetras(String palabra){
		
		Map<Character, Integer> contador = new HashMap<>();

	    for (char c : palabra.toCharArray()) {
	        contador.put(c, contador.getOrDefault(c, 0) + 1);
	    }
		return contador;
		
	}
}
