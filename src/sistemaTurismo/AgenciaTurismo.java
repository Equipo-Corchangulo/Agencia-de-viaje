package sistemaTurismo;

import java.util.List;

public class AgenciaTurismo {

	static List<Facturable> facturables;

	public static void main(String[] args) {

	AgenciaTurismo.facturables = ManejadorDeArchivo.obtenerFacturables();

	List<PerfilUsuario> usuarios = ManejadorDeArchivo.obtenerUsuario();
	Atraccion a = (Atraccion) facturables.get(0);
	Recomendador recomendar = new Recomendador(usuarios, facturables);
	recomendar.ofrecerSugerencias();
	System.out.println("Programa Terminado");
	}

}
