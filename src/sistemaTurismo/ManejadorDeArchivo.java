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
		int tipoPromocion = Integer.parseInt(promocionBase[0]);

		//guardamos el tipo de atracciones que contendrá este paquete
		TiposDeAtraccion tipoDePromocion = TiposDeAtraccion.valueOf(promocionBase[1]);

		// guardamos el nombre del paquete (vamos a usar esto en el toString para mostrar mas info al usuario por consola)
		String nombreDePromocuon = promocionBase[2];

		//ver bien como determinamos esto
		List<String> listaDeAtracciones = new ArrayList<String>();

		//declaramos una nueva Promocion ( lo hacemos del tipo de la clase abstracta para que no nos importe realmente
		// de que tipo estamos creando lo podemos guardar aca igual (evitamos tener una variable por cada tipo de promocion))
		Promocion nuevaPromocion;

		//dependiendo del tipo de promocion utilizamos una clase distinta y pedimos un dato distinto
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
		//inicializamos todos los valores conocidos de una atraccion
		// 0 = a costo de la visita
		// 1 = tiempo ¨promedio de  visita
		// 2 = cupo diario por atraccion
		// 3 = tipo de atraccion o paquete
		// 4 = nombre de la atraccion
		double costoVisita = Double.parseDouble(atraccionBase[0]);
		int tiempoPromedio = Integer.parseInt(atraccionBase[1]);
		int cupoDiario = Integer.parseInt(atraccionBase[2]);
		TiposDeAtraccion tipoAtraccion = TiposDeAtraccion.valueOf(atraccionBase[3]);
		String nombre = atraccionBase[4];

		//creamos una nueva atraccion utilizando el constructor y los valores obtenidos del archivo
		Atraccion nuevaAtraccion = new Atraccion(costoVisita,tiempoPromedio,cupoDiario,tipoAtraccion,nombre);

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
					double presupuesto = Double.parseDouble(usuarioBase[0]);
					int tiempoDisponible = Integer.parseInt(usuarioBase[1]);
					TiposDeAtraccion tipoAtraccion = TiposDeAtraccion.valueOf(usuarioBase[2]);
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
