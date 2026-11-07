package modelo;

public class Obrero extends Persona {
    private String areaTrabajo;

    public Obrero(String cedula, String nombre,
            String apellido, int edad, String areaTrabajo) {
        super(cedula, nombre, apellido, edad);
        this.areaTrabajo = areaTrabajo;
    }

    @Override
    public String getTipo() {
        return "Obrero";
    }

    @Override
    public String getDetalle() {
        return "Area de trabajo: " + areaTrabajo;
    }
}
