
package dao;


//import java.lang.System.Logger;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String SERVIDOR = "LAPTOP-UC6TCKKF\\LEOSERVER";
    private static final String USUARIO = "usuarioSQL";
    private static final String PW = "123";
    private static final String NOMBREBD = "Libros";
    private static final String PUERTO = "1433";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    public Connection obtenerConexion(){
        try{
            String conexionUrl = "jdbc:sqlserver://" + SERVIDOR +": " + PUERTO +
                    "; Databasename= " + NOMBREBD +"; user= " + USUARIO +
                    "; password = " + PW + ";";
            Class.forName(DRIVER);
            return (DriverManager.getConnection(conexionUrl));
        }catch(ClassNotFoundException | SQLException ex){
                Logger.getLogger(Conexion.class.getName()); //.log(Level.WARNING);
        }
        return null;
    }
    
    public void close(Connection conn){
        try{
        
        conn.close();
            
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()); //.log(Level.ERROR, null, ex);
        }
    
    }
    
}
