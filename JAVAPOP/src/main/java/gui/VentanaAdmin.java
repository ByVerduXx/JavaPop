
package gui;

import java.awt.Image;
import java.awt.Toolkit;
import javapop.Utilidad;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class VentanaAdmin extends javax.swing.JFrame {
    
    private JFrame principal;

    public VentanaAdmin(JFrame ventana) {
        
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
        
        principal = ventana;
        principal.setVisible(false);
        this.setVisible(true);
        
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
        productos = new javax.swing.JButton();
        clientes = new javax.swing.JButton();
        ventas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaPop Admin");
        setMinimumSize(new java.awt.Dimension(1280, 720));
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
        cerrar.setBounds(90, 580, 440, 100);

        productos.setFont(new java.awt.Font("Berlin Sans FB", 1, 36)); // NOI18N
        productos.setText("Consulta de Productos");
        productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosActionPerformed(evt);
            }
        });
        jPanel1.add(productos);
        productos.setBounds(800, 320, 440, 100);

        clientes.setFont(new java.awt.Font("Berlin Sans FB", 1, 36)); // NOI18N
        clientes.setText("Consulta de Usuarios");
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });
        jPanel1.add(clientes);
        clientes.setBounds(800, 120, 440, 100);

        ventas.setFont(new java.awt.Font("Berlin Sans FB", 1, 36)); // NOI18N
        ventas.setText("Consulta de Ventas ");
        ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasActionPerformed(evt);
            }
        });
        jPanel1.add(ventas);
        ventas.setBounds(800, 530, 440, 100);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido, Admin");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, -50, 430, 210);
        jPanel1.add(lblLogo);
        lblLogo.setBounds(10, 110, 690, 420);

        lblFondo.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        lblFondo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblFondo);
        lblFondo.setBounds(0, 0, 1280, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        this.setVisible (false);
        this.dispose();
        principal.setVisible(true);
    }//GEN-LAST:event_cerrarActionPerformed

    private void productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosActionPerformed
        VentanaConsultaProductos u = new VentanaConsultaProductos(this);
    }//GEN-LAST:event_productosActionPerformed

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        VentanaConsultaUsuarios b = new VentanaConsultaUsuarios(this);
    }//GEN-LAST:event_clientesActionPerformed

    private void ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasActionPerformed
        VentanaConsultaVentas v = new VentanaConsultaVentas(this);
    }//GEN-LAST:event_ventasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Utilidad.guardarDatos();
    }//GEN-LAST:event_formWindowClosing



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar;
    private javax.swing.JButton clientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JButton productos;
    private javax.swing.JButton ventas;
    // End of variables declaration//GEN-END:variables
}