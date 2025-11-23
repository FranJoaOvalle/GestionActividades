package vista;

import javax.swing.*;
import static java.awt.Toolkit.getDefaultToolkit;

public final class PopUps {

    public static void ERROR (String mensaje, Exception ex) {
        getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(
                null, mensaje + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
    }

    public static void SIN_IMPLEMENTAR() {
        getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(
                null, "Función aún no implementada.", "Advertencia",
                JOptionPane.WARNING_MESSAGE, null);
    }

    public static void GENERICO(String mensaje, String titulo) {
        getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE, null);
    }

    public static int CONFIRMAR(String mensaje, String titulo) {
        getDefaultToolkit().beep();
        return JOptionPane.showConfirmDialog(
                null, mensaje, titulo,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
    }
}