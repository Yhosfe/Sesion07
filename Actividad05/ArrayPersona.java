package Actividad05;

public class ArrayPersona {
    public Persona[] arreglo;
    final int max = 7;
    int tamano = 0;
    public ArrayPersona() {
        this.arreglo = new Persona[this.max];
    }
    public void printArray(String nombre) {
        for (int i =0; i<this.tamano; i++){
            if (this.arreglo[i].getNombre().equalsIgnoreCase(nombre)){
                System.out.println(this.arreglo[i]);
            }
        }
    }
    public void addArrat(Persona persona){
        if (this.tamano == max){
            System.exit(1);
        }
        this.arreglo[tamano++] = persona;
    }
    public void imprimirArray() {
        for (int i =0; i<this.tamano; i++){
            System.out.println(this.arreglo[i]);
        }
    }


}