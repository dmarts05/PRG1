package es.unileon.prg.tema6;
/**
 * Clase con los ejercicios correspondientes a sentencias condicionales:
 * sentencias con la instrucciin "switch".
 *
 * @author PRG
 * @version 1.0
 */
public class Apartado030103 extends Apartado {

	protected String obtenerPractica(){
		return "P-CTL";
	}

	protected String obtenerBloque() {
		return "Instruccion switch";
	}

	/**
	 * Instruccion switch - Ejercicio1.
	 *
	 * Modificar el metodo  para que al introducir un calificacion numerica  por teclado(1-10) se muestre 
	 * la calificacion de forma textual (1-4 -> Insuficiente , 5 -> Suficiente, 6 -> Bien, 
	 * 7-8 -> Notable, 9 -> Sobresaliente, 10 -> Matricula)
	 *
	 */
	public void ejercicio01() {
		cabecera("01","");

		// Inicio modificacion
		System.out.println("Indica la calificacion: ");
		int calificacion = Teclado.readInteger();

		switch (calificacion) {
			case 1:
			case 2:
			case 3:
			case 4:
				System.out.println("Insuficiente");
				break;
			case 5:
				System.out.println("Suficiente");
				break;
			case 6:
				System.out.println("Bien");
				break;
			case 7:
			case 8:
				System.out.println("Notable");
				break;
			case 9:
				System.out.println("Sobresaliente");
				break;
			case 10:
				System.out.println("Matricula");
				break;
				
		}
        // Fin modificacion
	}

	/**
	 * Instruccion switch - Ejercicio2.
	 *
	 * Modificar el metodo  para que retorne el numero de anillos que tiene un digito entero 
	 * introducido por el teclado. Se definen los anillos de un digito como el numero de circulos
	 * que tiene un digito. Ej.: 0 -> 1 anillo, 2 -> 0 anillos, 8 -> 2 anillos, etc.).
	 *
	 */
	public void ejercicio02() {
		cabecera("02", "");

		// Inicio modificacion
		System.out.println("Introduce un numero: ");
		int numero = Teclado.readInteger();

		switch (numero) {
			case 1:
			case 2:
			case 3:
			case 5:
			case 7:
				System.out.println("0 anillos.");
				break;
			case 0:
			case 4:
			case 6:
			case 9:
				System.out.println("1 anillo.");
				break;	
			case 8:
				System.out.println("2 anillo.");
				break;
		
		}
		// Fin modificacion
	}

	/**
	 * Instruccion switch - Ejercicio3.
	 *
	 * Modificar el metodo ejercicio3() del Apartado030103, utilizando una sentencia switch, 
	 * para que realice la misma funcionalidad que el metodo ejercicio4() del Apartado030102.
	 *
	 */
	public void ejercicio03() {
		cabecera("03", "");

		// Inicio modificacion
		System.out.println("Introduce el numero 1: ");
		int n1 = Teclado.readInteger();
		System.out.println("Introduce el numero 2: ");
		int n2 = Teclado.readInteger();
		System.out.println("1 - Sumar; 2 - Multiplicar; 3 - Divisores: ");
		int opcion = Teclado.readInteger();

		switch (opcion) {
			case 1:
				System.out.println("Resultado: " + (n1 + n2));
				break;
			case 2:
				System.out.println("Resultado: " + (n1 * n2));
				break;
			case 3:
				if ((n1 % n2) == 0) {
					System.out.println("El segundo es divisor del primero.");
				} else if ((n2 % n1) == 0) {
					System.out.println("El primero es divisor del segundo.");
				} else {
					System.out.println("Ninguno es divisor del otro.");
				}
				break;
			default:
				System.out.println("Opcion incorrecta.");
		}
		// Fin modificacion
	}

	/**
	 * Instruccion switch - Ejercicio4.
	 *
	 * Modificar el metodo ejercicio4() del Apartado030103  para que al introducir una cadena de caracteres 
	 * por teclado  se indique si el primer caracter de la cadena es una vocal escrita en minusculas, 
	 * si es una vocal escrita en mayusculas o si es otro tipo de caracter.
	 * 
	 */
	public void ejercicio04() {
		cabecera("04", "");

		// Inicio modificacion
		System.out.println("Introduce una cadena de caracteres: ");
		String cadena = Teclado.readString();
		
		switch (cadena.substring(0, 1)) {
			case "a":
			case "e":
			case "i":
			case "o":
			case "u":
				System.out.println("Vocal escrita en minusculas.");
				break;
			case "A":
			case "E":
			case "I":
			case "O":
			case "U":
				System.out.println("Vocal escrita en mayusculas.");
				break;
			default:
				System.out.println("Es otro tipo de caracter.");
				break;
		}
		// Fin modificacion
	}
}
