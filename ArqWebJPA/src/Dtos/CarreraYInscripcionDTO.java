package Dtos;

import entity.Carrera;

public class CarreraYInscripcionDTO {
    private Carrera c;
    private int cantidad;
    public CarreraYInscripcionDTO(Carrera c, int cantidad) {
        this.c = c;
        this.cantidad = cantidad;
    }
    public CarreraYInscripcionDTO() {
        super();
    }
    @Override
    public String toString() {
        return "\n" + cantidad + " Inscripciones en " + c.getNombre() + " " + c.getInstitucion()+ " Duración: "+c.getDuracion();
    }
    
}