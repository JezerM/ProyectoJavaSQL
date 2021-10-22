/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import modelos.Autor;


public class TablaAutor {
  
    private ArrayList<Autor> Lista;
    private final Conexion conexion = new Conexion();
    private Connection conn; // Gestiona la conexion
    private PreparedStatement mostrarRegistros;
    private PreparedStatement insertarRegistros;
    private PreparedStatement modificarRegistros;
    private PreparedStatement eliminarRegistros;

    public TablaAutor() {
        try{
            conn = conexion.obtenerConexion();
            mostrarRegistros = conn.prepareStatement("Select * from Autor");
            insertarRegistros = conn.prepareStatement("Insert Into Autor(nombrePila,"
                                + " apellidoPaterno) Values(?, ?)");
            modificarRegistros = conn.prepareStatement("Update Autor set nombrePila = ?," 
                                + "apellidoPaterno = ? where idAutor = ?");
            eliminarRegistros = conn.prepareStatement("Delete From Autor where idAutor = ?");
            Lista = new ArrayList<>();
            
            Lista = listarRegistro();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
                System.exit(1);
        }
    }
    
    private ArrayList<Autor> listarRegistro(){
       ArrayList<Autor> result = null;
       ResultSet rs = null;
       try{
           rs = mostrarRegistros.executeQuery();
           result = new ArrayList<>();
           
           while(rs.next()){
               result.add(new Autor(
                    rs.getInt("idAutor"),
                    rs.getString("nombrePila"),
                    rs.getString("apellidoPaterno"),
                    1 //estado original 
               ));  
           }
       
       }catch(SQLException ex){
            ex.printStackTrace();
       }finally{
           try{
              rs.close();
           }catch(SQLException ex){
              conexion.close(conn);
           }
       }
       return result;
    }
    
    public int agregarLista(String nombrePila, String apellidoPaterno){
       try{
           Lista.add(new Autor(0,
                   nombrePila,
                   apellidoPaterno,
                   4 // estado nuevo registrado, sin guardar
           ));
       
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       
       return 0;
    }
    
    public int editarLista(int idAutor, String nombrePila, String apellidoPaterno){
        try{
            Autor autor = new Autor(
              idAutor,
              nombrePila,
              apellidoPaterno,
              2 // estafdo modifcado de la lista
            );
            
            for(Autor a: Lista){
                if(a.getIdAutor() == autor.getIdAutor()){
                    a.setNombrePila(autor.getNombrePila());
                    a.setApellidoPaterno(autor.getApellidoPaterno());
                    if(a.getEstado()!=0) a.setEstado(autor.getEstado());
                    return 1;
                }
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    public int eliminarEnLista(int idAutor){
        try{
           for(Autor a: Lista){
               if(a.getIdAutor() == idAutor){
                   a.setEstado(3); // estado eliminado en la lista
                   // aun no eliminado en BD
                   return 1;
               }
           } 
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public int agregarRegistroBD(Autor autor){
        int result = 0;
        
        try{
            modificarRegistros.setString(1, autor.getNombrePila());
            modificarRegistros.setString(2,autor.getApellidoPaterno());
            modificarRegistros.setInt(3,autor.getIdAutor());
            result = modificarRegistros.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            conexion.close(conn);
        }
        return result;
    }
    
    public int modifiarRegistroBD(Autor autor){
        int result = 0;
        
        try{
            eliminarRegistros.setInt(1, autor.getIdAutor());
            
            result = eliminarRegistros.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            conexion.close(conn);
        }
        return result;
    }
    
    public int eliminarRegistroBD(Autor autor){
        int result = 0;
        
        try{
            eliminarRegistros.setInt(1, autor.getIdAutor());
        
            result = eliminarRegistros.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }
    
    public String actualizarBD(){
        String msn = "";
        String msnError = "Errores en: ";
        int nuevos = 0, modificados = 0, eliminados = 0;
        int errorNuevos = 0, errorModificados = 0, errorEliminados = 0;
        
        for(Autor autor: Lista){
            switch(autor.getEstado()){
                
            case 1:
                    // si es original no hace nada
                break;
                
            case 2:
                    // Estado modificado
                    if(this.modifiarRegistroBD(autor) != 0){
                        modificados++;
                    } else{
                        errorModificados++;
                        msnError += "\n Error al modificar: " + autor.getNombrePila() + " " + autor.getApellidoPaterno();
                    }
                break;
                
            case 3:
                        // Estado eliminado
                    if(this.eliminarRegistroBD(autor) != 0){
                        eliminados++;
                    } else{
                        errorEliminados++;
                        msnError += "\n Error al eliminar: " + autor.getNombrePila() + " " + autor.getApellidoPaterno();
                    }
                break;
                
            case 4: 
                //Estado nuevo registrado
                if(this.agregarRegistroBD(autor) != 0){
                    nuevos++;
                    
                } else{
                    errorNuevos++;
                    msnError += "\n -Error al agregar nuevo registros: " + autor.getNombrePila() + " " + autor.getApellidoPaterno();
                
                }
                    break;
                    
            default:
                msnError += "\n Revise el registro: "+ autor.getNombrePila() + " " + autor.getApellidoPaterno();
                    break;
            }
        }
        
        msn = "Registros guardados: " + nuevos + "\nRegistros editados " + modificados +
               "\nRegistos eliminados: " + eliminados;
        
        if(!msnError.equals("Errores en: ")){
            msn += "\n" + msnError;
        }
        
        Lista = this.listarRegistro();
        return msn;
    }
    
    public ArrayList<Autor> getLista(){
        return Lista;
    
    }
    
}
