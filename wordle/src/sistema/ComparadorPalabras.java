package sistema;

import java.util.HashMap;
import java.util.Map;

public class ComparadorPalabras {

	String secreto;
	
	public ComparadorPalabras(String secreto) {
		
		this.secreto = secreto.toUpperCase();
	}
	
	public EstadoLetra[] comparar(String intento) {

		EstadoLetra[] palabra = new EstadoLetra[secreto.length()];
		
		Map<Character, Integer> contador = contarLetras(secreto);

		// Verdes
		for (int i = 0; i < secreto.length(); i++) {
		    if (secreto.charAt(i) == intento.charAt(i)) {
		        palabra[i] = EstadoLetra.VERDE;

		        char letra = intento.charAt(i);
		        contador.put(letra, contador.get(letra) - 1);
		    }
		}

		// Amarillos y grises
		for (int i = 0; i < secreto.length(); i++) {
		    if (palabra[i] == null) {

		        char letra = intento.charAt(i);

		        if (contador.getOrDefault(letra, 0) > 0) {
		            palabra[i] = EstadoLetra.AMARILLO;
		            contador.put(letra, contador.get(letra) - 1);
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
	        contador.put(c, contador.getOrDefault(c, 0) + 1); //Cada vez que aparece una letra, suma 1. En caso de que no exista, pone 0
	    }
		return contador;
		
	}
}
