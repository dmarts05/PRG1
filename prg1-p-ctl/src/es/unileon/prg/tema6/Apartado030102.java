package es.unileon.prg.tema6;
/**
 * Clase con los ejercicios correspondientes a sentencias condicionales:
 * sentencias con la instruccion "if-else".
 *
 * @author PRG
 * @version 1.0
 */
public class Apartado030102 extends Apartado {

	protected String obtenerPractica(){
		return "P-CTL";
	}

	protected String obtenerBloque() {
		return "Instruccion if-else";
	}

	/**
	 * Instruccion if-else - Ejercicio1.
	 *
	 * </br>
	 *
	 * Realizar las modificaciones necesarias para que al ejecutar el metodo se ofrezca 
	 * al usuario la posibilidad de obtener el area o el perimetro del rectangulo.
	 * 
	 */
	public void ejercicio01() {
		cabecera("01","");

		Rectangulo rectangulo=new Rectangulo(10,5);
		System.out.println("Introduce una opcion (1 - Area, 2 - Perimetro):");
		// Inicio modificacion
        int opcion = Teclado.readInteger();
		if (opcion == 1) {
			System.out.println(rectangulo.getArea());
		} else if (opcion == 2) {
			System.out.println(rectangulo.getPerimetro());
		}
		
		// Fin modificacion
	}

	/**
	 * Instruccion if-else - Ejercicio2.
	 *
	 *  Realizar las modificaciones necesarias para que al ejecutar el metodo  se ofrezca al 
	 *  usuario la posibilidad de introducir un anio por el teclado y se le diga si es un anio bisiesto o no.
	 *  Un anio es bisiesto si es multiplo de 400 o si es multiplo de 4 sin serlo de 100
	 *
	 */
	public void ejercicio02() {
		cabecera("02", "");
		// Inicio modificacion
		System.out.println("Indica el anio para comprobar si es bisiesto: ");
		int anio = Teclado.readInteger();
		boolean bisiesto = true;

		if ((anio % 4) == 0) {
			if ((anio % 100) == 0) {
				if ((anio % 400) == 0) {
					bisiesto = true;
				} else {
					bisiesto = true;
				}
			} else {
				bisiesto = true;
			}	
		} else {
			bisiesto = false;
		}
		// Fin modificacion
	}

	/**
	 * Instruccion if-else - Ejercicio3.
	 *
	 * Se pide
	 * 
	 * <ul>
	 * <li> Quitar los comentarios indicados y compilar  el metodo 02.
	 * <li> Identificar los errores de compilacion.
	 * <li> Explicar en el fichero LEEME.TXT los errores existentes.
	 * <li> Implementar el metodo int compareTo(NumeroEntero n) de la clase NumeroEntero de forma que:
	 * <ul>
	 * <li>	retorne -1 si el valor del NumeroEntero sobre el que se ejecuta el metodo  
	 * 		es menor que  el valor del numero n.
	 * <li> retorne 0 si el valor de los dos objetos NumeroEntero son iguales.
	 * <li> retorne 1 si el valor del NumeroEntero sobre el que se ejecuta el metodo  
	 * 		es mayor que  el valor del numero n.
	 * </ul>
	 * <li> Modificar el  metodo realizando las comparaciones entre los numeros usando  el metodo compareTo.
	 * <li> Compilar y ejecutar el metodo y analizar los resultados obtenidos.
	 * </ul>
	 *
	 */
	public void ejercicio03() {
		cabecera("03", "");

        // Inicio modificacion
		
        NumeroEntero n1 = new NumeroEntero(10);
        NumeroEntero n2 = new NumeroEntero(10);
        
        
        if (n1.compareTo(n2) == 1){
        	 System.out.println("N1 -> "+n1);
             System.out.println("N1 es mayor que N2");
        }
        else if (n1.compareTo(n2) == -1) {
            System.out.println("N1 -> "+n1);
            System.out.println("N1 es menor que N2");
        }
        else
           System.out.println("N1 y N2 son iguales -> N1 -> "+n1+" N2 -> "+n2);
		
		
		// Fin modificacion
		
	}

