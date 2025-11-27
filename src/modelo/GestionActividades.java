package modelo;

import java.util.ArrayList;

public class GestionActividades {
    private ArrayList<Actividad> actividades;

    public GestionActividades() {
        this.actividades = new ArrayList<>();
    }

    public Actividad buscarActividadPorId(int id){
        for(Actividad a: actividades){
            if(a.getIdActividad() == id){
                return a;
            }
        }
        return null;
    }

    public ArrayList<Actividad> buscarActividadPorNombre(String nombre){
        ArrayList<Actividad> listado = new ArrayList<>();
        for(Actividad a: actividades){
            if(a.getNombreActividad().equalsIgnoreCase(nombre)){
                listado.add(a);
            }
        }
        return listado;
    }

    public ArrayList<Actividad> buscarActividadPorNombreProfesor(String nombreProfesor){
        ArrayList<Actividad> lista = new ArrayList<>();
        for(Actividad a: actividades){
            if(a.getNombreProfesor().equalsIgnoreCase(nombreProfesor)){
                lista.add(a);
            }
        }
        return lista;
    }

    public boolean agregarActividad(Actividad actividad){
        if(buscarActividadPorId(actividad.getIdActividad()) != null){
            return false;
        }
        actividades.add(actividad);
        return true;
    }

    public boolean eliminarActividad(Actividad actividad){
        Actividad a = buscarActividadPorId(actividad.getIdActividad());
        if(a == null){
            return false;
        }
        actividades.remove(a);
        return true;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }
}
