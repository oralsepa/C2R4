package view;

import controller.ControladorRequerimientos;

import model.vo.Requerimiento1;
import model.vo.Requerimiento2;
import model.vo.Requerimiento3;


import java.sql.SQLException;
import java.util.ArrayList;

public class VistaRequerimientos {
    
    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    public static void requerimiento1(){
    

        try{
            

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    public static void requerimiento2(){     

        try{
            // su codigo

        }catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void requerimiento3(){

        try{
              // su codigo    
        
        }catch(SQLException e){
            System.err.println(e);
        }
    }

}
