package main;

import vista.VistaPrincipal;

public class Main {
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            

            VistaPrincipal vista = new VistaPrincipal();
            

            vista.setVisible(true);
            

        });
    }
}