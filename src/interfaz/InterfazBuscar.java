package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazBuscar extends JFrame {
    
    JLabel titulo = new JLabel();
    ButtonGroup buttonGroup = new ButtonGroup();
    JRadioButton nombreButton = new JRadioButton();
    JRadioButton cedulaButton = new JRadioButton();
    JRadioButton mayorButton = new JRadioButton();
    JRadioButton jovenButton = new JRadioButton();
    JTextField text = new JTextField();
    JButton buscar = new JButton();
    JButton cerrar = new JButton();
        
    public InterfazBuscar(){
        setTitle("Buscar");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                setVisible(false);
        }
    });
        
    //diseño del frame
    getContentPane().setLayout(new GridBagLayout());
    GridBagConstraints gridConstraints = new GridBagConstraints();
    
    this.titulo.setText("BUSCAR");
    this.titulo.setFont(new Font(getName(), Font.PLAIN, 14));
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 0;
    gridConstraints.gridwidth = 2;
    gridConstraints.ipady = 40;
    gridConstraints.anchor = GridBagConstraints.NORTH;
    getContentPane().add(this.titulo,gridConstraints);
    
    this.cedulaButton.setText("cédula");
    this.cedulaButton.setSelected(true);
    this.buttonGroup.add(cedulaButton);
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 1;
    gridConstraints.gridwidth = 1;
    gridConstraints.ipady = 10;
    gridConstraints.ipadx = 10;
    gridConstraints.anchor = GridBagConstraints.WEST;
    getContentPane().add(this.cedulaButton,gridConstraints);
    this.cedulaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                text.setVisible(true);
                }
            });
    
    this.nombreButton.setText("nombre");
    this.buttonGroup.add(nombreButton);
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 2;
    getContentPane().add(this.nombreButton,gridConstraints);
    this.nombreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                text.setVisible(true);
                }
            });
    
    this.mayorButton.setText("mayor experiencia");
    this.buttonGroup.add(mayorButton);
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 4;
    getContentPane().add(this.mayorButton,gridConstraints);
    this.mayorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                text.setVisible(false);
                }
            });
    
    this.jovenButton.setText("más jóven");
    this.buttonGroup.add(jovenButton);
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 3;
    getContentPane().add(this.jovenButton,gridConstraints);
    this.jovenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                text.setVisible(false);
                }
            });
    
    this.text.setText("");
    this.text.setColumns(10);
    gridConstraints.gridwidth = 2;
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 5;
    gridConstraints.fill = GridBagConstraints.HORIZONTAL;
    getContentPane().add(this.text,gridConstraints);
    
    this.buscar.setText("buscar");
    gridConstraints.gridwidth = 1;
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 6;
    gridConstraints.fill = GridBagConstraints.NONE;
    getContentPane().add(this.buscar,gridConstraints);
    buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                buscarActionPerformed(e);
            }
        });
    
    this.cerrar.setText("cerrar");
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 6;
    gridConstraints.anchor = GridBagConstraints.EAST;
    getContentPane().add(this.cerrar, gridConstraints);
    cerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cerrarActionPerformed(e);
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
    
    private void buscarActionPerformed(ActionEvent e) {
        if(cedulaButton.isSelected()){
          //TODO: buscar con cedula  
        }
        else if(nombreButton.isSelected()){
            //TODO: buscar con nombre     
        }
        else if (mayorButton.isSelected()){
            //TODO: buscar el de más experiencia
            
        }
        else if(jovenButton.isSelected()){
            //TODO: buscar el más jóven 
        }    
    }
    
    private void cerrarActionPerformed(ActionEvent e) {
        setVisible(false);          
    }
    
}
