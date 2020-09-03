
package gui;

import java.time.format.DateTimeFormatter;
import javapop.Venta;


public class PanelVentas extends javax.swing.JPanel {


    public PanelVentas() {
        initComponents();
    }
    
    public void setDatos(Venta v){
        nombreProducto.setText(v.getProducto().getTitulo());
        String prec = String.valueOf(v.getProducto().getPrecio());
        precio.setText(prec + "€");
        
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
        String fn = v.getFecha().format(formatoCorto);
        fecha.setText(fn);
        
        nombreVend.setText(v.getNombreVend());
        dnivend.setText(v.getDniVend());
        nombreComp.setText(v.getNombreComp());
        dniComp.setText(v.getDniComp());
    }
    
    public void limpiar(){
        nombreProducto.setText("");
        precio.setText("");
        fecha.setText("");
        nombreVend.setText("");
        dnivend.setText("");
        nombreComp.setText("");
        dniComp.setText("");
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
        nombreProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nombreVend = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dnivend = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nombreComp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dniComp = new javax.swing.JTextField();

        setBackground(new java.awt.Color(42, 42, 42));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        setLayout(new java.awt.GridLayout(7, 2));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre del producto");
        add(jLabel1);

        nombreProducto.setEditable(false);
        nombreProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nombreProducto.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(nombreProducto);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Precio");
        add(jLabel2);

        precio.setEditable(false);
        precio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        precio.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(precio);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha");
        add(jLabel3);

        fecha.setEditable(false);
        fecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fecha.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(fecha);

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre del vendedor");
        add(jLabel4);

        nombreVend.setEditable(false);
        nombreVend.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nombreVend.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(nombreVend);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DNI del vendedor");
        add(jLabel5);

        dnivend.setEditable(false);
        dnivend.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        dnivend.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(dnivend);

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre del comprador");
        add(jLabel6);

        nombreComp.setEditable(false);
        nombreComp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nombreComp.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(nombreComp);

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 33)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DNI del comprador");
        add(jLabel7);

        dniComp.setEditable(false);
        dniComp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        dniComp.setMargin(new java.awt.Insets(1, 2, 1, 2));
        add(dniComp);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dniComp;
    private javax.swing.JTextField dnivend;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nombreComp;
    private javax.swing.JTextField nombreProducto;
    private javax.swing.JTextField nombreVend;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}
