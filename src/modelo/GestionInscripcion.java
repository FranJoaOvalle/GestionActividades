package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionInscripcion {
    private ArrayList<Inscripcion> inscripciones;

    public GestionInscripcion() {
        this.inscripciones = new ArrayList<>();
    }

    public Inscripcion buscarInscripcionPorId(int id){
        if(id < 0){
            return null;
        }

        for(Inscripcion i: inscripciones){
            if(i.getIdInscripcion() == id){
                return i;
            }
        }
        return null;
    }

    public ArrayList<Inscripcion> buscarInscripcionPorAdultoMayor(AdultoMayor adulto){
        ArrayList<Inscripcion> listado = new ArrayList<>();

        if(adulto == null){
            return listado;
        }

        for(Inscripcion i: inscripciones){
            if(i.getAdultoMayor().getRut().equalsIgnoreCase(adulto.getRut())){
                listado.add(i);
            }
        }
        return listado;
    }

    public ArrayList<Inscripcion> buscarInscripcionPorActividad(Actividad act){
        ArrayList<Inscripcion> lista = new ArrayList<>();

        if(act == null){
            return lista;
        }

        for(Inscripcion i: inscripciones){
            if(i.getActividad().getIdActividad() == act.getIdActividad()){
                lista.add(i);
            }
        }
        return lista;
    }

    public boolean agregarInscripcion(Inscripcion inscripcion, GestionAdultosMayores gestionAdultosMayores,
                                      GestionActividades gestionActividades){

        if(inscripcion == null || gestionAdultosMayores == null || gestionActividades == null){
            return false;
        }

        AdultoMayor adulto = inscripcion.getAdultoMayor();
        Actividad actividad = inscripcion.getActividad();

        if(gestionAdultosMayores.buscarAdultoMayorPorRut(adulto.getRut()) == null){
            return false;
        }

        if(gestionActividades.buscarActividadPorId(actividad.getIdActividad()) == null){
            return false;
        }

        if(buscarInscripcionPorId(inscripcion.getIdInscripcion()) != null){
            return false;
        }

        for(Inscripcion i : inscripciones){
            if(i.getAdultoMayor().getRut().equalsIgnoreCase(adulto.getRut()) &&
                    i.getActividad().getIdActividad() == actividad.getIdActividad()){
                return false;
            }
        }

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
        if(inscripcion == null){
            return false;
        }

        Inscripcion i = buscarInscripcionPorId(inscripcion.getIdInscripcion());

        if(i == null){
            return false;
        }

        Actividad actividad = i.getActividad();

        actividad.aumentarCupo();

        inscripciones.remove(i);
        return true;
    }

    public boolean eliminarInscripcionPorAdultoMayor(AdultoMayor adulto){
        if(adulto == null){
            return false;
        }

        boolean eliminado = false;

        Iterator<Inscripcion> it = inscripciones.iterator();

        while(it.hasNext()){
            Inscripcion i = it.next();

            if(i.getAdultoMayor().getRut().equalsIgnoreCase(adulto.getRut())){
                Actividad actividad = i.getActividad();
                actividad.aumentarCupo();
                it.remove();
                eliminado = true;
            }
        }
        return eliminado;
    }

    public boolean eliminarInscripcionPorActividad(Actividad actividad){
        if(actividad == null){
            return false;
        }

        boolean eliminado = false;

        Iterator<Inscripcion> it = inscripciones.iterator();

        while(it.hasNext()){
            Inscripcion i = it.next();

            if(i.getActividad().getIdActividad() == actividad.getIdActividad()){
                Actividad act = i.getActividad();
                act.aumentarCupo();
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
