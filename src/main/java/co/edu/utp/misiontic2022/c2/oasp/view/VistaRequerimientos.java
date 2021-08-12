package co.edu.utp.misiontic2022.c2.oasp.view;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.oasp.controller.CtrlReq;
import co.edu.utp.misiontic2022.c2.oasp.model.vo.O1LiderPorSalario;
import co.edu.utp.misiontic2022.c2.oasp.model.vo.O2ProyectoPorTipo;
import co.edu.utp.misiontic2022.c2.oasp.model.vo.O3LiderPorNombre;

public class VistaRequerimientos {
    
    public static final CtrlReq controlador = new CtrlReq();

    public static void requerimiento1(){
    
        System.out.println("*** Lideres por Salario ***");
        try{
            ArrayList<O1LiderPorSalario> listaLideres = controlador.Requerimiento_1();

            for(O1LiderPorSalario salarios : listaLideres){
                System.out.printf("El Lider %s %s con Id %d Tiene un salario de  %d %n",
                    salarios.getNombre(),salarios.getApellido(),salarios.getId_lider(),salarios.getSalario());
            }
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    public static void requerimiento2(){     

        System.out.println("*** Proyectos por Tipo ***");
        try{
            ArrayList<O2ProyectoPorTipo> listaProyectos = controlador.Requerimiento_2();

            for(O2ProyectoPorTipo proyectos : listaProyectos){
                System.out.printf("El proyecto de ID_Proyecto %d de la constructora: %s de la ciudad %s, tiene un estrato asignado de %d %n",
                    proyectos.getId_proyecto(),proyectos.getConstructora(),proyectos.getCiudad(),proyectos.getEstrato());

        }catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void requerimiento3(){

        System.out.println("*** Lideres por Nombre ***");
        try{
            ArrayList<O3LiderPorNombre> nombreLideres = controlador.Requerimiento_3();  

            for(O3LiderPorNombre nombres : nombreLideres){
                System.out.printf("El Lider con ID %d se llama %s %s %n",
                    nombres.getId_lider(),nombres.getNombre(),nombres.getApellido());
            
        }catch(SQLException e){
            System.err.println(e);
        }
    }

}
