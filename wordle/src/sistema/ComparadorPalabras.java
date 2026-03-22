package sistema;

import java.util.HashMap;
import java.util.Map;

public class ComparadorPalabras {

	String secreto;


	public ComparadorPalabras(String secreto) {
		this.secreto = secreto;
				//guarda solo la palabra que se elige del array de palabras
	}
	
	public EstadoLetra[] comparar(String adivinar) {
		//se ingresa por palametro la palabra que ingresa el usuario
		EstadoLetra[] palabra = new EstadoLetra[secreto.length()];

		for (int i = 0; i < secreto.length(); i++) {

			char a = adivinar.charAt(i);

			if (adivinar.charAt(i) == secreto.charAt(i)) {
				palabra[i] = EstadoLetra.VERDE;
			}
		}

		for (int i = 0; i < adivinar.length(); i++) {
			char g = adivinar.charAt(i);

			if (palabra[i] == null) { // no fue verde

				if (adivinar.contains(String.valueOf(secreto.charAt(i)))) {
					//si la letra en la posicion de i dentro de la palabra elegida
					//esta dentro de la palabra ingresada entra al if
					palabra[i] = EstadoLetra.AMARILLO;
				} else {
					palabra[i] = EstadoLetra.ROJO;
				}
			}
		}
		return palabra;
	}
}
