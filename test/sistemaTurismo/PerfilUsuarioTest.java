package sistemaTurismo;

import static org.junit.Assert.*;

import org.junit.Test;


public class PerfilUsuarioTest {

		PerfilUsuario Eowyn = new PerfilUsuario("Eowyn", 10, 8, TipoDeAtraccion.AVENTURA);
		PerfilUsuario Gandalf = new PerfilUsuario("Gandalf", 100, 5, TipoDeAtraccion.PAISAJE);
		PerfilUsuario Sam = new PerfilUsuario("Sam", 36, 8, TipoDeAtraccion.DEGUSTACION);
		PerfilUsuario Galadriel = new PerfilUsuario("Galadriel", 0, 6, TipoDeAtraccion.PAISAJE);
	
	        Atraccion atraccionMoria = new Atraccion("Aventura", 10, 2, 6, TipoDeAtraccion.AVENTURA,0);
	        Atraccion atraccionMinasTirith = new Atraccion("Paisaje", 15, 2.5, 25, TipoDeAtraccion.PAISAJE,1);
	        Atraccion atraccionLaComarca = new Atraccion("Degustacion", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION,2);

	@Test
	public void getPresupuestoTest() {
		assertEquals(10, Eowyn.getPresupuesto(), 0);
		assertEquals(100, Gandalf.getPresupuesto(), 0);
		assertEquals(36, Sam.getPresupuesto(), 0);
		assertEquals(0, Galadriel.getPresupuesto(), 0);
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
		Eowyn.reservarTiempoYdinero(atraccionLaComarca);
		assertEquals(7, Eowyn.getPresupuesto(), 0);
		assertEquals(1.5, Eowyn.getTiempoDisponible(), 0);		
	}
	
	@Test
	public void tieneTiempoYdineroTest() {
		assertTrue(Eowyn.tieneTiempoYdinero());
		assertTrue(Gandalf.tieneTiempoYdinero());
		assertTrue(Sam.tieneTiempoYdinero());
		assertFalse(Galadriel.tieneTiempoYdinero());
	}
	
	@Test
	public void puedeComprarTest() {
                assertTrue(Gandalf.puedeComprar(atraccionMoria));
                assertFalse(Eowyn.puedeComprar(atraccionMinasTirith));
	}
	
}
