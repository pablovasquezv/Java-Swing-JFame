/*
 * Clase  plana de transporte plana Automoviles y conductores.
 */
package modelo;

/**
 *  Clase Automovil Autor 
 * Juan Pablo Vásquez Vásquez.
 */
public class Asignacion {

    //Atributos
    String patente;
    int rut_Conductor;
    String fecha_Asignacion;

    //Constructor  Vacio de Asignación.
    public Asignacion() {
    }

    //Constructor  de Asignación.
    public Asignacion(String patente, int rut_Conductor, String fecha_Asignacion) {
        this.patente = patente;
        this.rut_Conductor = rut_Conductor;
        this.fecha_Asignacion = fecha_Asignacion;
    }

    //Método Gett y Set.
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getRut_Conductor() {
        return rut_Conductor;
    }

    public void setRut_Conductor(int rut_Conductor) {
        this.rut_Conductor = rut_Conductor;
    }

    public String getFecha_Asignacion() {
        return fecha_Asignacion;
    }

    public void setFecha_Asignacion(String fecha_Asignacion) {
        this.fecha_Asignacion = fecha_Asignacion;
    }

}
