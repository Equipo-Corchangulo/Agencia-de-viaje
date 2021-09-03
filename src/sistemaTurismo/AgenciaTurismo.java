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
	List<Atraccion> lista = ManejadorDeArchivo.obtenerAtracciones();
	
	List<PerfilUsuario> lista2 = ManejadorDeArchivo.obtenerUsuario();
	
	Recomendador recomendar = new Recomendador(lista2, lista, new ArrayList<Promocion>());
	recomendar.ofrecerSugerencias();
	
	System.out.println(lista.get(0).getCupo());
}
	
}
