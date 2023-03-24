package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import bolsadeempleo.Aspirante;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.support.ConnectionSource;


public class InterfazHojaDeVida extends JFrame {

    JLabel titulo = new JLabel();
    JLabel cedulaLabel = new JLabel();
    JLabel nombreLabel = new JLabel();
    JLabel edadLabel = new JLabel();
    JLabel experienciaLabel = new JLabel();
    JLabel profesionLabel = new JLabel();
    JLabel telefonoLabel = new JLabel();
    JButton guardar = new JButton();
    JButton cerrar = new JButton();

    JTextField cedulaText = new JTextField();
    JTextField nombreText = new JTextField();
    JTextField edadText = new JTextField();
    JTextField experienciaText = new JTextField();
    JTextField profesionText = new JTextField();
    JTextField telefonoText = new JTextField();

    ArrayList<Aspirante> aspirantes = new ArrayList();

    public InterfazHojaDeVida() {
        setTitle("Hoja de vida");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
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
        getContentPane().add(this.titulo, gridConstraints);

        this.cedulaLabel.setText("Cédula");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.ipady = 20;
        gridConstraints.ipadx = 10;
        gridConstraints.anchor = GridBagConstraints.EAST;
        getContentPane().add(this.cedulaLabel, gridConstraints);

        this.nombreLabel.setText("Nombre");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        getContentPane().add(this.nombreLabel, gridConstraints);

        this.edadLabel.setText("Edad");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        getContentPane().add(this.edadLabel, gridConstraints);

        this.experienciaLabel.setText("Años de experiencia");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        getContentPane().add(this.experienciaLabel, gridConstraints);

        this.profesionLabel.setText("Profesión");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 5;
        getContentPane().add(this.profesionLabel, gridConstraints);

        this.telefonoLabel.setText("Teléfono");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 6;
        getContentPane().add(this.telefonoLabel, gridConstraints);

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
            public void actionPerformed(ActionEvent e) {
                guardarActionPerformed(e);
            }
        });

        this.cerrar.setText("cerrar");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 7;
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(this.cerrar, gridConstraints);
        cerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cerrarActionPerformed(e);
            }
        });
        pack();

        //empezar en la mitad de la pantalla
        Dimension screenSize
                = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (0.5 * (screenSize.width
                - getWidth())), (int) (0.5 * (screenSize.height
                - getHeight())), getWidth(), getHeight());

    }

    //guardar nuevo aspirante en ArrayList aspirantes 
    private void guardarActionPerformed(ActionEvent e) {
        try {

            Logger.setGlobalLogLevel(Level.OFF);
            // Ubicación del archivo de la base de datos
            String url = "jdbc:h2:file:./BolsaDeEmpleo";
            ConnectionSource conexion
                    = new JdbcConnectionSource(url);
            // Obtener acceso a la lista de objetos=>Tabla (DAO)
            // Primero es la clase de la tabla, Segundo tipo de la llave
            Dao<Aspirante, String> listaAspirantes
                    = DaoManager.createDao(conexion, Aspirante.class);

            //creamos objeto,se modifica dejandolo en el constructor
            listaAspirantes.create(new Aspirante(
                    this.cedulaText.getText(),
                    this.nombreText.getText(),
                    Integer.parseInt(this.edadText.getText()),
                    Integer.parseInt(this.experienciaText.getText()),
                    this.profesionText.getText(),
                    this.telefonoText.getText()));

            conexion.close();

            //TODO: Verificar que no se repitan los atributos únicos
            JOptionPane.showMessageDialog(null, "nuevo aspirante guardado", null, JOptionPane.CLOSED_OPTION);
            resetearCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "input inválido", null, JOptionPane.ERROR_MESSAGE);
            resetearCampos();
        }

    }

    private void cerrarActionPerformed(ActionEvent e) {
        setVisible(false);
    }

    //resetear los campos de texto
    private void resetearCampos() {
        this.cedulaText.setText("");
        this.nombreText.setText("");
        this.edadText.setText("");
        this.experienciaText.setText("");
        this.profesionText.setText("");
        this.telefonoText.setText("");
    }

}
