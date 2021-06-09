package Layout;
import Data.*;
import Data.connect;
import java.awt.Color;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/*
    @author llawl
 */
public class Dashboard extends javax.swing.JFrame {
    private static Connection conn = new connect().configDB();
    Date now = new Date();
    String NikPen = "", NamPen = "", NikPem = "", NamPem = "";
    private DefaultTableModel tabmode;
    public Dashboard() {
        initComponents();
        String username = Encrypt.getUsername();
        lprofile.setText(username);
        MenuDashboard();
    }
    
    void DataDK(){
        Object [] Baris ={"No Induk", "Nama Lengkap", "Email", "No Telepon", 
            "Alamat", "Tempat", "Tgl Lahir", "Agama", "Jabatan"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtCari_DK.getText();
        try{
            String SQL = "SELECT * FROM karyawan where NoInduk like '%"+Cari+"%' or Nama like'%"+Cari+"%' order by NoInduk asc";
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
                    Result.getDate(7),
                    Result.getString(8),
                    Result.getString(9)
                });     
            }tKaryawan.setModel(tabmode);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil " + e);
        }
    }
    
    void clearDK(){
        txtNi_DK.setText("");
        txtNama_DK.setText("");
        txtEmail_DK.setText("");
        txtAlamat_DK.setText("");
        txtNoTelp_DK.setText("");
        txtTempat_DK.setText("");
        txt_tgl_DK.setDate(now);
        cbAgama_DK.setSelectedIndex(0);
        txtJabatan_DK.setText("");
    }
    
    void DataDC(){
        Object [] Baris ={"No Client", "Nama Lengkap", "NIK", "No Telepon", 
            "Alamat", "Pekerjaan", "Status", "Tanggal"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtCari_DK.getText();
        try{
            String SQL = "SELECT * FROM client where NoClient like '%"+Cari+"%' or Nama like'%"+Cari+"%' order by NoClient asc";
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
            }tClient.setModel(tabmode);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil " + e);
        }
    }
    
    void ClearDC(){
        txtNC_DC.setText("");
        txtNama_DC.setText("");
        txtNik_DC.setText("");
        txtAlamat_DC.setText("");
        txtNoTelp_DC.setText("");
        txtPekerjaan_DC.setText("");
        txtTgl_DC.setDate(now);
        cbStatus_DC.setSelectedIndex(0);
    }
    
    void DataPenTerpilih(){
        PopupPenjual Ppen = new PopupPenjual();
        Ppen.pen = this;
        txtNampen_DD.setText(NamPen);
        txtNikPen_DD.setText(NikPen);
    }
    
    void DataPemTerpilih(){
        PopupPembeli Ppem = new PopupPembeli();
        Ppem.pem = this;
        txtNampem_DD.setText(NamPem);
        txtNikpem_DD.setText(NikPem);
    }
    
    void DataDD(){
        Object [] Baris ={"No Document", "Nama Penjual", "NIK Penjual", "Nama Pembeli", 
            "NIK Pembeli", "Tgl Lahir", "Luas Tanah", "Harga"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtCari_DK.getText();
        try{
            String SQL = "SELECT * FROM document where NoDocument like '%"+Cari+"%' or Nama_Penjual like'%"+Cari+"%' or Nama_Pembeli like'%"+Cari+"%' order by NoDocument asc";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2), 
                    Result.getString(3),
                    Result.getString(4), 
                    Result.getString(5),
                    Result.getDate(6),
                    Result.getInt(7),
                    Result.getLong(8)
                });     
            }tDocument.setModel(tabmode);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil " + e);
        }
    }
    
    void ClearDD(){
        txtNo_DD.setText("");
        txtNampen_DD.setText("");
        txtNikPen_DD.setText("");
        txtNampem_DD.setText("");
        txtNikpem_DD.setText("");
        txtTgl_DD.setDate(now);
        txtLuas_DD.setText(Integer.toString(0));
        txtHarga_DD.setText(Integer.toString(0));
    }
    
    void DataDS(){
        Object [] Baris ={"No Urut", "Nama Lengkap", "Letak Tanah", "Surat Ukur", "Luas Tanah"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtCari_DK.getText();
        try{
            String SQL = "SELECT * FROM sertifikat where NoUrut like '%"+Cari+"%' or Nama like'%"+Cari+"%' order by NoUrut asc";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2), 
                    Result.getString(3),
                    Result.getString(4), 
                    Result.getInt(5)
                });     
            }tSertif.setModel(tabmode);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil " + e);
        }
    }
    
    void ClearDS(){
        txtNo_DS.setText("");
        txtNama_DS.setText("");
        txtSurat_DS.setText("");
        txtLetak_DS.setText("");
        txtLuas_DS.setText(Integer.toString(0));
    }
    
    void DataDH(){
        Object [] Baris ={"Nomor", "Nama Lengkap", "Tanggal"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtCari_DK.getText();
        try{
            String SQL = "SELECT * FROM kunjungan where No like '%"+Cari+"%' or Nama like'%"+Cari+"%' order by No asc";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2), 
                    Result.getDate(3)
                });     
            }tDH.setModel(tabmode);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil " + e);
        }
    }
    
    void ClearDH(){
        txtNo_DH.setText("");
        txtNama_DH.setText("");
        jTgl_DH.setDate(now);
    }
    
    void DataLJA(){
        Object [] Baris ={"Nomor", "Akta Jual Beli", "Hibah", "APHB", 
            "APHT", "SKMHT", "Jumlah"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtCari_DK.getText();
        try{
            String SQL = "SELECT * FROM lja where No like '%"+Cari+"%' order by No asc";
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
                    Result.getInt(7)
                });     
            }tLJA.setModel(tabmode);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil " + e);
        }
    }
    
    void ClearLJA(){
        txtNo_LJA.setText("");
        txtAkta_LJA.setText("");
        txtHibah_LJA.setText("");
        txtAPHB_LJA.setText("");
        txtAPHT_LJA.setText("");
        txtSKMHT_LJA.setText("");
        txtJumlah_LJA.setText(Integer.toString(0));
    }
    
    void DataLB(){
        Object [] Baris ={"No Urut", "No AJB", "Tanggal", "BPH", "Nama Penjual", 
            "Nama Pembeli", "JNH", "Letak Tanah", "Luas Tanah", "Harga", "NOP", "NJOP",
            "SSP", "SSB"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtCari_DK.getText();
        try{
            String SQL = "SELECT * FROM lb where NoUrut like '%"+Cari+"%' order by NoUrut asc";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2), 
                    Result.getDate(3),
                    Result.getString(4), 
                    Result.getString(5),
                    Result.getString(6), 
                    Result.getString(7), 
                    Result.getString(8),
                    Result.getInt(9),
                    Result.getLong(10),
                    Result.getString(11), 
                    Result.getString(12),
                    Result.getString(13),
                    Result.getString(14)
                });     
            }tLB.setModel(tabmode);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil " + e);
        }
    }
    
    void ClearLB(){
        txtNo_LB.setText("");
        txtNoAJB_LB.setText("");
        jTgl_LB.setDate(now);
        txtBPH_LB.setText("");
        txtNamPen_LB.setText("");
        txtNamPem_LB.setText("");
        txtJNA_LB.setText("");
        txtLetak_LB.setText("");
        txtLuas_LB.setText("");
        txtHarga_LB.setText("");
        txtNJOP_LB.setText("");
        txtNOP_LB.setText("");
        txtSSP_LB.setText("");
        txtSSB_LB.setText("");
    }
        
    private final void MenuDashboard(){
        colorAble(RectDash);
        colorDisable(RectDK);
        colorDisable(RectDC);
        colorDisable(RectDS);
        colorDisable(RectDH);
        colorDisable(RectDD);
        colorDisable(RectLJA);
        colorDisable(RectLB);
        conDK.setVisible(false);    
        conDC.setVisible(false);    
        conDD.setVisible(false);
        conDS.setVisible(false);
        conDH.setVisible(false);
        conLJA.setVisible(false);
        conLB.setVisible(false);
        conDashboard.setVisible(true);    
    }
    
    private final void MenuDK(){
        colorAble(RectDK);
        colorDisable(RectDash);
        colorDisable(RectDC);
        colorDisable(RectDS);
        colorDisable(RectDH);
        colorDisable(RectDD);
        colorDisable(RectLJA);
        colorDisable(RectLB);
        conDK.setVisible(true); 
        conLJA.setVisible(false);
        conDD.setVisible(false);
        conDC.setVisible(false);    
        conDS.setVisible(false);
        conDH.setVisible(false);
        conLB.setVisible(false);
        conDashboard.setVisible(false);
        DataDK();
        clearDK();
    }
    
    void MenuDC(){
        colorAble(RectDC);
        colorDisable(RectDK);
        colorDisable(RectDash);
        colorDisable(RectDS);
        colorDisable(RectDH);
        colorDisable(RectDD);
        colorDisable(RectLJA);
        colorDisable(RectLB);
        conDC.setVisible(true);    
        conDH.setVisible(false);
        conDashboard.setVisible(false);
        conLJA.setVisible(false);
        conDK.setVisible(false);
        conDD.setVisible(false);
        conDS.setVisible(false);
        conLB.setVisible(false);
        DataDC();
        ClearDC();
    }
    
    void MenuDH(){
        colorAble(RectDH);
        colorDisable(RectDK);
        colorDisable(RectDC);
        colorDisable(RectDS);
        colorDisable(RectDash);
        colorDisable(RectDD);
        colorDisable(RectLJA);
        colorDisable(RectLB);
        conDashboard.setVisible(false);
        conLJA.setVisible(false);
        conDK.setVisible(false); 
        conDC.setVisible(false);
        conDD.setVisible(false);
        conDS.setVisible(false);
        conDH.setVisible(true);
        conLB.setVisible(false);
        DataDH();
        ClearDH();
    }
    
    void MenuDD(){
        colorAble(RectDD);
        colorDisable(RectDK);
        colorDisable(RectDC);
        colorDisable(RectDS);
        colorDisable(RectDH);
        colorDisable(RectDash);
        colorDisable(RectLJA);
        colorDisable(RectLB);
        conDashboard.setVisible(false);
        conDK.setVisible(false);
        conDC.setVisible(false);
        conLJA.setVisible(false);
        conDD.setVisible(true);
        conDH.setVisible(false);
        conDS.setVisible(false);
        conLB.setVisible(false);
        ClearDD();
        DataDD();
    }
    
    void MenuDS(){
        colorAble(RectDS);
        colorDisable(RectDK);
        colorDisable(RectDC);
        colorDisable(RectDash);
        colorDisable(RectDH);
        colorDisable(RectDD);
        colorDisable(RectLJA);
        colorDisable(RectLB);
        conDS.setVisible(true);
        conLJA.setVisible(false);
        conDashboard.setVisible(false);
        conDK.setVisible(false);
        conDC.setVisible(false);
        conDH.setVisible(false);
        conDD.setVisible(false);
        conLB.setVisible(false);
        DataDS();
        ClearDS();
    }
    
    void MenuLJA(){
        colorAble(RectLJA);
        colorDisable(RectDK);
        colorDisable(RectDC);
        colorDisable(RectDash);
        colorDisable(RectDH);
        colorDisable(RectDD);
        colorDisable(RectDS);
        colorDisable(RectLB);
        conDashboard.setVisible(false);
        conLJA.setVisible(true);
        conDS.setVisible(false);
        conDK.setVisible(false);
        conDC.setVisible(false);
        conDH.setVisible(false);
        conDD.setVisible(false);
        conLB.setVisible(false);
        DataLJA();
        ClearLJA();
    }
    
    void MenuLB(){
        colorAble(RectLB);
        colorDisable(RectDK);
        colorDisable(RectDC);
        colorDisable(RectDash);
        colorDisable(RectDH);
        colorDisable(RectDD);
        colorDisable(RectDS);
        colorDisable(RectLJA);
        conDashboard.setVisible(false);
        conLJA.setVisible(false);
        conDK.setVisible(false);
        conDS.setVisible(false);
        conDC.setVisible(false);
        conDD.setVisible(false);
        conLB.setVisible(true);
        DataLB();
        ClearLB();
    }
    
    public void colorAble(JPanel p){
        p.setBackground(new Color(54,207,121));
    }
    
    public void colorDisable(JPanel p){
        p.setBackground(new Color(37,178,99));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Parent = new javax.swing.JPanel();
        User = new javax.swing.JPanel();
        profile = new javax.swing.JLabel();
        lprofile = new javax.swing.JLabel();
        Sidebar = new javax.swing.JPanel();
        RectDH = new javax.swing.JPanel();
        lDKar2 = new javax.swing.JLabel();
        RectLB = new javax.swing.JPanel();
        lDKar6 = new javax.swing.JLabel();
        RectLJA = new javax.swing.JPanel();
        lDKar5 = new javax.swing.JLabel();
        RectDS = new javax.swing.JPanel();
        lDKar4 = new javax.swing.JLabel();
        RectDD = new javax.swing.JPanel();
        lDKar3 = new javax.swing.JLabel();
        RectDash = new javax.swing.JPanel();
        lDash = new javax.swing.JLabel();
        RectDK = new javax.swing.JPanel();
        lDKar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RectDC = new javax.swing.JPanel();
        lDKar1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Content = new javax.swing.JPanel();
        conLB = new javax.swing.JPanel();
        lnomerLB = new javax.swing.JLabel();
        txtNo_LB = new javax.swing.JTextField();
        borderNo_LB = new javax.swing.JLabel();
        txtNoAJB_LB = new javax.swing.JTextField();
        borderAJB_LB = new javax.swing.JLabel();
        lNoAJB_LB = new javax.swing.JLabel();
        lTgl_LB = new javax.swing.JLabel();
        borderNaPem_LB = new javax.swing.JLabel();
        lnomerNaPem_LB = new javax.swing.JLabel();
        txtNamPem_LB = new javax.swing.JTextField();
        lJNA_LB = new javax.swing.JLabel();
        borderJNA_LB = new javax.swing.JLabel();
        txtJNA_LB = new javax.swing.JTextField();
        lNOP_LB = new javax.swing.JLabel();
        borderNJOP_LB = new javax.swing.JLabel();
        txtNJOP_LB = new javax.swing.JTextField();
        lNJOP_LB = new javax.swing.JLabel();
        borderNOP_LB = new javax.swing.JLabel();
        txtNOP_LB = new javax.swing.JTextField();
        bSave_LB = new javax.swing.JButton();
        bUbah_LB = new javax.swing.JButton();
        bHapus_LB = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tLB = new javax.swing.JTable();
        lTabel_LB = new javax.swing.JLabel();
        bBatal_LB = new javax.swing.JButton();
        bCetak_LB = new javax.swing.JButton();
        txtCari_LB = new javax.swing.JTextField();
        borderCari_LB = new javax.swing.JLabel();
        bCari_LB = new javax.swing.JButton();
        borderNoAJB_LB = new javax.swing.JLabel();
        lBPH_LB = new javax.swing.JLabel();
        borderBPH_LB = new javax.swing.JLabel();
        lNamPen_LB = new javax.swing.JLabel();
        borderNamPen_LB = new javax.swing.JLabel();
        txtBPH_LB = new javax.swing.JTextField();
        txtNamPen_LB = new javax.swing.JTextField();
        borderLetak_LB = new javax.swing.JLabel();
        lLetak_LB = new javax.swing.JLabel();
        lLuas_LB = new javax.swing.JLabel();
        borderLuas_LB = new javax.swing.JLabel();
        lHarga_LB = new javax.swing.JLabel();
        borderHarga_LB = new javax.swing.JLabel();
        borderSSB_LB = new javax.swing.JLabel();
        lSSB_LB = new javax.swing.JLabel();
        borderSSP_LB = new javax.swing.JLabel();
        lSSP_LB = new javax.swing.JLabel();
        txtHarga_LB = new javax.swing.JTextField();
        txtLuas_LB = new javax.swing.JTextField();
        txtLetak_LB = new javax.swing.JTextField();
        txtSSB_LB = new javax.swing.JTextField();
        txtSSP_LB = new javax.swing.JTextField();
        jTgl_LB = new com.toedter.calendar.JDateChooser();
        conDH = new javax.swing.JPanel();
        lnomer_DH = new javax.swing.JLabel();
        txtNo_DH = new javax.swing.JTextField();
        borderNo_DH = new javax.swing.JLabel();
        borderNama_DH = new javax.swing.JLabel();
        lnomerNama_DH = new javax.swing.JLabel();
        txtNama_DH = new javax.swing.JTextField();
        lTgl_DH = new javax.swing.JLabel();
        jTgl_DH = new com.toedter.calendar.JDateChooser();
        bSave_DH = new javax.swing.JButton();
        bUbah_DH = new javax.swing.JButton();
        bHapus_DH = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tDH = new javax.swing.JTable();
        lTabel_DH = new javax.swing.JLabel();
        bBatal_DH = new javax.swing.JButton();
        bCetak_DH = new javax.swing.JButton();
        txtCari_DH = new javax.swing.JTextField();
        borderCari_DH = new javax.swing.JLabel();
        bCari_DH = new javax.swing.JButton();
        conLJA = new javax.swing.JPanel();
        lnomer_LJA = new javax.swing.JLabel();
        txtNo_LJA = new javax.swing.JTextField();
        borderNo_LJA = new javax.swing.JLabel();
        txtAkta_LJA = new javax.swing.JTextField();
        borderAkta_LJA = new javax.swing.JLabel();
        lAkta_LJA = new javax.swing.JLabel();
        lHibah_LJA = new javax.swing.JLabel();
        borderHibah_LJA = new javax.swing.JLabel();
        txtHibah_LJA = new javax.swing.JTextField();
        borderAPHB_LJA = new javax.swing.JLabel();
        lnomerAPHB_LJA = new javax.swing.JLabel();
        txtAPHB_LJA = new javax.swing.JTextField();
        lAPHT_LJA = new javax.swing.JLabel();
        borderAPHT_LJA = new javax.swing.JLabel();
        txtAPHT_LJA = new javax.swing.JTextField();
        lSKMHT_LJA = new javax.swing.JLabel();
        borderSKMHT_LJA = new javax.swing.JLabel();
        txtSKMHT_LJA = new javax.swing.JTextField();
        lJumlah_LJA = new javax.swing.JLabel();
        borderJumlah_LJA = new javax.swing.JLabel();
        txtJumlah_LJA = new javax.swing.JTextField();
        bSave_LJA = new javax.swing.JButton();
        bUbah_LJA = new javax.swing.JButton();
        bHapus_LJA = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tLJA = new javax.swing.JTable();
        lTabel_LJA = new javax.swing.JLabel();
        bBatal_LJA = new javax.swing.JButton();
        bCetak_LJA = new javax.swing.JButton();
        txtCari_LJA = new javax.swing.JTextField();
        borderCari_LJA = new javax.swing.JLabel();
        bCari_LJA = new javax.swing.JButton();
        conDS = new javax.swing.JPanel();
        lnomerUrut_DS = new javax.swing.JLabel();
        borderNo_DS = new javax.swing.JLabel();
        txtNo_DS = new javax.swing.JTextField();
        lnama_DS = new javax.swing.JLabel();
        borderNama_DS = new javax.swing.JLabel();
        txtNama_DS = new javax.swing.JTextField();
        lLetak_DS = new javax.swing.JLabel();
        borderLetak_DS = new javax.swing.JLabel();
        lSurat_DS = new javax.swing.JLabel();
        borderSurat_DS = new javax.swing.JLabel();
        lLuas_DS = new javax.swing.JLabel();
        borderLuas_DS = new javax.swing.JLabel();
        bSave_DS = new javax.swing.JButton();
        bUbah_DS = new javax.swing.JButton();
        bHapus_DS = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tSertif = new javax.swing.JTable();
        lTabel_DS = new javax.swing.JLabel();
        bBatal_DS = new javax.swing.JButton();
        bCetak_DS = new javax.swing.JButton();
        txtCari_DS = new javax.swing.JTextField();
        borderCari_DS = new javax.swing.JLabel();
        bCari_DS = new javax.swing.JButton();
        txtLetak_DS = new javax.swing.JTextField();
        txtSurat_DS = new javax.swing.JTextField();
        txtLuas_DS = new javax.swing.JTextField();
        conDD = new javax.swing.JPanel();
        lnomerDocument = new javax.swing.JLabel();
        txtNo_DD = new javax.swing.JTextField();
        borderNo_DD = new javax.swing.JLabel();
        txtNampen_DD = new javax.swing.JTextField();
        borderNampen_DD = new javax.swing.JLabel();
        lnampen_DD = new javax.swing.JLabel();
        lnikPen_DD = new javax.swing.JLabel();
        bordernikPen_DD = new javax.swing.JLabel();
        txtNikPen_DD = new javax.swing.JTextField();
        borderNamPem_DD = new javax.swing.JLabel();
        lnamPem_DD = new javax.swing.JLabel();
        txtNampem_DD = new javax.swing.JTextField();
        lnikPem_DD = new javax.swing.JLabel();
        borderNikpem_DD = new javax.swing.JLabel();
        txtNikpem_DD = new javax.swing.JTextField();
        lTgl1 = new javax.swing.JLabel();
        txtTgl_DD = new com.toedter.calendar.JDateChooser();
        lLuas_DD = new javax.swing.JLabel();
        borderLuas_DD = new javax.swing.JLabel();
        txtLuas_DD = new javax.swing.JTextField();
        lHarga_DD = new javax.swing.JLabel();
        borderHarga_DD = new javax.swing.JLabel();
        txtHarga_DD = new javax.swing.JTextField();
        txtCari_DD = new javax.swing.JTextField();
        borderCari_DD = new javax.swing.JLabel();
        bCari_DD = new javax.swing.JButton();
        bSave_DD = new javax.swing.JButton();
        bUbah_DD = new javax.swing.JButton();
        bHapus_DD = new javax.swing.JButton();
        lTabel_DD = new javax.swing.JLabel();
        bBatal_DD = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tDocument = new javax.swing.JTable();
        bCetak_DD = new javax.swing.JButton();
        bCariNampen_DD = new javax.swing.JButton();
        bCariNampem_DD = new javax.swing.JButton();
        conDC = new javax.swing.JPanel();
        lnomerclient = new javax.swing.JLabel();
        txtNC_DC = new javax.swing.JTextField();
        borderNo_DC = new javax.swing.JLabel();
        txtNama_DC = new javax.swing.JTextField();
        borderNama_DC = new javax.swing.JLabel();
        lnama_DC = new javax.swing.JLabel();
        lnik_DC = new javax.swing.JLabel();
        bordernik_DC = new javax.swing.JLabel();
        txtNik_DC = new javax.swing.JTextField();
        borderNoTelp_DC = new javax.swing.JLabel();
        lnomertelp_DC = new javax.swing.JLabel();
        txtNoTelp_DC = new javax.swing.JTextField();
        lalamat_DC = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAlamat_DC = new javax.swing.JTextArea();
        borderAlamat_DC = new javax.swing.JLabel();
        lpekerjaan_DC = new javax.swing.JLabel();
        txtTgl_DC = new com.toedter.calendar.JDateChooser();
        cbStatus_DC = new javax.swing.JComboBox<>();
        borderStatus = new javax.swing.JLabel();
        lStatus_DC = new javax.swing.JLabel();
        lTgl = new javax.swing.JLabel();
        borderPekerjaan_DC = new javax.swing.JLabel();
        txtPekerjaan_DC = new javax.swing.JTextField();
        bSave_DC = new javax.swing.JButton();
        bUbah_DC = new javax.swing.JButton();
        bHapus_DC = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tClient = new javax.swing.JTable();
        lTabel_DC = new javax.swing.JLabel();
        bBatal_DC = new javax.swing.JButton();
        bCetak_DC = new javax.swing.JButton();
        txtCari_DC = new javax.swing.JTextField();
        borderCari_DC = new javax.swing.JLabel();
        bCari_DC = new javax.swing.JButton();
        conDK = new javax.swing.JPanel();
        lnomerinduk = new javax.swing.JLabel();
        txtNi_DK = new javax.swing.JTextField();
        borderNo = new javax.swing.JLabel();
        txtNama_DK = new javax.swing.JTextField();
        borderNama = new javax.swing.JLabel();
        lnama = new javax.swing.JLabel();
        lemail = new javax.swing.JLabel();
        borderEmail = new javax.swing.JLabel();
        txtEmail_DK = new javax.swing.JTextField();
        borderNoTelp = new javax.swing.JLabel();
        lnomertelp = new javax.swing.JLabel();
        txtNoTelp_DK = new javax.swing.JTextField();
        lalamat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat_DK = new javax.swing.JTextArea();
        borderAlamat = new javax.swing.JLabel();
        ltempat = new javax.swing.JLabel();
        txtTempat_DK = new javax.swing.JTextField();
        borderTempat = new javax.swing.JLabel();
        txt_tgl_DK = new com.toedter.calendar.JDateChooser();
        ltanggal = new javax.swing.JLabel();
        cbAgama_DK = new javax.swing.JComboBox<>();
        borderAgama = new javax.swing.JLabel();
        lAgama = new javax.swing.JLabel();
        ljabatan = new javax.swing.JLabel();
        borderJabatan = new javax.swing.JLabel();
        txtJabatan_DK = new javax.swing.JTextField();
        bSave_DK = new javax.swing.JButton();
        bUbah_DK = new javax.swing.JButton();
        bHapus_DK = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tKaryawan = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        bBatal_DK = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtCari_DK = new javax.swing.JTextField();
        borderCari = new javax.swing.JLabel();
        bCari_DK = new javax.swing.JButton();
        conDashboard = new javax.swing.JPanel();
        lKunjungan = new javax.swing.JLabel();
        LClient = new javax.swing.JLabel();
        lkunjungan = new javax.swing.JLabel();
        lclient = new javax.swing.JLabel();
        jmlKaryawan = new javax.swing.JLabel();
        lkaryawan = new javax.swing.JLabel();
        lkaryawan1 = new javax.swing.JLabel();
        Karyawan1 = new javax.swing.JLabel();
        RectKaryawan = new javax.swing.JLabel();
        RectKunjungan = new javax.swing.JLabel();
        RectSertifikat = new javax.swing.JLabel();
        RectSertifikat1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Parent.setBackground(new java.awt.Color(252, 252, 252));
        Parent.setPreferredSize(new java.awt.Dimension(1366, 768));
        Parent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        User.setBackground(new java.awt.Color(255, 255, 255));
        User.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/profile.png"))); // NOI18N
        User.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(977, 12, -1, -1));

        lprofile.setFont(new java.awt.Font("Roboto", 0, 25)); // NOI18N
        lprofile.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lprofile.setText("Vena Grasheela Septiani");
        User.add(lprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 23, 310, -1));

        Parent.add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 0, 1060, 74));
        User.getAccessibleContext().setAccessibleParent(Parent);

        Sidebar.setBackground(new java.awt.Color(37, 178, 99));
        Sidebar.setPreferredSize(new java.awt.Dimension(307, 768));
        Sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RectDH.setBackground(new java.awt.Color(37, 178, 99));
        RectDH.setForeground(new java.awt.Color(54, 207, 121));
        RectDH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RectDHMouseClicked(evt);
            }
        });
        RectDH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lDKar2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lDKar2.setForeground(new java.awt.Color(255, 255, 255));
        lDKar2.setText("Data Kunjungan");
        RectDH.add(lDKar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 23, -1, -1));

        Sidebar.add(RectDH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 306, 307, 72));

        RectLB.setBackground(new java.awt.Color(37, 178, 99));
        RectLB.setForeground(new java.awt.Color(54, 207, 121));
        RectLB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RectLBMouseClicked(evt);
            }
        });
        RectLB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lDKar6.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lDKar6.setForeground(new java.awt.Color(255, 255, 255));
        lDKar6.setText("Laporan Bulanan");
        RectLB.add(lDKar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 23, -1, -1));

        Sidebar.add(RectLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 588, 307, 72));

        RectLJA.setBackground(new java.awt.Color(37, 178, 99));
        RectLJA.setForeground(new java.awt.Color(54, 207, 121));
        RectLJA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RectLJAMouseClicked(evt);
            }
        });
        RectLJA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lDKar5.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lDKar5.setForeground(new java.awt.Color(255, 255, 255));
        lDKar5.setText("Laporan Jenis Akta");
        RectLJA.add(lDKar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 23, -1, -1));

        Sidebar.add(RectLJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 517, 307, 72));

        RectDS.setBackground(new java.awt.Color(37, 178, 99));
        RectDS.setForeground(new java.awt.Color(54, 207, 121));
        RectDS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RectDSMouseClicked(evt);
            }
        });
        RectDS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lDKar4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lDKar4.setForeground(new java.awt.Color(255, 255, 255));
        lDKar4.setText("Data Sertifikat");
        RectDS.add(lDKar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 23, -1, -1));

        Sidebar.add(RectDS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 445, 307, 72));

        RectDD.setBackground(new java.awt.Color(37, 178, 99));
        RectDD.setForeground(new java.awt.Color(54, 207, 121));
        RectDD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RectDDMouseClicked(evt);
            }
        });
        RectDD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lDKar3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lDKar3.setForeground(new java.awt.Color(255, 255, 255));
        lDKar3.setText("Data Dokumen");
        RectDD.add(lDKar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 23, -1, -1));

        Sidebar.add(RectDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 375, 307, 72));

        RectDash.setBackground(new java.awt.Color(54, 207, 121));
        RectDash.setForeground(new java.awt.Color(54, 207, 121));
        RectDash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RectDashMouseClicked(evt);
            }
        });
        RectDash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lDash.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lDash.setForeground(new java.awt.Color(255, 255, 255));
        lDash.setText("Dashboard");
        RectDash.add(lDash, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 23, -1, -1));

        Sidebar.add(RectDash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 94, 307, 72));

        RectDK.setBackground(new java.awt.Color(37, 178, 99));
        RectDK.setForeground(new java.awt.Color(54, 207, 121));
        RectDK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RectDKMouseClicked(evt);
            }
        });
        RectDK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lDKar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lDKar.setForeground(new java.awt.Color(255, 255, 255));
        lDKar.setText("Data Karyawan");
        RectDK.add(lDKar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 23, -1, -1));

        Sidebar.add(RectDK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 165, 307, 72));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SISAD");
        Sidebar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 19, -1, -1));

        RectDC.setBackground(new java.awt.Color(37, 178, 99));
        RectDC.setForeground(new java.awt.Color(54, 207, 121));
        RectDC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RectDCMouseClicked(evt);
            }
        });
        RectDC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lDKar1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lDKar1.setForeground(new java.awt.Color(255, 255, 255));
        lDKar1.setText("Data Klien");
        RectDC.add(lDKar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 23, -1, -1));

        Sidebar.add(RectDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 235, 307, 72));

        jButton1.setBackground(new java.awt.Color(54, 207, 121));
        jButton1.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jButton1.setText("Logout");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Sidebar.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 670, 210, 60));

        Parent.add(Sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 307, -1));

        Content.setBackground(new java.awt.Color(252, 252, 252));
        Content.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        conLB.setBackground(new java.awt.Color(252, 252, 252));
        conLB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lnomerLB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lnomerLB.setText("No Urut");
        conLB.add(lnomerLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 24, -1, -1));

        txtNo_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNo_LB.setBorder(null);
        conLB.add(txtNo_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 44, 236, 30));

        borderNo_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderNo_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 43, -1, -1));

        txtNoAJB_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNoAJB_LB.setBorder(null);
        conLB.add(txtNoAJB_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 112, 236, 29));

        borderAJB_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderAJB_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        lNoAJB_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lNoAJB_LB.setText("No AJB");
        conLB.add(lNoAJB_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 86, -1, -1));

        lTgl_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lTgl_LB.setText("Tanggal");
        conLB.add(lTgl_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 152, -1, -1));

        borderNaPem_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderNaPem_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderNaPem_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 43, -1, -1));

        lnomerNaPem_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lnomerNaPem_LB.setText("Nama Pembeli");
        conLB.add(lnomerNaPem_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 24, -1, -1));

        txtNamPem_LB.setBorder(null);
        conLB.add(txtNamPem_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 44, 236, 30));

        lJNA_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lJNA_LB.setText("Jenis dan No Hak");
        conLB.add(lJNA_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 86, -1, -1));

        borderJNA_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderJNA_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 110, -1, -1));

        txtJNA_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtJNA_LB.setBorder(null);
        conLB.add(txtJNA_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 112, 236, 30));

        lNOP_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lNOP_LB.setText("NOP Tahun");
        conLB.add(lNOP_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 24, -1, -1));

        borderNJOP_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderNJOP_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, -1, -1));

        txtNJOP_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNJOP_LB.setBorder(null);
        conLB.add(txtNJOP_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 112, 236, 30));

        lNJOP_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lNJOP_LB.setText("NJOP ");
        conLB.add(lNJOP_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 86, -1, -1));

        borderNOP_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderNOP_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderNOP_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 43, -1, -1));

        txtNOP_LB.setBorder(null);
        conLB.add(txtNOP_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 44, 236, 30));

        bSave_LB.setBackground(new java.awt.Color(8, 72, 135));
        bSave_LB.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bSave_LB.setForeground(new java.awt.Color(255, 255, 255));
        bSave_LB.setText("Simpan");
        bSave_LB.setBorder(null);
        bSave_LB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSave_LBActionPerformed(evt);
            }
        });
        conLB.add(bSave_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 375, 195, 30));

        bUbah_LB.setBackground(new java.awt.Color(255, 149, 5));
        bUbah_LB.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bUbah_LB.setForeground(new java.awt.Color(255, 255, 255));
        bUbah_LB.setText("Ubah");
        bUbah_LB.setBorder(null);
        bUbah_LB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbah_LBActionPerformed(evt);
            }
        });
        conLB.add(bUbah_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 375, 195, 30));

        bHapus_LB.setBackground(new java.awt.Color(248, 51, 60));
        bHapus_LB.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bHapus_LB.setForeground(new java.awt.Color(255, 255, 255));
        bHapus_LB.setText("Hapus");
        bHapus_LB.setBorder(null);
        bHapus_LB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapus_LBActionPerformed(evt);
            }
        });
        conLB.add(bHapus_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 375, 195, 30));

        tLB.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tLB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tLBMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tLB);

        conLB.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 919, 130));

        lTabel_LB.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lTabel_LB.setText("Tabel Laporan Bulanan");
        conLB.add(lTabel_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, -1, -1));

        bBatal_LB.setBackground(new java.awt.Color(232, 241, 242));
        bBatal_LB.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bBatal_LB.setText("Batal");
        bBatal_LB.setBorder(null);
        bBatal_LB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatal_LBActionPerformed(evt);
            }
        });
        conLB.add(bBatal_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 375, 195, 30));

        bCetak_LB.setBackground(new java.awt.Color(37, 178, 99));
        bCetak_LB.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        bCetak_LB.setForeground(new java.awt.Color(255, 255, 255));
        bCetak_LB.setText("Cetak Laporan Data Karyawan");
        bCetak_LB.setBorder(null);
        conLB.add(bCetak_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 620, 270, 26));

        txtCari_LB.setBorder(null);
        conLB.add(txtCari_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 431, 231, 30));

        borderCari_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderCari_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 430, -1, -1));

        bCari_LB.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        bCari_LB.setText("Cari");
        bCari_LB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCari_LBActionPerformed(evt);
            }
        });
        conLB.add(bCari_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 430, 68, 30));

        borderNoAJB_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderNoAJB_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        lBPH_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lBPH_LB.setText("Bentuk Perbuatan Hukum");
        conLB.add(lBPH_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 221, -1, -1));

        borderBPH_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderBPH_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderBPH_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 247, -1, -1));

        lNamPen_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lNamPen_LB.setText("Nama Penjual");
        conLB.add(lNamPen_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        borderNamPen_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderNamPen_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderNamPen_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 316, -1, -1));

        txtBPH_LB.setBorder(null);
        conLB.add(txtBPH_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 249, 236, 30));

        txtNamPen_LB.setBorder(null);
        conLB.add(txtNamPen_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 318, 236, 30));

        borderLetak_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderLetak_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderLetak_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 178, -1, -1));

        lLetak_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lLetak_LB.setText("Letak Tanah");
        conLB.add(lLetak_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 152, -1, -1));

        lLuas_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lLuas_LB.setText("Luas Tanah");
        conLB.add(lLuas_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 221, -1, -1));

        borderLuas_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderLuas_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderLuas_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 247, -1, -1));

        lHarga_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lHarga_LB.setText("Harga Transaksi");
        conLB.add(lHarga_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 290, -1, -1));

        borderHarga_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderHarga_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderHarga_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 316, -1, -1));

        borderSSB_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderSSB_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderSSB_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 247, -1, -1));

        lSSB_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lSSB_LB.setText("SSB");
        conLB.add(lSSB_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 221, -1, -1));

        borderSSP_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderSSP_LB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 14.png"))); // NOI18N
        conLB.add(borderSSP_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 178, -1, -1));

        lSSP_LB.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lSSP_LB.setText("SSP");
        conLB.add(lSSP_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 152, -1, -1));

        txtHarga_LB.setBorder(null);
        conLB.add(txtHarga_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 318, 236, 30));

        txtLuas_LB.setBorder(null);
        conLB.add(txtLuas_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 249, 236, 30));

        txtLetak_LB.setBorder(null);
        conLB.add(txtLetak_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 180, 236, 30));

        txtSSB_LB.setBorder(null);
        conLB.add(txtSSB_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 249, 236, 30));

        txtSSP_LB.setBorder(null);
        conLB.add(txtSSP_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 236, 30));
        conLB.add(jTgl_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 255, 32));

        Content.add(conLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 694));

        conDH.setBackground(new java.awt.Color(252, 252, 252));
        conDH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lnomer_DH.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        lnomer_DH.setText("No Hadir");
        conDH.add(lnomer_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 46, -1, -1));

        txtNo_DH.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNo_DH.setBorder(null);
        conDH.add(txtNo_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 81, 236, 46));

        borderNo_DH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 3.png"))); // NOI18N
        conDH.add(borderNo_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 78, -1, -1));

        borderNama_DH.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderNama_DH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 3.png"))); // NOI18N
        conDH.add(borderNama_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 78, -1, -1));

        lnomerNama_DH.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        lnomerNama_DH.setText("Nama Lengkap");
        conDH.add(lnomerNama_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 46, -1, -1));

        txtNama_DH.setBorder(null);
        conDH.add(txtNama_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 81, 236, 46));

        lTgl_DH.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        lTgl_DH.setText("Tanggal");
        conDH.add(lTgl_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 46, -1, -1));
        conDH.add(jTgl_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 255, 52));

        bSave_DH.setBackground(new java.awt.Color(8, 72, 135));
        bSave_DH.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        bSave_DH.setForeground(new java.awt.Color(255, 255, 255));
        bSave_DH.setText("Simpan");
        bSave_DH.setBorder(null);
        bSave_DH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSave_DHActionPerformed(evt);
            }
        });
        conDH.add(bSave_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 195, 50));

        bUbah_DH.setBackground(new java.awt.Color(255, 149, 5));
        bUbah_DH.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        bUbah_DH.setForeground(new java.awt.Color(255, 255, 255));
        bUbah_DH.setText("Ubah");
        bUbah_DH.setBorder(null);
        bUbah_DH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbah_DHActionPerformed(evt);
            }
        });
        conDH.add(bUbah_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 190, 195, 50));

        bHapus_DH.setBackground(new java.awt.Color(248, 51, 60));
        bHapus_DH.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        bHapus_DH.setForeground(new java.awt.Color(255, 255, 255));
        bHapus_DH.setText("Hapus");
        bHapus_DH.setBorder(null);
        bHapus_DH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapus_DHActionPerformed(evt);
            }
        });
        conDH.add(bHapus_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 190, 195, 50));

        tDH.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tDH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tDHMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tDH);

        conDH.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 919, 190));

        lTabel_DH.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        lTabel_DH.setText("Tabel Data Kunjungan");
        conDH.add(lTabel_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 296, -1, -1));

        bBatal_DH.setBackground(new java.awt.Color(232, 241, 242));
        bBatal_DH.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        bBatal_DH.setText("Batal");
        bBatal_DH.setBorder(null);
        bBatal_DH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatal_DHActionPerformed(evt);
            }
        });
        conDH.add(bBatal_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 190, 195, 50));

        bCetak_DH.setBackground(new java.awt.Color(37, 178, 99));
        bCetak_DH.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        bCetak_DH.setForeground(new java.awt.Color(255, 255, 255));
        bCetak_DH.setText("Cetak Laporan Data Karyawan");
        bCetak_DH.setBorder(null);
        conDH.add(bCetak_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 610, 289, 54));

        txtCari_DH.setBorder(null);
        conDH.add(txtCari_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 298, 231, 48));

        borderCari_DH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TF 3.png"))); // NOI18N
        conDH.add(borderCari_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 296, -1, -1));

        bCari_DH.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        bCari_DH.setText("Cari");
        bCari_DH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCari_DHActionPerformed(evt);
            }
        });
        conDH.add(bCari_DH, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 296, 100, 43));

        Content.add(conDH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 694));

        conLJA.setBackground(new java.awt.Color(252, 252, 252));
        conLJA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lnomer_LJA.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnomer_LJA.setText("Nomor");
        conLJA.add(lnomer_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 46, -1, -1));

        txtNo_LJA.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNo_LJA.setBorder(null);
        conLJA.add(txtNo_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 236, 34));

        borderNo_LJA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conLJA.add(borderNo_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 78, -1, -1));

        txtAkta_LJA.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAkta_LJA.setBorder(null);
        conLJA.add(txtAkta_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 161, 236, 34));

        borderAkta_LJA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conLJA.add(borderAkta_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 159, -1, -1));

        lAkta_LJA.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lAkta_LJA.setText("Akta Jual Beli");
        conLJA.add(lAkta_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 127, -1, -1));

        lHibah_LJA.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lHibah_LJA.setText("Hibah");
        conLJA.add(lHibah_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 208, -1, -1));

        borderHibah_LJA.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderHibah_LJA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conLJA.add(borderHibah_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 239, -1, -1));

        txtHibah_LJA.setBorder(null);
        conLJA.add(txtHibah_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 241, 236, 34));

        borderAPHB_LJA.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderAPHB_LJA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conLJA.add(borderAPHB_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 78, -1, -1));

        lnomerAPHB_LJA.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnomerAPHB_LJA.setText("APHB");
        conLJA.add(lnomerAPHB_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 46, -1, -1));

        txtAPHB_LJA.setBorder(null);
        conLJA.add(txtAPHB_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 80, 236, 34));

        lAPHT_LJA.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lAPHT_LJA.setText("APHT");
        conLJA.add(lAPHT_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 127, -1, -1));

        borderAPHT_LJA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conLJA.add(borderAPHT_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 159, -1, -1));

        txtAPHT_LJA.setBorder(null);
        conLJA.add(txtAPHT_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 161, 236, 34));

        lSKMHT_LJA.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lSKMHT_LJA.setText("SKMHT");
        conLJA.add(lSKMHT_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 208, -1, -1));

        borderSKMHT_LJA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conLJA.add(borderSKMHT_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 239, -1, -1));

        txtSKMHT_LJA.setBorder(null);
        conLJA.add(txtSKMHT_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 241, 236, 34));

        lJumlah_LJA.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lJumlah_LJA.setText("Jumlah");
        conLJA.add(lJumlah_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 46, -1, -1));

        borderJumlah_LJA.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderJumlah_LJA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conLJA.add(borderJumlah_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 78, -1, -1));

        txtJumlah_LJA.setBorder(null);
        conLJA.add(txtJumlah_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 236, 34));

        bSave_LJA.setBackground(new java.awt.Color(8, 72, 135));
        bSave_LJA.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bSave_LJA.setForeground(new java.awt.Color(255, 255, 255));
        bSave_LJA.setText("Simpan");
        bSave_LJA.setBorder(null);
        bSave_LJA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSave_LJAActionPerformed(evt);
            }
        });
        conLJA.add(bSave_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 303, 195, 39));

        bUbah_LJA.setBackground(new java.awt.Color(255, 149, 5));
        bUbah_LJA.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bUbah_LJA.setForeground(new java.awt.Color(255, 255, 255));
        bUbah_LJA.setText("Ubah");
        bUbah_LJA.setBorder(null);
        bUbah_LJA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbah_LJAActionPerformed(evt);
            }
        });
        conLJA.add(bUbah_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 303, 195, 39));

        bHapus_LJA.setBackground(new java.awt.Color(248, 51, 60));
        bHapus_LJA.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bHapus_LJA.setForeground(new java.awt.Color(255, 255, 255));
        bHapus_LJA.setText("Hapus");
        bHapus_LJA.setBorder(null);
        bHapus_LJA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapus_LJAActionPerformed(evt);
            }
        });
        conLJA.add(bHapus_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 303, 195, 39));

        tLJA.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tLJA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tLJAMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tLJA);

        conLJA.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 919, 170));

        lTabel_LJA.setFont(new java.awt.Font("Roboto", 0, 29)); // NOI18N
        lTabel_LJA.setText("Tabel Laporan Jenis Akta");
        conLJA.add(lTabel_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 377, -1, -1));

        bBatal_LJA.setBackground(new java.awt.Color(232, 241, 242));
        bBatal_LJA.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bBatal_LJA.setText("Batal");
        bBatal_LJA.setBorder(null);
        bBatal_LJA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatal_LJAActionPerformed(evt);
            }
        });
        conLJA.add(bBatal_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 303, 195, 39));

        bCetak_LJA.setBackground(new java.awt.Color(37, 178, 99));
        bCetak_LJA.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        bCetak_LJA.setForeground(new java.awt.Color(255, 255, 255));
        bCetak_LJA.setText("Cetak Laporan Data Karyawan");
        bCetak_LJA.setBorder(null);
        conLJA.add(bCetak_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 618, 289, 49));

        txtCari_LJA.setBorder(null);
        conLJA.add(txtCari_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 376, 231, 40));

        borderCari_LJA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/txtCari.png"))); // NOI18N
        conLJA.add(borderCari_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 375, -1, -1));

        bCari_LJA.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        bCari_LJA.setText("Cari");
        bCari_LJA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCari_LJAActionPerformed(evt);
            }
        });
        conLJA.add(bCari_LJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 375, 68, 43));

        Content.add(conLJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 694));

        conDS.setBackground(new java.awt.Color(252, 252, 252));
        conDS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lnomerUrut_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnomerUrut_DS.setText("No Urut");
        conDS.add(lnomerUrut_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 46, -1, -1));

        borderNo_DS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mini textfield.png"))); // NOI18N
        conDS.add(borderNo_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 87, -1, -1));

        txtNo_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtNo_DS.setBorder(null);
        conDS.add(txtNo_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 235, 42));

        lnama_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnama_DS.setText("Nama Lengkap");
        conDS.add(lnama_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 151, -1, -1));

        borderNama_DS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mini textfield.png"))); // NOI18N
        conDS.add(borderNama_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        txtNama_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtNama_DS.setBorder(null);
        conDS.add(txtNama_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 192, 235, 42));

        lLetak_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lLetak_DS.setText("Letak Tanah");
        conDS.add(lLetak_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 46, -1, -1));

        borderLetak_DS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mini textfield.png"))); // NOI18N
        conDS.add(borderLetak_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 87, -1, -1));

        lSurat_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lSurat_DS.setText("Surat Ukur");
        conDS.add(lSurat_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 151, -1, -1));

        borderSurat_DS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mini textfield.png"))); // NOI18N
        conDS.add(borderSurat_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 190, -1, -1));

        lLuas_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lLuas_DS.setText("Luas Tanah");
        conDS.add(lLuas_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 46, -1, -1));

        borderLuas_DS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mini textfield.png"))); // NOI18N
        conDS.add(borderLuas_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 87, -1, -1));

        bSave_DS.setBackground(new java.awt.Color(8, 72, 135));
        bSave_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bSave_DS.setForeground(new java.awt.Color(255, 255, 255));
        bSave_DS.setText("Simpan");
        bSave_DS.setBorder(null);
        bSave_DS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSave_DSActionPerformed(evt);
            }
        });
        conDS.add(bSave_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 279, 195, 42));

        bUbah_DS.setBackground(new java.awt.Color(255, 149, 5));
        bUbah_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bUbah_DS.setForeground(new java.awt.Color(255, 255, 255));
        bUbah_DS.setText("Ubah");
        bUbah_DS.setBorder(null);
        bUbah_DS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbah_DSActionPerformed(evt);
            }
        });
        conDS.add(bUbah_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 279, 195, 42));

        bHapus_DS.setBackground(new java.awt.Color(248, 51, 60));
        bHapus_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bHapus_DS.setForeground(new java.awt.Color(255, 255, 255));
        bHapus_DS.setText("Hapus");
        bHapus_DS.setBorder(null);
        bHapus_DS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapus_DSActionPerformed(evt);
            }
        });
        conDS.add(bHapus_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 279, 195, 42));

        tSertif.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tSertif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tSertifMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tSertif);

        conDS.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 919, 170));

        lTabel_DS.setFont(new java.awt.Font("Roboto", 0, 29)); // NOI18N
        lTabel_DS.setText("Tabel Data Sertifikat");
        conDS.add(lTabel_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 367, -1, -1));

        bBatal_DS.setBackground(new java.awt.Color(232, 241, 242));
        bBatal_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bBatal_DS.setText("Batal");
        bBatal_DS.setBorder(null);
        bBatal_DS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatal_DSActionPerformed(evt);
            }
        });
        conDS.add(bBatal_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 279, 195, 42));

        bCetak_DS.setBackground(new java.awt.Color(37, 178, 99));
        bCetak_DS.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        bCetak_DS.setForeground(new java.awt.Color(255, 255, 255));
        bCetak_DS.setText("Cetak Laporan Data Karyawan");
        bCetak_DS.setBorder(null);
        conDS.add(bCetak_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 618, 289, 49));

        txtCari_DS.setBorder(null);
        conDS.add(txtCari_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 369, 231, 38));

        borderCari_DS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/txtCari.png"))); // NOI18N
        conDS.add(borderCari_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 367, -1, -1));

        bCari_DS.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        bCari_DS.setText("Cari");
        bCari_DS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCari_DSActionPerformed(evt);
            }
        });
        conDS.add(bCari_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 367, 68, 43));

        txtLetak_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtLetak_DS.setBorder(null);
        conDS.add(txtLetak_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 90, 235, 42));

        txtSurat_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtSurat_DS.setBorder(null);
        conDS.add(txtSurat_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 193, 235, 42));

        txtLuas_DS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtLuas_DS.setBorder(null);
        conDS.add(txtLuas_DS, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 235, 42));

        Content.add(conDS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 694));

        conDD.setBackground(new java.awt.Color(252, 252, 252));
        conDD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lnomerDocument.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnomerDocument.setText("No Client");
        conDD.add(lnomerDocument, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 46, -1, -1));

        txtNo_DD.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNo_DD.setBorder(null);
        conDD.add(txtNo_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 236, 34));

        borderNo_DD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDD.add(borderNo_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 78, -1, -1));

        txtNampen_DD.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNampen_DD.setBorder(null);
        conDD.add(txtNampen_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 161, 154, 34));

        borderNampen_DD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Mini Document TF.png"))); // NOI18N
        conDD.add(borderNampen_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 159, -1, -1));

        lnampen_DD.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnampen_DD.setText("Nama Penjual");
        conDD.add(lnampen_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 127, -1, -1));

        lnikPen_DD.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnikPen_DD.setText("NIK Penjual");
        conDD.add(lnikPen_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 208, -1, -1));

        bordernikPen_DD.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        bordernikPen_DD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDD.add(bordernikPen_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 239, -1, -1));

        txtNikPen_DD.setBorder(null);
        conDD.add(txtNikPen_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 241, 236, 34));

        borderNamPem_DD.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderNamPem_DD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Mini Document TF.png"))); // NOI18N
        conDD.add(borderNamPem_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 78, -1, -1));

        lnamPem_DD.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnamPem_DD.setText("Nama Pembeli");
        conDD.add(lnamPem_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 46, -1, -1));

        txtNampem_DD.setBorder(null);
        conDD.add(txtNampem_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 80, 154, 34));

        lnikPem_DD.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnikPem_DD.setText("NIK Pembeli");
        conDD.add(lnikPem_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 127, -1, -1));

        borderNikpem_DD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDD.add(borderNikpem_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 159, -1, -1));

        txtNikpem_DD.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNikpem_DD.setBorder(null);
        conDD.add(txtNikpem_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 161, 236, 34));

        lTgl1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lTgl1.setText("Tanggal");
        conDD.add(lTgl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 208, -1, -1));

        txtTgl_DD.setDateFormatString("dd,MM,YYYY");
        txtTgl_DD.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        conDD.add(txtTgl_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 239, 255, 35));

        lLuas_DD.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lLuas_DD.setText("Luas Tanah");
        conDD.add(lLuas_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 46, -1, -1));

        borderLuas_DD.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderLuas_DD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDD.add(borderLuas_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 78, -1, -1));

        txtLuas_DD.setBorder(null);
        conDD.add(txtLuas_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 236, 34));

        lHarga_DD.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lHarga_DD.setText("Harga");
        conDD.add(lHarga_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 127, -1, -1));

        borderHarga_DD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDD.add(borderHarga_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 159, -1, -1));

        txtHarga_DD.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtHarga_DD.setBorder(null);
        conDD.add(txtHarga_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 161, 236, 34));

        txtCari_DD.setBorder(null);
        conDD.add(txtCari_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 376, 231, 40));

        borderCari_DD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/txtCari.png"))); // NOI18N
        conDD.add(borderCari_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 375, -1, -1));

        bCari_DD.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        bCari_DD.setText("Cari");
        bCari_DD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCari_DDActionPerformed(evt);
            }
        });
        conDD.add(bCari_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 375, 68, 43));

        bSave_DD.setBackground(new java.awt.Color(8, 72, 135));
        bSave_DD.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bSave_DD.setForeground(new java.awt.Color(255, 255, 255));
        bSave_DD.setText("Simpan");
        bSave_DD.setBorder(null);
        bSave_DD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSave_DDActionPerformed(evt);
            }
        });
        conDD.add(bSave_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 303, 195, 39));

        bUbah_DD.setBackground(new java.awt.Color(255, 149, 5));
        bUbah_DD.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bUbah_DD.setForeground(new java.awt.Color(255, 255, 255));
        bUbah_DD.setText("Ubah");
        bUbah_DD.setBorder(null);
        bUbah_DD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbah_DDActionPerformed(evt);
            }
        });
        conDD.add(bUbah_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 303, 195, 39));

        bHapus_DD.setBackground(new java.awt.Color(248, 51, 60));
        bHapus_DD.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bHapus_DD.setForeground(new java.awt.Color(255, 255, 255));
        bHapus_DD.setText("Hapus");
        bHapus_DD.setBorder(null);
        bHapus_DD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapus_DDActionPerformed(evt);
            }
        });
        conDD.add(bHapus_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 303, 195, 39));

        lTabel_DD.setFont(new java.awt.Font("Roboto", 0, 29)); // NOI18N
        lTabel_DD.setText("Tabel Data Karyawan");
        conDD.add(lTabel_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 377, -1, -1));

        bBatal_DD.setBackground(new java.awt.Color(232, 241, 242));
        bBatal_DD.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bBatal_DD.setText("Batal");
        bBatal_DD.setBorder(null);
        bBatal_DD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatal_DDActionPerformed(evt);
            }
        });
        conDD.add(bBatal_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 303, 195, 39));

        tDocument.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tDocument.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tDocumentMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tDocument);

        conDD.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 919, 170));

        bCetak_DD.setBackground(new java.awt.Color(37, 178, 99));
        bCetak_DD.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        bCetak_DD.setForeground(new java.awt.Color(255, 255, 255));
        bCetak_DD.setText("Cetak Laporan Data Karyawan");
        bCetak_DD.setBorder(null);
        conDD.add(bCetak_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 618, 289, 49));

        bCariNampen_DD.setBackground(new java.awt.Color(37, 178, 99));
        bCariNampen_DD.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        bCariNampen_DD.setForeground(new java.awt.Color(255, 255, 255));
        bCariNampen_DD.setText("Cari");
        bCariNampen_DD.setBorder(null);
        bCariNampen_DD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariNampen_DDActionPerformed(evt);
            }
        });
        conDD.add(bCariNampen_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 159, 66, 37));

        bCariNampem_DD.setBackground(new java.awt.Color(37, 178, 99));
        bCariNampem_DD.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        bCariNampem_DD.setForeground(new java.awt.Color(255, 255, 255));
        bCariNampem_DD.setText("Cari");
        bCariNampem_DD.setBorder(null);
        bCariNampem_DD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariNampem_DDActionPerformed(evt);
            }
        });
        conDD.add(bCariNampem_DD, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 78, 66, 37));

        Content.add(conDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 694));

        conDC.setBackground(new java.awt.Color(252, 252, 252));
        conDC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lnomerclient.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnomerclient.setText("Nomor");
        conDC.add(lnomerclient, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 46, -1, -1));

        txtNC_DC.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNC_DC.setBorder(null);
        conDC.add(txtNC_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 236, 34));

        borderNo_DC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDC.add(borderNo_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 78, -1, -1));

        txtNama_DC.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNama_DC.setBorder(null);
        conDC.add(txtNama_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 161, 236, 34));

        borderNama_DC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDC.add(borderNama_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 159, -1, -1));

        lnama_DC.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnama_DC.setText("Nama Lengkap");
        conDC.add(lnama_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 127, -1, -1));

        lnik_DC.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnik_DC.setText("NIK");
        conDC.add(lnik_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 208, -1, -1));

        bordernik_DC.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        bordernik_DC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDC.add(bordernik_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 239, -1, -1));

        txtNik_DC.setBorder(null);
        conDC.add(txtNik_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 241, 236, 34));

        borderNoTelp_DC.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderNoTelp_DC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDC.add(borderNoTelp_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 78, -1, -1));

        lnomertelp_DC.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnomertelp_DC.setText("No Telepon");
        conDC.add(lnomertelp_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 46, -1, -1));

        txtNoTelp_DC.setBorder(null);
        conDC.add(txtNoTelp_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 80, 236, 34));

        lalamat_DC.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lalamat_DC.setText("Alamat");
        conDC.add(lalamat_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 127, -1, -1));

        jScrollPane3.setBorder(null);

        txtAlamat_DC.setColumns(10);
        txtAlamat_DC.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAlamat_DC.setRows(5);
        txtAlamat_DC.setPreferredSize(new java.awt.Dimension(164, 112));
        jScrollPane3.setViewportView(txtAlamat_DC);

        conDC.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 162, 220, 112));

        borderAlamat_DC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Alamat.png"))); // NOI18N
        conDC.add(borderAlamat_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        lpekerjaan_DC.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lpekerjaan_DC.setText("Pekerjaan");
        conDC.add(lpekerjaan_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 46, -1, -1));

        txtTgl_DC.setDateFormatString("dd,MM,YYYY");
        txtTgl_DC.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        conDC.add(txtTgl_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 239, 255, 35));

        cbStatus_DC.setEditable(true);
        cbStatus_DC.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbStatus_DC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Pembeli", "Penjual" }));
        cbStatus_DC.setToolTipText("");
        cbStatus_DC.setBorder(null);
        conDC.add(cbStatus_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 236, 34));

        borderStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDC.add(borderStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 159, -1, -1));

        lStatus_DC.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lStatus_DC.setText("Status");
        conDC.add(lStatus_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 127, -1, -1));

        lTgl.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lTgl.setText("Tanggal");
        conDC.add(lTgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 208, -1, -1));

        borderPekerjaan_DC.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderPekerjaan_DC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDC.add(borderPekerjaan_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 78, -1, -1));

        txtPekerjaan_DC.setBorder(null);
        conDC.add(txtPekerjaan_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 236, 34));

        bSave_DC.setBackground(new java.awt.Color(8, 72, 135));
        bSave_DC.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bSave_DC.setForeground(new java.awt.Color(255, 255, 255));
        bSave_DC.setText("Simpan");
        bSave_DC.setBorder(null);
        bSave_DC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSave_DCActionPerformed(evt);
            }
        });
        conDC.add(bSave_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 303, 195, 39));

        bUbah_DC.setBackground(new java.awt.Color(255, 149, 5));
        bUbah_DC.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bUbah_DC.setForeground(new java.awt.Color(255, 255, 255));
        bUbah_DC.setText("Ubah");
        bUbah_DC.setBorder(null);
        bUbah_DC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbah_DCActionPerformed(evt);
            }
        });
        conDC.add(bUbah_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 303, 195, 39));

        bHapus_DC.setBackground(new java.awt.Color(248, 51, 60));
        bHapus_DC.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bHapus_DC.setForeground(new java.awt.Color(255, 255, 255));
        bHapus_DC.setText("Hapus");
        bHapus_DC.setBorder(null);
        bHapus_DC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapus_DCActionPerformed(evt);
            }
        });
        conDC.add(bHapus_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 303, 195, 39));

        tClient.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tClientMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tClient);

        conDC.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 919, 170));

        lTabel_DC.setFont(new java.awt.Font("Roboto", 0, 29)); // NOI18N
        lTabel_DC.setText("Tabel Data Karyawan");
        conDC.add(lTabel_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 377, -1, -1));

        bBatal_DC.setBackground(new java.awt.Color(232, 241, 242));
        bBatal_DC.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bBatal_DC.setText("Batal");
        bBatal_DC.setBorder(null);
        bBatal_DC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatal_DCActionPerformed(evt);
            }
        });
        conDC.add(bBatal_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 303, 195, 39));

        bCetak_DC.setBackground(new java.awt.Color(37, 178, 99));
        bCetak_DC.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        bCetak_DC.setForeground(new java.awt.Color(255, 255, 255));
        bCetak_DC.setText("Cetak Laporan Data Karyawan");
        bCetak_DC.setBorder(null);
        conDC.add(bCetak_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 618, 289, 49));

        txtCari_DC.setBorder(null);
        conDC.add(txtCari_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 376, 231, 40));

        borderCari_DC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/txtCari.png"))); // NOI18N
        conDC.add(borderCari_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 375, -1, -1));

        bCari_DC.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        bCari_DC.setText("Cari");
        bCari_DC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCari_DCActionPerformed(evt);
            }
        });
        conDC.add(bCari_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 375, 68, 43));

        Content.add(conDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 694));

        conDK.setBackground(new java.awt.Color(252, 252, 252));
        conDK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lnomerinduk.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnomerinduk.setText("Nomor Induk");
        conDK.add(lnomerinduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 46, -1, -1));

        txtNi_DK.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNi_DK.setBorder(null);
        conDK.add(txtNi_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 236, 34));

        borderNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDK.add(borderNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 78, -1, -1));

        txtNama_DK.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNama_DK.setBorder(null);
        conDK.add(txtNama_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 161, 236, 34));

        borderNama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDK.add(borderNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 159, -1, -1));

        lnama.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnama.setText("Nama Lengkap");
        conDK.add(lnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 127, -1, -1));

        lemail.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lemail.setText("Email");
        conDK.add(lemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 208, -1, -1));

        borderEmail.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDK.add(borderEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 239, -1, -1));

        txtEmail_DK.setBorder(null);
        conDK.add(txtEmail_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 241, 236, 34));

        borderNoTelp.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderNoTelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDK.add(borderNoTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 78, -1, -1));

        lnomertelp.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lnomertelp.setText("No Telepon");
        conDK.add(lnomertelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 46, -1, -1));

        txtNoTelp_DK.setBorder(null);
        conDK.add(txtNoTelp_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 80, 236, 34));

        lalamat.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lalamat.setText("Alamat");
        conDK.add(lalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 127, -1, -1));

        jScrollPane1.setBorder(null);

        txtAlamat_DK.setColumns(10);
        txtAlamat_DK.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtAlamat_DK.setRows(5);
        txtAlamat_DK.setPreferredSize(new java.awt.Dimension(164, 112));
        jScrollPane1.setViewportView(txtAlamat_DK);
        txtAlamat_DK.getAccessibleContext().setAccessibleParent(conDK);

        conDK.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 162, 220, 112));

        borderAlamat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Alamat.png"))); // NOI18N
        conDK.add(borderAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        ltempat.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        ltempat.setText("Tempat");
        conDK.add(ltempat, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 46, -1, -1));

        txtTempat_DK.setBorder(null);
        conDK.add(txtTempat_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 79, 90, 35));

        borderTempat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mini tf.png"))); // NOI18N
        conDK.add(borderTempat, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 78, -1, -1));

        txt_tgl_DK.setDateFormatString("dd,MM,YYYY");
        txt_tgl_DK.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        conDK.add(txt_tgl_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 78, 119, 35));

        ltanggal.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        ltanggal.setText("Tanggal Lahir");
        conDK.add(ltanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 46, -1, -1));

        cbAgama_DK.setEditable(true);
        cbAgama_DK.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbAgama_DK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Buddha", "Hindu", "Islam", "Katolik", "Konghuchu", "Kristen" }));
        cbAgama_DK.setToolTipText("");
        cbAgama_DK.setBorder(null);
        conDK.add(cbAgama_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 236, 34));

        borderAgama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDK.add(borderAgama, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 159, -1, -1));

        lAgama.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lAgama.setText("Agama");
        conDK.add(lAgama, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 127, -1, -1));

        ljabatan.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        ljabatan.setText("Jabatan");
        conDK.add(ljabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 208, -1, -1));

        borderJabatan.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        borderJabatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/textfield 9.png"))); // NOI18N
        conDK.add(borderJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 239, -1, -1));

        txtJabatan_DK.setBorder(null);
        conDK.add(txtJabatan_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 241, 236, 34));

        bSave_DK.setBackground(new java.awt.Color(8, 72, 135));
        bSave_DK.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bSave_DK.setForeground(new java.awt.Color(255, 255, 255));
        bSave_DK.setText("Simpan");
        bSave_DK.setBorder(null);
        bSave_DK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSave_DKActionPerformed(evt);
            }
        });
        conDK.add(bSave_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 303, 195, 39));

        bUbah_DK.setBackground(new java.awt.Color(255, 149, 5));
        bUbah_DK.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bUbah_DK.setForeground(new java.awt.Color(255, 255, 255));
        bUbah_DK.setText("Ubah");
        bUbah_DK.setBorder(null);
        bUbah_DK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbah_DKActionPerformed(evt);
            }
        });
        conDK.add(bUbah_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 303, 195, 39));

        bHapus_DK.setBackground(new java.awt.Color(248, 51, 60));
        bHapus_DK.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bHapus_DK.setForeground(new java.awt.Color(255, 255, 255));
        bHapus_DK.setText("Hapus");
        bHapus_DK.setBorder(null);
        bHapus_DK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapus_DKActionPerformed(evt);
            }
        });
        conDK.add(bHapus_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 303, 195, 39));

        tKaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tKaryawanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tKaryawan);

        conDK.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 919, 170));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 29)); // NOI18N
        jLabel3.setText("Tabel Data Karyawan");
        conDK.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 377, -1, -1));

        bBatal_DK.setBackground(new java.awt.Color(232, 241, 242));
        bBatal_DK.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        bBatal_DK.setText("Batal");
        bBatal_DK.setBorder(null);
        bBatal_DK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatal_DKActionPerformed(evt);
            }
        });
        conDK.add(bBatal_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 303, 195, 39));

        jButton2.setBackground(new java.awt.Color(37, 178, 99));
        jButton2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cetak Laporan Data Karyawan");
        jButton2.setBorder(null);
        conDK.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 618, 289, 49));

        txtCari_DK.setBorder(null);
        conDK.add(txtCari_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 376, 231, 40));

        borderCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/txtCari.png"))); // NOI18N
        conDK.add(borderCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 375, -1, -1));

        bCari_DK.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        bCari_DK.setText("Cari");
        bCari_DK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCari_DKActionPerformed(evt);
            }
        });
        conDK.add(bCari_DK, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 375, 68, 43));

        Content.add(conDK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 694));

        conDashboard.setBackground(new java.awt.Color(252, 252, 252));
        conDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lKunjungan.setFont(new java.awt.Font("Roboto", 0, 35)); // NOI18N
        lKunjungan.setForeground(new java.awt.Color(255, 255, 255));
        lKunjungan.setText("Jumlah Kunjungan");
        conDashboard.add(lKunjungan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        LClient.setFont(new java.awt.Font("Roboto", 0, 35)); // NOI18N
        LClient.setForeground(new java.awt.Color(255, 255, 255));
        LClient.setText("Jumlah Client");
        conDashboard.add(LClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, -1, -1));

        lkunjungan.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        lkunjungan.setForeground(new java.awt.Color(255, 255, 255));
        lkunjungan.setText("0");
        conDashboard.add(lkunjungan, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        lclient.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        lclient.setForeground(new java.awt.Color(255, 255, 255));
        lclient.setText("0");
        conDashboard.add(lclient, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, -1, -1));

        jmlKaryawan.setFont(new java.awt.Font("Roboto", 0, 35)); // NOI18N
        jmlKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        jmlKaryawan.setText("Jumlah Karyawan");
        conDashboard.add(jmlKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 414, -1, -1));

        lkaryawan.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        lkaryawan.setForeground(new java.awt.Color(255, 255, 255));
        lkaryawan.setText("0");
        conDashboard.add(lkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 484, -1, -1));

        lkaryawan1.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        lkaryawan1.setForeground(new java.awt.Color(255, 255, 255));
        lkaryawan1.setText("0");
        conDashboard.add(lkaryawan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 484, -1, -1));

        Karyawan1.setFont(new java.awt.Font("Roboto", 0, 35)); // NOI18N
        Karyawan1.setForeground(new java.awt.Color(255, 255, 255));
        Karyawan1.setText("Jumlah Sertifikat");
        conDashboard.add(Karyawan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 414, -1, -1));

        RectKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/kotak dashboard.png"))); // NOI18N
        conDashboard.add(RectKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 74, -1, -1));

        RectKunjungan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/kotak dashboard.png"))); // NOI18N
        conDashboard.add(RectKunjungan, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 74, -1, -1));

        RectSertifikat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/kotak dashboard.png"))); // NOI18N
        conDashboard.add(RectSertifikat, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 371, -1, -1));

        RectSertifikat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/kotak dashboard.png"))); // NOI18N
        conDashboard.add(RectSertifikat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 371, -1, -1));

        Content.add(conDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 694));

        Parent.add(Content, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 74, 1060, 694));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Parent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Parent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RectDashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RectDashMouseClicked
        MenuDashboard();
    }//GEN-LAST:event_RectDashMouseClicked

    private void RectDKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RectDKMouseClicked
        MenuDK();
    }//GEN-LAST:event_RectDKMouseClicked

    private void RectDCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RectDCMouseClicked
        MenuDC();
    }//GEN-LAST:event_RectDCMouseClicked

    private void RectDHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RectDHMouseClicked
        MenuDH();
    }//GEN-LAST:event_RectDHMouseClicked

    private void RectDDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RectDDMouseClicked
        MenuDD();
    }//GEN-LAST:event_RectDDMouseClicked

    private void RectDSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RectDSMouseClicked
        MenuDS();
    }//GEN-LAST:event_RectDSMouseClicked

    private void RectLJAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RectLJAMouseClicked
        MenuLJA();
    }//GEN-LAST:event_RectLJAMouseClicked

    private void RectLBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RectLBMouseClicked
        MenuLB();
    }//GEN-LAST:event_RectLBMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Login.Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bSave_DKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSave_DKActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String Tgl = Date.format(txt_tgl_DK.getDate());
        Karyawan.Tambah(txtNi_DK.getText(), txtNama_DK.getText(), txtEmail_DK.getText(),
                txtNoTelp_DK.getText(),txtAlamat_DK.getText(), txtTempat_DK.getText(),
                Tgl, (String)cbAgama_DK.getSelectedItem(), txtJabatan_DK.getText());
        clearDK();
        DataDK();
    }//GEN-LAST:event_bSave_DKActionPerformed

    private void bUbah_DKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbah_DKActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String Tgl = Date.format(txt_tgl_DK.getDate());
        Karyawan.Ubah(txtNi_DK.getText(), txtNama_DK.getText(), txtEmail_DK.getText(),
                txtNoTelp_DK.getText(),txtAlamat_DK.getText(), txtTempat_DK.getText(),
                Tgl, (String)cbAgama_DK.getSelectedItem(), txtJabatan_DK.getText());
        clearDK();
        DataDK();
        txtNi_DK.enable();
    }//GEN-LAST:event_bUbah_DKActionPerformed

    private void bHapus_DKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapus_DKActionPerformed
        Karyawan.Hapus(txtNi_DK.getText());
        clearDK();
        DataDK();
        txtNi_DK.enable();
    }//GEN-LAST:event_bHapus_DKActionPerformed

    private void bBatal_DKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatal_DKActionPerformed
        clearDK();
    }//GEN-LAST:event_bBatal_DKActionPerformed

    private void tKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tKaryawanMouseClicked
        int brs = tKaryawan.getSelectedRow();
        String ini = tKaryawan.getValueAt(brs, 0).toString();
        String itu = tKaryawan.getValueAt(brs, 1).toString();
        String uhuy = tKaryawan.getValueAt(brs, 2).toString();
        String uwu = tKaryawan.getValueAt(brs, 3).toString();
        String ono = tKaryawan.getValueAt(brs, 4).toString();
        String sini = tKaryawan.getValueAt(brs, 5).toString();
        Date situ = java.sql.Date.valueOf(tKaryawan.getValueAt(brs, 6).toString());
        String sono = tKaryawan.getValueAt(brs, 7).toString();
        String inu = tKaryawan.getValueAt(brs, 8).toString();
        txtNi_DK.setText(ini); 
        txtNama_DK.setText(itu); 
        txtEmail_DK.setText(uhuy); 
        txtNoTelp_DK.setText(uwu); 
        txtAlamat_DK.setText(ono); 
        txtTempat_DK.setText(sini); 
        txt_tgl_DK.setDate(situ); 
        cbAgama_DK.setSelectedItem(sono); 
        txtJabatan_DK.setText(inu);
        txtNi_DK.disable();
    }//GEN-LAST:event_tKaryawanMouseClicked

    private void bSave_DCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSave_DCActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String Tgl = Date.format(txtTgl_DC.getDate());
        Client.Tambah(txtNC_DC.getText(), txtNama_DC.getText(), txtNik_DC.getText(), 
                txtNoTelp_DC.getText(),txtAlamat_DC.getText(), txtPekerjaan_DC.getText(), 
                (String)cbStatus_DC.getSelectedItem(), Tgl);
        ClearDC();
        DataDC();
    }//GEN-LAST:event_bSave_DCActionPerformed

    private void bUbah_DCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbah_DCActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String Tgl = Date.format(txtTgl_DC.getDate());
        Client.Ubah(txtNC_DC.getText(), txtNama_DC.getText(), txtNik_DC.getText(), 
                txtNoTelp_DC.getText(),txtAlamat_DC.getText(), txtPekerjaan_DC.getText(), 
                (String)cbStatus_DC.getSelectedItem(), Tgl);
        ClearDC();
        DataDC();
        txtNC_DC.enable();
    }//GEN-LAST:event_bUbah_DCActionPerformed

    private void bHapus_DCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapus_DCActionPerformed
        Client.Hapus(txtNC_DC.getText());
        txtNC_DC.enable();
    }//GEN-LAST:event_bHapus_DCActionPerformed

    private void tClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tClientMouseClicked
        int brs = tClient.getSelectedRow();
        String ini = tClient.getValueAt(brs, 0).toString();
        String itu = tClient.getValueAt(brs, 1).toString();
        String uhuy = tClient.getValueAt(brs, 2).toString();
        String uwu = tClient.getValueAt(brs, 3).toString();
        String ono = tClient.getValueAt(brs, 4).toString();
        String sini = tClient.getValueAt(brs, 5).toString();
        String sono = tClient.getValueAt(brs, 6).toString();
        Date situ = java.sql.Date.valueOf(tClient.getValueAt(brs, 7).toString());
        txtNC_DC.setText(ini); 
        txtNama_DC.setText(itu); 
        txtNik_DC.setText(uhuy); 
        txtNoTelp_DC.setText(uwu); 
        txtAlamat_DC.setText(ono); 
        txtPekerjaan_DC.setText(sini); 
        cbStatus_DC.setSelectedItem(sono); 
        txtTgl_DC.setDate(situ); 
        txtNC_DC.disable();
    }//GEN-LAST:event_tClientMouseClicked

    private void bBatal_DCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatal_DCActionPerformed
        ClearDC();
        DataDC();
    }//GEN-LAST:event_bBatal_DCActionPerformed

    private void bSave_DDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSave_DDActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String Tgl = Date.format(txtTgl_DC.getDate());
        Document.Tambah(txtNo_DD.getText(), txtNampen_DD.getText(), txtNikPen_DD.getText(), 
                txtNampem_DD.getText(),txtNikpem_DD.getText(), Tgl, 
                Integer.parseInt(txtLuas_DD.getText()), Integer.parseInt(txtHarga_DD.getText()));
        ClearDD();
        DataDD();
    }//GEN-LAST:event_bSave_DDActionPerformed

    private void bUbah_DDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbah_DDActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String Tgl = Date.format(txtTgl_DC.getDate());
        Document.Ubah(txtNo_DD.getText(), txtNampen_DD.getText(), txtNikPen_DD.getText(), 
                txtNampem_DD.getText(),txtNikpem_DD.getText(), Tgl, 
                Integer.parseInt(txtLuas_DD.getText()), Integer.parseInt(txtHarga_DD.getText()));
        ClearDD();
        DataDD();
    }//GEN-LAST:event_bUbah_DDActionPerformed

    private void bHapus_DDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapus_DDActionPerformed
        Document.Hapus(txtNo_DD.getText());
        ClearDD();
        DataDD();
    }//GEN-LAST:event_bHapus_DDActionPerformed

    private void tDocumentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDocumentMouseClicked
        int brs = tDocument.getSelectedRow();
        String ini = tDocument.getValueAt(brs, 0).toString();
        String itu = tDocument.getValueAt(brs, 1).toString();
        String uhuy = tDocument.getValueAt(brs, 2).toString();
        String uwu = tDocument.getValueAt(brs, 3).toString();
        String ono = tDocument.getValueAt(brs, 4).toString();
        Date situ = java.sql.Date.valueOf(tDocument.getValueAt(brs, 5).toString());
        String sini = tDocument.getValueAt(brs, 6).toString();
        String sono = tDocument.getValueAt(brs, 7).toString();
        txtNo_DD.setText(ini); 
        txtNampen_DD.setText(itu); 
        txtNikPen_DD.setText(uhuy); 
        txtNampem_DD.setText(uwu); 
        txtNikpem_DD.setText(ono); 
        txtTgl_DD.setDate(situ); 
        txtLuas_DD.setText(sini); 
        txtHarga_DD.setText(sono); 
        txtNo_DD.disable();
    }//GEN-LAST:event_tDocumentMouseClicked

    private void bBatal_DDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatal_DDActionPerformed
        ClearDD();
        DataDD();
    }//GEN-LAST:event_bBatal_DDActionPerformed

    private void bCariNampen_DDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariNampen_DDActionPerformed
        PopupPenjual Pen = new PopupPenjual();
        Pen.pen = this;
        Pen.setVisible(true);
        Pen.setResizable(false);
    }//GEN-LAST:event_bCariNampen_DDActionPerformed

    private void bCariNampem_DDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariNampem_DDActionPerformed
        PopupPembeli Pem = new PopupPembeli();
        Pem.pem = this;
        Pem.setVisible(true);
        Pem.setResizable(false);
    }//GEN-LAST:event_bCariNampem_DDActionPerformed

    private void bCari_DDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCari_DDActionPerformed
        DataDD();
    }//GEN-LAST:event_bCari_DDActionPerformed

    private void bCari_DCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCari_DCActionPerformed
        DataDC();
    }//GEN-LAST:event_bCari_DCActionPerformed

    private void bCari_DKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCari_DKActionPerformed
        DataDK();
    }//GEN-LAST:event_bCari_DKActionPerformed

    private void bSave_DSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSave_DSActionPerformed
        Sertifikat.Tambah(txtNo_DS.getText(), txtNama_DS.getText(), txtLetak_DS.getText(), 
                txtSurat_DS.getText(), Integer.parseInt(txtLuas_DS.getText()));
        DataDS();
        ClearDS();
    }//GEN-LAST:event_bSave_DSActionPerformed

    private void bUbah_DSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbah_DSActionPerformed
        Sertifikat.Ubah(txtNo_DS.getText(), txtNama_DS.getText(), txtLetak_DS.getText(), 
                txtSurat_DS.getText(), Integer.parseInt(txtLuas_DS.getText()));
        DataDS();
        ClearDS();
        txtNo_DS.enable();
    }//GEN-LAST:event_bUbah_DSActionPerformed

    private void bHapus_DSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapus_DSActionPerformed
        Sertifikat.Hapus(txtNo_DS.getText());
        DataDS();
        ClearDS();
        txtNo_DS.enable();
    }//GEN-LAST:event_bHapus_DSActionPerformed

    private void tSertifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tSertifMouseClicked
        int brs = tSertif.getSelectedRow();
        String ini = tSertif.getValueAt(brs, 0).toString();
        String itu = tSertif.getValueAt(brs, 1).toString();
        String uhuy = tSertif.getValueAt(brs, 2).toString();
        String uwu = tSertif.getValueAt(brs, 3).toString();
        String ono = tSertif.getValueAt(brs, 4).toString();
        txtNo_DS.setText(ini); 
        txtNama_DS.setText(itu); 
        txtLetak_DS.setText(uhuy); 
        txtSurat_DS.setText(uwu); 
        txtLuas_DS.setText(ono); 
        txtNo_DS.disable();
    }//GEN-LAST:event_tSertifMouseClicked

    private void bBatal_DSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatal_DSActionPerformed
        DataDS();
        ClearDS();
        txtNo_DS.enable();
    }//GEN-LAST:event_bBatal_DSActionPerformed

    private void bCari_DSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCari_DSActionPerformed
        DataDS();
    }//GEN-LAST:event_bCari_DSActionPerformed

    private void bSave_LJAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSave_LJAActionPerformed
        LJA.Tambah(txtNo_LJA.getText(), txtAkta_LJA.getText(), txtHibah_LJA.getText(), 
                txtAPHB_LJA.getText(), txtAPHT_LJA.getText(), txtSKMHT_LJA.getText(), 
                Integer.parseInt(txtJumlah_LJA.getText()));
        DataLJA();
        ClearLJA();
    }//GEN-LAST:event_bSave_LJAActionPerformed

    private void bUbah_LJAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbah_LJAActionPerformed
        LJA.Ubah(txtNo_LJA.getText(), txtAkta_LJA.getText(), txtHibah_LJA.getText(), 
                txtAPHB_LJA.getText(), txtAPHT_LJA.getText(), txtSKMHT_LJA.getText(), 
                Integer.parseInt(txtJumlah_LJA.getText()));
        DataLJA();
        ClearLJA();
        txtNo_LJA.enable();
    }//GEN-LAST:event_bUbah_LJAActionPerformed

    private void bHapus_LJAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapus_LJAActionPerformed
        LJA.Hapus(txtNo_LJA.getText());
        DataLJA();
        ClearLJA();
        txtNo_LJA.enable();
    }//GEN-LAST:event_bHapus_LJAActionPerformed

    private void tLJAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tLJAMouseClicked
        int brs = tLJA.getSelectedRow();
        String ini = tLJA.getValueAt(brs, 0).toString();
        String itu = tLJA.getValueAt(brs, 1).toString();
        String uhuy = tLJA.getValueAt(brs, 2).toString();
        String uwu = tLJA.getValueAt(brs, 3).toString();
        String ono = tLJA.getValueAt(brs, 4).toString();
        String sini = tLJA.getValueAt(brs, 5).toString();
        String sono = tLJA.getValueAt(brs, 6).toString();
        txtNo_LJA.setText(ini); 
        txtAkta_LJA.setText(itu); 
        txtHibah_LJA.setText(uhuy); 
        txtAPHB_LJA.setText(uwu); 
        txtAPHT_LJA.setText(ono); 
        txtSKMHT_LJA.setText(ono); 
        txtJumlah_LJA.setText(ono); 
        txtNo_LJA.disable();
    }//GEN-LAST:event_tLJAMouseClicked

    private void bBatal_LJAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatal_LJAActionPerformed
        DataLJA();
        txtNo_LJA.enable();
        ClearLJA();
    }//GEN-LAST:event_bBatal_LJAActionPerformed

    private void bCari_LJAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCari_LJAActionPerformed
        DataLJA();
    }//GEN-LAST:event_bCari_LJAActionPerformed

    private void bCari_DHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCari_DHActionPerformed
        DataDH();
    }//GEN-LAST:event_bCari_DHActionPerformed

    private void bBatal_DHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatal_DHActionPerformed
        ClearDH();
        txtNo_DH.enable();
    }//GEN-LAST:event_bBatal_DHActionPerformed

    private void tDHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDHMouseClicked
        int brs = tDH.getSelectedRow();
        String ini = tDH.getValueAt(brs, 0).toString();
        String itu = tDH.getValueAt(brs, 1).toString();
        Date uhuy = java.sql.Date.valueOf(tDH.getValueAt(brs, 2).toString());
        txtNo_DH.setText(ini); 
        txtNama_DH.setText(itu); 
        jTgl_DH.setDate(uhuy); 
        txtNo_DH.disable();
    }//GEN-LAST:event_tDHMouseClicked

    private void bHapus_DHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapus_DHActionPerformed
        Kunjungan.Hapus(txtNo_DH.getText());
        DataDH();
        ClearDH();
        txtNo_DH.enable();
    }//GEN-LAST:event_bHapus_DHActionPerformed

    private void bUbah_DHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbah_DHActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String Tgl = Date.format(jTgl_DH.getDate());
        Kunjungan.Ubah(txtNo_DH.getText(), txtNama_DH.getText(), Tgl);
        DataDH();
        ClearDH();
        txtNo_DH.enable();
    }//GEN-LAST:event_bUbah_DHActionPerformed

    private void bSave_DHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSave_DHActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String Tgl = Date.format(jTgl_DH.getDate());
        Kunjungan.Tambah(txtNo_DH.getText(), txtNama_DH.getText(), Tgl);
        DataDH();
        ClearDH();
    }//GEN-LAST:event_bSave_DHActionPerformed

    private void bCari_LBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCari_LBActionPerformed
        DataLB();
    }//GEN-LAST:event_bCari_LBActionPerformed

    private void bBatal_LBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatal_LBActionPerformed
        ClearLB();
        txtNo_LB.enable();
    }//GEN-LAST:event_bBatal_LBActionPerformed

    private void tLBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tLBMouseClicked
        int brs = tLB.getSelectedRow();
        String a = tLB.getValueAt(brs, 0).toString();
        String b = tLB.getValueAt(brs, 1).toString();
        Date c = java.sql.Date.valueOf(tLB.getValueAt(brs, 2).toString());
        String d = tLB.getValueAt(brs, 3).toString();
        String e = tLB.getValueAt(brs, 4).toString();
        String f = tLB.getValueAt(brs, 5).toString();
        String g = tLB.getValueAt(brs, 6).toString();
        String h = tLB.getValueAt(brs, 7).toString();
        String i = tLB.getValueAt(brs, 8).toString();
        String j = tLB.getValueAt(brs, 9).toString();
        String k = tLB.getValueAt(brs, 10).toString();
        String l = tLB.getValueAt(brs, 11).toString();
        String m = tLB.getValueAt(brs, 12).toString();
        String n = tLB.getValueAt(brs, 13).toString();
        txtNo_LB.setText(a); 
        txtNoAJB_LB.setText(b); 
        jTgl_LB.setDate(c); 
        txtBPH_LB.setText(d); 
        txtNamPen_LB.setText(e); 
        txtNamPem_LB.setText(f); 
        txtJNA_LB.setText(g); 
        txtLetak_LB.setText(h); 
        txtLuas_LB.setText(i); 
        txtHarga_LB.setText(j); 
        txtNOP_LB.setText(k); 
        txtNJOP_LB.setText(l); 
        txtSSP_LB.setText(m); 
        txtSSB_LB.setText(n); 
        txtNo_LB.disable();
    }//GEN-LAST:event_tLBMouseClicked

    private void bHapus_LBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapus_LBActionPerformed
        LB.Hapus(txtNo_LB.getText());
        DataLB();
        ClearLB();
        txtNo_LB.enable();
    }//GEN-LAST:event_bHapus_LBActionPerformed

    private void bUbah_LBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbah_LBActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String Tgl = Date.format(jTgl_LB.getDate());
        LB.Ubah(txtNo_LB.getText(), txtNoAJB_LB.getText(), Tgl, txtBPH_LB.getText(), 
                txtNamPen_LB.getText(), txtNamPem_LB.getText(), txtJNA_LB.getText(), 
                txtLetak_LB.getText(), Integer.parseInt(txtLuas_LB.getText()), 
                Integer.parseInt(txtHarga_LB.getText()), txtNJOP_LB.getText(), 
                txtNOP_LB.getText(), txtSSP_LB.getText(), txtSSB_LB.getText());
        DataLB();
        ClearLB();
        txtNo_LB.enable();
    }//GEN-LAST:event_bUbah_LBActionPerformed

    private void bSave_LBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSave_LBActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String Tgl = Date.format(jTgl_LB.getDate());
        LB.Tambah(txtNo_LB.getText(), txtNoAJB_LB.getText(), Tgl, txtBPH_LB.getText(), 
                txtNamPen_LB.getText(), txtNamPem_LB.getText(), txtJNA_LB.getText(), 
                txtLetak_LB.getText(), Integer.parseInt(txtLuas_LB.getText()), 
                Integer.parseInt(txtHarga_LB.getText()), txtNJOP_LB.getText(), 
                txtNOP_LB.getText(), txtSSP_LB.getText(), txtSSB_LB.getText());
        DataLB();
        ClearLB();
    }//GEN-LAST:event_bSave_LBActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JLabel Karyawan1;
    private javax.swing.JLabel LClient;
    private javax.swing.JPanel Parent;
    private javax.swing.JPanel RectDC;
    private javax.swing.JPanel RectDD;
    private javax.swing.JPanel RectDH;
    private javax.swing.JPanel RectDK;
    private javax.swing.JPanel RectDS;
    private javax.swing.JPanel RectDash;
    private javax.swing.JLabel RectKaryawan;
    private javax.swing.JLabel RectKunjungan;
    private javax.swing.JPanel RectLB;
    private javax.swing.JPanel RectLJA;
    private javax.swing.JLabel RectSertifikat;
    private javax.swing.JLabel RectSertifikat1;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JPanel User;
    private javax.swing.JButton bBatal_DC;
    private javax.swing.JButton bBatal_DD;
    private javax.swing.JButton bBatal_DH;
    private javax.swing.JButton bBatal_DK;
    private javax.swing.JButton bBatal_DS;
    private javax.swing.JButton bBatal_LB;
    private javax.swing.JButton bBatal_LJA;
    private javax.swing.JButton bCariNampem_DD;
    private javax.swing.JButton bCariNampen_DD;
    private javax.swing.JButton bCari_DC;
    private javax.swing.JButton bCari_DD;
    private javax.swing.JButton bCari_DH;
    private javax.swing.JButton bCari_DK;
    private javax.swing.JButton bCari_DS;
    private javax.swing.JButton bCari_LB;
    private javax.swing.JButton bCari_LJA;
    private javax.swing.JButton bCetak_DC;
    private javax.swing.JButton bCetak_DD;
    private javax.swing.JButton bCetak_DH;
    private javax.swing.JButton bCetak_DS;
    private javax.swing.JButton bCetak_LB;
    private javax.swing.JButton bCetak_LJA;
    private javax.swing.JButton bHapus_DC;
    private javax.swing.JButton bHapus_DD;
    private javax.swing.JButton bHapus_DH;
    private javax.swing.JButton bHapus_DK;
    private javax.swing.JButton bHapus_DS;
    private javax.swing.JButton bHapus_LB;
    private javax.swing.JButton bHapus_LJA;
    private javax.swing.JButton bSave_DC;
    private javax.swing.JButton bSave_DD;
    private javax.swing.JButton bSave_DH;
    private javax.swing.JButton bSave_DK;
    private javax.swing.JButton bSave_DS;
    private javax.swing.JButton bSave_LB;
    private javax.swing.JButton bSave_LJA;
    private javax.swing.JButton bUbah_DC;
    private javax.swing.JButton bUbah_DD;
    private javax.swing.JButton bUbah_DH;
    private javax.swing.JButton bUbah_DK;
    private javax.swing.JButton bUbah_DS;
    private javax.swing.JButton bUbah_LB;
    private javax.swing.JButton bUbah_LJA;
    private javax.swing.JLabel borderAJB_LB;
    private javax.swing.JLabel borderAPHB_LJA;
    private javax.swing.JLabel borderAPHT_LJA;
    private javax.swing.JLabel borderAgama;
    private javax.swing.JLabel borderAkta_LJA;
    private javax.swing.JLabel borderAlamat;
    private javax.swing.JLabel borderAlamat_DC;
    private javax.swing.JLabel borderBPH_LB;
    private javax.swing.JLabel borderCari;
    private javax.swing.JLabel borderCari_DC;
    private javax.swing.JLabel borderCari_DD;
    private javax.swing.JLabel borderCari_DH;
    private javax.swing.JLabel borderCari_DS;
    private javax.swing.JLabel borderCari_LB;
    private javax.swing.JLabel borderCari_LJA;
    private javax.swing.JLabel borderEmail;
    private javax.swing.JLabel borderHarga_DD;
    private javax.swing.JLabel borderHarga_LB;
    private javax.swing.JLabel borderHibah_LJA;
    private javax.swing.JLabel borderJNA_LB;
    private javax.swing.JLabel borderJabatan;
    private javax.swing.JLabel borderJumlah_LJA;
    private javax.swing.JLabel borderLetak_DS;
    private javax.swing.JLabel borderLetak_LB;
    private javax.swing.JLabel borderLuas_DD;
    private javax.swing.JLabel borderLuas_DS;
    private javax.swing.JLabel borderLuas_LB;
    private javax.swing.JLabel borderNJOP_LB;
    private javax.swing.JLabel borderNOP_LB;
    private javax.swing.JLabel borderNaPem_LB;
    private javax.swing.JLabel borderNamPem_DD;
    private javax.swing.JLabel borderNamPen_LB;
    private javax.swing.JLabel borderNama;
    private javax.swing.JLabel borderNama_DC;
    private javax.swing.JLabel borderNama_DH;
    private javax.swing.JLabel borderNama_DS;
    private javax.swing.JLabel borderNampen_DD;
    private javax.swing.JLabel borderNikpem_DD;
    private javax.swing.JLabel borderNo;
    private javax.swing.JLabel borderNoAJB_LB;
    private javax.swing.JLabel borderNoTelp;
    private javax.swing.JLabel borderNoTelp_DC;
    private javax.swing.JLabel borderNo_DC;
    private javax.swing.JLabel borderNo_DD;
    private javax.swing.JLabel borderNo_DH;
    private javax.swing.JLabel borderNo_DS;
    private javax.swing.JLabel borderNo_LB;
    private javax.swing.JLabel borderNo_LJA;
    private javax.swing.JLabel borderPekerjaan_DC;
    private javax.swing.JLabel borderSKMHT_LJA;
    private javax.swing.JLabel borderSSB_LB;
    private javax.swing.JLabel borderSSP_LB;
    private javax.swing.JLabel borderStatus;
    private javax.swing.JLabel borderSurat_DS;
    private javax.swing.JLabel borderTempat;
    private javax.swing.JLabel bordernikPen_DD;
    private javax.swing.JLabel bordernik_DC;
    private javax.swing.JComboBox<String> cbAgama_DK;
    private javax.swing.JComboBox<String> cbStatus_DC;
    private javax.swing.JPanel conDC;
    private javax.swing.JPanel conDD;
    private javax.swing.JPanel conDH;
    private javax.swing.JPanel conDK;
    private javax.swing.JPanel conDS;
    private javax.swing.JPanel conDashboard;
    private javax.swing.JPanel conLB;
    private javax.swing.JPanel conLJA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private com.toedter.calendar.JDateChooser jTgl_DH;
    private com.toedter.calendar.JDateChooser jTgl_LB;
    private javax.swing.JLabel jmlKaryawan;
    private javax.swing.JLabel lAPHT_LJA;
    private javax.swing.JLabel lAgama;
    private javax.swing.JLabel lAkta_LJA;
    private javax.swing.JLabel lBPH_LB;
    private javax.swing.JLabel lDKar;
    private javax.swing.JLabel lDKar1;
    private javax.swing.JLabel lDKar2;
    private javax.swing.JLabel lDKar3;
    private javax.swing.JLabel lDKar4;
    private javax.swing.JLabel lDKar5;
    private javax.swing.JLabel lDKar6;
    private javax.swing.JLabel lDash;
    private javax.swing.JLabel lHarga_DD;
    private javax.swing.JLabel lHarga_LB;
    private javax.swing.JLabel lHibah_LJA;
    private javax.swing.JLabel lJNA_LB;
    private javax.swing.JLabel lJumlah_LJA;
    private javax.swing.JLabel lKunjungan;
    private javax.swing.JLabel lLetak_DS;
    private javax.swing.JLabel lLetak_LB;
    private javax.swing.JLabel lLuas_DD;
    private javax.swing.JLabel lLuas_DS;
    private javax.swing.JLabel lLuas_LB;
    private javax.swing.JLabel lNJOP_LB;
    private javax.swing.JLabel lNOP_LB;
    private javax.swing.JLabel lNamPen_LB;
    private javax.swing.JLabel lNoAJB_LB;
    private javax.swing.JLabel lSKMHT_LJA;
    private javax.swing.JLabel lSSB_LB;
    private javax.swing.JLabel lSSP_LB;
    private javax.swing.JLabel lStatus_DC;
    private javax.swing.JLabel lSurat_DS;
    private javax.swing.JLabel lTabel_DC;
    private javax.swing.JLabel lTabel_DD;
    private javax.swing.JLabel lTabel_DH;
    private javax.swing.JLabel lTabel_DS;
    private javax.swing.JLabel lTabel_LB;
    private javax.swing.JLabel lTabel_LJA;
    private javax.swing.JLabel lTgl;
    private javax.swing.JLabel lTgl1;
    private javax.swing.JLabel lTgl_DH;
    private javax.swing.JLabel lTgl_LB;
    private javax.swing.JLabel lalamat;
    private javax.swing.JLabel lalamat_DC;
    private javax.swing.JLabel lclient;
    private javax.swing.JLabel lemail;
    private javax.swing.JLabel ljabatan;
    private javax.swing.JLabel lkaryawan;
    private javax.swing.JLabel lkaryawan1;
    private javax.swing.JLabel lkunjungan;
    private javax.swing.JLabel lnamPem_DD;
    private javax.swing.JLabel lnama;
    private javax.swing.JLabel lnama_DC;
    private javax.swing.JLabel lnama_DS;
    private javax.swing.JLabel lnampen_DD;
    private javax.swing.JLabel lnikPem_DD;
    private javax.swing.JLabel lnikPen_DD;
    private javax.swing.JLabel lnik_DC;
    private javax.swing.JLabel lnomerAPHB_LJA;
    private javax.swing.JLabel lnomerDocument;
    private javax.swing.JLabel lnomerLB;
    private javax.swing.JLabel lnomerNaPem_LB;
    private javax.swing.JLabel lnomerNama_DH;
    private javax.swing.JLabel lnomerUrut_DS;
    private javax.swing.JLabel lnomer_DH;
    private javax.swing.JLabel lnomer_LJA;
    private javax.swing.JLabel lnomerclient;
    private javax.swing.JLabel lnomerinduk;
    private javax.swing.JLabel lnomertelp;
    private javax.swing.JLabel lnomertelp_DC;
    private javax.swing.JLabel lpekerjaan_DC;
    private javax.swing.JLabel lprofile;
    private javax.swing.JLabel ltanggal;
    private javax.swing.JLabel ltempat;
    private javax.swing.JLabel profile;
    private javax.swing.JTable tClient;
    private javax.swing.JTable tDH;
    private javax.swing.JTable tDocument;
    private javax.swing.JTable tKaryawan;
    private javax.swing.JTable tLB;
    private javax.swing.JTable tLJA;
    private javax.swing.JTable tSertif;
    private javax.swing.JTextField txtAPHB_LJA;
    private javax.swing.JTextField txtAPHT_LJA;
    private javax.swing.JTextField txtAkta_LJA;
    private javax.swing.JTextArea txtAlamat_DC;
    private javax.swing.JTextArea txtAlamat_DK;
    private javax.swing.JTextField txtBPH_LB;
    private javax.swing.JTextField txtCari_DC;
    private javax.swing.JTextField txtCari_DD;
    private javax.swing.JTextField txtCari_DH;
    private javax.swing.JTextField txtCari_DK;
    private javax.swing.JTextField txtCari_DS;
    private javax.swing.JTextField txtCari_LB;
    private javax.swing.JTextField txtCari_LJA;
    private javax.swing.JTextField txtEmail_DK;
    private javax.swing.JTextField txtHarga_DD;
    private javax.swing.JTextField txtHarga_LB;
    private javax.swing.JTextField txtHibah_LJA;
    private javax.swing.JTextField txtJNA_LB;
    private javax.swing.JTextField txtJabatan_DK;
    private javax.swing.JTextField txtJumlah_LJA;
    private javax.swing.JTextField txtLetak_DS;
    private javax.swing.JTextField txtLetak_LB;
    private javax.swing.JTextField txtLuas_DD;
    private javax.swing.JTextField txtLuas_DS;
    private javax.swing.JTextField txtLuas_LB;
    private javax.swing.JTextField txtNC_DC;
    private javax.swing.JTextField txtNJOP_LB;
    private javax.swing.JTextField txtNOP_LB;
    private javax.swing.JTextField txtNamPem_LB;
    private javax.swing.JTextField txtNamPen_LB;
    private javax.swing.JTextField txtNama_DC;
    private javax.swing.JTextField txtNama_DH;
    private javax.swing.JTextField txtNama_DK;
    private javax.swing.JTextField txtNama_DS;
    private javax.swing.JTextField txtNampem_DD;
    private javax.swing.JTextField txtNampen_DD;
    private javax.swing.JTextField txtNi_DK;
    private javax.swing.JTextField txtNikPen_DD;
    private javax.swing.JTextField txtNik_DC;
    private javax.swing.JTextField txtNikpem_DD;
    private javax.swing.JTextField txtNoAJB_LB;
    private javax.swing.JTextField txtNoTelp_DC;
    private javax.swing.JTextField txtNoTelp_DK;
    private javax.swing.JTextField txtNo_DD;
    private javax.swing.JTextField txtNo_DH;
    private javax.swing.JTextField txtNo_DS;
    private javax.swing.JTextField txtNo_LB;
    private javax.swing.JTextField txtNo_LJA;
    private javax.swing.JTextField txtPekerjaan_DC;
    private javax.swing.JTextField txtSKMHT_LJA;
    private javax.swing.JTextField txtSSB_LB;
    private javax.swing.JTextField txtSSP_LB;
    private javax.swing.JTextField txtSurat_DS;
    private javax.swing.JTextField txtTempat_DK;
    private com.toedter.calendar.JDateChooser txtTgl_DC;
    private com.toedter.calendar.JDateChooser txtTgl_DD;
    private com.toedter.calendar.JDateChooser txt_tgl_DK;
    // End of variables declaration//GEN-END:variables
}
