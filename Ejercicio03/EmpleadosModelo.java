package Ejercicio03;
import java.util.ArrayList;
public class EmpleadosModelo {
    ArrayList<Empleado> empleados;
    public EmpleadosModelo() {
        empleados = new ArrayList<>();
    }
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }
    public Empleado buscarEmpleado(int id) {
        for (Empleado empleado : empleados) {
            if (id == empleado.getNumero()){
                return empleado;
            }
        }
        return null;
    }
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
}
