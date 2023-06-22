package es.unileon.prg.tema6;

public class Ecuacion2Grado {
    private double a;
    private double b;
    private double c;

    public Ecuacion2Grado(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public int numeroDeSoluciones() {
        int numeroSoluciones;
        double discriminante = Math.pow(this.b, 2) - (4 * this.a * this.c);

        if (discriminante > 0) {
            numeroSoluciones = 2;
        } else if (discriminante < 0) {
            numeroSoluciones = 0;
        } else {
            numeroSoluciones = 1;
        }

        return numeroSoluciones;
    }

    public String calcularSoluciones(int numeroSoluciones) {
        
        String resultado = "";
        double sol1 = 0;
        double sol2 = 0;

        if (numeroSoluciones == 0) {
            resultado = "No hay soluciones.";
        } else {
            sol1 = ((-this.b) + Math.sqrt(Math.pow(this.b, 2) - (4 * this.a * this.c))) / (2 * this.a);
            sol2 = ((-this.b) - Math.sqrt(Math.pow(this.b, 2) - (4 * this.a * this.c))) / (2 * this.a);
        }

        if (numeroSoluciones == 1) {
            resultado = "Unica solucion: " + sol1;
        } else if (numeroSoluciones == 2) {
            resultado = "Solucion 1: " + sol1 + "\nSolucion 2: " + sol2;
        }

        return resultado;
    }

    public String toString() {
        return "Ecuacion: " + a + "x^2 + " + b + "x + " + c + " = 0" + "\nNumero de soluciones: " + numeroDeSoluciones() + "\n" + calcularSoluciones(numeroDeSoluciones());
    }
}
