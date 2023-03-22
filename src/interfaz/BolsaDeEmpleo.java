package interfaz;
import bolsadeempleo.Aspirante;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class BolsaDeEmpleo extends JFrame{
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
    public BolsaDeEmpleo(){
        setTitle("Bolsa de empleo");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
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
        getContentPane().add(this.titulo,gridConstraints);
        
        this.nuevaHoja.setText("nueva hoja");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.anchor = GridBagConstraints.CENTER;
        getContentPane().add(this.nuevaHoja,gridConstraints);
        nuevaHoja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                nuevaHojaActionPerformed(e);
            } 
        });
        
        this.buscar.setText("buscar");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        getContentPane().add(this.buscar,gridConstraints);
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                buscarActionPerformed(e);
            } 
        });
        
        
        this.listaTotal.setText("listaTotal");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        getContentPane().add(this.listaTotal,gridConstraints);
        listaTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                listaTotalActionPerformed(e);
            } 
        });
        
        this.listaCedulas.setText("lista de cédulas");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        getContentPane().add(this.listaCedulas,gridConstraints);
        listaCedulas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                listaCedulasActionPerformed(e);
            } 
        });
        
        this.promedio.setText("promedio");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        getContentPane().add(this.promedio,gridConstraints);
        promedio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                promedioActionPerformed(e);
            } 
        });
   
        this.cerrar.setText("cerrar");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        getContentPane().add(this.cerrar,gridConstraints);
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
    
    //métodos para cada botón
     
    private void nuevaHojaActionPerformed(ActionEvent e) {
    new InterfazHojaDeVida().show();
    }
    
    private void listaCedulasActionPerformed(ActionEvent e) {
 
    }
    
    private void listaTotalActionPerformed(ActionEvent e) {
        
    }
    
    private void buscarActionPerformed(ActionEvent e) {
        new InterfazBuscar().show();
        
    }
    
    private void promedioActionPerformed(ActionEvent e) {
        
    }
      
    private void cerrarActionPerformed(ActionEvent e) {
        System.exit(0);
    }
        
    private void exitForm(WindowEvent e){
        System.exit(0);
    }
}