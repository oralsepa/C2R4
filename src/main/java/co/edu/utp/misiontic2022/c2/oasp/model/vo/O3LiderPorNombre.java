package co.edu.utp.misiontic2022.c2.oasp.model.vo;


public class O3LiderPorNombre {
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
