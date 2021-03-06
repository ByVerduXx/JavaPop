
package gui;



import javapop.ClientePro;




public class PanelPro extends javax.swing.JPanel {


    public PanelPro() {
        initComponents();
    }
    
    public void setDatos(ClientePro c){
        
        web.setText(c.getWeb());
        horario.setText(c.getHorario());
        telefono.setText(String.valueOf(c.getTlf()));
        desc.setText(c.getDescripcion());
    } 
    public void limpiar(){
        web.setText("");
        horario.setText("");
        telefono.setText("");
        desc.setText("");
    }


    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        web = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        horario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        descripcion = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(42, 42, 42));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        setLayout(null);

        web.setEditable(false);
        web.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        add(web);
        web.setBounds(20, 40, 230, 30);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Página Web");
        add(jLabel2);
        jLabel2.setBounds(20, 10, 135, 28);

        horario.setEditable(false);
        horario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        add(horario);
        horario.setBounds(20, 310, 230, 30);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripción");
        add(jLabel3);
        jLabel3.setBounds(20, 70, 280, 28);

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Teléfono");
        add(jLabel4);
        jLabel4.setBounds(20, 220, 280, 28);

        telefono.setEditable(false);
        telefono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        add(telefono);
        telefono.setBounds(20, 250, 230, 30);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Horario");
        add(jLabel5);
        jLabel5.setBounds(20, 280, 280, 28);

        desc.setEditable(false);
        descripcion.setViewportView(desc);

        add(descripcion);
        descripcion.setBounds(20, 100, 230, 120);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane desc;
    private javax.swing.JScrollPane descripcion;
    private javax.swing.JTextField horario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField web;
    // End of variables declaration//GEN-END:variables
}
