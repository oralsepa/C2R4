import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.File;
import java.sql.DriverManager;



//controller
class CtrlReq {       
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



//vista
class VistaRequerimientosReto4 {
    
    public static final CtrlReq controlador = new CtrlReq();

    public static void requerimiento1(){
    
        System.out.println("*** Lideres por Salario ***");
        try{
            ArrayList<O1LiderPorSalario> listaLideres = controlador.Requerimiento_1();

            for(O1LiderPorSalario salarios : listaLideres){
                System.out.printf("El Lider %s %s con Id %d Tiene un salario de %d %n",
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
                System.out.printf("El proyecto con ID %d de la constructora: %s de la ciudad %s, tiene un estrato asignado igual a %d %n",
                    proyectos.getId_proyecto(),proyectos.getConstructora(),proyectos.getCiudad(),proyectos.getEstrato());
            }
        }catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void requerimiento3(){

        System.out.println("*** Lideres por Nombre ***");
        try{
            ArrayList<O3LiderPorNombre> nombreLideres = controlador.Requerimiento_3();  

            for(O3LiderPorNombre nombres : nombreLideres){
                System.out.printf("El Lider con Id %d se llama %s %s %n",
                    nombres.getId_lider(),nombres.getNombre(),nombres.getApellido());
            }
        }catch(SQLException e){
            System.err.println(e);
        }
    }
}



//dao1
class Req1LiderPorSalario {
    
    public ArrayList<O1LiderPorSalario> requerimiento1() throws SQLException {
        
        ArrayList<O1LiderPorSalario> respuesta = new ArrayList<O1LiderPorSalario>();
        Connection conexion = JDBCUtilities.getConnection();

        try{

            String consulta =   "select Nombre, Primer_Apellido, ID_lider, Salario from Lider "+
                                "where Salario <= 500000 order by Salario asc";
 
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            while(resultado.next()){
                O1LiderPorSalario salarios = new O1LiderPorSalario();
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



//dao2
class Req2ProyectoPorTipo {
   
    public ArrayList<O2ProyectoPorTipo> requerimiento2() throws SQLException {
        
        ArrayList<O2ProyectoPorTipo> respuesta = new ArrayList<O2ProyectoPorTipo>();
        Connection conexion = JDBCUtilities.getConnection();

        try{

            String consulta =   "SELECT ID_Proyecto, Constructora, Ciudad, Estrato from Proyecto " +
                                "natural join Tipo t where Ciudad = 'Cartagena' order by Estrato asc";
 
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            while(resultado.next()){
                O2ProyectoPorTipo proyectos = new O2ProyectoPorTipo();
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



//dao3
class Req3LiderPorNombre {
    //Obtener los proyectos por Tipo en la ciudad de Montería
    public ArrayList<O3LiderPorNombre> requerimiento3() throws SQLException {

        ArrayList<O3LiderPorNombre> respuesta = new ArrayList<O3LiderPorNombre>();
        Connection conexion = JDBCUtilities.getConnection();

        try{       

            String consulta =   "select id_lider, nombre, primer_apellido from Lider "+
                                "where Primer_Apellido like '%z' order by nombre asc";
                                
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultado.next()){
                O3LiderPorNombre nombres = new O3LiderPorNombre();
                nombres.setNombre(resultado.getString("nombre"));
                nombres.setApellido(resultado.getString("primer_apellido"));
                nombres.setId_lider(resultado.getInt("id_lider"));
                respuesta.add(nombres);
            }
            resultado.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error en la consulta "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        return respuesta;
    }     
}



//vo1
class O1LiderPorSalario {
    private String nombre;
    private String apellido;
    private Integer id_lider;
    private Integer salario;
    
    public O1LiderPorSalario() {
    }

    public O1LiderPorSalario(String nombre, String apellido, Integer id_lider, Integer salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_lider = id_lider;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getId_lider() {
        return id_lider;
    }

    public void setId_lider(Integer id_lider) {
        this.id_lider = id_lider;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    } 
}



//vo2
class O2ProyectoPorTipo {
    private Integer id_proyecto;
    private String constructora;
    private String ciudad;
    private Integer estrato;
    
    public O2ProyectoPorTipo() {
    }

    public O2ProyectoPorTipo(Integer id_proyecto, String constructora, String ciudad, Integer estrato) {
        this.id_proyecto = id_proyecto;
        this.constructora = constructora;
        this.ciudad = ciudad;
        this.estrato = estrato;
    }

    public Integer getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getEstrato() {
        return estrato;
    }

    public void setEstrato(Integer estrato) {
        this.estrato = estrato;
    }    
}



//vo3
class O3LiderPorNombre {
    private String nombre;
    private String apellido;
    private Integer id_lider;

    public O3LiderPorNombre() {
    }
    
    public O3LiderPorNombre(String nombre, String apellido, Integer id_lider) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_lider = id_lider;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getId_lider() {
        return id_lider;
    }

    public void setId_lider(Integer id_lider) {
        this.id_lider = id_lider;
    }    
}



//jdbc
class JDBCUtilities {
    //Atributos de clase para gestión de conexión con la base de datos    
    private static final String UBICACION_BD = "ProyectosConstruccion.db";    

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;        
        return DriverManager.getConnection(url);
    }

    public static boolean estaVacia(){
        File archivo = new File(JDBCUtilities.UBICACION_BD);
        return archivo.length() == 0;
    }
}