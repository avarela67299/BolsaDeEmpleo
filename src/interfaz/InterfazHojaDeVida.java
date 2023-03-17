package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazHojaDeVida extends JFrame{
    JLabel titulo = new JLabel();
    JLabel cedulaLabel = new JLabel();
    JLabel nombreLabel = new JLabel();
    JLabel edadLabel = new JLabel();
    JLabel experienciaLabel = new JLabel();
    JLabel profesionLabel = new JLabel();
    JLabel telefonoLabel = new JLabel();
    JButton guardar = new JButton();
    JButton cancelar = new JButton();
    
    JTextField cedulaText = new JTextField();
    JTextField nombreText = new JTextField();
    JTextField edadText = new JTextField();
    JTextField experienciaText = new JTextField();
    JTextField profesionText = new JTextField();
    JTextField telefonoText = new JTextField();

    
    public InterfazHojaDeVida(){
    setTitle("Bolsa de empleo");
    addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e){
            setVisible(false);
        }
    });

    //diseño del frame
    getContentPane().setLayout(new GridBagLayout());
    GridBagConstraints gridConstraints = new GridBagConstraints();

    //añadir controles al frame
    this.titulo.setText("NUEVA HOJA DE VIDA");
    this.titulo.setFont(new Font(getName(), Font.PLAIN, 14));
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 0;
    gridConstraints.gridwidth = 2;
    gridConstraints.ipady = 40;
    gridConstraints.anchor = GridBagConstraints.NORTH;
    getContentPane().add(this.titulo,gridConstraints);
    
    this.cedulaLabel.setText("Cédula");
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 1;
    gridConstraints.gridwidth = 1;
    gridConstraints.ipady = 20;
    gridConstraints.ipadx = 10;
    gridConstraints.anchor = GridBagConstraints.EAST;
    getContentPane().add(this.cedulaLabel,gridConstraints);
    
    this.nombreLabel.setText("Nombre");
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 2;
    getContentPane().add(this.nombreLabel,gridConstraints);
    
    this.edadLabel.setText("Edad");
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 3;
    getContentPane().add(this.edadLabel,gridConstraints);
    
    this.experienciaLabel.setText("Años de experiencia");
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 4;
    getContentPane().add(this.experienciaLabel,gridConstraints);
    
    this.profesionLabel.setText("Profesión");
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 5;
    getContentPane().add(this.profesionLabel,gridConstraints);
    
    this.telefonoLabel.setText("Teléfono");
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 6;
    getContentPane().add(this.telefonoLabel,gridConstraints);
    
    this.cedulaText.setText("");
    this.cedulaText.setColumns(10);
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 1;
    gridConstraints.ipady = 5;
    getContentPane().add(this.cedulaText, gridConstraints);
    
    this.nombreText.setText("");
    this.nombreText.setColumns(10);
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 2;
    getContentPane().add(this.nombreText, gridConstraints);
    
    this.edadText.setText("");
    this.edadText.setColumns(10);
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 3;
    getContentPane().add(this.edadText, gridConstraints);
    
    this.experienciaText.setText("");
    this.experienciaText.setColumns(10);
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 4;
    getContentPane().add(this.experienciaText, gridConstraints);
    
    this.profesionText.setText("");
    this.profesionText.setColumns(10);
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 5;
    getContentPane().add(this.profesionText, gridConstraints);
    pack();
    
    this.telefonoText.setText("");
    this.telefonoText.setColumns(10);
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 6;
    getContentPane().add(this.telefonoText, gridConstraints);
    pack();
    
    this.guardar.setText("guardar");
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 7;
    getContentPane().add(this.guardar, gridConstraints);
    pack();
    guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                guardarActionPerformed(e);
            } 
        });
    
    this.cancelar.setText("cancelar");
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 7;
    gridConstraints.anchor = GridBagConstraints.WEST;
    getContentPane().add(this.cancelar, gridConstraints);
    cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cancelarActionPerformed(e);
            } 
        });
    pack();
    
    
    //empezar en la mitad de la pantalla
    Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (0.5 * (screenSize.width -
                getWidth())), (int) (0.5 * (screenSize.height -
                getHeight())), getWidth(), getHeight());
    
    }
    
    //métodos para cada botón
    private void guardarActionPerformed(ActionEvent e) {

    }
    
    private void cancelarActionPerformed(ActionEvent e) {
        setVisible(false);          
    }

    
}
