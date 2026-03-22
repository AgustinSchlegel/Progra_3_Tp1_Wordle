package sistema;

import java.util.HashMap;
import java.util.Map;

public class ComparadorPalabras {

	String adivinar;
	String secreto;
	
	Map<Character,Integer> contador; //Cantidad de ves que aparece cada letra
	

	public ComparadorPalabras(String adivinar, String secreto) {
		
		this.adivinar = adivinar;
		this.secreto = secreto;
		this.contador = new HashMap<Character, Integer>();
		
		for (char c : secreto.toCharArray()) {
		    contador.put(c, contador.getOrDefault(c, 0) + 1);
		}
	}
	
	public EstadoLetra[] comparar() {

		EstadoLetra[] palabra = new EstadoLetra[adivinar.length()];

		for (int i = 0; i < adivinar.length(); i++) {

			char a = adivinar.charAt(i);

			if (adivinar.charAt(i) == secreto.charAt(i)) {
				palabra[i] = EstadoLetra.VERDE;
				contador.put(a, contador.get(a) - 1);
			}
		}

		for (int i = 0; i < adivinar.length(); i++) {
			char g = adivinar.charAt(i);

			if (palabra[i] == null) { // no fue verde

				if (contador.getOrDefault(g, 0) > 0) {
					palabra[i] = EstadoLetra.AMARILLO;

					// Resta la cantidad de veces que aparece
					contador.put(g, contador.get(g) - 1);

				} else {
					palabra[i] = EstadoLetra.ROJO;
				}
			}
		}
		return palabra;
	}
}
