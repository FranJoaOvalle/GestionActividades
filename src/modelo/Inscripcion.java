package modelo;

public class Inscripcion {
    private int idInscripcion;
    private AdultoMayor adultoMayor;
    private Actividad actividad;

    public Inscripcion() {
    }

    public Inscripcion(int idInscripcion, AdultoMayor adultoMayor, Actividad actividad) {
        this.setIdInscripcion(idInscripcion);
        this.setAdultoMayor(adultoMayor);
        this.setActividad(actividad);
    }

    public void setIdInscripcion(int idInscripcion) {
        if(idInscripcion < 0){
            throw new IllegalArgumentException("el id de inscripcion no puede ser negativo.");
        }
        this.idInscripcion = idInscripcion;
    }

    public void setAdultoMayor(AdultoMayor adultoMayor) {
        this.adultoMayor = adultoMayor;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public AdultoMayor getAdultoMayor() {
        return adultoMayor;
    }

    public Actividad getActividad() {
        return actividad;
    }
}
