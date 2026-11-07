package controlador;

import modelo.*;
import java.util.ArrayList;

public class EmpleadoControlador {
    private RepositorioGenerico<Persona> repositorio;

    public EmpleadoControlador() {
        repositorio = new RepositorioGenerico<>();
    }

    public String registrar(String cedula, String nombre,
            String apellido, String edadTexto, String tipo,
            String detalle) {

        cedula = cedula.trim();
        nombre = nombre.trim();
        apellido = apellido.trim();
        edadTexto = edadTexto.trim();
        detalle = detalle.trim();

        if (cedula.isEmpty() || nombre.isEmpty() ||
                apellido.isEmpty() || edadTexto.isEmpty() ||
                detalle.isEmpty()) {
            return "Complete todos los campos";
        }

        if (!cedula.matches("[0-9]{10}")) {
            return "La cedula debe tener 10 numeros";
        }

        if (repositorio.buscar(cedula) != null) {
            return "Ya existe un empleado con esa cedula";
        }

        int edad;

        try {
            Integer edadObjeto = Integer.valueOf(edadTexto);
            edad = edadObjeto.intValue();
        } catch (NumberFormatException e) {
            return "Ingrese una edad valida";
        }

        if (edad < 18 || edad > 100) {
            return "La edad debe estar entre 18 y 100";
        }

        Persona empleado;

        switch (tipo) {
            case "Administrativo":
                empleado = new Administrativo(cedula, nombre,
                        apellido, edad, detalle);
                break;
            case "Obrero":
                empleado = new Obrero(cedula, nombre,
                        apellido, edad, detalle);
                break;
            case "Tecnico":
                empleado = new Tecnico(cedula, nombre,
                        apellido, edad, detalle);
                break;
            default:
                return "Seleccione un tipo de empleado";
        }

        repositorio.agregar(empleado);
        return "Empleado registrado correctamente";
    }
    public String buscar(String cedula) {
        Persona empleado = repositorio.buscar(cedula.trim());

        if (empleado == null) {
            return "Empleado no encontrado";
        }

        return RepositorioGenerico.mostrarEmpleado(empleado);
    }


    public String listar() {
        ArrayList<Persona> lista = repositorio.obtenerTodos();

        if (lista.isEmpty()) {
            return "No hay empleados registrados";
        }

        StringBuilder resultado = new StringBuilder();

        for (Persona empleado : lista) {
            resultado.append(
                    RepositorioGenerico.mostrarEmpleado(empleado)
            );
            resultado.append("\n-------------------------\n");
        }

        
        int total = repositorio.cantidadEmpleados();
        resultado.append("\nTotal de empleados: ").append(total);

        return resultado.toString();
    }
}
