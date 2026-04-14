package sistema;

import java.util.HashMap;

public class PalabrasJugables {
    public static String[] palabras_español = {
            "veloz", "libro", "piano", "arbol", "playa", "cielo", "fuego", "carta", "monte", "ahora",
            "brazo", "clase", "disco", "enero", "fruta", "globo", "hielo", "islas", "juego", "kilos",
            "lapiz", "metro", "nieve", "orden", "perro", "queso", "radio", "selva", "tigre", "union",
            "vuelo", "wafer", "extra", "yegua", "zorro", "punto", "nacer", "llave", "hongo", "calle"
    };

    public static String[] palabras_guarani = {
            "kunuu", "pyagu", "yvytu", "yvoty", "pirai", "ysyry", "ygate", "akare", "mainu", "tembi",
            "akara", "yrasy", "guyra", "tyapu", "itaky", "apyka", "pinda", "keray", "sagua", "mandy",
            "ovava", "mante", "kyhyj", "tapey", "yvaga", "angua", "poaty", "neeti", "porai", "momby",
            "tapia", "hekue", "kamba", "avati", "mitai", "vakaa", "yvoty", "kaagu", "pukavy", "marai"
    };

    public static String[] palabras_ingles = {
            "light", "water", "sound", "earth", "bread", "stone", "cloud", "river", "flame", "night",
            "house", "world", "music", "heart", "smile", "dream", "green", "black", "white", "sugar",
            "fruit", "storm", "beach", "phone", "table", "chair", "space", "power", "money", "paper",
            "voice", "ocean", "small", "large", "young", "early", "short", "clear", "point", "heavy"
    };

    public static String[] palabras_aleman = {
            "apfel", "musik", "tisch", "gluck", "stadt", "blume", "feuer", "traum", "nacht", "brief",
            "abend", "vogel", "sonne", "fluss", "natur", "sturm", "pferd", "kleid", "lampe", "licht",
            "farbe", "sport", "platz", "reise", "preis", "milch", "stuck", "stuhl", "kuche", "tante",
            "onkel", "bauer", "radio", "leben", "vater", "stein", "unten", "immer", "heute", "klein"
    };

    public static String[] palabras_portugues = {
            "tempo", "plano", "noite", "festa", "livro", "chuva", "pedra", "vento", "campo", "sonho",
            "corpo", "mente", "valor", "mundo", "folha", "peixe", "praia", "porto", "terra", "fruta",
            "calor", "carro", "porta", "braco", "canto", "viver", "achar", "olhar", "sorte", "grade",
            "ponto", "falar", "andar", "lugar", "chave", "negro", "fundo", "baixo", "preto", "norte"
    };
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