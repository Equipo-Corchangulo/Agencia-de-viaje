package sistemaTurismo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejadorDeArchivo {

	//funcion para obtener Facturables ( promociones o Atracciones)
	public static List<Facturable> obtenerFacturables(boolean esPromocion) {
		//inicializamos la lista de facturables a devolver
		List<Facturable> listaDeAtracciones = new ArrayList<Facturable>();

		//inicializamos las variables del reader para leer los archivos.txt
		FileReader fr = null;
		BufferedReader br = null;

		//determinamos a cual archivo .txt llamar dependiendo del booleano que viene como parametro de la funcion
		//de esta forma sabemos si son promociones o atracciones lo que vamos a crear
		String archivo = esPromocion ? "Promociones.txt" : "Atracciones.txt";
		//separar la creacion de atracciones y promociones
		try {
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;

			//iteramos a traves de todas las lineas del archivo
			while ((linea = br.readLine())!= null) {
				try {
					//dividimos la linea en un arreglo de strings
					String [] elementoBase = linea.split(",");

					//dependiendo del booleano creamos una Atraccion o una Promocion y la guardamos en una variable del
					// tipo Facturable para que sea facil de manejar por el resto del programa
					Facturable elemento = esPromocion ? crearPromocion(elementoBase) : crearAtraccion(elementoBase);

					//agregamos el elemento a la lista que vamos a devolver
					listaDeAtracciones.add(elemento);
					
					
				} catch (Exception e) {
					//mostramos el stack de la excepcion
					e.printStackTrace();
				}
			}
		}
		catch (IOException e) {
			//mostramos el stack de la excepcion
			e.printStackTrace();
		}

		//devolvemos lista de atracciones
		return listaDeAtracciones;
	}

	private static Promocion crearPromocion(String[] promocionBase){
		//obtenemos el tipo de promocion lo que nos va a permitir saber que clase vamos a instanciar
		Promocion.enumDePromocion tipoPromocion = Promocion.enumDePromocion.valueOf(promocionBase[0]);

		//guardamos el tipo de atracciones que contendrá este paquete
		TipoDeAtraccion tipoDePromocion = TipoDeAtraccion.valueOf(promocionBase[1]);

		// guardamos el nombre del paquete (vamos a usar esto en el toString para mostrar mas info al usuario por consola)
		String nombreDePromocuon = promocionBase[2];

		//ver bien como determinamos esto
		List<Facturable> listaDeAtracciones = new ArrayList<Facturable>();
		String[] indicesAtracciones = promocionBase[3].split("-");
		for (String indice : indicesAtracciones) {
			listaDeAtracciones.add(AgenciaTurismo.atracciones.get(Integer.parseInt(indice)));
		}


		//declaramos una nueva Promocion ( lo hacemos del tipo de la clase abstracta para que no nos importe realmente
		// de que tipo estamos creando lo podemos guardar aca igual (evitamos tener una variable por cada tipo de promocion))
		Promocion nuevaPromocion;

		//dependiendo del tipo de promocion utilizamos una clase distinta y pedimos un dato distinto
		switch (tipoPromocion){
			case ABSOLUTA:
				double costoFijo = Double.parseDouble(promocionBase[4]);
				nuevaPromocion = new PromoAbsoluta(listaDeAtracciones, tipoDePromocion, nombreDePromocuon,costoFijo);
				break;
			case AXB:
				int indiceDeAtraccionExtra = Integer.parseInt(promocionBase[4]);
				 Facturable atraccionExtra = AgenciaTurismo.atracciones.get(indiceDeAtraccionExtra);
				nuevaPromocion = new PromoAxB(listaDeAtracciones, tipoDePromocion, nombreDePromocuon,atraccionExtra);
				break;
			case PORCENTUAL:
				double porcentajeDescuento = Double.parseDouble(promocionBase[4]);
				nuevaPromocion = new PromoPorcentual(listaDeAtracciones, tipoDePromocion, nombreDePromocuon, porcentajeDescuento);
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
		
		//creamos una nueva atraccion utilizando el constructor y los valores obtenidos del archivo
		Atraccion nuevaAtraccion = new Atraccion(nombre, costoVisita,tiempoPromedio,cupoDiario,tipoAtraccion);

		//devolvemos la atraccion creada
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

}
