package Ejercicio03;

public class Empleado {
    private int numero;
    private String nombre;
    double sueldo;
    public Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    public int getNumero() {
        return this.numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getNombreE() {
        return nombre;
    }
    public void setNombreE(String nombre) {
        this.nombre = nombre;
    }
    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    @Override
    public String toString() {
        return "Empleado < "+ this.numero+" >"+
                "\n   Nombre: "+ this.nombre+
                "\n   Sueldo: "+ this.sueldo;
    }
}
