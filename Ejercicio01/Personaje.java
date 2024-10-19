package Ejercicio01;

public class Personaje {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;
    public Personaje(String nombre, int vida, int ataque, int def, int alc) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = def;
        this.alcance = alc;
    }
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getDefensa() {
        return defensa;
    }
    public void setDefensa(int def) {
        this.defensa = def;
    }
    public int getAlcance() {
        return alcance;
    }
    public void setAlcance(int alc) {
        this.alcance = alc;
    }
    // toString
    @Override
    public String toString() {
        return nombre+" "+vida+" "+ataque+" "+defensa+" "+alcance;
    }
//    public String toString() {
//        return "    Nombre:" + this.nombre
//                + "\n    Vida:" + this.vida
//                + "\n    ataque:" + this.ataque
//                + "\n    Defensa:" + this.defensa
//                + "\n    Alcance:" + this.alcance;
//    }
}
