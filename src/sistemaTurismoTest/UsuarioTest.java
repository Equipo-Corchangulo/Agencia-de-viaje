package sistemaTurismoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import sistemaTurismo.Atraccion;
import sistemaTurismo.PerfilUsuario;
import sistemaTurismo.TipoDeAtraccion;

public class UsuarioTest {

	@Test 
	public void UsuarioTest() {
		PerfilUsuario micaela = new PerfilUsuario("Micaela", 100, 80, TipoDeAtraccion.AVENTURA);
		assertEquals("Micaela", micaela.getNombre());
		assertEquals(100, micaela.getPresupuesto(), 0.001);
		assertEquals(80, micaela.getTiempoDisponible(), 0.001);
		assertEquals(TipoDeAtraccion.AVENTURA, micaela.getTipoDeAtraccion());
				
	 }
  }
