package es.unileon.prg.tema6;

/**
 * Clase que representa un alumno.
 * 
 * @author PRG
 * @version 1.0
 */
public class Alumno {
	/**
	 * Identificador del alumno
	 * 
	 * @see String
	 */
	private String niu;
	/**
	 * Nombre del alumno
	 * 
	 * @see String
	 */
	private String nombre;
	/**
	 * Nota del alumno
	 */
	private float nota;

	/**
	 * Constructor de la clase. Crea un alumno con la informacion recibida
	 * 
	 * @param niu
	 *            Identificador del alumno
	 * @param nombre
	 *            Nombre del alumno
	 */
	public Alumno(String niu, String nombre) {
		this.niu = niu;
		this.nombre = nombre;
	}

	/**
	 * Asigna la calificacion del alumno
	 * 
	 * @param nota
	 *            Nota del alumno
	 */
	public void asignarNota(float nota) {
		this.nota = nota;
	}

	// Inicio modificacion Apartado 030101 - ejercicio01

	// Fin modificacion Apartado 030101 - ejercicio01

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	public String toString() {
		StringBuffer salida = new StringBuffer();

		salida.append("NIU: " + this.niu + " ");
		salida.append("Nombre: " + this.nombre + " ");
		salida.append("Nota: " + this.nota + " ");

		return salida.toString();
	}

}
