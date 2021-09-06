package sistemaTurismo;

import java.util.List;

enum TipoDeAtraccion {
    AVENTURA,
    DEGUSTACION,
    PAISAJE;
}

public class AgenciaTurismo {
	static List<Facturable> atracciones;
public static void main(String[] args) {
	AgenciaTurismo.atracciones = ManejadorDeArchivo.obtenerFacturables(false);

	
	List<PerfilUsuario> usuarios = ManejadorDeArchivo.obtenerUsuario();
	List<Facturable> promociones = ManejadorDeArchivo.obtenerFacturables(true);
	
	Recomendador recomendar = new Recomendador(usuarios, atracciones, promociones);
	recomendar.ofrecerSugerencias();

	System.out.println(((Atraccion) atracciones.get(0)).getCupo());
}
	
}
