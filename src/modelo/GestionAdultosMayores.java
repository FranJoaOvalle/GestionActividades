package modelo;

import java.util.ArrayList;

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

    public ArrayList<AdultoMayor> getAdultosMayores() {
        return adultosMayores;
    }
}
