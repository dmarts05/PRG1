package es.unileon.prg.tema6;

/**
 * Clase que representa un cheque definido con un numero y los digitos que tiene
 * el mismo Impementa un metodo para comprobar que un cheque es falso
 * 
 * @author PRG
 * @version (1.0)
 */

public class Cheque {
	/**
	 * Digitos del cheque
	 * 
	 */
	private int DIGITOS = 10;
	/**
	 * Numero que identifica al cheqte
	 * 
	 */
	private String numeroDeCheque;

	/**
	 * Constructor de la clase Cheque. Recibe un String con el numero de Cheque
	 * 
	 * @param numero
	 *            Numero del cheque
	 */
	public Cheque(String numero) {
		this.numeroDeCheque = numero;
	}

	/**
	 * Devuelve true si el numero de cheque es falso y false si es correcto
	 * 
	 * @return true si el cheque es falso, false en caso contrario
	 */

	public boolean esFalso() {
		boolean esFalso = false;
		int maximoCerosSeguidos = 0;
		int cerosSeguidos = 0;
		int maximoNumerosSeguidos = 0;
		int numerosSeguidos = 0;
		// Inicio modificacion - ejercicio02() de la clase Apartado030204 -.
		for (int i = 0; i < this.DIGITOS; i++) {
			String digito = numeroDeCheque.substring(i, i + 1);
			if (digito.equals("0")) {
				cerosSeguidos += 1;
				if (numerosSeguidos >= maximoNumerosSeguidos) {
					maximoNumerosSeguidos = numerosSeguidos;
					numerosSeguidos = 0;
				}
			} else {
				numerosSeguidos += 1;
				if (cerosSeguidos >= maximoCerosSeguidos) {
					maximoCerosSeguidos = cerosSeguidos;
					cerosSeguidos = 0;
				}
			}
		}

		if (maximoCerosSeguidos >= 3 || maximoNumerosSeguidos >= 4) {
			esFalso = true;
		}
		// Fin modificacion - ejercicio02() de la clase Apartado030204 -.
		return esFalso;
	}

}
