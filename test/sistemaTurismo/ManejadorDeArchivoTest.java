package sistemaTurismo;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ManejadorDeArchivoTest {

	@Test
	public void obtenerUsuariosTest() {
		List<PerfilUsuario> usuarios = ManejadorDeArchivo.obtenerUsuario("files/UsuariosTest.txt");
		PerfilUsuario usuario = new PerfilUsuario("Irina", 100.0,50,TipoDeAtraccion.AVENTURA);
		assertTrue(usuarios.size() == 1);
		assertEquals(usuarios.get(0), usuario);

	}

	@Test
	public void obtenerFacturableTest(){
		List<Facturable> facturables = ManejadorDeArchivo.obtenerFacturables("files/AtraccionesTest.txt", "files/PromocionesTest.txt");
		Atraccion atraccion1 = new Atraccion("Moria",10.0,2,6,TipoDeAtraccion.AVENTURA,0);
		Atraccion atraccion2 = new Atraccion("Bosque Negro",3,4,12,TipoDeAtraccion.AVENTURA,7);
		List<Facturable> listaAtracciones = new ArrayList<>();
		listaAtracciones.add(atraccion1);
		listaAtracciones.add(atraccion2);
		Promocion promocion1 = new PromoPorcentual(listaAtracciones,TipoDeAtraccion.AVENTURA,"Pack Aventura Test",20);
		assertEquals(atraccion1, facturables.get(0));
		assertEquals(atraccion2, facturables.get(1));
		assertEquals(promocion1, facturables.get(2));
		assertTrue(facturables.size() == 3);
	}

}
