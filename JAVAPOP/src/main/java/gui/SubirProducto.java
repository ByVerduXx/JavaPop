
package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import javapop.Cliente;
import javapop.Producto;
import javapop.Utilidad;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class SubirProducto extends javax.swing.JFrame {
    
    private JFrame principal;
    private Producto prod = null;
    private String nombreImagen, rutaImagen, extension;
    private File file;
    private BufferedImage bimage;
    private LocalDate fecha;
    
    public SubirProducto(JFrame ventana) {
        
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
        
        panelProductos1.tituloEditable(true);
        panelProductos1.descripcionEditable(true);
        panelProductos1.precioEditable(true);
        
        fijarDatos();
        panelProductos1.setCategoria(jComboBox1.getSelectedItem().toString());
        panelProductos1.setEstado(jComboBox2.getSelectedItem().toString());
        
    }
    public void fijarDatos(){
        fecha = LocalDate.now();
        panelProductos1.setFecha(fecha);
        panelProductos1.setPostal();
        panelProductos1.setCiudad();
        panelProductos1.setPropietario();
        panelProductos1.setUrgente(false);
    }
    
    public ImageIcon ResizeImage(String ImagePath){
        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(panelProductos1.getFoto().getWidth(), panelProductos1.getFoto().getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    public String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
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
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelProductos1 = new gui.PanelProductos();
        imagen = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        subir = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JavaPop Subir Producto");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setLayout(null);

        jCheckBox1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText(" Urgente");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(690, 160, 120, 40);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Subir Producto");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 50, 330, 100);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(670, 60, 120, 30);

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Categoría");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(470, 58, 120, 30);
        jPanel1.add(panelProductos1);
        panelProductos1.setBounds(60, 150, 610, 470);

        imagen.setFont(new java.awt.Font("Berlin Sans FB", 1, 36)); // NOI18N
        imagen.setText("Imagen");
        imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagenActionPerformed(evt);
            }
        });
        jPanel1.add(imagen);
        imagen.setBounds(440, 640, 180, 50);

        jComboBox2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox2.setMaximumRowCount(5);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo", "Como nuevo", "Bueno", "Aceptable", "Regular" }));
        jComboBox2.setBorder(null);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(670, 90, 170, 40);

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Moda y accesorios", "TV, audio y foto", "Móviles y telefonía", "Informática y electrónica", "Consolas y videojuegos", "Deporte y ocio" }));
        jComboBox1.setBorder(null);
        jComboBox1.setLightWeightPopupEnabled(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(470, 90, 170, 40);

        subir.setFont(new java.awt.Font("Berlin Sans FB", 1, 36)); // NOI18N
        subir.setText("Subir Producto");
        subir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirActionPerformed(evt);
            }
        });
        jPanel1.add(subir);
        subir.setBounds(90, 630, 290, 70);
        jPanel1.add(lblLogo);
        lblLogo.setBounds(710, 230, 540, 440);

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

    private void subirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirActionPerformed
        String titulo,descripcion,categoria,estado,postal,ciudad;
        double precio;
        boolean urgente;
        LocalDate fecha;
        Cliente cliente;
        ImageIcon imagen;
        if(panelProductos1.getTitulo().equals("") || panelProductos1.getDesc().equals("") || String.valueOf(panelProductos1.getPrecio()).equals("") || panelProductos1.getFoto().getIcon() == null){
            JOptionPane.showMessageDialog(this, "Debe rellenar todos los datos del producto.", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try{
                bimage = ImageIO.read(file);
                File fout = new File("imagenes/" + nombreImagen);
                ImageIO.write(bimage, extension, fout);
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar imagen");
            }
            try{
                titulo = panelProductos1.getTitulo();
                descripcion = panelProductos1.getDesc();
                categoria = panelProductos1.getCategoria();
                estado = panelProductos1.getEstado();
                postal = panelProductos1.getPostal();
                ciudad = panelProductos1.getCiudad();
                precio = panelProductos1.getPrecio();
                fecha = this.fecha;
                if (panelProductos1.isUrgente()){
                    urgente = true;
                }
                else{urgente = false;}
                imagen = new ImageIcon("imagenes/"+nombreImagen);
                cliente = Utilidad.getLogged();
                prod = new Producto(titulo,descripcion,categoria,estado,precio,fecha,imagen,postal,ciudad,urgente,cliente);
                if(urgente){
                    int resp = JOptionPane.showConfirmDialog(null, "Usted ha marcado el producto como Urgente. Debe pagar 5 euros.", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if(resp == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(this, "Se han cargado 5 euros a su tarjeta: " + Utilidad.getLogged().getTarjeta(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        if(Utilidad.subirProducto(prod)){
                            JOptionPane.showMessageDialog(this, "El producto ha sido subido con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "Ha habido un error al subir el producto.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Debe pagar 5 euros para que su producto pueda ser Urgente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    if(Utilidad.subirProducto(prod)){
                        JOptionPane.showMessageDialog(this, "El producto ha sido subido con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Ha habido un error al subir el producto.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
                }   
                
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Ha habido un error desconocido, inténtelo más tarde.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_subirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagenActionPerformed
        JFileChooser filec = new JFileChooser();
        filec.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","gif","png");
        filec.addChoosableFileFilter(filter);
        int result = filec.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            file = filec.getSelectedFile();
            extension = getExtension(file);
            rutaImagen = file.getAbsolutePath();
            nombreImagen = file.getName();
            String[] aux = nombreImagen.split("\\.");
            panelProductos1.setImage(ResizeImage(rutaImagen));
        }
        else {
            JOptionPane.showMessageDialog(this, "Ningún fichero seleccionado", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_imagenActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String cate = jComboBox1.getSelectedItem().toString();
        panelProductos1.setCategoria(cate);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String estado = jComboBox2.getSelectedItem().toString();
        panelProductos1.setEstado(estado);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()){
            panelProductos1.setUrgente(true);
        }
        else{
            panelProductos1.setUrgente(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton imagen;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private gui.PanelProductos panelProductos1;
    private javax.swing.JButton subir;
    // End of variables declaration//GEN-END:variables
}
