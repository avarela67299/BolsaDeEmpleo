package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazBusqueda extends JFrame{
   
    JPanel panelBusqueda = new JPanel();
    JLabel cedulaLabel = new JLabel("Cédula: ");
    JTextField cedulaTextField = new JTextField(20);
    JLabel nombreLabel = new JLabel("Nombre: ");
    JTextField nombreTextField = new JTextField(20);
    JLabel edadLabel = new JLabel("Edad: ");
    JTextField edadTextField = new JTextField(20);
    JLabel experienciaLabel = new JLabel("Experiencia: ");
    JTextField experienciaTextField = new JTextField(20);
    JLabel profesionLabel = new JLabel("Profesión: ");
    JTextField profesionTextField = new JTextField(20);
    JLabel telefonoLabel = new JLabel("Teléfono: ");
    JTextField telefonoTextField = new JTextField(20);
    
    JButton contratarButton = new JButton("Contratar");
    JButton eliminarButton = new JButton("Eliminar");
    JButton cerrarButton = new JButton("cerrar");

    public InterfazBusqueda(String cedula, String nombre, String edad, String eperiencia, 
                                 String profesion, String telefono){

    getContentPane().setLayout(new GridBagLayout());
    panelBusqueda.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 0;
    panelBusqueda.add(cedulaLabel, gbc);
    gbc.gridx = 1;
    panelBusqueda.add(cedulaTextField, gbc);
    cedulaTextField.setEditable(false);
    gbc.gridx = 0;
    gbc.gridy = 1;
    panelBusqueda.add(nombreLabel, gbc);
    gbc.gridx = 1;
    panelBusqueda.add(nombreTextField, gbc);
    nombreTextField.setEditable(false);
    gbc.gridx = 0;
    gbc.gridy = 2;
    panelBusqueda.add(edadLabel, gbc);
    gbc.gridx = 1;
    panelBusqueda.add(edadTextField, gbc);
    this.edadTextField.setEditable(false);
    gbc.gridx = 0;
    gbc.gridy = 3;
    panelBusqueda.add(experienciaLabel, gbc);
    gbc.gridx = 1;
    panelBusqueda.add(experienciaTextField, gbc);
    this.experienciaTextField.setEditable(false);
    gbc.gridx = 0;
    gbc.gridy = 4;
    panelBusqueda.add(profesionLabel, gbc);
    gbc.gridx = 1;
    panelBusqueda.add(profesionTextField, gbc);
    this.profesionTextField.setEditable(false);
    gbc.gridx = 0;
    gbc.gridy = 5;
    panelBusqueda.add(telefonoLabel, gbc);
    gbc.gridx = 1;
    panelBusqueda.add(telefonoTextField, gbc);
    this.telefonoTextField.setEditable(false);
    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.gridheight = 2;
    gbc.fill = GridBagConstraints.BOTH;
    panelBusqueda.add(contratarButton, gbc);
    contratarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                contratarActionPerformed(e);
            } 
        });
    
    gbc.gridx = 2;
    gbc.gridy = 2;
    panelBusqueda.add(eliminarButton, gbc);
    eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                eliminarActionPerformed(e);
            } 
        });
    
    gbc.gridx = 2;
    gbc.gridy = 4;
    panelBusqueda.add(cerrarButton, gbc);
    cerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cerrarActionPerformed(e);
            } 
        });
    
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridheight = 1;

    getContentPane().add(panelBusqueda,gbc);

    cedulaTextField.setText(cedula);
    nombreTextField.setText(nombre);
    edadTextField.setText(edad);
    experienciaTextField.setText(eperiencia);
    profesionTextField.setText(profesion);
    telefonoTextField.setText(telefono);

    pack();

    Dimension screenSize =
    Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((int) (0.5 * (screenSize.width -
    getWidth())), (int) (0.5 * (screenSize.height -
    getHeight())), getWidth(), getHeight());
        
    }
    
    private void contratarActionPerformed(ActionEvent e) {
        
    }
    
    private void eliminarActionPerformed(ActionEvent e) {
        
    }
    
    private void cerrarActionPerformed(ActionEvent e) {
        setVisible(false);          
    }
        
}

