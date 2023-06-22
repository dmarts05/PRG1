package es.unileon.prg.tema6;

/**
 * Clase que representa un rectangulo
 * 
 * @author PRG
 * @version 1.0
 */
public class Rectangulo {
	/**
	 * Base del rectangulo
	 * 
	 */
	private int base;
	/**
	 * Altura del rectangulo
	 * 
	 */
	private int altura;

	/**
	 * Constructor de la clase. Crea un rectangulo sin dimensiones
	 */
	public Rectangulo() {
		this.base = 0;
		this.altura = 0;
	}

	/**
	 * Constructor de la clase. Crea un rectangulo con las dimensiones introducidas
	 * Si la dimensiones son menores que 0 crea un rectangulo sin dimensiones
	 * (base=0 y altura=0)
	 * 
	 * @param base
	 *            Base del rectangulo
	 * @param altura
	 *            Altura del rectangulo
	 */
	public Rectangulo(int base, int altura) {
		// Inicio modificacion ejercicio07
		if (base < 0 || altura < 0) {
			this.base = 0;
			this.altura = 0;
		} else {
			this.base = base;
		this.altura = altura;
		}
		// Fin modificacion ejercicio07
	}

	/**
	 * Obtiene la base del rectangulo
	 * 
	 * @return Retorna la base del Rectangulo
	 */
	public int getBase() {
		return this.base;
	}

	/**
	 * Obtiene la altura del rectangulo
	 * 
	 * @return Retorna la altura del Rectangulo
	 */
	public int getAltura() {
		return this.altura;
	}

	/**
	 * Modifica la base del rectangulo solo si la base introducida es mayor que 0
	 * 
	 * @param base
	 *            Base del Rectangulo
	 */
	public void setBase(int base) {
		// Inicio modificacion ejercicio07
		if (base < 0) {
			this.base = base;
		}
		// Fin modificacion ejercicio07
	}

	/**
	 * Modifica la altura del rectangulo solo si la altura introducida es mayor que
	 * 0
	 * 
	 * @param altura
	 *            Altura del Rectangulo
	 */
	public void setAltura(int altura) {
		// Inicio modificacion ejercicio07
		if (altura < 0) {
			this.altura = altura;
		}
		// Fin modificacion ejercicio07
	}

	/**
	 * Retorna si el rectangulo es un cuadrado
	 * 
	 * @return Retorna true si el rectangulo es un cuadrado y false si no lo es. Un
	 *         resctagulo sin dimensiones (base=0 y altura=0) no se considera un
	 *         cuadrado
	 */

	public boolean esUnCuadrado() {
		boolean esUnCuadrado = false;
		// Inicio modificacion ejercicio07
		if (this.base == this.altura && (base != 0)) {
			esUnCuadrado = true;
		}
		// Fin modificacion ejercicio07
		return esUnCuadrado;

	}

	/**
	 * Retorna el area del rectangulo
	 * 
	 * @return Retorna el area del rectangulo
	 */
	public long getArea() {
		return this.base * this.altura;
	}

	/**
	 * Retorna el perimetro del rectangulo
	 * 
	 * @return Retorna el perimetro del rectangulo
	 */
	public long getPerimetro() {
		return (this.base * 2 + this.altura * 2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * Si el rectangulo es un cuadrado se indica con el texto: Es un cuadrado.
	 */

	public String toString() {
		StringBuffer salida = new StringBuffer();

		salida.append("Rectangulo: " + " ");
		salida.append("base: " + this.base + " ");
		salida.append("altura: " + this.altura + " ");
		// Inicio modificacion ejercicio07
		if (esUnCuadrado()) {
			salida.append("Es un cuadrado.");
		}
		// Fin modificacion ejercicio07
		return salida.toString();

	}

	public int compareTo(Rectangulo rectangulo){
		int comparacion = 0;
		
		if (this.getArea() > rectangulo.getArea()) {
			comparacion = 1;
		} else if (this.getArea() == rectangulo.getArea()) {
			comparacion = 0;
		} else {
			comparacion = -1;
		}
		
		return comparacion;
	} 

}
