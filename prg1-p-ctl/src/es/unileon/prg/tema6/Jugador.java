package es.unileon.prg.tema6;

/**
 * 
 * 
 * Definicion de la clase Jugador
 * 
 * @author PRG
 * @version (1.0)
 *
 */

public class Jugador {
	/**
	 * Nombre del jugador
	 * 
	 */
	private String nombre;

	/**
	 * Puntos ATP
	 * 
	 */
	private double puntosATP;

	/**
	 * Constructor de la clase.
	 * 
	 * @param nombre
	 * @param puntosATP
	 * 
	 */
	public Jugador(String nombre, double puntosATP) {
		this.nombre = nombre;
		this.puntosATP = puntosATP;
	}

	/**
	 * Obtiene el nombre del jugador
	 * 
	 * @return Retorna el nombre del jugador
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Obtiene los puntos ATP del jugador
	 * 
	 * @return Retorna los puntos ATP del jugador
	 */
	public double getPuntosATP() {
		return this.puntosATP;
	}

	/**
	 * Cambia los puntos ATP del jugador
	 * 
	 * @param puntosATP
	 */
	public void setPuntosATP(double puntosATP) {
		this.puntosATP = puntosATP;
	}

}
