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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public class InterfazTablaDatos extends JFrame {

    JTable table = new JTable();
    JScrollPane scrollPane = new JScrollPane(table);
    JButton contratarButton = new JButton("contratar");
    JButton eliminarButton = new JButton("eliminar");
    JButton cerrarButton = new JButton("cerrar");
    JPanel panelBotones = new JPanel();
    ArrayList<Aspirante> aspirantesBuscados = new ArrayList();

    public InterfazTablaDatos(ArrayList<Aspirante> aplicantes) {
        aspirantesBuscados = aplicantes;
        getContentPane().setLayout(new GridBagLayout());
        panelBotones.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        Object[][] data = new Object[aplicantes.size()][6];
        String[] columnNames = {"Cedula", "Nombre", "Edad", "Experiencia", "Profesion", "Telefono"};

        for (int i = 0; i < aplicantes.size(); i++) {
            Aspirante a = aplicantes.get(i);
            data[i][0] = a.getCedula();
            data[i][1] = a.getNombre();
            data[i][2] = a.getEdad();
            data[i][3] = a.getExperiencia();
            data[i][4] = a.getProfesion();
            data[i][5] = a.getTelefono();
        }

        TableModel tableModel = new DefaultTableModel(data, columnNames);
        table.setModel(tableModel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 3;

        getContentPane().add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panelBotones.add(contratarButton, gbc);
        contratarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    contratarActionPerformed(e);
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(InterfazTablaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        });

        gbc.gridy = 1;
        panelBotones.add(eliminarButton, gbc);
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eliminarActionPerformed(e);
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(InterfazTablaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }

        });

        gbc.gridy = 2;
        panelBotones.add(cerrarButton, gbc);
        cerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cerrarActionPerformed(e);
            }

        });

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 3;
        getContentPane().add(panelBotones);

        pack();
        Dimension screenSize
                = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (0.5 * (screenSize.width
                - getWidth())), (int) (0.5 * (screenSize.height
                - getHeight())), getWidth(), getHeight());

    }

    private void contratarActionPerformed(ActionEvent e) throws SQLException, Exception {

        int fila = table.getSelectedRow();

        Logger.setGlobalLogLevel(Level.OFF);
        String url = "jdbc:h2:file:./BolsaDeEmpleo";
        ConnectionSource conexion = new JdbcConnectionSource(url);
        Dao<Aspirante, String> listaAspirantes = DaoManager.createDao(conexion, Aspirante.class);

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "seleccione una fila", null, JOptionPane.ERROR_MESSAGE);
        } else {

            Aspirante contratado = listaAspirantes.queryForId(aspirantesBuscados.get(fila).getCedula());

            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de contratar este aspirante " + contratado.getNombre() + "?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                listaAspirantes.delete(contratado);
            }
            setVisible(false);
        }

        conexion.close();

    }

    private void eliminarActionPerformed(ActionEvent e) throws SQLException, Exception {
        int fila = table.getSelectedRow();
        System.out.println(fila);

        Logger.setGlobalLogLevel(Level.OFF);
        String url = "jdbc:h2:file:./BolsaDeEmpleo";
        ConnectionSource conexion = new JdbcConnectionSource(url);
        Dao<Aspirante, String> listaAspirantes = DaoManager.createDao(conexion, Aspirante.class);

        if (fila == -1) {
            try {
                List<Aspirante> eliminados = new ArrayList();
                String entrada = JOptionPane.showInputDialog(null, "Escriba la experiencia mínima. Se eliminarán aquellos con menos experiencia");
                int edadMinima = Integer.parseInt(entrada);

                int numAspirantes = (int) listaAspirantes.countOf();

                for (int i = 0; i < numAspirantes; i++) {
                    Aspirante aEliminar = listaAspirantes.queryForAll().get(i);
                    if (aEliminar.getExperiencia() < edadMinima) {
                        eliminados.add(aEliminar);
                    }
                }
                listaAspirantes.delete(eliminados);
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "input inválido", null, JOptionPane.ERROR_MESSAGE);
            }
            setVisible(false);

        } else {
            Aspirante contratado = listaAspirantes.queryForId(aspirantesBuscados.get(fila).getCedula());
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de elimirar el aspirante " + contratado.getNombre() + "?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                listaAspirantes.delete(contratado);
            }
            setVisible(false);
        }

        conexion.close();

    }

    private void cerrarActionPerformed(ActionEvent e) {
        setVisible(false);
    }

}
