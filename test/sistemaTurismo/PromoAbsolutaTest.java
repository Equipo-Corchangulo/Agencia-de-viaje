package sistemaTurismo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PromoAbsolutaTest {

	public List<Facturable> atraccion = new ArrayList<Facturable>();
	
	PromoAbsoluta promoAbs = new PromoAbsoluta(atraccion, TipoDeAtraccion.DEGUSTACION, "Promocion Absoluta", 11);

	@Test
	public void esPromocionTest() {
		assertTrue(promoAbs.esPromocion());
	}
	
	@Test
	public void obtenerCostoTotalTest() {
		assertEquals(11,promoAbs.obtenerCostoTotal(), 0);	
	}

}
