package es.unileon.prg.tema6;

/**
 * 
 * 
 * Definicion de la clase Partido
 * 
 * @author PRG
 * @version (1.0)
 *
 */

public class Partido {

	/**
	 * Jugador 1 del partido
	 * 
	 */
	private Jugador jugador1;
	/**
	 * Jugador 2 del partido
	 * 
	 */
	private Jugador jugador2;
	/**
	 * Ganador del partido. Si su su valor es null todavia no se ha jugado el
	 * partido
	 * 
	 */
	private Jugador ganador;

	/**
	 * Constructor de la clase. Crea un partido con los jugadores introducidos
	 * 
	 * @param jugador1
	 * @param jugador2
	 * 
	 */
	public Partido(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.ganador = null;
	}

	/**
	 * Retorna el jugador 1
	 * 
	 * @return Retorna el jugador 1
	 */
	public Jugador getJugador1() {
		return this.jugador1;
	}

	/**
	 * Retorna el jugador 2
	 * 
	 * @return Retorna el jugador 2
	 */
	public Jugador getJugador2() {
		return this.jugador2;
	}

	/**
	 * Juega el partido y genera el ganador
	 * 
	 */
	public void jugar() {
		// Inicio modificacion - ejercicio06() de la clase Apartado030202 -
		boolean empate = true;
		double resultado1 = 0;
		double resultado2 = 0;
		double puntosATP = 0;

		while (empate) {
			resultado1 = Math.random() * jugador1.getPuntosATP();
			resultado2 = Math.random() * jugador2.getPuntosATP();

			if (resultado1 != resultado2) {
				empate = false;
			}
		}

		if (resultado1 > resultado2) {
			this.ganador = jugador1;
			puntosATP = jugador1.getPuntosATP() + 1;
			jugador1.setPuntosATP(puntosATP);
		} else {
			this.ganador = jugador2;
			puntosATP = jugador2.getPuntosATP() + 1;
			jugador2.setPuntosATP(puntosATP);
		}
		// Fin modificacion - ejercicio06() de la clase Apartado030202 -

	}

	/**
	 * Retorna el ganador. Si retorna null el partido todavia no se ha jugado
	 * 
	 * @return Retorna el ganador del partido
	 */
	public Jugador ganador() {
		return this.ganador;
	}

}