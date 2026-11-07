
package vista;

import controlador.EmpleadoControlador;
import javax.swing.*;
import java.awt.*;

public class VentanaEmpleados extends JFrame {

    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEdad;
    private JTextField txtDetalle;
    private JTextField txtBuscar;

    private JComboBox<String> cmbTipo;
    private JTextArea txtResultado;
    private JLabel lblDetalle;

    private EmpleadoControlador controlador;

    public VentanaEmpleados() {
        controlador = new EmpleadoControlador();

        setTitle("Gestion de Empleados");
        setSize(700, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Absolute Layout
        getContentPane().setLayout(null);

        JLabel titulo = new JLabel("SISTEMA DE GESTION DE EMPLEADOS");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(100, 15, 500, 30);
        getContentPane().add(titulo);

        JLabel lblCedula = new JLabel("Cedula:");
        lblCedula.setBounds(40, 65, 120, 25);
        getContentPane().add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(190, 65, 430, 25);
        getContentPane().add(txtCedula);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(40, 100, 120, 25);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(190, 100, 430, 25);
        getContentPane().add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(40, 135, 120, 25);
        getContentPane().add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(190, 135, 430, 25);
        getContentPane().add(txtApellido);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(40, 170, 120, 25);
        getContentPane().add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(190, 170, 430, 25);
        getContentPane().add(txtEdad);

        JLabel lblTipo = new JLabel("Tipo de empleado:");
        lblTipo.setBounds(40, 205, 140, 25);
        getContentPane().add(lblTipo);

        cmbTipo = new JComboBox<>(new String[]{
            "Administrativo", "Obrero", "Tecnico"
        });
        cmbTipo.setBounds(190, 205, 430, 25);
        getContentPane().add(cmbTipo);

        lblDetalle = new JLabel("Departamento:");
        lblDetalle.setBounds(40, 240, 140, 25);
        getContentPane().add(lblDetalle);

        txtDetalle = new JTextField();
        txtDetalle.setBounds(190, 240, 430, 25);
        getContentPane().add(txtDetalle);

        JButton btnRegistrar = new JButton("Registrar empleado");
        btnRegistrar.setBounds(100, 285, 220, 30);
        getContentPane().add(btnRegistrar);

        JButton btnLimpiar = new JButton("Limpiar campos");
        btnLimpiar.setBounds(360, 285, 220, 30);
        getContentPane().add(btnLimpiar);

        JLabel lblConsulta = new JLabel("CONSULTA DE EMPLEADOS");
        lblConsulta.setFont(new Font("Arial", Font.BOLD, 13));
        lblConsulta.setBounds(40, 335, 250, 25);
        getContentPane().add(lblConsulta);

        JLabel lblBuscar = new JLabel("Cedula:");
        lblBuscar.setBounds(40, 370, 70, 25);
        getContentPane().add(lblBuscar);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(110, 370, 230, 25);
        getContentPane().add(txtBuscar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(355, 370, 110, 25);
        getContentPane().add(btnBuscar);

        JButton btnListar = new JButton("Mostrar todos");
        btnListar.setBounds(475, 370, 145, 25);
        getContentPane().add(btnListar);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scroll = new JScrollPane(txtResultado);
        scroll.setBounds(40, 415, 580, 140);
        getContentPane().add(scroll);

        // Cambiar etiqueta segun tipo
        cmbTipo.addActionListener(e -> {
            String tipo = cmbTipo.getSelectedItem().toString();

            switch (tipo) {
                case "Administrativo":
                    lblDetalle.setText("Departamento:");
                    break;
                case "Obrero":
                    lblDetalle.setText("Area de trabajo:");
                    break;
                case "Tecnico":
                    lblDetalle.setText("Especialidad:");
                    break;
            }
        });

        // RF-01: Registrar empleado
        btnRegistrar.addActionListener(e -> {
            String mensaje = controlador.registrar(
                txtCedula.getText(),
                txtNombre.getText(),
                txtApellido.getText(),
                txtEdad.getText(),
                cmbTipo.getSelectedItem().toString(),
                txtDetalle.getText()
            );

            JOptionPane.showMessageDialog(this, mensaje);

            if (mensaje.equals("Empleado registrado correctamente")) {
                limpiarCampos();
                txtResultado.setText(controlador.listar());
            }
        });

        // RF-03: Buscar empleado
        btnBuscar.addActionListener(e -> {
            txtResultado.setText(
                controlador.buscar(txtBuscar.getText())
            );
        });

        // RF-04: Mostrar empleados
        btnListar.addActionListener(e -> {
            txtResultado.setText(controlador.listar());
        });

        // Limpiar campos
        btnLimpiar.addActionListener(e -> {
            limpiarCampos();
        });
    }

    private void limpiarCampos() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtDetalle.setText("");
        cmbTipo.setSelectedIndex(0);
        txtCedula.requestFocus();
    }
}
