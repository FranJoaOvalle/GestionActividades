package modelo;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

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

    public ArrayList<Actividad> buscarActividadPorDia(DayOfWeek dia){
        ArrayList<Actividad> lista = new ArrayList<>();
        for(Actividad a: actividades){
            if(a.getDia() == dia){
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

    public boolean eliminarActividadPorProfesor(String nombreProfesor){
        boolean eliminado = false;

        Iterator<Actividad> it = actividades.iterator();

        while(it.hasNext()){
            Actividad a = it.next();

            if(a.getNombreProfesor().equalsIgnoreCase(nombreProfesor)){
                it.remove();
                eliminado = true;
            }
        }
        return eliminado;
    }

    public boolean eliminarActividadPorNombreActividad(String nombreActividad){
        boolean eliminado = false;

        Iterator<Actividad> it = actividades.iterator();

        while(it.hasNext()){
            Actividad a = it.next();

            if(a.getNombreActividad().equalsIgnoreCase(nombreActividad)){
                it.remove();
                eliminado = true;
            }
        }
        return eliminado;
    }

    public boolean eliminarActividadPorDia(DayOfWeek dia){
        boolean eliminado = false;

        Iterator<Actividad> it = actividades.iterator();

        while(it.hasNext()){
            Actividad a = it.next();

            if(a.getDia() == dia){
                it.remove();
                eliminado = true;
            }
        }
        return eliminado;
    }

    public boolean actualizarActividad(Actividad antiguosDatos, Actividad nuevosDatos){
        for(Actividad a: actividades){
            if(a.getIdActividad() == antiguosDatos.getIdActividad()){
                a.setNombreActividad(nuevosDatos.getNombreActividad());
                a.setDescripcion(nuevosDatos.getDescripcion());
                a.setDia(nuevosDatos.getDia());
                a.setHoraInicio(nuevosDatos.getHoraInicio());
                a.setHoraFin(nuevosDatos.getHoraFin());
                a.setCupos(nuevosDatos.getCupos());
                a.setNombreProfesor(nuevosDatos.getNombreProfesor());

                return true;
            }
        }
        return false;
    }

    public boolean actualizarNombreActividad(Actividad actividad, String nombre){
        for(Actividad a: actividades){
            if(a.getIdActividad() == actividad.getIdActividad()){
                a.setNombreActividad(nombre);

                return true;
            }
        }
        return false;
    }

    public boolean actualizarDescripcionActividad(Actividad actividad, String descripcion){
        for(Actividad a: actividades){
            if(a.getIdActividad() == actividad.getIdActividad()){
                a.setDescripcion(descripcion);

                return true;
            }
        }
        return false;
    }

    public boolean actualizarDiaActividad(Actividad actividad, DayOfWeek dia){
        for(Actividad a: actividades){
            if(a.getIdActividad() == actividad.getIdActividad()){
                a.setDia(dia);

                return true;
            }
        }
        return false;
    }

    public boolean actualizarHoraInicioActividad(Actividad actividad, LocalTime horaInicio){
        for(Actividad a: actividades){
            if(a.getIdActividad() == actividad.getIdActividad()){
                a.setHoraInicio(horaInicio);

                return true;
            }
        }
        return false;
    }

    public boolean actualizarHoraFinActividad(Actividad actividad, LocalTime horaFin){
        for(Actividad a: actividades){
            if(a.getIdActividad() == actividad.getIdActividad()){
                a.setHoraFin(horaFin);

                return true;
            }
        }
        return false;
    }

    public boolean actualizarCupos(Actividad actividad, int cupos){
        for(Actividad a: actividades){
            if(a.getIdActividad() == actividad.getIdActividad()){
                a.setCupos(cupos);

                return true;
            }
        }
        return false;
    }

    public boolean actualizarNombreProfesor(Actividad actividad, String nombreProfesor){
        for(Actividad a: actividades){
            if(a.getIdActividad() == actividad.getIdActividad()){
                a.setNombreProfesor(nombreProfesor);

                return true;
            }
        }
        return false;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }
}
