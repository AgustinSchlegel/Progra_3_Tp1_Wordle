package sistema;

import java.util.HashMap;

public class palabras_jugables {
	static String[] palabras_español = {"Veloz","Libro","Piano","Arbol","Playa"};
	static String[] palabras_guarani = {"Kunuũ","Pyagu","Yvytu","Yvoty","Piraĩ"};
	static String[] palabras_ingles = {"Light","Water","Sound","Earth","Bread"};
	static String[] palabras_aleman = {"Apfel","Musik","Tisch","Glück","Stadt"};
	HashMap<String, String[]> idiomas;
	
	
	public palabras_jugables() {
        // Así se agregan correctamente:
		idiomas.put("Español", palabras_español);
        idiomas.put("Guarani", palabras_guarani);
        idiomas.put("Ingles", palabras_ingles);
        idiomas.put("Aleman", palabras_aleman);
    }
	
	public String[] obtenerPalabras(String idiomaElegido) {
        return idiomas.get(idiomaElegido);
    }
	
	public static String seleccionarPalabra(String[]idioma) {
		int random = (int)(Math.random() * 5);
		String palabra = idioma[random];
		return palabra;
	}
	
	
	
}