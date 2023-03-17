package interfaz;
import bolsadeempleo.Aspirante;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BolsaDeEmpleo extends JFrame{
    JLabel titulo = new JLabel();
    JButton nuevaHoja = new JButton();
    JButton listaCedulas = new JButton();
    JButton listaTotal = new JButton();
    JButton contratar = new JButton();
    JButton buscar = new JButton();
    JButton eliminar = new JButton();
    JButton promedio = new JButton();
    JButton cerrar = new JButton();
    
    public static void main(String[] args) {
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
        
        this.listaCedulas.setText("lista de cédulas");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        getContentPane().add(this.listaCedulas,gridConstraints);
        listaCedulas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                listaCedulasActionPerformed(e);
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
        
        this.contratar.setText("contratar");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        getContentPane().add(this.contratar,gridConstraints);
        contratar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                contratarActionPerformed(e);
            } 
        });
        
        this.buscar.setText("buscar");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        getContentPane().add(this.buscar,gridConstraints);
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                buscarActionPerformed(e);
            } 
        });
        
        this.eliminar.setText("eliminar");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        getContentPane().add(this.eliminar,gridConstraints);
        eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                eliminarActionPerformed(e);
            } 
        });
        
        this.promedio.setText("promedio");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        getContentPane().add(this.promedio,gridConstraints);
        promedio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                promedioActionPerformed(e);
            } 
        });
        
        this.cerrar.setText("cerrar");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 4;
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
    Aspirante alejo = new Aspirante("123","Alejo",3,3,"programer", "559");
    }
    
    private void listaCedulasActionPerformed(ActionEvent e) {
        
    }
    
    private void listaTotalActionPerformed(ActionEvent e) {
        
    }
    
    private void contratarActionPerformed(ActionEvent e) {
        
    }
    
    private void buscarActionPerformed(ActionEvent e) {
        
    }
    
    
    private void eliminarActionPerformed(ActionEvent e) {
        
    }
    
    private void promedioActionPerformed(ActionEvent e) {
        
    }
      
    private void cerrarActionPerformed(ActionEvent e) {
    }
        
    private void exitForm(WindowEvent e){
        System.exit(0);
    }
}