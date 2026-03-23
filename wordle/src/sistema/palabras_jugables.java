package sistema;

import java.util.HashMap;

public class palabras_jugables {
	public static String[] palabras_español = {"veloz","libro","piano","arbol","playa"};
	public static String[] palabras_guarani = {"kunuũ","pyagu","yvytu","yvoty","piraĩ"};
	public static String[] palabras_ingles = {"light","water","sound","earth","bread"};
	public static String[] palabras_aleman = {"apfel","musik","tisch","glück","stadt"};
	HashMap<String, String[]> idiomas = new HashMap<>();
	
	
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