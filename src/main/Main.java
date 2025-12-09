package main;

import controlador.Controlador;
import modelo.GestionActividades;
import modelo.GestionAdultosMayores;
import modelo.GestionInscripcion;
import vista.VistaPrincipal;

public class Main {
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            

            VistaPrincipal vista = new VistaPrincipal();
            GestionAdultosMayores gestionAdultosMayores = new GestionAdultosMayores();
            GestionActividades gestionActividades = new GestionActividades();
            GestionInscripcion gestionInscripcion = new GestionInscripcion();
            Controlador controlador = new Controlador(gestionAdultosMayores,gestionActividades,gestionInscripcion,vista);


            vista.setVisible(true);
            controlador.botones();

        });
    }
}