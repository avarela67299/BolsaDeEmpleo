package interfaz;

import bolsadeempleo.Aspirante;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
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
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BolsaDeEmpleo extends JFrame {

    JLabel titulo = new JLabel();
    JButton nuevaHoja = new JButton();
    JButton listaCedulas = new JButton();
    JButton listaTotal = new JButton();
    JButton buscar = new JButton();
    JButton promedio = new JButton();
    JButton cerrar = new JButton();

    public static void main(String[] args) throws SQLException {

        new BolsaDeEmpleo().show();

    }

    //constructor
    public BolsaDeEmpleo() {
        setTitle("Bolsa de empleo");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitForm(e);
            }
        });

        //diseño del frame
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();

        //añadir controles al frame
        this.titulo.setText("GESTIONE A SUS ASPIRANTES");
        this.titulo.setFont(new Font(getName(), Font.PLAIN, 14));
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 2;
        gridConstraints.ipady = 40;
        gridConstraints.anchor = GridBagConstraints.NORTH;
        getContentPane().add(this.titulo, gridConstraints);

        this.nuevaHoja.setText("nueva hoja");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.anchor = GridBagConstraints.CENTER;
        getContentPane().add(this.nuevaHoja, gridConstraints);
        nuevaHoja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nuevaHojaActionPerformed(e);
            }
        });

        this.buscar.setText("buscar");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        getContentPane().add(this.buscar, gridConstraints);
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarActionPerformed(e);
            }
        });

        //se agrega catch
        this.listaTotal.setText("listaTotal");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        getContentPane().add(this.listaTotal, gridConstraints);
        listaTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    listaTotalActionPerformed(e);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(BolsaDeEmpleo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        });

        this.listaCedulas.setText("lista de cédulas");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        getContentPane().add(this.listaCedulas, gridConstraints);
        listaCedulas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    listaCedulasActionPerformed(e);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(BolsaDeEmpleo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        });

        this.promedio.setText("promedio");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        getContentPane().add(this.promedio, gridConstraints);
        promedio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    promedioActionPerformed(e);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(BolsaDeEmpleo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        });

        this.cerrar.setText("cerrar");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
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

    //métodos para cada botón
    private void nuevaHojaActionPerformed(ActionEvent e) {
        new InterfazHojaDeVida().show();
    }

    private void listaCedulasActionPerformed(ActionEvent e) throws SQLException {

        Logger.setGlobalLogLevel(Level.OFF);
        String url = "jdbc:h2:file:./BolsaDeEmpleo";
        ConnectionSource conexion = new JdbcConnectionSource(url);
        Dao<Aspirante, String> listaAspirantes = DaoManager.createDao(conexion, Aspirante.class);

        new InterfazTablaCedulas((ArrayList<Aspirante>) listaAspirantes.queryForAll()).show();

    }

    //se agrega lista desde la base de datos
    private void listaTotalActionPerformed(ActionEvent e) throws SQLException {
        Logger.setGlobalLogLevel(Level.OFF);
        String url = "jdbc:h2:file:./BolsaDeEmpleo";
        ConnectionSource conexion = new JdbcConnectionSource(url);
        Dao<Aspirante, String> listaAspirantes = DaoManager.createDao(conexion, Aspirante.class);
        new InterfazTablaDatos((ArrayList<Aspirante>) listaAspirantes.queryForAll()).show();
    }

    private void buscarActionPerformed(ActionEvent e) {
        new InterfazBuscar().show();

    }
//DONE:PROMEDIO

    private void promedioActionPerformed(ActionEvent e) throws SQLException {

        Logger.setGlobalLogLevel(Level.OFF);
        String url = "jdbc:h2:file:./BolsaDeEmpleo";
        ConnectionSource conexion = new JdbcConnectionSource(url);
        Dao<Aspirante, String> listaAspirantes = DaoManager.createDao(conexion, Aspirante.class);

        QueryBuilder<Aspirante, String> queryBuilder = listaAspirantes.queryBuilder();
        queryBuilder.selectRaw("AVG(edad)"); // calcular el promedio de edad
        GenericRawResults<String[]> resultados = listaAspirantes.queryRaw(queryBuilder.prepareStatementString());

        try {
            String[] resultado = resultados.getFirstResult();
            if (resultado != null && resultado.length > 0) {
                double promedioEdad = Double.parseDouble(resultado[0]);
                JOptionPane.showMessageDialog(null, "El promedio de edad de los aspirantes es: " + promedioEdad, null, JOptionPane.CLOSED_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron aspirantes", null, JOptionPane.CLOSED_OPTION);
            }
        } catch (SQLException f) {
            JOptionPane.showMessageDialog(null, "Error al calcular el promedio de edad: " + f.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }

    }

    private void cerrarActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void exitForm(WindowEvent e) {
        System.exit(0);
    }
}
