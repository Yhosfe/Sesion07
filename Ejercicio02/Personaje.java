package Ejercicio02;

public class Personaje {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;
    private int nivel;
    public Personaje(String nombre, int vida, int ataque, int def, int alc) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = def;
        this.alcance = alc;
        this.nivel = 1;
    }
    public Personaje(String nombre, int vida, int ataque, int def, int alc, int nivel) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = def;
        this.alcance = alc;
        this.nivel = nivel;
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
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    // Metedo que aumementa los atributos al subir de nivel
    public void subirNivel() {
        this.nivel +=1;
        this.vida +=1;
        this.ataque +=1;
        this.defensa +=1;
        this.alcance +=1;
    }
    // toString
    @Override
    public String toString() {
        return nombre+" "+vida+" "+ataque+" "+defensa+" "+alcance+" "+nivel;
    }
//    public String toString() {
//        return "    Nombre:" + this.nombre
//                + "\n    Vida:" + this.vida
//                + "\n    ataque:" + this.ataque
//                + "\n    Defensa:" + this.defensa
//                + "\n    Alcance:" + this.alcance;
//    }
}
