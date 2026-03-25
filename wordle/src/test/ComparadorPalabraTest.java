package test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import sistema.ComparadorPalabras;
import sistema.EstadoLetra;

/**
 * COMENTARIOS
 *  Hize el test con chatGPT para tener una revision rapida de algunos casos especificos. Pero resulta medio engorroso hacerlo
 * de esta manera, por lo que conviene directamente hacer las pruebas jugando. Asun asi la dejo para tenerlo a mano en caso de 
 * que alguien quiera usarlo para crear otro caso especifico.
 * */

public class ComparadorPalabraTest {

	
	@Test
    public void testTodoVerde() {
        ComparadorPalabras comp = new ComparadorPalabras("LIBRO");

        EstadoLetra[] resultado = comp.comparar("LIBRO");

        EstadoLetra[] esperado = {
            EstadoLetra.VERDE,
            EstadoLetra.VERDE,
            EstadoLetra.VERDE,
            EstadoLetra.VERDE,
            EstadoLetra.VERDE
        };

        assertArrayEquals(esperado, resultado);
    }

    @Test
    public void testCasoEjemploHielo() {
        ComparadorPalabras comp = new ComparadorPalabras("LIBRO");

        EstadoLetra[] resultado = comp.comparar("HIELO");

        EstadoLetra[] esperado = {
            EstadoLetra.GRIS,     // H
            EstadoLetra.VERDE,    // I
            EstadoLetra.GRIS,     // E
            EstadoLetra.AMARILLO, // L
            EstadoLetra.VERDE     // O
        };

        assertArrayEquals(esperado, resultado);
    }

    @Test
    public void testSinCoincidencias() {
        ComparadorPalabras comp = new ComparadorPalabras("LIBRO");

        EstadoLetra[] resultado = comp.comparar("AAAAA");

        EstadoLetra[] esperado = {
            EstadoLetra.GRIS,
            EstadoLetra.GRIS,
            EstadoLetra.GRIS,
            EstadoLetra.GRIS,
            EstadoLetra.GRIS
        };

        assertArrayEquals(esperado, resultado);
    }

    @Test
    public void testLetrasRepetidas() {
        ComparadorPalabras comp = new ComparadorPalabras("PERRO");

        EstadoLetra[] resultado = comp.comparar("RRRRR");

        EstadoLetra[] esperado = {
        	EstadoLetra.GRIS,
        	EstadoLetra.GRIS,
        	EstadoLetra.VERDE,
        	EstadoLetra.VERDE,
        	EstadoLetra.GRIS
            
        };

        assertArrayEquals(esperado, resultado);
    }

    @Test
    public void testMezclaCompleja() {
        ComparadorPalabras comp = new ComparadorPalabras("CASAS");

        EstadoLetra[] resultado = comp.comparar("SACOS");

        EstadoLetra[] esperado = {
            EstadoLetra.AMARILLO, // S
            EstadoLetra.AMARILLO, // A
            EstadoLetra.AMARILLO, // C
            EstadoLetra.GRIS,     // O
            EstadoLetra.VERDE     // S
        };

        assertArrayEquals(esperado, resultado);
    }
}
