package sistemaTurismo;

import java.util.Comparator;

public class ComparadorDeFacturable implements Comparator<Facturable> {
	private  TipoDeAtraccion preferencia;
	
	

	public ComparadorDeFacturable(TipoDeAtraccion preferencia) {
	
		this.preferencia = preferencia;
	}



	@Override
	public int compare(Facturable o1, Facturable o2) {
		if(this.preferencia == o1.getTipo() && this.preferencia != o2.getTipo())
			return -1;
		else if (this.preferencia != o1.getTipo() && this.preferencia == o2.getTipo())
			return 1;
		else if(o1.esPromocion() == true && o2.esPromocion() == false)
			return -1;
		else if(o1.esPromocion() == false && o2.esPromocion() == true)
			return 1;
		else if (o1.obtenerCostoTotal() > o2.obtenerCostoTotal())
			return -1;
		else if (o1.obtenerCostoTotal() < o2.obtenerCostoTotal())
			return 1;
		else if (o1.obtenerTiempoTotal() > o2.obtenerTiempoTotal())
			return -1;
		else if (o1.obtenerTiempoTotal() < o2.obtenerTiempoTotal())
			return 1;
		else
			return 0;	
	}

}
