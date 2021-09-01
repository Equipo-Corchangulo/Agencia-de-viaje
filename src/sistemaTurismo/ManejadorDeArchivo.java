package sistemaTurismo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ManejadorDeArchivo {

	public static List <Atraccion> obtenerAtracciones() {
		 List <Atraccion> listaDeAtracciones = new ArrayList<Atraccion>();
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("Atracciones.txt");
			br = new BufferedReader(fr);
			String linea;
			
			while ((linea = br.readLine())!= null) {
				try {
					String [] atraccionBase = linea.split(",");
					double costoVisita = Double.parseDouble(atraccionBase[0]);
					int tiempoPromedio = Integer.parseInt(atraccionBase[1]);
					int cupoDiario = Integer.parseInt(atraccionBase[2]);
					PromocionType tipoAtraccion = PromocionType.valueOf(atraccionBase[3]);
					String nombre = atraccionBase[4];
					
					Atraccion nuevaAtraccion = new Atraccion(costoVisita,tiempoPromedio,cupoDiario,tipoAtraccion,nombre);
					listaDeAtracciones.add(nuevaAtraccion);
					
					
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
					
					
					PerfilUsuario nuevoUsuario = new PerfilUsuario(presupuesto, tiempoDisponible, tipoAtraccion);
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
