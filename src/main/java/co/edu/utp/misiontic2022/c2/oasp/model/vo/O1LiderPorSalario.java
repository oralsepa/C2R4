package co.edu.utp.misiontic2022.c2.oasp.model.vo;

public class O1LiderPorSalario {
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
