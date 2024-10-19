package Actividad06;

import Actividad05.Persona;

public class Alumno extends Persona {
    private Fecha fechaMatricula;

    public Alumno(String nombre, String telefono, String direccion, Fecha fechaMatricula) {
        super(nombre, telefono, direccion);
        this.fechaMatricula = new Fecha();
        setFechaMatricula(fechaMatricula);

    }
    public Fecha getFechaMatricula() {
        return fechaMatricula;
    }
    public void setFechaMatricula(Fecha fechaN) {
        this.fechaMatricula.setAno(fechaN.getAno());
        this.fechaMatricula.setMes(fechaN.getMes());
        this.fechaMatricula.setDia(fechaN.getDia());

    }
}
