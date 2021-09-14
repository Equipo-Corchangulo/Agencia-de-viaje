package sistemaTurismo;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PromoPorcentualTest {

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
		
	PromoPorcentual promo_uno = new PromoPorcentual(atraccion, TipoDeAtraccion.AVENTURA, "Pack Aventura", 20);
	

	@Test
	public void getPorcentajeDescuentoTest() {
		atraccion.add(atraccionMordor);
		atraccion.add(atraccionBosqueNegro);
		assertEquals(20, promo_uno.getPorcentajeDescuento(),0);
	}

	@Test
	public void obtenerCostoTotalTest() {
		atraccion.add(atraccionErebor);
		atraccion.add(atraccionAbismoDeHelm);
		assertEquals(13.6, promo_uno.obtenerCostoTotal(),0.001);
	}

}
