/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.supplier;
import javax.swing.JOptionPane;
import models.Supplier;
import view.HomePage;

/**
 *
 * @author Admin
 */
public class EditSupplier extends javax.swing.JFrame {

    /**
     * Creates new form EditSupplier
     */
    HomePage home;
    
    Supplier sp;
    
    public EditSupplier(java.awt.Frame parent, boolean modal) {
        initComponents();
        this.setLocationRelativeTo(null);
        home = (HomePage) parent;
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void setEditData(Supplier x) {
        sp = x;
        txtSupplierEditName.setText(x.getName());
        txtSupplierEditPhone.setText(x.getPhoneNumber());
        txtSupplierEditAddress.setText(x.getAddress());
        txtSupplierEditEmail.setText(x.getEmail());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSupplierEditName = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtSupplierEditPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSupplierEditEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSupplierEditAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnHuyBo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldSupplierID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtSupplierEditName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierEditNameActionPerformed(evt);
            }
        });

        btnThem.setText("Sửa");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("SỬA THÔNG TIN NHÀ CUNG CẤP");

        txtSupplierEditPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierEditPhoneActionPerformed(evt);
            }
        });

        jLabel6.setText("Địa chỉ:");

        txtSupplierEditEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierEditEmailActionPerformed(evt);
            }
        });

        jLabel3.setText("Điện thoại:");

        txtSupplierEditAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierEditAddressActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên NCC:");

        btnHuyBo.setText("Hủy bỏ");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        jLabel4.setText("Email:");

        jLabel5.setText("Mã NCC:");

        fieldSupplierID.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSupplierEditName, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addComponent(txtSupplierEditAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSupplierEditEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSupplierEditPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(87, 87, 87)
                        .addComponent(btnHuyBo))
                    .addComponent(fieldSupplierID))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSupplierEditName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSupplierEditPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSupplierEditEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtSupplierEditAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnHuyBo))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSupplierEditNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierEditNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierEditNameActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String name, phone, email, address;

        name = txtSupplierEditName.getText();
        phone = txtSupplierEditPhone.getText();
        email = txtSupplierEditEmail.getText();
        address = txtSupplierEditAddress.getText();

        try {
            // Validate inputs before creating the Supplier object
            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty()) {
                throw new IllegalArgumentException("All fields must be filled out.");
            }

            // Attempt to create a Supplier object
            Supplier a = new Supplier(sp.getId(), name, address, phone, email);

            // Call the updateSupplier method to update the supplier
            home.updateSupplier(a);

            // Display success message to the user
            JOptionPane.showMessageDialog(null, "Supplier information updated successfully!");

        } catch (IllegalArgumentException ex) {
            // Handle input validation exceptions
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            // Handle other exceptions here
            ex.printStackTrace(); // Print exception details to the console (for debugging)
            // Display error message to the user
            JOptionPane.showMessageDialog(null, "An error occurred while updating the supplier information. Please try again or contact the administrator.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtSupplierEditPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierEditPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierEditPhoneActionPerformed

    private void txtSupplierEditEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierEditEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierEditEmailActionPerformed

    private void txtSupplierEditAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierEditAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierEditAddressActionPerformed

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyBoActionPerformed

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
            java.util.logging.Logger.getLogger(EditSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditSupplier(null, false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnThem;
    private javax.swing.JTextField fieldSupplierID;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtSupplierEditAddress;
    private javax.swing.JTextField txtSupplierEditEmail;
    private javax.swing.JTextField txtSupplierEditName;
    private javax.swing.JTextField txtSupplierEditPhone;
    // End of variables declaration//GEN-END:variables
}
