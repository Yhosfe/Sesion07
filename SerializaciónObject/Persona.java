package SerializaciónObject;

import java.io.Serializable;

public class Persona implements Serializable {
    public static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;
    private transient String clave;

    public Persona() {}
    public Persona(String nombre, int edad, String contra) {
        this.nombre = nombre;
        this.edad = edad;
        this.clave = contra;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", clave: "+ clave + '}';
    }
}
