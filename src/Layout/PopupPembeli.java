package Layout;

import Data.connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
    @author llawl
 */
public class PopupPembeli extends javax.swing.JFrame {
    private DefaultTableModel tabmode;
    private static Connection conn = new connect().configDB();
    public Dashboard pem = null;
    public PopupPembeli() {
        initComponents();
        DataPem();
    }
    
    void DataPem(){
        Object [] Baris ={"No Client", "Nama Lengkap", "NIK", "No Telepon", 
            "Alamat", "Pekerjaan", "Status", "Tanggal"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtCari.getText();
        try{
            String SQL = "SELECT * FROM Client where Nama like'%"+Cari+"%' and Status='Pembeli' order by NIK asc";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2), 
                    Result.getString(3),
                    Result.getString(4), 
                    Result.getString(5),
                    Result.getString(6), 
                    Result.getString(7),
                    Result.getDate(8)
                });     
            }tPen.setModel(tabmode);
        }catch(SQLException yusuf){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil "+yusuf);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPen = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1060, 649));
        setSize(new java.awt.Dimension(1060, 649));
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(252, 252, 252));
        jPanel1.setPreferredSize(new java.awt.Dimension(1060, 694));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(37, 178, 99));
        jLabel1.setText("Tabel Data Penjual");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 44, -1, -1));
        jPanel1.add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 44, 220, 43));

        jButton1.setBackground(new java.awt.Color(37, 178, 99));
        jButton1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cari");
        jButton1.setBorder(null);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 44, 80, 43));

        jScrollPane1.setBackground(new java.awt.Color(37, 178, 99));
        jScrollPane1.setBorder(null);

        tPen.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tPen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tPen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tPenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tPen);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 870, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tPenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPenMouseClicked
        int row = tPen.getSelectedRow();
        pem.NamPem = tPen.getValueAt(row, 1).toString();
        pem.NikPem = tPen.getValueAt(row, 2).toString();
        pem.DataPemTerpilih();
        this.dispose();
    }//GEN-LAST:event_tPenMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupPembeli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tPen;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
