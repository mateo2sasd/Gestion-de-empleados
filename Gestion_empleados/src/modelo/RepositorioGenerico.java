package modelo;

import java.util.ArrayList;

public class RepositorioGenerico<T extends Persona> {
    private ArrayList<T> empleados;

    public RepositorioGenerico() {
        empleados = new ArrayList<>();
    }

    public void agregar(T empleado) {
        empleados.add(empleado);
    }

    public T buscar(String cedula) {
        for (T empleado : empleados) {
            if (empleado.getCedula().equals(cedula)) {
                return empleado;
            }
        }
        return null;
    }

    public ArrayList<T> obtenerTodos() {
        return new ArrayList<>(empleados);
    }

    public static <E extends Persona> String mostrarEmpleado(E empleado) {
        return empleado.mostrarDatos();
    }

    public Integer cantidadEmpleados() {
        int cantidad = empleados.size();
        Integer numero = Integer.valueOf(cantidad);
        return numero;
    }
}
