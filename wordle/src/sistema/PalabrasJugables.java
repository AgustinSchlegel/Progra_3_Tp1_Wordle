package sistema;

import java.util.HashMap;

public class PalabrasJugables {
	public static String[] palabras_español = {"veloz","libro","piano","arbol","playa","cielo","fuego","carta","monte","ahora"};
	public static String[] palabras_guarani = {"kunuũ","pyagu","yvytu","yvoty","piraĩ","ka'ag","ysyry","tata ","ygate","mba'e"};
	public static String[] palabras_ingles = {"light","water","sound","earth","bread","stone","cloud","river","flame","night"};
	public static String[] palabras_aleman = {"apfel","musik","tisch","glück","stadt","blume","feuer","traum","nacht","brief"};
	public static String[] palabras_portugues = {"tempo","plano","noite","festa","livro","chuva","pedra","vento","campo","sonho"};

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

        if (diccionario == null) {
            diccionario = idiomas.get("Español");
        }

        int random = (int)(Math.random() * diccionario.length);
        return diccionario[random];
    }
}