package sistemaTurismo;

public class Itinerario {

	private float horasNecesarias;

	public float getHorasNecesarias() {
		return horasNecesarias;
	}

	public void setHorasNecesarias(float horasNecesarias) {
		this.horasNecesarias = horasNecesarias;
	}

	public double getCostoMonedas() {
		return costoMonedas;
	}

	public void setCostoMonedas(double costoMonedas) {
		this.costoMonedas = costoMonedas;
	}

	private double costoMonedas;
	
	public Facturable[] ListaDeVisitas() {
		
		Facturable[] lista = {};
		return lista;
	}
	
	
}
