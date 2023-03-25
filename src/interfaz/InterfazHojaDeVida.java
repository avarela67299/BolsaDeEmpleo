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
            String url = "jdbc:h2:file:./BolsaDeEmpleo";
            ConnectionSource conexion
                    = new JdbcConnectionSource(url);
            Dao<Aspirante, String> listaAspirantes
                    = DaoManager.createDao(conexion, Aspirante.class);

            listaAspirantes.create(new Aspirante(
                    this.cedulaText.getText(),
                    this.nombreText.getText(),
                    Integer.parseInt(this.edadText.getText()),
                    Integer.parseInt(this.experienciaText.getText()),
                    this.profesionText.getText(),
                    this.telefonoText.getText()));
            
            
            listaAspirantes.create(new Aspirante("001", "Juan", 25, 2, "Ingeniero", "111-1111"));
listaAspirantes.create(new Aspirante("002", "Maria", 30, 5, "Abogada", "222-2222"));
listaAspirantes.create(new Aspirante("003", "Pedro", 28, 4, "Ingeniero", "333-3333"));
listaAspirantes.create(new Aspirante("004", "Luisa", 27, 3, "Arquitecta", "444-4444"));
listaAspirantes.create(new Aspirante("005", "Jorge", 24, 1, "Programador", "555-5555"));
listaAspirantes.create(new Aspirante("006", "Lucia", 26, 2, "Contadora", "666-6666"));
listaAspirantes.create(new Aspirante("007", "Andres", 29, 6, "Ingeniero", "777-7777"));
listaAspirantes.create(new Aspirante("008", "Ana", 23, 1, "Diseñadora", "888-8888"));
listaAspirantes.create(new Aspirante("009", "Carlos", 31, 7, "Abogado", "999-9999"));
listaAspirantes.create(new Aspirante("010", "Sofia", 22, 1, "Ingeniera", "101-0101"));
listaAspirantes.create(new Aspirante("011", "Miguel", 26, 3, "Programador", "111-1111"));
listaAspirantes.create(new Aspirante("012", "Carmen", 27, 4, "Ingeniera", "121-2121"));
listaAspirantes.create(new Aspirante("013", "Jose", 28, 5, "Abogado", "131-3131"));
listaAspirantes.create(new Aspirante("014", "Laura", 25, 2, "Contadora", "141-4141"));
listaAspirantes.create(new Aspirante("015", "Diego", 24, 1, "Ingeniero", "151-5151"));
listaAspirantes.create(new Aspirante("016", "Monica", 23, 1, "Diseñadora", "161-6161"));
listaAspirantes.create(new Aspirante("017", "Javier", 30, 6, "Ingeniero", "171-7171"));
listaAspirantes.create(new Aspirante("018", "Paola", 27, 3, "Arquitecta", "181-8181"));
listaAspirantes.create(new Aspirante("019", "Oscar", 26, 2, "Programador", "191-9191"));
listaAspirantes.create(new Aspirante("020", "Fabiola", 25, 2, "Ingeniera", "202-0202"));
listaAspirantes.create(new Aspirante("021", "Gustavo", 29, 4, "Abogado", "212-1212"));
            

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
