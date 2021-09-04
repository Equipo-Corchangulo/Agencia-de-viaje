package sistemaTurismo;

import java.util.ArrayList;
import java.util.List;

enum PromocionType {
    AVENTURA,
    DEGUSTACION,
    PAISAJE;
}
 
public class AgenciaTurismo {

public static void main(String[] args) {
	List<Facturable> atracciones = ManejadorDeArchivo.obtenerAtracciones(false);
	
	List<PerfilUsuario> usuarios = ManejadorDeArchivo.obtenerUsuario();
	
	Recomendador recomendar = new Recomendador(usuarios, atracciones, new ArrayList<Facturable>());
	recomendar.ofrecerSugerencias();
	
	System.out.println(((Atraccion) atracciones.get(0)).getCupo());
}
	
}
