package sistemaTurismo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ManejadorDeArchivo {

	public static List<Facturable> obtenerAtracciones(boolean esPromocion) {
		 List<Facturable> listaDeAtracciones = new ArrayList<Facturable>();
		FileReader fr = null;
		BufferedReader br = null;
		String archivo = esPromocion ? "Promociones.txt" : "Atracciones.txt";
		//separar la creacion de atracciones y promociones
		try {
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			
			while ((linea = br.readLine())!= null) {
				try {
					String [] elementoBase = linea.split(",");
					Facturable elemento = esPromocion ? crearPromocion(elementoBase) : crearAtraccion(elementoBase);
					listaDeAtracciones.add(elemento);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return listaDeAtracciones;
	}

	private static Promocion crearPromocion(String[] promocionBase){
		int tipoPromocion = Integer.parseInt(promocionBase[0]);
		PromocionType tipoDePromocion = PromocionType.valueOf(promocionBase[1]);
		String nombreDePromocuon = promocionBase[2];

		//ver bien como determinamos esto
		List<String> listaDeAtracciones = new ArrayList<String>();

		Promocion nuevaPromocion;
		switch (tipoPromocion){
			case 0:
				double costofijo = Double.parseDouble(promocionBase[3]);
				nuevaPromocion = new PromoAbsoluta(listaDeAtracciones, tipoDePromocion, nombreDePromocuon,costofijo);
				break;
			case 1:
				String promoExtra = promocionBase[3];
				nuevaPromocion = new PromoAxB(listaDeAtracciones, tipoDePromocion, nombreDePromocuon,promoExtra);
				break;
			case 2:
				double porcentajeDescuento = Double.parseDouble(promocionBase[3]);
				nuevaPromocion = new PromoPorcentual(listaDeAtracciones, tipoDePromocion, nombreDePromocuon, porcentajeDescuento);
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + tipoPromocion);
		}
		return nuevaPromocion;
	}

	private static Atraccion crearAtraccion(String[] atraccionBase){
		double costoVisita = Double.parseDouble(atraccionBase[0]);
		int tiempoPromedio = Integer.parseInt(atraccionBase[1]);
		int cupoDiario = Integer.parseInt(atraccionBase[2]);
		PromocionType tipoAtraccion = PromocionType.valueOf(atraccionBase[3]);
		String nombre = atraccionBase[4];

		Atraccion nuevaAtraccion = new Atraccion(costoVisita,tiempoPromedio,cupoDiario,tipoAtraccion,nombre);
		return nuevaAtraccion;
	}
	
	public static List <PerfilUsuario> obtenerUsuario() {
		 List <PerfilUsuario> listaDePerfilUsuario = new ArrayList<PerfilUsuario>();
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("PerfilUsuario.txt");
			br = new BufferedReader(fr);
			String linea;
			
			while ((linea = br.readLine())!= null) {
				try {
					String [] usuarioBase = linea.split(",");
					double presupuesto = Double.parseDouble(usuarioBase[0]);
					int tiempoDisponible = Integer.parseInt(usuarioBase[1]);
					PromocionType tipoAtraccion = PromocionType.valueOf(usuarioBase[2]);
					String nombre = usuarioBase[3];
					
					
					PerfilUsuario nuevoUsuario = new PerfilUsuario(presupuesto, tiempoDisponible, tipoAtraccion, nombre);
					listaDePerfilUsuario.add(nuevoUsuario);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return listaDePerfilUsuario;
	}

}
