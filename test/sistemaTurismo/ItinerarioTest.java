package sistemaTurismo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/*import static org.junit.Assert.assertArrayEquals;*/

public class ItinerarioTest {
	
	  
	/*@Test
	public void test() {
		 /* List<Facturable> ListaDeVisitasEsperada = new ArrayList<Facturable>();
		  ListaDeVisitasEsperada.add(new Atraccion("Aventura", 10, 2, 6, TipoDeAtraccion.AVENTURA));
		  List<Facturable> ListaDeVisitasFinal = new ArrayList<Facturable>();
		  ListaDeVisitasFinal.add(new Atraccion("Aventura", 10, 2, 6, TipoDeAtraccion.AVENTURA));
		  assertArrayEquals(ListaDeVisitasEsperada.toArray(), ListaDeVisitasFinal.toArray() );

	}*/
	
	@Test
	public void getListaDeVisitasTest() {
		  List<Facturable> ListaDeVisitasEsperada = new ArrayList<Facturable>();
		  ListaDeVisitasEsperada.add(new Atraccion("Aventura", 10, 2, 6, TipoDeAtraccion.AVENTURA));
		  Itinerario prueba01 = new Itinerario();
		  assertEquals(ListaDeVisitasEsperada, prueba01.getListaDeVisitas());

	}
	
	
	

}
