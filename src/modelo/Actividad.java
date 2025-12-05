package modelo;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Actividad
{
    private int idActividad;
    private String nombreActividad;
    private String categoria;
    private String descripcion;
    private DayOfWeek dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int cupos;
    private String nombreProfesor;

    public Actividad() {
    }

    public Actividad(int idActividad, String nombreActividad, String categoria, String descripcion, DayOfWeek dia, LocalTime horaInicio,
                     LocalTime horaFin, int cupos, String nombreProfesor)
    {
        this.setIdActividad(idActividad);
        this.setNombreActividad(nombreActividad);
        this.setCategoria(categoria);
        this.setDescripcion(descripcion);
        this.setDia(dia);
        this.setHoraInicio(horaInicio);
        this.setHoraFin(horaFin);
        this.setCupos(cupos);
        this.setNombreProfesor(nombreProfesor);
    }

    public void setIdActividad(int idActividad) {
        if(idActividad < 0){
            throw new IllegalArgumentException("El id de la actividad no puede ser negativo.");
        }
        this.idActividad = idActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        if(nombreActividad == null || nombreActividad.isEmpty()){
            throw new IllegalArgumentException("El nombre de la actividad no puede estar vacio.");
        }
        this.nombreActividad = nombreActividad;
    }

    public void setCategoria(String categoria) {
        if(categoria == null || categoria.isEmpty()){
            throw new IllegalArgumentException("La categoria de la actividad no puede estar vacia.");
        }
        this.categoria = categoria;
    }

    public void setDescripcion(String descripcion) {
        if(descripcion == null || descripcion.isEmpty()){
            throw new IllegalArgumentException("La descripcion no puede estar vacia.");
        }
        this.descripcion = descripcion;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public void setCupos(int cupos) {
        if(cupos < 0){
            throw new IllegalArgumentException("Los cupos no pueden ser negativos.");
        }
        this.cupos = cupos;
    }

    public void setNombreProfesor(String nombreProfesor) {
        if(nombreProfesor == null || nombreProfesor.isEmpty()){
            throw new IllegalArgumentException("El nombre del profesor no puede estar vacio.");
        }
        this.nombreProfesor = nombreProfesor;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public int getCupos() {
        return cupos;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public boolean tieneCupos() {
        return cupos > 0;
    }

    public boolean descontarCupo() {
        if (cupos > 0) {
            cupos--;
            return true;
        }
        return false;
    }

    public void aumentarCupo() {
        cupos++;
    }
}
