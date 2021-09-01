package sistemaTurismo;

import java.util.List;

enum PromocionType {
    AVENTURA,
    DEGUSTACION,
    PAISAJE;
}
 
public class AgenciaTurismo {

public static void main(String[] args) {
	List<Atraccion> lista = ManejadorDeArchivo.obtenerAtracciones();
	System.out.println(lista.get(0));
	System.out.println(lista.get(1));
	
	List<PerfilUsuario> lista2 = ManejadorDeArchivo.obtenerUsuario();
	System.out.println(lista2.get(0));
	System.out.println(lista2.get(1));
}
	
}
