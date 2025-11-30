package modelo;

import java.util.ArrayList;
import java.util.Date;

public class GestionAdultosMayores {
    private ArrayList<AdultoMayor> adultosMayores;

    public GestionAdultosMayores() {
        this.adultosMayores = new ArrayList<>();
    }

    public AdultoMayor buscarAdultoMayorPorRut(String rut){
        if(rut == null){
            return null;
        }

        for(AdultoMayor a: adultosMayores){
            if(a.getRut().equalsIgnoreCase(rut)){
                return a;
            }
        }
        return null;
    }

    public ArrayList<AdultoMayor> buscarAdultoMayorPorNombreEncargado(String nombre){
        ArrayList<AdultoMayor> listado = new ArrayList<>();

        if(nombre == null){
            return listado;
        }

        for(AdultoMayor a: adultosMayores){
            if(a.getNombreEncargado().equalsIgnoreCase(nombre)){
                listado.add(a);
            }
        }
        return listado;
    }

    public ArrayList<AdultoMayor> buscarAdultoMayorPorNombre(String nombre){
        ArrayList<AdultoMayor> lista = new ArrayList<>();

        if(nombre == null){
            return lista;
        }

        for(AdultoMayor a: adultosMayores){
            if(a.getNombreAdultoMayor().equalsIgnoreCase(nombre)){
                lista.add(a);
            }
        }
        return lista;
    }

    public boolean agregarAdultoMayor(AdultoMayor adultoMayor){
        if(adultoMayor == null){
            return false;
        }
        if(buscarAdultoMayorPorRut(adultoMayor.getRut()) != null){
            return false;
        }
        adultosMayores.add(adultoMayor);
        return true;
    }

    public boolean eliminarAdultoMayor(AdultoMayor adultoMayor){
        if(adultoMayor == null){
            return false;
        }

        AdultoMayor a = buscarAdultoMayorPorRut(adultoMayor.getRut());

        if(a == null){
            return false;
        }
        adultosMayores.remove(a);
        return true;
    }

    public boolean actualizarAdultoMayor(AdultoMayor antiguosDatos, AdultoMayor nuevosDatos){
        if(antiguosDatos == null || nuevosDatos == null){
            return false;
        }

        for(AdultoMayor a: adultosMayores){
            if(a.getRut().equalsIgnoreCase(antiguosDatos.getRut())){
                a.setNombreAdultoMayor(nuevosDatos.getNombreAdultoMayor());
                a.setNacimiento(nuevosDatos.getNacimiento());
                a.setNombreEncargado(nuevosDatos.getNombreEncargado());
                a.setContactoEncargado(nuevosDatos.getContactoEncargado());

                return true;
            }
        }
        return false;
    }

    public boolean actualizarNombreAdultoMayor(AdultoMayor adulto, String nombre){
        if(adulto == null || nombre == null){
            return false;
        }

        for(AdultoMayor a: adultosMayores){
            if(a.getRut().equalsIgnoreCase(adulto.getRut())){
                a.setNombreAdultoMayor(nombre);

                return true;
            }
        }
        return false;
    }

    public boolean actualizarNacimientoAdultoMayor(AdultoMayor adulto, Date nacimiento){
        if(adulto == null){
            return false;
        }

        for(AdultoMayor a: adultosMayores){
            if(a.getRut().equalsIgnoreCase(adulto.getRut())){
                a.setNacimiento(nacimiento);

                return true;
            }
        }
        return false;
    }

    public boolean actualizarNombreEncargadoAdultoMayor(AdultoMayor adulto, String nombreEncargado){
        if(adulto == null || nombreEncargado == null){
            return false;
        }

        for(AdultoMayor a: adultosMayores){
            if(a.getRut().equalsIgnoreCase(adulto.getRut())){
                a.setNombreEncargado(nombreEncargado);

                return true;
            }
        }
        return false;
    }

    public boolean actualizarContactoEncargadoAdultoMayor(AdultoMayor adulto, String contactoEncargado){
        if(adulto == null || contactoEncargado == null){
            return false;
        }

        for(AdultoMayor a: adultosMayores){
            if(a.getRut().equalsIgnoreCase(adulto.getRut())){
                a.setContactoEncargado(contactoEncargado);

                return true;
            }
        }
        return false;
    }

    public ArrayList<AdultoMayor> getAdultosMayores() {
        return adultosMayores;
    }
}
