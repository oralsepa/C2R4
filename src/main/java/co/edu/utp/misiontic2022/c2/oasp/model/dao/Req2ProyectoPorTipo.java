package co.edu.utp.misiontic2022.c2.oasp.model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.O2ProyectoPorTipo;

public class Req2ProyectoPorTipo {
   
    public ArrayList<O2ProyectoPorTipo> requerimiento2() throws SQLException {
        
        ArrayList<O2ProyectoPorTipo> respuesta = new ArrayList<O2ProyectoPorTipo>();
        Connection conexion = JDBCUtilities.getConnection();

        try{

            String consulta =   "SELECT ID_Proyecto, Constructora, Ciudad, Estrato from Proyecto " +
                                "natural join Tipo t where Ciudad = 'Cartagena' order by Estrato asc";
 
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            while(resultado.next()){
                O2ProyectoPorTipo proyectos = new O2ProyectosPorTipo();
                proyectos.setId_proyecto(resultado.getInt("ID_Proyecto"));
                proyectos.setConstructora(resultado.getString("Constructora"));
                proyectos.setCiudad(resultado.getString("Ciudad"));
                proyectos.setEstrato(resultado.getInt("Estrato"));            
                respuesta.add(proyectos);
            }
            resultado.close();
            statement.close();

        } catch (SQLException e){
            System.out.println("Error en la consulta" + e);
        } finally{
            if(conexion != null){
                conexion.close();
            }
        }

        return respuesta;
    }        
}
