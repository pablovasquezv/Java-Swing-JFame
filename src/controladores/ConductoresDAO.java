/*
 * Clase  de acceso a datos ConductoresDAO.
 */
package controladores;

/*
 * Clase: ConductorDAO
 * Autor: Juan Pablo Vásquez Vásquez. 
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;//
import modelo.Conductores;
import modelo.Conexion;

public class ConductoresDAO {

    //Método crear conductores.
    public void crearConductores(Conductores conductores) {//Creamos el paquete Conductores.
        //Atributos
        String sql = "";// cadena vacia  Sql para construi la  instrucion para insertar.
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión,
        //Creamos la consulta SQL  para insertar los valores en la tabla.
        sql = "INSERT INTO conductores VALUES"//Insertamos los valores 
                + "(" + conductores.getRut()//Capturamos el rut del conductor.
                + ",'" + conductores.getNombre()//Capturamos el Nombre.
                + "','" + conductores.getApellido_Paterno()//Capturamos el Apellido_Paterno.
                + "','" + conductores.getApellido_Materno()//Capturamos el Apellido_Paterno.
                + "','" + conductores.getSexo()//Capturamos el Sexo.
                + "','" + conductores.getFecha_Nacimiento()//Capturamos el Fecha_Nacimiento.
                + "','" + conductores.getTipo_Licencia()//Capturamos el Tipo_Licencia.
                + "')";//Cerramos la inserción.

        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            estatuto.executeUpdate(sql);//ejecuta la insercion  que es una actualización o consulta ala bd donde  guarda los datos.
            JOptionPane.showMessageDialog(null, "se ha registrado exitosamente",
                    "informacion", JOptionPane.INFORMATION_MESSAGE);//Mostramos el mensaje.
            estatuto.close();//Cerramos el uso del recurso.
            con.desconectar();//Desconectamos la conexión.
        } catch (SQLException e) {//Método 
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "NO SE REGISTRO EL ALUMNO", "INFORMACION", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Método eliminar conductor
    public void eliminarConductor(int rut) {
        //Atributos
        String consulta = "";// cadena vacia  Sql para construi la  instrucion para insertar.
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
        //Creamos la consulta SQL  para eliminra los valores en la tabla.
        consulta = "DELETE FROM  conductores  WHERE rut =" + rut;//Eliminamos donde esta el

        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            estatuto.executeUpdate(consulta);//ejecuta la insercion  que es una actualización o consulta ala bd donde  guarda los datos.
            JOptionPane.showMessageDialog(null, "se ha eliminado exitosamente",
                    "informacion", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

            JOptionPane.showMessageDialog(null, "NO SE ELIMINO EL ALUMNO", "INFORMACION", JOptionPane.ERROR_MESSAGE);

        }
    }

    //Método Midificar.
    public void Modificar(Conductores conductores) {
        //Atributos
        String sql = "";// cadena vacia  Sql para construi la  instrucion para insertar.
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
        //Creamos la consulta SQL  para modificar los valores en la tabla.
        sql = "UPDATE  CONDUCTORES SET "
                + ",nombre= '" + conductores.getNombre()
                + "',apellido_paterno='" + conductores.getApellido_Paterno()
                + "',apellido_materno='" + conductores.getApellido_Materno()
                + "',sexo='" + conductores.getSexo()
                + "',fecha_nacimiento='" + conductores.getFecha_Nacimiento()
                + "'WHERE  rut=" + conductores.getRut();

        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            estatuto.executeUpdate(sql);//ejecuta la insercion  que es una actualización o consulta ala bd donde  guarda los datos
            JOptionPane.showMessageDialog(null, "se ha registrado exitosamente",
                    "informacion", JOptionPane.INFORMATION_MESSAGE);//Mostramos el mensaje
            estatuto.close();//Cerramos el uso del recurso.
            con.desconectar();//Desconectamos la conexión.
        } catch (SQLException e) {
            System.out.println(e.getMessage());

            JOptionPane.showMessageDialog(null, "NO SE MODIFICO EL CONDUCTOR", "INFORMACION", JOptionPane.ERROR_MESSAGE);

        }

    }

    //Método ResultSet.
    public ResultSet listarConductores() {
        //Atributos.
        ResultSet rs = null;//Iniciamos el conjunto de resultado.
        String sql = "";// cadena vacia  Sql para construir la  instrución para .
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
        //Creamos la consulta SQL  para mostrar todos los valores en la tabla.
        sql = "SELECT * FROM conductores ";//Seleccionamos todos lo valores de la tabla conductores.
        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            rs = estatuto.executeQuery(sql);//Devolvemos la consulta y lo que devuelva queda guardado en rs de todos los registros de la tabla.
            //JOptionPane.showMessageDialog(null, "se ha modificado exitosamente",
            //  "informacion", JOptionPane.INFORMATION_MESSAGE);

            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

            JOptionPane.showMessageDialog(null, "NO SE MODIFICO EL ALUMNO", "INFORMACION", JOptionPane.ERROR_MESSAGE);

        }
        return rs;//Retorna el Resulset con  todos los registros de la tabla.
    }
    
    //Método ResultSet buscar Conductores.

    public ResultSet buscarConductores(int rut) {
        //Atributos.
        ResultSet rs = null;//Iniciamos el conjunto de resultado.
        //Creamos la consulta SQL  para buscar los rut en la tabla.
        String consulta = "SELECT * FROM conductores WHERE rut=" + rut;
        Conexion con = new Conexion();//Creamos el objeto de la clase conexión.
        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            rs = estatuto.executeQuery(consulta);//insercion
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nose se puede consultar!");
            System.out.println(ex.getMessage());
        }

        return rs;
    }
    //Método actualizar Conductores.

    public void actualizarConductores(Conductores conductores) {
        //Atributos.
        ResultSet rs = null;//Iniciamos el conjunto de resultado.
        int rut = conductores.getRut();
        String nombre = conductores.getNombre();
        String apellido_Paterno = conductores.getApellido_Paterno();
        String apellido_Materno = conductores.getApellido_Materno();
        String sexo = conductores.getSexo();
        String fecha_Nacimiento = conductores.getFecha_Nacimiento();
        String tipo_Licencia = conductores.getTipo_Licencia();
        //Creamos la consulta SQL  para modificar los valores en la tabla.
        String consulta = " UPDATE conductores "
                + "SET nombre = '" + nombre + "'"
                + ",Apellido_Paterno = '" + apellido_Paterno + "'"
                + ",Apellido_Materno= '" + apellido_Materno + "'"
                + ",Sexo = '" + sexo + "'"
                + ",Fecha_Nacimiento = '" + fecha_Nacimiento + "'"
                + ",Tipo_Licencia = '" + tipo_Licencia + "'"
                + " WHERE RUT = " + rut;
        try {
            Conexion con = new Conexion();//Creamos el objeto de la clase conexión.
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            estatuto.executeUpdate(consulta);//ejecuta la insercion en al base de datos,  que es una actualización o consulta ala bd donde  guarda los datos
            JOptionPane.showMessageDialog(null, "Se actualizo Corectamente!");;//Mostramos el mensaje
            estatuto.close();//Cerramos el uso del recurso.
            con.desconectar();//Desconectamos la conexión.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nose se puede consultar!");;//Mostramos el mensaje
            System.out.println(ex.getMessage());;//Mostramos el mensaje
        }

    }
}
