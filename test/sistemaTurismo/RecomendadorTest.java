package sistemaTurismo;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RecomendadorTest {

	@Test
	public void test() {
		Atraccion atraccion1 = new Atraccion("Moria",10.0,2,6,TipoDeAtraccion.AVENTURA,0);
		Atraccion atraccion2 = new Atraccion("Bosque Negro",3,4,12,TipoDeAtraccion.AVENTURA,7);
		List<Facturable> listaAtracciones = new ArrayList<>();
		listaAtracciones.add(atraccion1);
		listaAtracciones.add(atraccion2);
		Promocion promocion1 = new PromoPorcentual(listaAtracciones,TipoDeAtraccion.AVENTURA,"Pack Aventura Test",20);
		List<Facturable> listaDeFacturables = new ArrayList<>();
		listaDeFacturables.add(atraccion1);
		listaDeFacturables.add(atraccion2);
		listaDeFacturables.add(promocion1);
		List<PerfilUsuario> listaDeUsuarios = new ArrayList<>();
		listaDeUsuarios.add(new PerfilUsuario("Irina", 100.0,50,TipoDeAtraccion.AVENTURA));
		Recomendador recomendador = new Recomendador(listaDeUsuarios, listaDeFacturables);
		String input = "1";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		recomendador.ofrecerSugerencias();

		assertTrue(listaDeUsuarios.get(0).getTiempoDisponible() == 44);

	}

}
