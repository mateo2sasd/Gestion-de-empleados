package modelo;

public class Administrativo extends Persona {
    private String departamento;

    public Administrativo(String cedula, String nombre,
            String apellido, int edad, String departamento) {
        super(cedula, nombre, apellido, edad);
        this.departamento = departamento;
    }

    @Override
    public String getTipo() {
        return "Administrativo";
    }

    @Override
    public String getDetalle() {
        return "Departamento: " + departamento;
    }
}
