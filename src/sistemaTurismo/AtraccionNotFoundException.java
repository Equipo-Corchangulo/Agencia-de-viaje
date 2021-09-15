package sistemaTurismo;

public class AtraccionNotFoundException extends Exception {
	
	public AtraccionNotFoundException(String id) {
		super("No se encuentra la atraccion con el id: " + id);
	}

}
