package sistema;

public class logica_Seleccion {
	static String[] palabras_español = {"Veloz","Libro","Piano","Arbol","Playa"};
	static String[] palabras_guarani = {"Kunuũ","Pyagu","Yvytu","Yvoty","Piraĩ"};
	static String[] palabras_ingles = {"Light","Water","Sound","Earth","Bread"};
	static String[] palabras_aleman = {"Apfel","Musik","Tisch","Glück","Stadt"};
	
	public static void main(String[] args) {
		System.out.println(seleccionarPalabra(palabras_español));
	}
	
	public static String seleccionarPalabra(String[]idioma) {
		int random = (int)(Math.random() * 5);
		String palabra = idioma[random];
		return palabra;
	}
	
	
	
}