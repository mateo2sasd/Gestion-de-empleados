package modelo;

public class Persona {
    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String cedula, String nombre, String apellido, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getTipo() {
        return "Persona";
    }

    public String getDetalle() {
        return "";
    }

    public String mostrarDatos() {
        return "Cedula: " + cedula +
               "\nNombre: " + nombre +
               "\nApellido: " + apellido +
               "\nEdad: " + edad +
               "\nTipo: " + getTipo() +
               "\n" + getDetalle();
    }
}
