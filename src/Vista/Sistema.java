
package Vista;

public class Sistema extends javax.swing.JFrame {
    
    public Sistema() {
        initComponents(); 
        this.setLocationRelativeTo(null);
        setTitle("Viva Aerobus");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jB_buscarvuelo = new javax.swing.JButton();
        jB_boletosreservados = new javax.swing.JButton();
        jB_verdervuelo = new javax.swing.JButton();
        jB_promociones = new javax.swing.JButton();
        jB_gestionusuarios = new javax.swing.JButton();
        jB_cerrarsesion = new javax.swing.JButton();
        jB_gestionusuarios1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/viva-aerobus-logo-374569F0FD-seeklogo.com-2.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Kefa", 1, 36)); // NOI18N
        jLabel1.setText("Bienvenido...");

        jLabel3.setFont(new java.awt.Font("ITF Devanagari Marathi", 1, 24)); // NOI18N
        jLabel3.setText("Sistema de Reservas");

        jB_buscarvuelo.setBackground(new java.awt.Color(204, 204, 204));
        jB_buscarvuelo.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jB_buscarvuelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscarvuelo50.png"))); // NOI18N
        jB_buscarvuelo.setText("          Buscar Vuelo");
        jB_buscarvuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_buscarvueloActionPerformed(evt);
            }
        });

        jB_boletosreservados.setBackground(new java.awt.Color(204, 204, 204));
        jB_boletosreservados.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jB_boletosreservados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1731879650055.png"))); // NOI18N
        jB_boletosreservados.setText("Boletos Reservados");
        jB_boletosreservados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_boletosreservadosActionPerformed(evt);
            }
        });

        jB_verdervuelo.setBackground(new java.awt.Color(204, 204, 204));
        jB_verdervuelo.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jB_verdervuelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/book50.png"))); // NOI18N
        jB_verdervuelo.setText("        Compar Vuelo");
        jB_verdervuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_verdervueloActionPerformed(evt);
            }
        });

        jB_promociones.setBackground(new java.awt.Color(204, 204, 204));
        jB_promociones.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jB_promociones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/promo2.png"))); // NOI18N
        jB_promociones.setText("        Promociones");
        jB_promociones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_promocionesActionPerformed(evt);
            }
        });

        jB_gestionusuarios.setBackground(new java.awt.Color(204, 204, 204));
        jB_gestionusuarios.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jB_gestionusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gestionusuarios.png"))); // NOI18N
        jB_gestionusuarios.setText("Gestión de Usuarios");
        jB_gestionusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_gestionusuariosActionPerformed(evt);
            }
        });

        jB_cerrarsesion.setBackground(new java.awt.Color(204, 204, 204));
        jB_cerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrarsesion.png"))); // NOI18N
        jB_cerrarsesion.setText("Cerrar Sesión");
        jB_cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cerrarsesionActionPerformed(evt);
            }
        });

        jB_gestionusuarios1.setBackground(new java.awt.Color(204, 204, 204));
        jB_gestionusuarios1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jB_gestionusuarios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gestionvuelos.png"))); // NOI18N
        jB_gestionusuarios1.setText("Gestión de Vuelos");
        jB_gestionusuarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_gestionusuarios1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jB_gestionusuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB_boletosreservados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jB_buscarvuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_verdervuelo, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addComponent(jB_promociones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB_gestionusuarios1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jB_cerrarsesion)
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jB_cerrarsesion))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(46, 46, 46)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_buscarvuelo)
                    .addComponent(jB_verdervuelo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_boletosreservados)
                    .addComponent(jB_promociones, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_gestionusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_gestionusuarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_buscarvueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_buscarvueloActionPerformed
        BuscarVuelo fr = new BuscarVuelo();
        fr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jB_buscarvueloActionPerformed

    private void jB_verdervueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_verdervueloActionPerformed
        VenderVuelo frmLogin = new VenderVuelo();
        frmLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jB_verdervueloActionPerformed

    private void jB_cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cerrarsesionActionPerformed
        Login fr = new Login();
        fr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jB_cerrarsesionActionPerformed

    private void jB_gestionusuarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_gestionusuarios1ActionPerformed
        GestionDeVuelos fr = new GestionDeVuelos();
        fr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jB_gestionusuarios1ActionPerformed

    private void jB_promocionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_promocionesActionPerformed
        Promos frmLogin = new Promos();
        frmLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jB_promocionesActionPerformed

    private void jB_gestionusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_gestionusuariosActionPerformed
        GestionUsuarios fr = new GestionUsuarios();
        fr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jB_gestionusuariosActionPerformed

    private void jB_boletosreservadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_boletosreservadosActionPerformed
        BoletosReservados fr = new BoletosReservados();
        fr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jB_boletosreservadosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_boletosreservados;
    private javax.swing.JButton jB_buscarvuelo;
    private javax.swing.JButton jB_cerrarsesion;
    private javax.swing.JButton jB_gestionusuarios;
    private javax.swing.JButton jB_gestionusuarios1;
    private javax.swing.JButton jB_promociones;
    private javax.swing.JButton jB_verdervuelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