	/**
	 * Instruccion if-else - Ejercicio4.
	 *
	 * </br>
	 *
	 * 
	 * Modificar el metodo para que al ejecutarlo se le pida al usuario que introduzca dos numeros 
	 * y a continuacion se le ofrezcan las siguientes opciones:
	 * <ul>
	 * <li>	1 - Sumar: Se mostrara por pantalla la suma de los numeros
	 * <li> 2 - Multiplicar:Se mostrara por pantalla la multiplicacion de los dos numeros
	 * <li> 3 - Divisores:	Se mostrara por pantalla: si el primero es divisor del segundo, si el segundo es divisor del primero o si ninguno es divisor del otro.
	 *  		Si no introduce ninguna de las opciones se mostrara el mensaje : Opcion incorrecta
	 *  </ul>
	 *  	 
	 */
	public void ejercicio04() {
		cabecera("04", "");

		// Inicio modificacion
		System.out.println("Introduce el numero 1: ");
		int n1 = Teclado.readInteger();
		System.out.println("Introduce el numero 2: ");
		int n2 = Teclado.readInteger();
		System.out.println("1 - Sumar; 2 - Multiplicar; 3 - Divisores: ");
		int opcion = Teclado.readInteger();
		int resultado;

		if (opcion == 1) {
			resultado = n1 + n2;
			System.out.println("Resultado: " + resultado);
		} else if (opcion == 2) {
			resultado = n1 * n2;
			System.out.println("Resultado: " + resultado);
		} else if (opcion == 3) {
			if ((n1 % n2) == 0) {
				System.out.println("El segundo es divisor del primero.");
			} else if ((n2 % n1) == 0) {
				System.out.println("El primero es divisor del segundo.");
			} else {
				System.out.println("Ninguno es divisor del otro.");
			}
		} else {
			System.out.println("Opcion incorrecta.");
		}
        // Fin modificacion
	}

	/**
	 * Instruccion if-else - Ejercicio5.
	 *
	 * Crear una clase denominada Ecuacion2Grado que tenga como atributos los coeficientes de 
	 * una ecuacion de segundo grado (a,b,c)  (ax2 +bx +c=0). Definir e implementar los siguientes metodos
	 * <ul>
	 * <li>	Un constructor que reciba los tres coeficientes de la ecuacion que se va a crear (a,b,c)
	 * <li>	Tres metodos get para cada uno de sus atributos.
	 * <li> Un metodo numeroDeSoluciones que retorne el numero de  soluciones de la ecuacion.
	 * <li> El metodo String toString() que retorne un String representativo de la ecuacion indicando el numero de soluciones que tiene 
	 * 		y el valor para cada una de las soluciones que tenga.
	 * </ul>
	 * 
	 * Probar la clase realizando las modificaciones necesarias y ejecutando el metodo ejercicio5().
	 * 
	 */
	public void ejercicio05() {
		cabecera("05","");

		int a=4, b=-7, c=2; //Modificar los valores para realizar pruebas o leerlos por teclado
		
		Ecuacion2Grado ecuacion=new Ecuacion2Grado(a,b,c);
		// Inicio modificacion
		System.out.println(ecuacion);
        // Fin modificacion
	}

	/**
	 * Instruccion if-else - Ejercicio6.
	 *
	 * Modificar el metodo  para que al ejecutarlo se le pida al usuario que introduzca tres numeros  
	 * y se indique cual es el mayor de los tres. Tambien se informara si hay dos o tres numeros iguales
	 * y cuales son. 
	 *
	 */
	public void ejercicio06() {
		cabecera("06", "");

		// Inicio modificacion
		System.out.println("Introduce el numero 1: ");
		int n1 = Teclado.readInteger();
		System.out.println("Introduce el numero 2: ");
		int n2 = Teclado.readInteger();
		System.out.println("Introduce el numero 3: ");
		int n3 = Teclado.readInteger();

		if (n1 >= n2 && n1 >= n3) {
			System.out.println("El numero mayor es: " + n1);
		} else if (n2 >= n1 && n2 >= n3) {
			System.out.println("El numero mayor es: " + n2);
		} else if (n3 >= n1 && n3 >= n2) {
			System.out.println("El numero mayor es: " + n3);
		}

		if (n1 == n2  && n1 == n3) {
			System.out.println("Todos los numeros son iguales.");
		} else if (n1 == n2) {
			System.out.println("El numero 1 es igual al numero 2: " + n1);
		} else if (n1 == n3) {
			System.out.println("El numero 1 es igual al numero 3: " + n1);
		} else if (n2 == n3) {
			System.out.println("El numero 2 es igual al numero 3: " + n2);
		}
		// Fin modificacion
	}
}
