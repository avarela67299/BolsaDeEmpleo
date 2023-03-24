package interfaz;

import bolsadeempleo.Aspirante;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.util.List;

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
    JButton ejecutar = new JButton();

    public InterfazBuscar() {
        setTitle("Buscar");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
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
        getContentPane().add(this.titulo, gridConstraints);

        this.cedulaButton.setText("cédula");
        this.cedulaButton.setSelected(true);
        this.buttonGroup.add(cedulaButton);
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.ipady = 10;
        gridConstraints.ipadx = 10;
        gridConstraints.anchor = GridBagConstraints.WEST;
        getContentPane().add(this.cedulaButton, gridConstraints);
        this.cedulaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setVisible(true);
            }
        });

        this.nombreButton.setText("nombre");
        this.buttonGroup.add(nombreButton);
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        getContentPane().add(this.nombreButton, gridConstraints);
        this.nombreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setVisible(true);
            }
        });

        this.mayorButton.setText("mayor experiencia");
        this.buttonGroup.add(mayorButton);
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        getContentPane().add(this.mayorButton, gridConstraints);
        this.mayorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setVisible(false);
            }
        });

        this.jovenButton.setText("más jóven");
        this.buttonGroup.add(jovenButton);
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        getContentPane().add(this.jovenButton, gridConstraints);
        this.jovenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setVisible(false);
            }
        });

        this.text.setText("");
        this.text.setColumns(10);
        gridConstraints.gridwidth = 2;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 5;
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(this.text, gridConstraints);

        this.buscar.setText("buscar");
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 6;
        gridConstraints.fill = GridBagConstraints.NONE;
        getContentPane().add(this.buscar, gridConstraints);
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

    private void buscarActionPerformed(ActionEvent e) throws SQLException, Exception {

        //base de datos
        Logger.setGlobalLogLevel(Level.OFF);
        String url = "jdbc:h2:file:./BolsaDeEmpleo";
        ConnectionSource conexion = new JdbcConnectionSource(url);
        Dao<Aspirante, String> listaAspirantes = DaoManager.createDao(conexion, Aspirante.class);

        List<Aspirante> aspirantesBuscados = new ArrayList();

        try {
            if (text.getText().isEmpty() && !(mayorButton.isSelected() || jovenButton.isSelected())) {
                JOptionPane.showMessageDialog(null, "El input se encuentra vacio", null, JOptionPane.CLOSED_OPTION);
            } else {
                if (cedulaButton.isSelected()) {
                    //DONE: buscar con cedula   
                    aspirantesBuscados.addAll(listaAspirantes.queryForEq("cedula", text.getText()));
                } else if (nombreButton.isSelected()) {
                    //DONE: buscar con nombre   
                    aspirantesBuscados.addAll(listaAspirantes.queryForEq("nombre", text.getText()));
                } else if (mayorButton.isSelected()) {
                    //DONE: buscar el de más experiencia

                    QueryBuilder<Aspirante, String> queryBuilder = listaAspirantes.queryBuilder();
                    queryBuilder.orderBy("experiencia", false);
                    queryBuilder.limit(1L);
                    List<Aspirante> resultado = listaAspirantes.query(queryBuilder.prepare());

                    if (!resultado.isEmpty()) {
                        // Obtener el valor máximo de experiencia de la lista completa
                        int experienciaMaxima = resultado.get(0).getExperiencia();

                        // Crear una nueva consulta para obtener todos los aspirantes con la experiencia máxima
                        queryBuilder = listaAspirantes.queryBuilder();
                        queryBuilder.where().eq("experiencia", experienciaMaxima);

                        List<Aspirante> aspirantesConMaxExperiencia = listaAspirantes.query(queryBuilder.prepare());

                        // Agregar los aspirantes con experiencia máxima a la lista
                        aspirantesBuscados.addAll(aspirantesConMaxExperiencia);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontraron aspirantes con experiencia", null, JOptionPane.CLOSED_OPTION);
                    }

                } else if (jovenButton.isSelected()) {
                    //DONE: buscar el más jóven 

                    QueryBuilder<Aspirante, String> queryBuilder = listaAspirantes.queryBuilder();
                    queryBuilder.orderBy("edad", true);
                    queryBuilder.limit(1L);
                    List<Aspirante> resultado = listaAspirantes.query(queryBuilder.prepare());

                    if (!resultado.isEmpty()) {
                        // Obtener el valor minimo de edad de la lista completa
                        int edadMinima = resultado.get(0).getEdad();

                        // Crear una nueva consulta para obtener todos los aspirantes con la edadminima
                        queryBuilder = listaAspirantes.queryBuilder();
                        queryBuilder.where().eq("edad", edadMinima);

                        List<Aspirante> aspirantesConedadminima = listaAspirantes.query(queryBuilder.prepare());

                        // Agregar los aspirantes con eedadminima a la lista
                        aspirantesBuscados.addAll(aspirantesConedadminima);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontraron aspirantes con edad minima", null, JOptionPane.CLOSED_OPTION);
                    }

                }
            }
        } catch (Exception x) {
        }

        if (aspirantesBuscados == null || aspirantesBuscados.isEmpty() && !text.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El aspirante buscado no se encuentra registrado", null, JOptionPane.CLOSED_OPTION);
        } else {
            // desplega la informacion del aplicante
            new InterfazTablaDatos((ArrayList<Aspirante>) aspirantesBuscados).show();

        }
        conexion.close();

    }

    private void cerrarActionPerformed(ActionEvent e) {
        setVisible(false);
    }

}
