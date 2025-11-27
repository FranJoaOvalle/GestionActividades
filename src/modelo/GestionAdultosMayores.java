package modelo;

import java.util.ArrayList;
import java.util.Date;

public class GestionAdultosMayores {
    private ArrayList<AdultoMayor> adultosMayores;

    public GestionAdultosMayores() {
        this.adultosMayores = new ArrayList<>();
    }

    public AdultoMayor buscarAdultoMayorPorRut(String rut){
        for(AdultoMayor a: adultosMayores){
            if(a.getRut().equalsIgnoreCase(rut)){
                return a;
            }
        }
        return null;
    }

    public ArrayList<AdultoMayor> buscarAdultoMayorPorNombreEncargado(String nombre){
        ArrayList<AdultoMayor> listado = new ArrayList<>();
        for(AdultoMayor a: adultosMayores){
            if(a.getNombreEncargado().equalsIgnoreCase(nombre)){
                listado.add(a);
            }
        }
        return listado;
    }

    public ArrayList<AdultoMayor> buscarAdultoMayorPorNombre(String nombre){
        ArrayList<AdultoMayor> lista = new ArrayList<>();
        for(AdultoMayor a: adultosMayores){
            if(a.getNombreAdultoMayor().equalsIgnoreCase(nombre)){
                lista.add(a);
            }
        }
        return lista;
    }

    public boolean agregarAdultoMayor(AdultoMayor adultoMayor){
        if(buscarAdultoMayorPorRut(adultoMayor.getRut()) != null){
            return false;
        }
        adultosMayores.add(adultoMayor);
        return true;
    }

    public boolean eliminarAdultoMayor(AdultoMayor adultoMayor){
        AdultoMayor a = buscarAdultoMayorPorRut(adultoMayor.getRut());
        if(a == null){
            return false;
        }
        adultosMayores.remove(a);
        return true;
    }

    public boolean actualizarAdultoMayor(AdultoMayor antiguosDatos, AdultoMayor nuevosDatos){
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
        for(AdultoMayor a: adultosMayores){
            if(a.getRut().equalsIgnoreCase(adulto.getRut())){
                a.setNombreAdultoMayor(nombre);

                return true;
            }
        }
        return false;
    }

    public boolean actualizarNacimientoAdultoMayor(AdultoMayor adulto, Date nacimiento){
        for(AdultoMayor a: adultosMayores){
            if(a.getRut().equalsIgnoreCase(adulto.getRut())){
                a.setNacimiento(nacimiento);

                return true;
            }
        }
        return false;
    }

    public boolean actualizarNombreEncargadoAdultoMayor(AdultoMayor adulto, String nombreEncargado){
        for(AdultoMayor a: adultosMayores){
            if(a.getRut().equalsIgnoreCase(adulto.getRut())){
                a.setNombreEncargado(nombreEncargado);

                return true;
            }
        }
        return false;
    }

    public boolean actualizarContactoEncargado(AdultoMayor adulto, String contactoEncargado){
        for(AdultoMayor a: adultosMayores){
            if(a.getRut().equalsIgnoreCase(adulto.getRut())){
                a.setContactoEncargado(contactoEncargado);
            }

            return true;
        }
        return false;
    }

    public ArrayList<AdultoMayor> getAdultosMayores() {
        return adultosMayores;
    }
}
