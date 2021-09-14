package sistemaTurismo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PromoAxBTest {
	
	public Facturable atraccionMoria = new Atraccion("Aventura", 10, 2, 6, TipoDeAtraccion.AVENTURA,0);
	public Facturable atraccionMinasTirith = new Atraccion("Paisaje", 5, 2.5, 25, TipoDeAtraccion.PAISAJE,1);
	public Facturable atraccionLaComarca = new Atraccion("Degustacion", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION,2);
	public Facturable atraccionMordor = new Atraccion("Aventura", 25, 3, 4, TipoDeAtraccion.AVENTURA,3);
	public Facturable atraccionAbismoDeHelm = new Atraccion("Paisaje", 5, 2, 15, TipoDeAtraccion.PAISAJE,4);
	public Facturable atraccionLothlorien = new Atraccion("Degustacion", 35, 1, 30, TipoDeAtraccion.DEGUSTACION,5);
	public Facturable atraccionErebor = new Atraccion("Paisaje", 12, 3, 32, TipoDeAtraccion.PAISAJE,6);
	public Facturable atraccionBosqueNegro = new Atraccion("Aventura", 3, 4, 12, TipoDeAtraccion.AVENTURA,7);
	public Facturable atraccionSpecial = new Atraccion("Aventura", 15, 3, 2, TipoDeAtraccion.AVENTURA,8);
	
	public List<Facturable> atraccion = new ArrayList<Facturable>();
	
	public List<Facturable> atraccionDePromo = new ArrayList<Facturable>();
	
	public PerfilUsuario usuario = new PerfilUsuario("Josy", 500, 10, TipoDeAtraccion.AVENTURA);
	
	PromoAxB promoAxB = new PromoAxB(atraccion, TipoDeAtraccion.AVENTURA, "Promo AxB", atraccionMordor);
	

	@Test
	public void obtenerTiempoTotalTest01() {
		atraccion.add(atraccionMinasTirith);
		atraccion.add(atraccionMoria);
		assertEquals(7.5, promoAxB.obtenerTiempoTotal(),0);
	}
	
	@Test
	public void obtenerTiempoTotalTest02() {
		atraccion.add(atraccionLaComarca);
		atraccion.add(atraccionAbismoDeHelm);
		assertEquals(11.5, promoAxB.obtenerTiempoTotal(),0);
	}
	
	@Test
	public void hayCupoTest() {
		assertTrue(promoAxB.hayCupo());	
	}
	
	@Test
	public void restarCupoTest() {
		atraccion.add(atraccionSpecial);
		promoAxB.restarCupo();
		assertTrue(atraccionSpecial.hayCupo());
		promoAxB.restarCupo();
		assertFalse(atraccionSpecial.hayCupo());
	}
	
	@Test
	public void seEncuentraEnElFacturableTest() {
		atraccion.add(atraccionErebor);
		atraccion.add(atraccionBosqueNegro);
		
		assertTrue(promoAxB.seEncuentraEnElFacturable(atraccionErebor));
		assertTrue(promoAxB.seEncuentraEnElFacturable(atraccionBosqueNegro));
		assertTrue(promoAxB.seEncuentraEnElFacturable(atraccionMordor));
		assertFalse(promoAxB.seEncuentraEnElFacturable(atraccionSpecial));
	}
}
