package modelo;

import java.util.Date;

public class AdultoMayor {
    private String rut;
    private String nombreAdultoMayor;
    private Date nacimiento;
    private String nombreEncargado;
    private String contactoEncargado;

    public AdultoMayor() {
    }

    public AdultoMayor(String rut, String nombreAdultoMayor, Date nacimiento, String nombreEncargado, String contactoEncargado) {
        this.setRut(rut);
        this.setNombreAdultoMayor(nombreAdultoMayor);
        this.setNacimiento(nacimiento);
        this.setNombreEncargado(nombreEncargado);
        this.setContactoEncargado(contactoEncargado);
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombreAdultoMayor(String nombreAdultoMayor) {
        this.nombreAdultoMayor = nombreAdultoMayor;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public void setContactoEncargado(String contactoEncargado) {
        this.contactoEncargado = contactoEncargado;
    }

    public String getRut() {
        return rut;
    }

    public String getNombreAdultoMayor() {
        return nombreAdultoMayor;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public String getContactoEncargado() {
        return contactoEncargado;
    }
}
