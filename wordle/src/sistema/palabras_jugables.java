package sistema;

import java.util.HashMap;

public class palabras_jugables {
	public static String[] palabras_español = {"veloz","libro","piano","arbol","playa"};
	public static String[] palabras_guarani = {"kunuũ","pyagu","yvytu","yvoty","piraĩ"};
	public static String[] palabras_ingles = {"light","water","sound","earth","bread"};
	public static String[] palabras_aleman = {"apfel","musik","tisch","glück","stadt"};
	public static String[] palabras_portugues = {"Tempo", "Plano", "Noite", "Festa", "Livro"};

	static HashMap<String, String[]> idiomas = new HashMap<>();
	
	static {
        idiomas.put("Español", palabras_español);
        idiomas.put("English", palabras_ingles);
        idiomas.put("Português", palabras_portugues);
        idiomas.put("Deutsch", palabras_aleman);
        idiomas.put("Avañe'ẽ", palabras_guarani);
    }
	
	public String[] obtenerPalabras(String idiomaElegido) {
        return idiomas.get(idiomaElegido);
    }
	
	public static String seleccionarPalabra(String nombreIdioma) {
        String[] diccionario = idiomas.get(nombreIdioma);

        // Si hay algún error, cargamos español por defecto para evitar que explote
        if (diccionario == null) {
            diccionario = idiomas.get("Español");
        }

        int random = (int)(Math.random() * diccionario.length);
        return diccionario[random];
    }
}