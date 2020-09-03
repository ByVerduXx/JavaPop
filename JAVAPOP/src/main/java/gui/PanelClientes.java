
package gui;

import javapop.Cliente;


public class PanelClientes extends javax.swing.JPanel {


    public PanelClientes() {
        initComponents();
    }
    
    public void setDatos(Cliente c){
        correo.setText(c.getCorreo());
        pass.setText(c.getClave());
        dni.setText(c.getDni());
        nombre.setText(c.getNombre());
        postal.setText(c.getPostal());
        ciudad.setText(c.getCiudad());
        tarjeta.setText(c.getTarjeta());
    }
    public void limpiar(){
        correo.setText("");
        pass.setText("");
        dni.setText("");
        nombre.setText("");
        postal.setText("");
        ciudad.setText("");
        tarjeta.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        postal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ciudad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tarjeta = new javax.swing.JTextField();

        setBackground(new java.awt.Color(42, 42, 42));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        setLayout(new java.awt.GridLayout(7, 2));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Correo");
        add(jLabel1);

        correo.setEditable(false);
        correo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        correo.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(correo);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        add(jLabel2);

        pass.setEditable(false);
        pass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pass.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(pass);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DNI");
        add(jLabel3);

        dni.setEditable(false);
        dni.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        dni.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(dni);

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");
        add(jLabel4);

        nombre.setEditable(false);
        nombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nombre.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(nombre);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Postal");
        add(jLabel5);

        postal.setEditable(false);
        postal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        postal.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(postal);

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ciudad");
        add(jLabel6);

        ciudad.setEditable(false);
        ciudad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ciudad.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(ciudad);

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tarjeta");
        add(jLabel7);

        tarjeta.setEditable(false);
        tarjeta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tarjeta.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(tarjeta);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ciudad;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField dni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField postal;
    private javax.swing.JTextField tarjeta;
    // End of variables declaration//GEN-END:variables
}