package sistemaTurismo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ItinerarioTest {
	public Facturable atraccionMoria = new Atraccion("Aventura", 10, 2, 6, TipoDeAtraccion.AVENTURA,0);
	public Facturable atraccionMinasTirith = new Atraccion("Paisaje", 5, 2.5, 25, TipoDeAtraccion.PAISAJE,1);
	public Facturable atraccionLaComarca = new Atraccion("Degustacion", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION,2);
	public Facturable atraccionMordor = new Atraccion("Aventura", 25, 3, 4, TipoDeAtraccion.AVENTURA,3);
	public Facturable atraccionAbismoDeHelm = new Atraccion("Paisaje", 5, 2, 15, TipoDeAtraccion.PAISAJE,4);
	public Facturable atraccionLothlorien = new Atraccion("Degustacion", 35, 1, 30, TipoDeAtraccion.DEGUSTACION,5);
	public Facturable atraccionErebor = new Atraccion("Paisaje", 12, 3, 32, TipoDeAtraccion.PAISAJE,6);
	public Facturable atraccionBosqueNegro = new Atraccion("Aventura", 3, 4, 12, TipoDeAtraccion.AVENTURA,7);
	
	public List<Facturable> atraccion = new ArrayList<Facturable>();
	
	public List<Facturable> atraccionDePromo = new ArrayList<Facturable>();
	
	public PerfilUsuario usuario = new PerfilUsuario("Irina", 1000, 100, TipoDeAtraccion.AVENTURA);
	
	  

	@Test
	public void getHorasNecesariasTest() {
		usuario.agregarAtraccion(atraccionMoria);
		usuario.agregarAtraccion(atraccionBosqueNegro);
		assertEquals(6, usuario.getItinerario().getHorasNecesarias(), 0);
	}
	
	@Test
	public void getCostoMonedasTest() {
		usuario.agregarAtraccion(atraccionMoria);
		usuario.agregarAtraccion(atraccionBosqueNegro);
		assertEquals(13, usuario.getItinerario().getCostoMonedas(), 0);
	}
	
	@Test
	public void poseeAtraccionTest() {
		atraccion.add(atraccionMoria);
		atraccion.add(atraccionBosqueNegro);
		atraccionDePromo.add(atraccionMoria);
		atraccionDePromo.add(atraccionMordor);
		   
		Facturable promoPorcentual = new PromoPorcentual(atraccionDePromo,TipoDeAtraccion.AVENTURA , "Promo 1", 0.5);
		Facturable promoAxB = new PromoAxB(atraccionDePromo,TipoDeAtraccion.AVENTURA , "Promo 2", atraccionMordor);

		usuario.agregarAtraccion(promoPorcentual);
			
		assertTrue(usuario.getItinerario().poseeAtraccion(promoAxB));
		atraccion.clear();
		atraccionDePromo.clear();
	}
	   
	@Test 	   
	public void poseeAtraccionTest2() {
		atraccion.add(atraccionMoria);
		atraccion.add(atraccionBosqueNegro);
		Facturable promoPorcentual = new PromoPorcentual(atraccion,TipoDeAtraccion.AVENTURA , "Promo 1", 0.5);

		usuario.agregarAtraccion(promoPorcentual);
		Itinerario itinerario = usuario.getItinerario();
		assertTrue(itinerario.poseeAtraccion(atraccionMoria));
		assertTrue(itinerario.poseeAtraccion(atraccionBosqueNegro));
		assertFalse(itinerario.poseeAtraccion(atraccionErebor));
		atraccion.clear();
		atraccionDePromo.clear();	
	   }
}
