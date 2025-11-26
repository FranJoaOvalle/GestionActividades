package modelo;

import java.util.Date;

import static utils.Validadores.validarRUT;

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
        if(!validarRUT(rut)){
            throw new IllegalArgumentException("RUT invalido");
        }
        this.rut = rut;
    }

    public void setNombreAdultoMayor(String nombreAdultoMayor) {
        if(nombreAdultoMayor == null || nombreAdultoMayor.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombreAdultoMayor = nombreAdultoMayor;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setNombreEncargado(String nombreEncargado) {
        if(nombreEncargado == null || nombreEncargado.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombreEncargado = nombreEncargado;
    }

    public void setContactoEncargado(String contactoEncargado) {
        if(contactoEncargado == null || contactoEncargado.isEmpty()){
            throw new IllegalArgumentException("El contacto no puede estar vacio");
        }
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
