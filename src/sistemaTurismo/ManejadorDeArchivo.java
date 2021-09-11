package sistemaTurismo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejadorDeArchivo {

	public static List<Facturable> obtenerFacturables() {
		List<Facturable> listaDeAtracciones = new ArrayList<Facturable>();

		AgenciaTurismo.facturables = leerArchivos("Files/Atracciones.txt", false, listaDeAtracciones);
		leerArchivos("files/Promociones.txt", true, AgenciaTurismo.facturables);	
		return listaDeAtracciones;
	}
	
	private static List<Facturable> leerArchivos(String nombreDeArchivo
			, boolean esPromocion
			, List<Facturable> listaDeAtracciones){

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(nombreDeArchivo);
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
			br.close();
			fr.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}


		return listaDeAtracciones;
	}
	private static Promocion crearPromocion(String[] promocionBase){
	
		Promocion.enumDePromocion tipoPromocion = Promocion.enumDePromocion.valueOf(promocionBase[0]);
		TipoDeAtraccion tipoDePromocion = TipoDeAtraccion.valueOf(promocionBase[1]);
		String nombreDePromocion = promocionBase[2];
		List<Facturable> listaDeAtracciones = new ArrayList<Facturable>();
		String[] indicesAtracciones = promocionBase[3].split("-");

		for (String indice : indicesAtracciones) {
			listaDeAtracciones.add(AgenciaTurismo.facturables.get(Integer.parseInt(indice))); 
		}

		Promocion nuevaPromocion;
		switch (tipoPromocion){
			case ABSOLUTA:
				double costoFijo = Double.parseDouble(promocionBase[4]);
				nuevaPromocion = new PromoAbsoluta(listaDeAtracciones, tipoDePromocion, nombreDePromocion,costoFijo);
				break;
			case AXB:
				int indiceDeAtraccionExtra = Integer.parseInt(promocionBase[4]);
				 Facturable atraccionExtra = AgenciaTurismo.facturables.get(indiceDeAtraccionExtra);
				nuevaPromocion = new PromoAxB(listaDeAtracciones, tipoDePromocion, nombreDePromocion,atraccionExtra);
				break;
			case PORCENTUAL:
				double porcentajeDescuento = Double.parseDouble(promocionBase[4]);
				nuevaPromocion = new PromoPorcentual(listaDeAtracciones, tipoDePromocion, nombreDePromocion, porcentajeDescuento);
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + tipoPromocion);
		}
		return nuevaPromocion;
	}

	private static Atraccion crearAtraccion(String[] atraccionBase){
		//inicializamos todos los valores conocidos de una atraccion
		// 0 = nombre de la atraccion
		// 1 = a costo de la visita
		// 2 = tiempo ¨promedio de  visita
		// 3 = cupo diario por atraccion
		// 4 = tipo de atraccion o paquete
		String nombre = atraccionBase[0];
		double costoVisita = Double.parseDouble(atraccionBase[1]);
		double tiempoPromedio = Double.parseDouble(atraccionBase[2]);
		int cupoDiario = Integer.parseInt(atraccionBase[3]);
		TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(atraccionBase[4]);
		int iD = Integer.parseInt(atraccionBase[5]);
		Atraccion nuevaAtraccion = new Atraccion(nombre, costoVisita,tiempoPromedio,cupoDiario,tipoAtraccion, iD);

		return nuevaAtraccion;
	}

	public static List <PerfilUsuario> obtenerUsuario() {
		 List <PerfilUsuario> listaDePerfilUsuario = new ArrayList<PerfilUsuario>();
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader("files/PerfilUsuario.txt");
			br = new BufferedReader(fr);
			String linea;

			while ((linea = br.readLine())!= null) {
				try {
					String [] usuarioBase = linea.split(",");
					String nombre = usuarioBase[0];
					double presupuesto = Double.parseDouble(usuarioBase[1]);
					int tiempoDisponible = Integer.parseInt(usuarioBase[2]);
					TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(usuarioBase[3]);
				

					PerfilUsuario nuevoUsuario = new PerfilUsuario(nombre, presupuesto, tiempoDisponible, tipoAtraccion);
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

	public static void guardarItinerarioEnArchivo(List<Itinerario> listaDeItinerarios){
		//hacer mi logica para guardar
		File f = new File("files/ReportedeItinerarios.txt");
		PrintWriter pw;
		System.out.println("==========================REPORTE DE ITINERARIO===============================");
		try {
			pw = new PrintWriter(f);
			for(Itinerario itinerario : listaDeItinerarios){
				pw.write(itinerario.toString() + "\n");
				System.out.println(itinerario);
			}
			pw.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}

	}

}
