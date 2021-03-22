/*
 * Clase de acceso a datos Asignacion.
 */
package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Asignacion;
import modelo.Automoviles;
import modelo.Conexion;

/*
 * Clase: ConductoDAO
 * Autor: Juan Pablo Vásquez Vásquez. 
 */
public class AsignacionDAO {

    public void crearAsignacion(Asignacion asignacion) {
        //Atributos
        String sql = "";// cadena vacia  Sql para construi la  instrucion para insertar.
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
        //Creamos la consulta SQL  para insertar los valores en la tabla.
        sql = "INSERT INTO asignacion VALUES"//Insertamos los valores 
                + "('" + asignacion.getPatente()//Capturamos Patente.
                + "'," + asignacion.getRut_Conductor()//Capturamos Rut_Conductor.
                + ",'" + asignacion.getFecha_Asignacion()//Capturamos Fecha_Asignacion.
                + "')";//Cerramos la inserción.

        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            estatuto.executeUpdate(sql);//ejecuta la insercion  que es una actualización o consulta ala bd donde  guarda los datos.
            JOptionPane.showMessageDialog(null, "se ha registrado exitosamente",
                    "informacion", JOptionPane.INFORMATION_MESSAGE);//Mostramos el mensaje.
            estatuto.close();//Cerramos el uso del recurso.
            con.desconectar();//Desconectamos la conexión.
        } catch (SQLException e) {
            System.out.println(e.getMessage());//Mostramos el mensaje.

            JOptionPane.showMessageDialog(null, "NO SE REGISTRO EL AUTOMOVIL :(",
                    "INFORMACION", JOptionPane.ERROR_MESSAGE);//Mostramos el mensaje.

        }
    }

    //ELIMINAR
    public void eliminarAsignacion(String Patente) {
        //Atributos
        String consulta = "";// cadena vacia  Sql para construi la  instrucion para insertar.
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
        //Creamos la consulta SQL  para insertar los valores en la tabla.
        consulta = "DELETE FROM  asignacion  WHERE Patente = '" + Patente + "'";

        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            estatuto.executeUpdate(consulta);//ejecuta la insercion  que es una actualización o consulta ala bd donde  guarda los datos.
            JOptionPane.showMessageDialog(null, "se ha registrado exitosamente",
                    "informacion", JOptionPane.INFORMATION_MESSAGE);//Mostramos el mensaje.
            estatuto.close();//Cerramos el uso del recurso.
            con.desconectar();//Desconectamos la conexión.
        } catch (SQLException e) {
            System.out.println(e.getMessage());//Mostramos el mensaje.

            JOptionPane.showMessageDialog(null, "NO SE ELIMINO EL AUTOMOVIL",
                    "INFORMACION", JOptionPane.ERROR_MESSAGE);//Mostramos el mensaje.

        }
    }

    public void modificarAutomoviles(Asignacion asignacion) {
        //Atributos.
        String sql = "";// cadena vacia  Sql para construir la  instrución para .
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
        //Creamos la consulta SQL  para insertar los valores en la tabla.
        sql = "UPDATE  asignacion SET "
                + ",Rut= '" + asignacion.getRut_Conductor()
                + "',Fecha_Asignacion = " + asignacion.getFecha_Asignacion()
                + "' WHERE Patente = '" + asignacion.getPatente();

        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            estatuto.executeUpdate(sql);//ejecuta la insercion  que es una actualización o consulta ala bd donde  guarda los datos.
            JOptionPane.showMessageDialog(null, "se ha modificado exitosamente",
                    "informacion", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();//Cerramos el uso del recurso.
            con.desconectar();//Desconectamos la conexión.
        } catch (SQLException e) {
            System.out.println(e.getMessage());//mostramos el mensaje.

            JOptionPane.showMessageDialog(null, "NO SE MODIFICO EL ALUMNO", "INFORMACION", JOptionPane.ERROR_MESSAGE);//mostramos el mensaje.

        }

    }

    //Médo listar.
    public ResultSet listarAsignacion() {
        //Atributos.
        ResultSet rs = null;//Iniciamos el conjunto de resultado.
        String sql = "";// cadena vacia  Sql para construir la  instrución para .
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
        //Creamos la consulta SQL  para mostrar todos los valores en la tabla.
        sql = "SELECT * FROM asignacion ";
        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            rs = estatuto.executeQuery(sql);//Devolvemos la consulta y lo que devuelva queda guardado en rs de todos los registros de la tabla.
            //JOptionPane.showMessageDialog(null, "se ha modificado exitosamente",
            //  "informacion", JOptionPane.INFORMATION_MESSAGE);

            con.desconectar();//Desconectamos la conexión.
        } catch (SQLException e) {
            System.out.println(e.getMessage());

            JOptionPane.showMessageDialog(null, "NO SE MODIFICO EL ALUMNO", "INFORMACION", JOptionPane.ERROR_MESSAGE);

        }
        return rs;//Retorna el Resulset con  todos los registros de la tabla.
    }

    public ResultSet buscarAsignacion(String patente) {
        //Atributos.
        ResultSet rs = null;//Iniciamos el conjunto de resultado.
        //Creamos la consulta SQL  para insertar los valores en la tabla.
        String consulta = "SELECT * FROM asignacion WHERE Patente=" + patente;
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            rs = estatuto.executeQuery(consulta);//Devolvemos la consulta y lo que devuelva queda guardado en rs de todos los registros de la tabla.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nose se puede consultar!");
            System.out.println(ex.getMessage());//mostramos el mensaje.
        }

        return rs;//Retorna el Resulset con  todos los registros de la tabla.
    }

    public void actualizarAutomoviles(Asignacion asignacion) {
        //Atributos.
        ResultSet rs = null;//Iniciamos el conjunto de resultado.
        String patente = asignacion.getPatente();
        int rut = asignacion.getRut_Conductor();
        String fecha = asignacion.getFecha_Asignacion();

        String consulta = " UPDATE asignacion "
                + "SET Rut = '" + rut + "'"
                + ", Fecha_Asignacion = " + fecha + "'"
                + " WHERE Patente = '" + patente + "'";
        try {
            Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
            Statement estatuto = con.getConnection().createStatement();
            estatuto.executeUpdate(consulta);//insercion
            JOptionPane.showMessageDialog(null, "Se actualizo Corectamente!");//mostramos el mensaje.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nose se puede consultar!");//mostramos el mensaje.
            System.out.println(ex.getMessage());//mostramos el mensaje.
        }

    }
}
