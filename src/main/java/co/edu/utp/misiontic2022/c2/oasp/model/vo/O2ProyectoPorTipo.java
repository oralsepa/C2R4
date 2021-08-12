package co.edu.utp.misiontic2022.c2.oasp.model.vo;

public class O2ProyectoPorTipo {
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
