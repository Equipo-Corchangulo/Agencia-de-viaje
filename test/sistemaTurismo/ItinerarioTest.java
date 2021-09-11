package sistemaTurismo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/*import static org.junit.Assert.assertArrayEquals;*/

public class ItinerarioTest {
	
	  
	@Test
	public void testuno() {
		 List<Facturable> ListaDeVisitasEsperada = new ArrayList<Facturable>();
		  ListaDeVisitasEsperada.add(new Atraccion("Aventura", 10, 2, 6, TipoDeAtraccion.AVENTURA,1));
		  List<Facturable> ListaDeVisitasFinal = new ArrayList<Facturable>();
		  ListaDeVisitasFinal.add(new Atraccion("Aventura", 10, 2, 6, TipoDeAtraccion.AVENTURA,1));
		  assertArrayEquals(ListaDeVisitasEsperada.toArray(), ListaDeVisitasFinal.toArray() );

	}
	
	@Test
	public void getListaDeVisitasTest() {
  		List<Facturable> ListaDeVisitasEsperada = new ArrayList<Facturable>();
  		Facturable atraccion = new Atraccion("Aventura", 10, 2, 6, TipoDeAtraccion.AVENTURA,0);
  		PerfilUsuario usuario = new PerfilUsuario("Irina",10.0,5,TipoDeAtraccion.AVENTURA);
		Itinerario prueba01 = new Itinerario(usuario);

  		ListaDeVisitasEsperada.add(atraccion);
  		prueba01.agregarAtraccion(atraccion);
  		assertEquals(ListaDeVisitasEsperada, prueba01.getListaDeVisitas());

	}
	
	
	

}
