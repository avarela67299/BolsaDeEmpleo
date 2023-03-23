package interfaz;

import bolsadeempleo.Aspirante;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class InterfazTablaDatos extends JFrame {
    
    JTable table = new JTable();
    JScrollPane scrollPane = new JScrollPane(table);
    JButton contratarButton = new JButton("contratar");
    JButton eliminarButton = new JButton("eliminar");
    JButton cerrarButton = new JButton("cerrar");
    JPanel panelBotones = new JPanel();
          
    public InterfazTablaDatos (ArrayList<Aspirante> aplicantes){
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
            public void actionPerformed(ActionEvent e){
                contratarActionPerformed(e);
            }    
        });
        
        gbc.gridy = 1;
        panelBotones.add(eliminarButton, gbc);
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                eliminarActionPerformed(e);
            } 
    
        });
        
        gbc.gridy = 2;
        panelBotones.add(cerrarButton, gbc);
        cerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cerrarActionPerformed(e);
            } 

        });
        
         gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 3;
        getContentPane().add(panelBotones);

        pack();
        Dimension screenSize =
        Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (0.5 * (screenSize.width -
        getWidth())), (int) (0.5 * (screenSize.height -
        getHeight())), getWidth(), getHeight());  
        
    }
    
    private void contratarActionPerformed(ActionEvent e) {
        
        int fila = table.getSelectedRow();
        
        JOptionPane.showMessageDialog(null, String.valueOf(fila), null,JOptionPane.CLOSED_OPTION);
           
    }
    
    private void eliminarActionPerformed(ActionEvent e) {
        
    }
    
    private void cerrarActionPerformed(ActionEvent e) {
        setVisible(false);          
    }
    
}
