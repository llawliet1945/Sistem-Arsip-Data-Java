package Login;

import Data.Encrypt;
import static Data.Encrypt.encrypt;
import Data.connect;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;

/*
    @author llawl
 */
public class Login extends javax.swing.JFrame {
    private static Connection conn = new connect().configDB();
    public Login() {
        initComponents();
        lpassword.setVisible(true);
        lpassword.setForeground(new Color(183,183,183));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        borderUsr = new javax.swing.JLabel();
        lpassword = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        borderPass = new javax.swing.JLabel();
        Rectangle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(37, 178, 99));
        jButton1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 372, 66));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        jLabel1.setText("Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, -1, -1));

        txt_user.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_user.setBorder(null);
        txt_user.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_userFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_userFocusLost(evt);
            }
        });
        jPanel1.add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 223, 340, 60));

        borderUsr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield.png"))); // NOI18N
        jPanel1.add(borderUsr, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 372, 66));

        lpassword.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lpassword.setForeground(new java.awt.Color(183, 183, 183));
        lpassword.setText("Password");
        jPanel1.add(lpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 353, 340, 60));

        txt_pass.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_pass.setBorder(null);
        txt_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_passFocusLost(evt);
            }
        });
        jPanel1.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 353, 340, 60));

        borderPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield.png"))); // NOI18N
        jPanel1.add(borderPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 372, 66));

        Rectangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/login.png"))); // NOI18N
        Rectangle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Rectangle.setPreferredSize(new java.awt.Dimension(500, 492));
        jPanel1.add(Rectangle, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 547, 543));
        Rectangle.getAccessibleContext().setAccessibleDescription("");
        Rectangle.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String SQL = "Select * from admin where Username='"+txt_user.getText()+"' or Password='"+String.valueOf(encrypt(encrypt(txt_pass.getText())))+"'";
        try{
            PreparedStatement state = conn.prepareStatement(SQL);
            ResultSet Result = state.executeQuery(SQL);
            if(Result.next()){
                if(txt_user.getText().equals(Result.getString("Username"))&&String.valueOf(encrypt(encrypt(txt_pass.getText()))).equals(Result.getString("Password"))){
                    Encrypt.setUsername(Result.getString("Username"));
                    JOptionPane.showMessageDialog(null, "\tLogin Sukses \nSelamat Datang "+Result.getString("Nama_Admin"));                    
                    new Layout.Dashboard().setVisible(true);
                    this.dispose();
                }else if(!txt_user.getText().equals(Result.getString("Username"))&&String.valueOf(encrypt(encrypt(txt_pass.getText()))).equals(Result.getString("Password"))){
                    JOptionPane.showMessageDialog(null, "Username Salah!", "Error!", JOptionPane.ERROR_MESSAGE);                    
                }else if(!encrypt(encrypt(txt_pass.getText())).equals(Result.getString("Password"))&&txt_user.getText().equals(Result.getString("Username"))){
                    JOptionPane.showMessageDialog(null, "Password Salah!", "Error!", JOptionPane.ERROR_MESSAGE);                   
                }
            }else{
                JOptionPane.showMessageDialog(null, "Username & Password Salah!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException yusuf){
            JOptionPane.showMessageDialog(null, "Error "+yusuf);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passFocusLost
        if(txt_pass.getText().equals("")){
            txt_pass.setText("");
            txt_pass.setForeground(new Color(183,183,183));
            lpassword.setVisible(true);
        }
    }//GEN-LAST:event_txt_passFocusLost

    private void txt_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passFocusGained
        lpassword.setVisible(false);
        if(txt_pass.getText().equals("")){
            txt_pass.setText("");
            txt_pass.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txt_passFocusGained

    private void txt_userFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_userFocusGained
        if(txt_user.getText().equals("Username")){
            txt_user.setText("");
            txt_user.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txt_userFocusGained

    private void txt_userFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_userFocusLost
        if(txt_user.getText().equals("")){
            txt_user.setText("Username");
            txt_user.setForeground(new Color(183,183,183));
        }
    }//GEN-LAST:event_txt_userFocusLost

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Rectangle;
    private javax.swing.JLabel borderPass;
    private javax.swing.JLabel borderUsr;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lpassword;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
