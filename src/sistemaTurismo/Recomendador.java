package sistemaTurismo;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Recomendador {

	private List<PerfilUsuario> listaDeUsuarios;

	private List<Facturable> listaDeFacturables;

	public Recomendador(List<PerfilUsuario> listaDeUsuarios, List<Facturable> listaDeFacturables) {
		super();
		this.listaDeUsuarios = listaDeUsuarios;
		this.listaDeFacturables = listaDeFacturables;
	}

	

	public boolean leer() {

		//si el usuario ingresa 1 es verdadero sino no.

		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		
		return teclado.nextInt() == 1;
	}

	public void ofrecerSugerencias() {

		for(PerfilUsuario usuario : listaDeUsuarios) {
			System.out.println("-------------------------------");
			System.out.println(usuario);
			System.out.println("-------------------------------");
			System.out.println();
			System.out.println("Presione 1 para aceptar y 0 para cancelar");

			Itinerario nuevoItinerario = new Itinerario(usuario);

			Collections.sort(listaDeFacturables, new ComparadorDeFacturable(usuario.getTipoDeAtraccion()));

			iterarSugerencias(usuario, nuevoItinerario);
			ManejadorDeArchivo.guardarItinerarioEnArchivo(nuevoItinerario);
		}
	}
	
	public boolean seDebeOcultarAtraccion(Facturable atraccion, Itinerario itinerario, PerfilUsuario usuario) {
		
		return itinerario.poseeAtraccion(atraccion) || !usuario.puedeComprar(atraccion) || !atraccion.hayCupo();
	}
	
	public void iterarSugerencias(PerfilUsuario usuario, Itinerario nuevoItinerario) {
		for (Facturable atraccion :listaDeFacturables) {
			if (!usuario.tieneTiempoYdinero()){
				return;
			}
			else if(seDebeOcultarAtraccion(atraccion, nuevoItinerario, usuario)){
				continue;
			}
			
			

			System.out.println(atraccion);

			//si el usuario lo quiere la agregamos al itinerario
			if(leer()) {
				atraccion.restarCupo();
				nuevoItinerario.agregarAtraccion(atraccion);
				usuario.reservarTiempoYdinero(atraccion);
			}
		}
	}

}
