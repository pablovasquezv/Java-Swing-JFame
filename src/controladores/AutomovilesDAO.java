package controladores;

/*
 * Clase de acceso a datos AutomovilesDAO.
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Automoviles;
import modelo.Conexion;

/*
 * Clase: AutomovilesDAO
 * Autor: Juan Pablo Vásquez Vásquez. 
 */ 

public class AutomovilesDAO {

    public void crearAutomoviles(Automoviles automoviles) {
        //Atributos
        String sql = "";// cadena vacia  Sql para construi la  instrucion para insertar.
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
        //Creamos la consulta SQL  para insertar los valores en la tabla.
        sql = "INSERT INTO automoviles VALUES"//Insertamos los valores 
                + "('" + automoviles.getPatente()//Capturamos el Patente.
                + "','" + automoviles.getMarca()//Capturamos el Marca.
                + "'," + automoviles.getAnyo()//Capturamos el Anyo.
                + ",'" + automoviles.getColor()//Capturamos el Color.
                + "'," + automoviles.getCilindrada()//Capturamos la Cilindrada.
                + ",'" + automoviles.getTipo()//Capturamos el Tipo.
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
                    "INFORMACION", JOptionPane.ERROR_MESSAGE);//Mostramos el mensaje

        }
    }

    //Método Eliminar automoviles.
    
    public void elminarAutomoviles(String Patente) {
        //Atributos
        String consulta = "";// cadena vacia  Sql para construi la  instrucion para insertar.
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
        //Creamos la consulta SQL  para eliminar los valores en la tabla.
        consulta = "DELETE  FROM  automoviles  WHERE Patente = '" + Patente + "'";

        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            estatuto.executeUpdate(consulta);//ejecuta la insercion  que es una actualización o consulta ala bd donde  guarda los datos.
            JOptionPane.showMessageDialog(null, "se ha eliminado exitosamente",
                    "informacion", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();//Cerramos el uso del recurso.
            con.desconectar();//Desconectamos la conexión.
        } catch (SQLException e) {
            System.out.println(e.getMessage());//Mostramos el mensaje

            JOptionPane.showMessageDialog(null, "NO SE ELIMINO EL Automovil", "INFORMACION", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println(e);//Mostramos el mensaje
        }

    }
    
    //Creamos un Método para modificar los automoviles.
    
    public void modificarAutomoviles(Automoviles automoviles) {
        //Atributos.
        String sql = "";// cadena vacia  Sql para construi la  instrucion para modificar.
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
        //Creamos la consulta SQL  para insertar los valores en la tabla.
        sql = "UPDATE  automoviles SET "
                + ", Marca = '" + automoviles.getMarca()
                + "', Anyo = " + automoviles.getAnyo()
                + ", Color = '" + automoviles.getColor()
                + "', Cilindrada = " + automoviles.getCilindrada()
                + ", Tipo = '" + automoviles.getTipo()
                + "' WHERE Patente = '" + automoviles.getPatente() + "'";//Cerramos la inserción

        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            estatuto.executeUpdate(sql);//ejecuta la insercion  que es una actualización o consulta ala bd donde  guarda los datos.
            JOptionPane.showMessageDialog(null, "se ha modificado exitosamente",
                    "informacion", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();//Cerramos el uso del recurso.
            con.desconectar();//Desconectamos la conexión.
        } catch (SQLException e) {
            System.out.println(e.getMessage());//Mostramos el mensaje

            JOptionPane.showMessageDialog(null, "NO SE MODIFICO EL AUTOMOVIL", "INFORMACION", JOptionPane.ERROR_MESSAGE);

        }

    }
    
    //Creamos un Método para listar los automoviles.
    
    public ResultSet listarAutomoviles() {
        //Atributos.
        ResultSet rs = null;//Iniciamos el conjunto de resultado.
        String sql = "";// cadena vacia  Sql para construir la  instrución para .
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
        //Creamos la consulta SQL  para mostrar todos los valores en la tabla.
        sql = "SELECT * FROM Automoviles ";
        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            rs = estatuto.executeQuery(sql);//Devolvemos la consulta y lo que devuelva queda guardado en rs de todos los registros de la tabla.
            //JOptionPane.showMessageDialog(null, "se ha modificado exitosamente",
            //  "informacion", JOptionPane.INFORMATION_MESSAGE);

            con.desconectar();//Desconectamos la conexión.
        } catch (SQLException e) {
            System.out.println(e.getMessage());//Mostramos el mensaje

            JOptionPane.showMessageDialog(null, "NO SE Listaron los automoviles", "INFORMACION", JOptionPane.ERROR_MESSAGE);

        }
        return rs;//Retorna el Resulset con  todos los registros de la tabla.
    }
    
    //Creamos un Método para buscar los automoviles.
    
    public ResultSet buscarAutomoviles(String patente) {
        //Atributos.
        ResultSet rs = null;//Iniciamos el conjunto de resultado.
        //Creamos la consulta SQL  para mostrar todos los valores en la tabla.
        String consulta = "SELECT * FROM automoviles WHERE Patente =  '" + patente + "'";
        Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
        try {
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            rs = estatuto.executeQuery(consulta);//Devolvemos la consulta y lo que devuelva queda guardado en rs de todos los registros de la tabla.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nose se puede consultar!");
            System.out.println(ex.getMessage());
        }

        return rs;//Retorna el Resulset con  todos los registros de la tabla.
    }
    
    //Creamos un Método para modificar los automoviles.
    
    public void actualizarAutomoviles(Automoviles automoviles) {
        //Atributos.
        ResultSet rs = null;//Iniciamos el conjunto de resultado.
        String patente = automoviles.getPatente();
        String marca = automoviles.getMarca();
        int anyo = automoviles.getAnyo();
        String color = automoviles.getColor();
        int cilindrada = automoviles.getCilindrada();
        String tipo = automoviles.getTipo();

        String consulta = " UPDATE automoviles "
                + "SET Marca = '" + marca + "'"
                + ", Anyo = " + anyo + ""
                + ", Color = '" + color + "'"
                + ", Cilindrada = " + cilindrada + ""
                + ", Tipo = '" + tipo + "'"
                + " WHERE Patente = '" + patente + "'";
        try {
            Conexion con = new Conexion();//Creamos un objeto de la clase conexión.
            Statement estatuto = con.getConnection().createStatement();//Creamos una declaracion en esta conexión.
            estatuto.executeUpdate(consulta);//ejecuta la insercion  que es una actualización o consulta ala bd donde  guarda los datos.
            JOptionPane.showMessageDialog(null, "Se actualizo Corectamente!");
            estatuto.close();//Cerramos el uso del recurso.
            con.desconectar();//Desconectamos la conexión.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nose se puede consultar!");//Mostramos el mensaje.
            System.out.println(ex.getMessage());//Mostramos el mensaje.
        }

    }
}
