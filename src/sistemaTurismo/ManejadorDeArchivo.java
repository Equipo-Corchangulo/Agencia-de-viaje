package sistemaTurismo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejadorDeArchivo {

	public static List<Facturable> obtenerFacturables(String ArchivoAtracciones, String ArchivoPromociones) throws AtraccionNotFoundException{
		List<Facturable> listaDeAtracciones = new ArrayList<Facturable>();

		AgenciaTurismo.facturables = leerArchivos(ArchivoAtracciones, false, listaDeAtracciones);
		leerArchivos(ArchivoPromociones, true, AgenciaTurismo.facturables);
		return listaDeAtracciones;
	}
	
	private static List<Facturable> leerArchivos(String nombreDeArchivo
			, boolean esPromocion
			, List<Facturable> listaDeAtracciones) throws AtraccionNotFoundException{

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(nombreDeArchivo);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine())!= null) {
				
				String [] elementoBase = linea.split(",");
				Facturable elemento = esPromocion ? crearPromocion(elementoBase) : crearAtraccion(elementoBase);
				listaDeAtracciones.add(elemento);
				 
			}
			br.close();
			fr.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}


		return listaDeAtracciones;
	}
	private static Promocion crearPromocion(String[] promocionBase) throws AtraccionNotFoundException{
	
		Promocion.enumDePromocion tipoPromocion = Promocion.enumDePromocion.valueOf(promocionBase[0]);
		TipoDeAtraccion tipoDePromocion = TipoDeAtraccion.valueOf(promocionBase[1]);
		String nombreDePromocion = promocionBase[2];
		List<Facturable> listaDeAtracciones = new ArrayList<Facturable>();
		String[] indicesAtracciones = promocionBase[3].split("-");
		boolean atraccionEncontrada;
	
		for (String id : indicesAtracciones) {
			atraccionEncontrada = false;
			
			for (Facturable facturable : AgenciaTurismo.facturables) {
				if(((Atraccion) facturable).getID() == Integer.parseInt(id)) {
					listaDeAtracciones.add(facturable);
					atraccionEncontrada = true;
					break;
				}
			}
			if(!atraccionEncontrada) {
				throw new AtraccionNotFoundException(id);
			}
		}
	
		
		

		Promocion nuevaPromocion;
		switch (tipoPromocion){
			case ABSOLUTA:
				double costoFijo = Double.parseDouble(promocionBase[4]);
				nuevaPromocion = new PromoAbsoluta(listaDeAtracciones, tipoDePromocion, nombreDePromocion,costoFijo);
				break;
			case AXB:
				int idDeAtraccionExtra = Integer.parseInt(promocionBase[4]);
				
				 Facturable atraccionExtra = null;
				 atraccionEncontrada = false;
				 
				for (Facturable facturable : AgenciaTurismo.facturables) {
					if(((Atraccion) facturable).getID() == idDeAtraccionExtra) {
						atraccionExtra = facturable;
						atraccionEncontrada = true;
						break;
					}
				}
				if (!atraccionEncontrada) {
					throw new AtraccionNotFoundException(promocionBase[4]);
				}
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
		// 2 = tiempo ??promedio de  visita
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

	public static List <PerfilUsuario> obtenerUsuario(String Archivousuario) {
		 List <PerfilUsuario> listaDePerfilUsuario = new ArrayList<PerfilUsuario>();
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(Archivousuario);
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

	public static void guardarItinerarioEnArchivo(PerfilUsuario usuario){
		File f = new File("files/ReportedeItinerarios"+ usuario.getNombre()+".txt");
		PrintWriter pw;
		Itinerario itinerarioAImprimir = usuario.getItinerario();
		try {
			pw = new PrintWriter(f);


			System.out.println("------------------------- REPORTE DE ITINERARIO ------------------------");
			pw.write(usuario.toString() + "\n"+itinerarioAImprimir.toString() + "\n");
			System.out.println(Recomendador.ANSI_BLUE+usuario);
			System.out.println(Recomendador.ANSI_WHITE+itinerarioAImprimir);
			System.out.println(Recomendador.ANSI_CYAN+"------------------------- FIN DE REPORTE -------------------------------");
			System.out.println();
			System.out.println();
			pw.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}

	}

}
