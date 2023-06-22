package es.unileon.prg.tema6;

/**
 * Clase que representa un numero entero
 * 
 * @author PRG
 * @version 1.0
 */

public class NumeroEntero {

	/**
	 * Valor del numero
	 * 
	 */
	private int valor;

	/**
	 * Constructor de la clase. Crea un numero con el valor recibido
	 * 
	 * @param valor
	 *            valor del numero
	 * 
	 */
	public NumeroEntero(int valor) {
		this.valor = valor;
	}

	/**
	 * Constructor de la clase. Crea un numero con el valor 0
	 * 
	 */
	public NumeroEntero() {
		this.valor = 0;
	}

	/**
	 * Modifica el valor del numero
	 * 
	 * @return Valor del numero
	 */
	void setValor(int nuevoValor) {
		this.valor = nuevoValor;
	}

	/**
	 * Retorna el valor del numero
	 * 
	 * @return Valor del numero
	 */
	int getValor() {
		return this.valor;
	}

	/**
	 * Incrementa en 1 el valor del numero
	 * 
	 */
	void incrementar() {
		if (this.valor < Integer.MAX_VALUE)
			this.valor = this.valor + 1;
	}

	/**
	 * Decrementa en 1 el valor del numero
	 * 
	 */
	void decrementar() {
		if (this.valor > Integer.MIN_VALUE)
			this.valor = this.valor - 1;
	}

	/**
	 * Pone a 0 el valor del numero
	 * 
	 */
	void poneraCero() {
		this.valor = 0;
	}

	/**
	 * Suma el numero entero con otro
	 * 
	 * @parame n Numero con el que se suma
	 * @return Objeto de tipo NumeroEntero cuyo valor es la suma
	 */
	NumeroEntero suma(NumeroEntero n) {

		NumeroEntero suma = new NumeroEntero(this.valor + n.getValor());
		return suma;
	}

	public String toString() {
		StringBuffer salida = new StringBuffer();

		salida.append(this.valor);

		return salida.toString();

	}

	// -- Inicio modificacion del ejercicio10 Apartado030101. boolean
	public boolean equals(NumeroEntero n) {
		return this.getValor() == n.getValor();
	}
	// -- Fin modificacion del ejercicio10 Apartado030101


	
	// -- Inicio modificacion del ejercicio02 Apartado030102. int
	public int compareTo(NumeroEntero n){
		int comparacion = 0;
		
		if (this.getValor() > n.getValor()) {
			comparacion = 1;
		} else if (this.getValor() == n.getValor()) {
			comparacion = 0;
		} else {
			comparacion = -1;
		}
		
		return comparacion;
	} 
	// -- Fin modificacion del ejercicio02 Apartado030102.

	 public int numeroDigitos() {
		 int numeroDigitos = 0;
		 int numero = this.getValor();

		 while (numero > 0) {
			numero = numero / 10;
			numeroDigitos++;
		 }

		 return numeroDigitos;
	 }

	 public int inverso() {
		 int numero = this.getValor();
		 int resto = 0;
		 int inverso = 0;

		 while( numero > 0 ) {
			resto = numero % 10;
			inverso = inverso * 10 + resto;
			numero /= 10;
		 }

		 return inverso;
	 }

	 public boolean esCapicua() {
		return this.getValor() == this.inverso();
	 }

}