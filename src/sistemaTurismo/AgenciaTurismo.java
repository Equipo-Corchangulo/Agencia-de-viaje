package sistemaTurismo;

import java.util.List;

public class AgenciaTurismo {

	static List<Facturable> facturables;

	public static void main(String[] args) {

	AgenciaTurismo.facturables = ManejadorDeArchivo.obtenerFacturables("Files/Atracciones.txt", "files/Promociones.txt");

	List<PerfilUsuario> usuarios = ManejadorDeArchivo.obtenerUsuario("files/PerfilUsuario.txt");
	Atraccion a = (Atraccion) facturables.get(0);
	Recomendador recomendar = new Recomendador(usuarios, facturables);
	recomendar.ofrecerSugerencias();
	System.out.println("Programa Terminado");
	}

}
