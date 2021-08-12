package co.edu.utp.misiontic2022.c2.oasp.controller;

//Librerías para bases de datos
import java.sql.SQLException;
//Estructuras de datos (colecciones)
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.oasp.model.dao.Req1LiderPorSalario;
import co.edu.utp.misiontic2022.c2.oasp.model.dao.Req2ProyectoPorTipo;
import co.edu.utp.misiontic2022.c2.oasp.model.dao.Req3LiderPorNombre;
import co.edu.utp.misiontic2022.c2.oasp.model.vo.O1LiderPorSalario;
import co.edu.utp.misiontic2022.c2.oasp.model.vo.O2ProyectoPorTipo;
import co.edu.utp.misiontic2022.c2.oasp.model.vo.O3LiderPorNombre;

public class CtrlReq {       
    private final Req1LiderPorSalario req1LiderPorSalario;
    private final Req2ProyectoPorTipo req2ProyectoPorTipo;
    private final Req3LiderPorNombre req3LiderPorNombre;
    

    public CtrlReq() {
        this.req1LiderPorSalario = new Req1LiderPorSalario();
        this.req2ProyectoPorTipo = new Req2ProyectoPorTipo();
        this.req3LiderPorNombre = new Req3LiderPorNombre();
    }

    public ArrayList<O1LiderPorSalario> Requerimiento_1() throws SQLException {
        return this.req1LiderPorSalario.requerimiento1();
    }
    
    public ArrayList<O2ProyectoPorTipo> Requerimiento_2() throws SQLException {
        return this.req2ProyectoPorTipo.requerimiento2();
    }

    public ArrayList<O3LiderPorNombre> Requerimiento_3() throws SQLException {
        return this.req3LiderPorNombre.requerimiento3();
    }

}
