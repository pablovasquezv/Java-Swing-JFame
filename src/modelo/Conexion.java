/*
 * Clase Conexion.
 
 */
package modelo;

import java.sql.Connection;//Importamos el paquete Java sql de consulta estructurado.
import java.sql.DriverManager;//Importamos el paquete para crear un recurso valido para conectar.
import java.sql.SQLException;//Importamos el paquete para las exepciones.

/**
 * Clase Conexión Autor Juan Pablo Vasquez.
 */
public class Conexion {

    //Definimos cuatro parámetros  que son los necesarios para conectarse a la base de datos MYSQL. 
    //Utilizando esta estructura para tener un mejor control en caso de cambiar algun parámetro.
    String bd = "prueba";//el nombre de la base de datos.
    static String login = "root";//Estatico no cambia durante el ciclo de vida,  además para evitar que alguien cambie el  dato por error.
    static String password = "";//Estatico no cambia durante el ciclo de vida, ademásc para evitar que alguien cambie el  dato por error.
    String url = "jdbc:mysql://localhost/" + bd;//esto es obligatorio esta el jdbc y el tipo de basea a la que se esta conectando y la ruta donde esta la bd
    // en este computador y el bd es solo la ruta de base datos.  

    //Atributo de la clase  conexión  para manejar la conexión.
    Connection connection = null;//La variable conexion va ser el enlace  entre la aplicación y la base de datos.

    //Constructor de la clase conexión.
    public Conexion() {
        //Creamos un try para controlar la conexión.
        try {
            Class.forName("com.mysql.jdbc.Driver");//el drive que utilizaremos y el paqueta dónde esta el conector para base de datos.
            connection = DriverManager.getConnection(url, login, password);//Datos utilizados para conecta, creando un recurso valido para conectar.
        } catch (SQLException e) {//La exepcion en caso de no conectarse la mas cercana en que falló la conexión por eso la exepcion Sql.
            System.out.println(e);//Mostramos el mensaje de donde falló la conexión.
        } catch (ClassNotFoundException e) {//La exepcion por falla de driver.
            System.out.println(e);//Mostramos el mensaje de donde falló la conexión.
        } catch (Exception e) {//La exepcion mas generica.
            System.out.println(e);//Mostramos el mensaje de exepcion.
        }
    }

    //Creamos un método de getConnectión.
    public Connection getConnection() {
        return connection;//crea el recurso de la coneccion solamente eso.
    }

    //Creamos un método para desconectarnos.
    public void desconectar() {
        connection = null;//Elimina la conexión.
    }
}
