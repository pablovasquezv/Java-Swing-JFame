/*
 * Clase Plana  de transporte Conductores.
 */
package modelo;

/**
 * Clase Conductor Autor Juan Pablo Vásquez.
 */
public class Conductores {

    //Variables
    int rut;
    String nombre;
    String apellido_Paterno;
    String apellido_Materno;
    String sexo;
    String fecha_Nacimiento;
    String tipo_Licencia;

    //Constructor Vacio.
    public Conductores() {
    }

    //Constructor Clase Conductores.
    public Conductores(int rut, String nombre, String apellido_Paterno, String apellido_Materno, String sexo, String fecha_Nacimiento, String tipo_Licencia) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido_Paterno = apellido_Paterno;
        this.apellido_Materno = apellido_Materno;
        this.sexo = sexo;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.tipo_Licencia = tipo_Licencia;
    }

    //Métodos Gett y Set.
    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_Paterno() {
        return apellido_Paterno;
    }

    public void setApellido_Paterno(String apellido_Paterno) {
        this.apellido_Paterno = apellido_Paterno;
    }

    public String getApellido_Materno() {
        return apellido_Materno;
    }

    public void setApellido_Materno(String apellido_Materno) {
        this.apellido_Materno = apellido_Materno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public String getTipo_Licencia() {
        return tipo_Licencia;
    }

    public void setTipo_Licencia(String tipo_Licencia) {
        this.tipo_Licencia = tipo_Licencia;
    }

}
