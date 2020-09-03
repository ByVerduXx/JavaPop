
package gui;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javapop.*;


public class VentanaCliente extends javax.swing.JFrame {
    
    private JFrame principal;
    private String tipo;
    public VentanaCliente(JFrame ventana) {

        initComponents();
        ImageIcon imagenFondo = new ImageIcon("fondo.jpg");
        Icon iconoFondo = new ImageIcon(imagenFondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(),Image.SCALE_DEFAULT));
        lblFondo.setIcon(iconoFondo);
        this.repaint();
        ImageIcon imagenLogo = new ImageIcon("logo.png");
        Icon iconoLogo = new ImageIcon(imagenLogo.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(),Image.SCALE_DEFAULT));
        lblLogo.setIcon(iconoLogo);
        this.repaint();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("icono.png"));
        
        
        jLabel1.setText("Bienvenido "+Utilidad.getLogged().getNombre());
        
        principal = ventana;
        principal.setVisible(false);
        this.setVisible(true);
        
        tipo = Utilidad.getLogged().getClass().getSimpleName();
        if (tipo.equals("Cliente")){
            upgrade.setText("Conviertete en premium");
        }
        else{upgrade.setText("Modifica tus datos");}
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cerrar = new javax.swing.JButton();
        baja = new javax.swing.JButton();
        upgrade = new javax.swing.JButton();
        subir = new javax.swing.JButton();
        busqueda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaPop ");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("frame0"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(null);

        cerrar.setFont(new java.awt.Font("Berlin Sans FB", 1, 36)); // NOI18N
        cerrar.setText("Cerrar sesión ");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        jPanel1.add(cerrar);
        cerrar.setBounds(790, 600, 440, 100);

        baja.setFont(new java.awt.Font("Berlin Sans FB", 1, 36)); // NOI18N
        baja.setText("Dar de baja un producto");
        baja.setToolTipText("");
        baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaActionPerformed(evt);
            }
        });
        jPanel1.add(baja);
        baja.setBounds(30, 390, 460, 100);

        upgrade.setFont(new java.awt.Font("Berlin Sans FB", 1, 36)); // NOI18N
        upgrade.setText("Conviertete en Premium");
        upgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upgradeActionPerformed(evt);
            }
        });
        jPanel1.add(upgrade);
        upgrade.setBounds(30, 150, 460, 100);

        subir.setFont(new java.awt.Font("Berlin Sans FB", 1, 36)); // NOI18N
        subir.setText("Subir un producto");
        subir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirActionPerformed(evt);
            }
        });
        jPanel1.add(subir);
        subir.setBounds(30, 510, 460, 100);

        busqueda.setFont(new java.awt.Font("Berlin Sans FB", 1, 36)); // NOI18N
        busqueda.setText("Búsqueda de Productos");
        busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaActionPerformed(evt);
            }
        });
        jPanel1.add(busqueda);
        busqueda.setBounds(30, 270, 460, 100);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido ...");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, -20, 1220, 210);
        jPanel1.add(lblLogo);
        lblLogo.setBounds(550, 60, 690, 460);

        lblFondo.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        lblFondo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblFondo);
        lblFondo.setBounds(0, 0, 1280, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaActionPerformed
        // TODO add your handling code here:
        BajaProducto b = new BajaProducto(this);
    }//GEN-LAST:event_bajaActionPerformed

    private void upgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upgradeActionPerformed
        // TODO add your handling code here:
        MejoraPro m = new MejoraPro(this);
        
    }//GEN-LAST:event_upgradeActionPerformed

    private void subirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirActionPerformed
        SubirProducto s = new SubirProducto(this);

        
    }//GEN-LAST:event_subirActionPerformed

    private void busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaActionPerformed
        BuscarProductos d = new BuscarProductos(this);
        
    }//GEN-LAST:event_busquedaActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        this.setVisible (false);
        this.dispose();
        Login l = new Login();
        l.setVisible(true);
       
    }//GEN-LAST:event_cerrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Utilidad.guardarDatos();
    }//GEN-LAST:event_formWindowClosing



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baja;
    private javax.swing.JButton busqueda;
    private javax.swing.JButton cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JButton subir;
    private javax.swing.JButton upgrade;
    // End of variables declaration//GEN-END:variables
}
