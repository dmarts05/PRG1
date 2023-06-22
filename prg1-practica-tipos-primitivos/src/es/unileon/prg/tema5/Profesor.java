package es.unileon.prg.tema5;

/**
 * Clase que representa un profesor.
 *
 * @author PRG
 * @version 1.0
 */
public class Profesor {
	/**
	 * Identificador del profesor
	 *
	 * @see String
	 */
	private String niu;
	/**
	 * Nombre del profesor
	 *
	 * @see String
	 */
	private String nombre;

	/**
	 * Constructor de la clase. Crea un profesor con la informacion recibida
	 *
	 * @param niu
	 *            Identificador del profesor
	 * @param nombre
	 *            Nombre del profesor
	 */
	public Profesor(String niu, String nombre) {
		this.niu = niu;
		this.nombre = nombre;
	}

	public String toString() {
		StringBuffer salida = new StringBuffer();
		
		salida.append("NIU: " + this.niu + " ");
		salida.append("Nombre: " + this.nombre + " ");
		
		return salida.toString();
	}
}