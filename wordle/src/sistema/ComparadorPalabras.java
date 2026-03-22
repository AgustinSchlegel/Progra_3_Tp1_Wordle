package sistema;

public class ComparadorPalabras {

	String adivinar;
	String secreto;
	
	public ComparadorPalabras(String adivinar, String secreto) {
		
		this.adivinar = adivinar;
		this.secreto = secreto;
	}
	
	public void comparar() {
		
		boolean[] acertado = new boolean[secreto.length()];
		
		for (int i = 0; i < adivinar.length(); i++) {
			if(adivinar.charAt(i) == secreto.charAt(i)) {
				acertado[i]= true;
			}
		}
	}
}
