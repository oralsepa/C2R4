package model.dao;

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
import model.vo.ProyectosQuibdoApartaestudio;

public class Requerimiento_3Dao {
    //Obtener los proyectos por Tipo en la ciudad de Montería
    public ArrayList<ProyectosQuibdoApartaestudio> rankinQuibdoApartaestudios() throws SQLException {

        ArrayList<ProyectosQuibdoApartaestudio> respuesta = new ArrayList<ProyectosQuibdoApartaestudio>();
        Connection conexion = JDBCUtilities.getConnection();

        try{       

            String consulta =   "SELECT ID_Proyecto, Constructora, Porcentaje_Cuota_Inicial, Acabados "+
                                "FROM Proyecto "+
                                "WHERE Ciudad = 'Quibdo'"+
                                "AND Clasificacion = 'Apartaestudio'";


            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultSet.next()){
                ProyectosQuibdoApartaestudio proyectosQuibdoApartaestudio = new ProyectosQuibdoApartaestudio();
                proyectosQuibdoApartaestudio.setIdProyecto(resultSet.getInt("Id_Proyecto"));
                proyectosQuibdoApartaestudio.setConstructora(resultSet.getString("Constructora"));
                proyectosQuibdoApartaestudio.setPorcentajeCuotaInicial(resultSet.getDouble("Porcentaje_Cuota_Inicial"));
                proyectosQuibdoApartaestudio.setAcabados(resultSet.getString("Acabados"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(proyectosQuibdoApartaestudio);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los proyectos de tipo Apartaestudio en Quibdo: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de vo's
        return respuesta;
    }     
}
