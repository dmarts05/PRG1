package es.unileon.prg.tema6;

import org.w3c.dom.css.Rect;

/**
 * Clase con los ejercicios correspondientes a sentencias de repeticion:
 * sentencias con la instruccion "do-while".
 *
 * @author PRG
 * @version 1.0
 */
public class Apartado030203 extends Apartado {

	protected String obtenerPractica(){
		return "P-CTL";
	}

	protected String obtenerBloque() {
		return "Instruccion do-while";
	}

	/**
	 * Instruccion do-while - Ejercicio1.
	 *
	 * Programar el codigo que ofrezca un menu de opciones al usuario  hasta que seleccione la opcion salir.
	 * 
	 */
	public void ejercicio01() {
		cabecera("01","");

		// Inicio modificacion
		int salir = 0;
		do {
			System.out.println("---- Opciones ----");
			System.out.println("1. Opcion A\n2. Opcion B\n3. Salir");
			int opcion = Teclado.readInteger();
			if (opcion == 3) {
				salir = 1;
			} else if (opcion > 3 || opcion < 1) {
				System.out.println("La opcion no existe.\n");
			}

		} while (salir != 1);
        // Fin modificacion
	}

	/**
	 * Instruccion do-while - Ejercicio2.
	 *
	 * Programar el  codigo que lea numeros enteros hasta que el usuario introduzca un valor igual a cero 
	 * o hasta que el usuario introduzca dos veces seguidas el mismo numero.
	 * 
	 * Similar al  ejercicio02() de la clase Apartado030202 pero empleando la sentencia do-while).
	 *
	 */
	public void ejercicio02() {
		cabecera("02", "");

		// Inicio modificacion
		int numero = 0;
		int numeroAnterior = 0;
		do {
			numeroAnterior = numero;
			System.out.println("Introduce un numero: ");
			numero = Teclado.readInteger();
		} while ((numero != numeroAnterior) && (numero != 0));
		// Fin modificacion
	}

	/**
	 * Instruccion do-while - Ejercicio3.
	 *
	 * Programar el codigo que lea la base y la altura de un numero indeterminado de rectangulos y
	 * cree los correspondientes objetos de tipo Rectangulo. Para cada rectangulo el programa mostrara 
	 * por pantalla su area y si es un cuadrado o un rectangulo. El programa terminara cuando alguno 
	 * de los lados del cuadrilatero sea menor o igual que  0.
	 * 
	 */
	public void ejercicio03() {
		cabecera("03", "");

		// Inicio modificacion
		System.out.println("Indique la cantidad de rectangulos: ");
		int numeroRectangulos = Teclado.readInteger();
		Rectangulo rectangulo = new Rectangulo();
		int contador = 0;

		do {
			System.out.println("Introduce la base del rectangulo " + (contador + 1) + ": ");
			int base=Teclado.readInteger();
			System.out.println("Introduce la altura del rectangulo " + (contador + 1) + ": ");
			int altura=Teclado.readInteger();

			if (base == 0 || altura == 0) {
				break;
			}

			rectangulo=new Rectangulo(base, altura);

			System.out.println(rectangulo.toString());

			contador++;
		} while (contador < numeroRectangulos);

		// Fin modificacion
	}

	/**
	 * Instruccion do-while - Ejercicio4.
	 *
	 * Programar el codigo que dado un numero entero introducido por teclado indique si es o no perfecto.
	 * Un numero entero es perfecto si es igual a la suma de los sus divisores positivos menores que el.
	 * Ejemplos
	 * <ul>
	 * <li>6 es perfecto porque
	 * <ul>
	 * <li>	Sus divisores menores que el  son 1, 2, 3  y
	 * <li> 1 + 2 + 3 = 6;
	 * </ul>
	 * <li> 8 no es perfecto porque
	 * <ul>
	 * <li>	Sus divisores menores que el son 1, 2,4  y
	 * <li> 1+2+4  !=  8
	 * </ul>
	 * </ul>
	 * 
	 */
	public void ejercicio04() {
		cabecera("04", "");

		// Inicio modificacion
		System.out.println("Introduce un numero: ");
		int numero = Teclado.readInteger();
		int contador = 1;
		int sumaDivisores = 0;

		do {
			if ((numero % contador) == 0 && numero != contador) {
				sumaDivisores += contador;
			}
			contador++;
		} while (contador < numero);

		if (sumaDivisores == numero) {
			System.out.println(numero + " es perfecto.");
		} else {
			System.out.println(numero + " no es perfecto.");
		}
		// Fin modificacion
	}
}
