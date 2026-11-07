package modelo;

public class Tecnico extends Persona {
    private String especialidad;

    public Tecnico(String cedula, String nombre,
            String apellido, int edad, String especialidad) {
        super(cedula, nombre, apellido, edad);
        this.especialidad = especialidad;
    }

    @Override
    public String getTipo() {
        return "Tecnico";
    }

    @Override
    public String getDetalle() {
        return "Especialidad: " + especialidad;
    }
}
