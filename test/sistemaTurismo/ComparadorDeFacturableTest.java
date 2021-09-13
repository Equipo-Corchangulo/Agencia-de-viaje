package sistemaTurismo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComparadorDeFacturableTest {
	
	
	ComparadorDeFacturable comparadorTest = new ComparadorDeFacturable(TipoDeAtraccion.AVENTURA);

		
	@Test
	public void compararDistintaPreferenciaTest() {
		Atraccion atraccionMoria = new Atraccion("Aventura", 10, 2, 6, TipoDeAtraccion.AVENTURA,0);
		Atraccion atraccionMinasTirith = new Atraccion("Paisaje", 5, 2.5, 25, TipoDeAtraccion.PAISAJE,1);
		assertEquals(-1, comparadorTest.compare(atraccionMoria, atraccionMinasTirith), 0);
	}

	@Test
	public void compararObtenerCostoTotalTest() {
		Atraccion atraccionMoria = new Atraccion("Aventura", 10, 2, 6, TipoDeAtraccion.AVENTURA,0);
		Atraccion atraccionMinasTirith = new Atraccion("Paisaje", 5, 2.5, 25, TipoDeAtraccion.PAISAJE,1);
		assertEquals(1, comparadorTest.compare(atraccionMinasTirith, atraccionMoria), 0);
		assertEquals(-1, comparadorTest.compare(atraccionMoria, atraccionMinasTirith), 0);
	}
	
	@Test
	public void compararObtenerTiempoTotalTest() {
		Atraccion atraccionAbismoDeHelm = new Atraccion("Paisaje", 5, 2, 15, TipoDeAtraccion.PAISAJE,4);
	    Atraccion atraccionLothlorien = new Atraccion("Degustacion", 35, 1, 30, TipoDeAtraccion.DEGUSTACION,5);
		assertEquals(-1, comparadorTest.compare(atraccionLothlorien, atraccionAbismoDeHelm), 0);
		assertEquals(1, comparadorTest.compare(atraccionAbismoDeHelm, atraccionLothlorien), 0);
	}
	
	@Test
	public void compararIgualesTest() {
		Atraccion atraccionAbismoDeHelm = new Atraccion("Paisaje", 5, 2, 15, TipoDeAtraccion.PAISAJE,4);
	    Atraccion atraccionPrueba = new Atraccion("Paisaje", 5, 2, 15, TipoDeAtraccion.PAISAJE,4);
		assertEquals(0, comparadorTest.compare(atraccionPrueba, atraccionAbismoDeHelm), 0);
	}
	
	
	
}
