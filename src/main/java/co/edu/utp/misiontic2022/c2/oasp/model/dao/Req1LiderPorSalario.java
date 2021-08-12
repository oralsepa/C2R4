package co.edu.utp.misiontic2022.c2.oasp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//Librerías para SQL y Base de Datos
import java.sql.SQLException;
//Estructura de datos
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.oasp.model.vo.O1LiderPorSalario;
import co.edu.utp.misiontic2022.c2.oasp.util.JDBCUtilities;

public class Req1LiderPorSalario {
    
    public ArrayList<O1LiderPorSalario> requerimiento1() throws SQLException {
        
        ArrayList<O1LiderPorSalario> respuesta = new ArrayList<O1LiderPorSalario>();
        Connection conexion = JDBCUtilities.getConnection();

        try{

            String consulta =   "select Nombre, Primer_Apellido, ID_lider, Salario from Lider "+
                                "where Salario <= 500000 order by Salario asc";
 
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            while(resultado.next()){
                co.edu.utp.misiontic2022.c2.oasp.model.vo.O1LiderPorSalario salarios = new O1LiderPorSalario();
                salarios.setNombre(resultado.getString("Nombre"));
                salarios.setApellido(resultado.getString("Primer_Apellido"));
                salarios.setId_lider(resultado.getInt("ID_lider"));
                salarios.setSalario(resultado.getInt("Salario"));
                respuesta.add(salarios);
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
