package controlador;

import javax.swing.SwingUtilities;
import vista.VentanaEmpleados;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaEmpleados ventana = new VentanaEmpleados();
            ventana.setVisible(true);
        });
    }
}
