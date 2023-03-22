package interfaz;
import bolsadeempleo.Aspirante;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.support.ConnectionSource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

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
    
    JPanel busqueda = new JPanel();
    JLabel cedulaLabel = new JLabel();
    JLabel nombreLabel = new JLabel();
    JLabel edadLabel = new JLabel();
    JLabel experienciaLabel = new JLabel();
    JLabel profeciónLabel = new JLabel();
    JLabel telefonoLabel = new JLabel();
    ButtonGroup buttonGroupBusqueda = new ButtonGroup();
    JRadioButton contratar = new JRadioButton();
    JRadioButton eliminar = new JRadioButton();
    JRadioButton cancelar = new JRadioButton();
    JButton ejecutar = new JButton ();
        
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
                try {
                    buscarActionPerformed(e);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(InterfazBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(InterfazBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
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
    
    private void buscarActionPerformed(ActionEvent e) throws SQLException, Exception {
        Aspirante aspiranteBuscado = null;
        
        if(cedulaButton.isSelected()){
          //TODO: buscar con cédula  
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
        
        if (aspiranteBuscado != null){
            JOptionPane.showMessageDialog(null, "aspirante no existe", null,JOptionPane.CLOSED_OPTION);
            
        } else {
            
            Logger.setGlobalLogLevel(Level.OFF);
            // Ubicación del archivo de la base de datos
            String url = "jdbc:h2:file:./BolsaDeEmpleo";
            ConnectionSource conexion = new JdbcConnectionSource(url);
            // Obtener acceso a la lista de objetos=>Tabla (DAO)
            // Primero es la clase de la tabla, Segundo tipo de la llave
            Dao<Aspirante, String> listaAspirantes = DaoManager.createDao(conexion, Aspirante.class);
            Aspirante karen = listaAspirantes.queryForId("123");
            karen.toString();
            // desplega la informacion del aplicante
            new InterfazBusqueda(karen.getCedula(),karen.getNombre(),String.valueOf(karen.getEdad()),String.valueOf(karen.getExperiencia()),karen.getProfesion(),karen.getTelefono()).show();
            conexion.close();
        }
        
    } 
    
    private void cerrarActionPerformed(ActionEvent e) {
        setVisible(false);          
    }
    
}
