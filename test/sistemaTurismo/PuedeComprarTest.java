package sistemaTurismo;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PuedeComprarTest {
	
			public PerfilUsuario u1 = new PerfilUsuario("pepito", 100, 100, TipoDeAtraccion.AVENTURA);
			
	 		public Facturable a1 = new Atraccion ("a1", 10, 3, 1, TipoDeAtraccion.AVENTURA,0);
			public Facturable a2 = new Atraccion ("a2", 4, 2.5, 1, TipoDeAtraccion.AVENTURA,1);
			public Facturable a3 = new Atraccion ("a3", 2, 1, 1, TipoDeAtraccion.AVENTURA,2);
			public Facturable a4 = new Atraccion ("a4", 8, 4, 1, TipoDeAtraccion.AVENTURA,3);
			
			public List<Facturable> lista01 = new ArrayList<Facturable>();
			
			PromoAbsoluta p1 = new PromoAbsoluta(lista01, TipoDeAtraccion.AVENTURA, "Promocion Absoluta", 10);
			PromoPorcentual p2 = new PromoPorcentual(lista01, TipoDeAtraccion.AVENTURA, "Pack Aventura", 30);
			PromoAxB p3 = new PromoAxB(lista01, TipoDeAtraccion.AVENTURA, "Promo AxB", a2);
			PromoAbsoluta p4 = new PromoAbsoluta(lista01, TipoDeAtraccion.AVENTURA, "Promocion Absoluta", 5);
			
	@Test
	
	public void test01() {
		lista01.add(a1);
		lista01.add(a2);

		u1.agregarAtraccion(p1);
		assertFalse(u1.puedeComprar(a2));
	}
	
	@Test
	public void test02() {
		lista01.add(a1);
		lista01.add(a3);

		u1.agregarAtraccion(p1);
		assertFalse(u1.puedeComprar(p2));
	}
	
	@Test
	public void test03() {
		lista01.add(a2);
		lista01.add(a4);

		u1.agregarAtraccion(p3);
		assertFalse(u1.puedeComprar(p4));
	}
	
	

}
