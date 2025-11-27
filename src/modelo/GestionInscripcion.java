package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionInscripcion {
    private ArrayList<Inscripcion> inscripciones;

    public GestionInscripcion() {
        this.inscripciones = new ArrayList<>();
    }

    public Inscripcion buscarInscripcionPorId(int id){
        for(Inscripcion i: inscripciones){
            if(i.getIdInscripcion() == id){
                return i;
            }
        }
        return null;
    }

    public ArrayList<Inscripcion> buscarInscripcionPorAdultoMayor(AdultoMayor adulto){
        ArrayList<Inscripcion> listado = new ArrayList<>();
        for(Inscripcion i: inscripciones){
            if(i.getAdultoMayor().getRut().equalsIgnoreCase(adulto.getRut())){
                listado.add(i);
            }
        }
        return listado;
    }

    public ArrayList<Inscripcion> buscarInscripcionPorActividad(Actividad act){
        ArrayList<Inscripcion> lista = new ArrayList<>();
        for(Inscripcion i: inscripciones){
            if(i.getActividad().getIdActividad() == act.getIdActividad()){
                lista.add(i);
            }
        }
        return lista;
    }

    public boolean agregarInscripcion(Inscripcion inscripcion){
        if(inscripcion == null){
            return false;
        }

        if(buscarInscripcionPorId(inscripcion.getIdInscripcion()) != null){
            return false;
        }

        Actividad actividad = inscripcion.getActividad();

        if(!actividad.tieneCupos()){
            return false;
        }

        if(!actividad.descontarCupo()){
            return false;
        }

        inscripciones.add(inscripcion);
        return true;
    }

    public boolean eliminarInscripcion(Inscripcion inscripcion){
        Inscripcion i = buscarInscripcionPorId(inscripcion.getIdInscripcion());
        if(i == null){
            return false;
        }
        inscripciones.remove(i);
        return true;
    }

    public boolean eliminarInscripcionPorAdultoMayor(AdultoMayor adulto){
        boolean eliminado = false;

        Iterator<Inscripcion> it = inscripciones.iterator();

        while(it.hasNext()){
            Inscripcion i = it.next();

            if(i.getAdultoMayor().getRut().equalsIgnoreCase(adulto.getRut())){
                it.remove();
                eliminado = true;
            }
        }
        return eliminado;
    }

    public boolean eliminarInscripcionPorActividad(Actividad actividad){
        boolean eliminado = false;

        Iterator<Inscripcion> it = inscripciones.iterator();

        while(it.hasNext()){
            Inscripcion i = it.next();

            if(i.getActividad().getIdActividad() == actividad.getIdActividad()){
                it.remove();
                eliminado = true;
            }
        }
        return eliminado;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }
}
