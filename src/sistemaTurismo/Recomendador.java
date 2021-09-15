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
				int entradaDelUsuario = 10;
		Scanner teclado = new Scanner(System.in);
		while (entradaDelUsuario != 0 && entradaDelUsuario != 1){

			System.out.println("Presione 1 para aceptar y 0 para cancelar");
			if (teclado.hasNextInt())
				entradaDelUsuario = teclado.nextInt();
			else
				entradaDelUsuario = 10;
		}

		return entradaDelUsuario == 1;

	}

	public void ofrecerSugerencias() {

		for(PerfilUsuario usuario : listaDeUsuarios) {
			System.out.println("-------------------------------");
			System.out.println(usuario);
			System.out.println("-------------------------------");
			System.out.println();

			Collections.sort(listaDeFacturables, new ComparadorDeFacturable(usuario.getTipoDeAtraccion()));

			iterarSugerencias(usuario);
			ManejadorDeArchivo.guardarItinerarioEnArchivo(usuario);
		}
	}
	
	public void iterarSugerencias(PerfilUsuario usuario) {
		for (Facturable atraccion :listaDeFacturables) {
			if (!usuario.tieneTiempoYdinero()){
				return;
			}
			else if(usuario.puedeComprar(atraccion)){

				System.out.println(atraccion);
	
				//si el usuario lo quiere la agregamos al itinerario
				if(leer()) {
					usuario.agregarAtraccion(atraccion);
				}
			}
		}
	}

}
