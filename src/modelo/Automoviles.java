/*
 * Clase  Plana  de  transporte Automoviles.
 */
package modelo;
/*
* Clase Automoviles
* Autor Juan Pablo Vásquez.
*/
public class Automoviles {

    //Variables
    String patente;
    String marca;
    int anyo;
    String color;
    int cilindrada;
    String tipo;

    //Constructor Vacio.
    public Automoviles() {
    }

    //Constructor Automoviles.

    public Automoviles(String patente, String marca, int anyo, String color, int cilindrada, String tipo) {
        this.patente = patente;
        this.marca = marca;
        this.anyo = anyo;
        this.color = color;
        this.cilindrada = cilindrada;
        this.tipo = tipo;
    }
    

    //Métodos Get y Set.

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   

}
