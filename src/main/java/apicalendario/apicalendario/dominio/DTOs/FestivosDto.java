package apicalendario.apicalendario.dominio.DTOs;


public class FestivosDto {

    String fecha;
    String nombre;
    
    public FestivosDto(String fecha, String nombre) {
        this.fecha = fecha;
        this.nombre = nombre;
    }

    public FestivosDto() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    

}
