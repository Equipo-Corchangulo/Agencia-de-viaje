package sistemaTurismo;

import static org.junit.Assert.*;

import org.junit.Test;


public class PerfilUsuarioTest {

		PerfilUsuario Eowyn = new PerfilUsuario("Eowyn", 10, 8, TipoDeAtraccion.AVENTURA);
		PerfilUsuario Gandalf = new PerfilUsuario("Gandalf", 100, 5, TipoDeAtraccion.PAISAJE);
		PerfilUsuario Sam = new PerfilUsuario("Sam", 36, 8, TipoDeAtraccion.DEGUSTACION);
		PerfilUsuario Galadriel = new PerfilUsuario("Galadriel", 120, 6, TipoDeAtraccion.PAISAJE);

	@Test
	public void getPresupuestoTest() {
		assertEquals(10, Eowyn.getPresupuesto(), 0);
		assertEquals(100, Gandalf.getPresupuesto(), 0);
		assertEquals(36, Sam.getPresupuesto(), 0);
		assertEquals(120, Galadriel.getPresupuesto(), 0);
	}
	
	@Test
	public void getTiempoDisponibleTest() {
		assertEquals(8, Eowyn.getTiempoDisponible(), 0);
		assertEquals(5, Gandalf.getTiempoDisponible(), 0);
		assertEquals(8, Sam.getTiempoDisponible(), 0);
		assertEquals(6, Galadriel.getTiempoDisponible(), 0);
	}
	
	@Test
	public void getTipoDeAtraccionTest() {
		assertEquals(TipoDeAtraccion.AVENTURA, Eowyn.getTipoDeAtraccion());
		assertEquals(TipoDeAtraccion.PAISAJE, Gandalf.getTipoDeAtraccion());
		assertEquals(TipoDeAtraccion.DEGUSTACION, Sam.getTipoDeAtraccion());
		assertEquals(TipoDeAtraccion.PAISAJE, Galadriel.getTipoDeAtraccion());
	}
	
	@Test
	public void getNombreTest() {
		assertEquals("Eowyn", Eowyn.getNombre());
		assertEquals("Gandalf", Gandalf.getNombre());
		assertEquals("Sam", Sam.getNombre());
		assertEquals("Galadriel", Galadriel.getNombre());
	}
	
	@Test
	public void reservarTiempoYDineroTest() {
		
	}
	
	@Test
	public void tieneTiempoYdineroTest() {
		assertTrue(Eowyn.tieneTiempoYdinero());
		assertTrue(Gandalf.tieneTiempoYdinero());
		assertTrue(Sam.tieneTiempoYdinero());
		assertTrue(Galadriel.tieneTiempoYdinero());
	}
	
	@Test
	public void puedeComprarTest() {

	}
	
}