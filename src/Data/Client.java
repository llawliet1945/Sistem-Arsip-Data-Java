package Data;
/*
    @author llawl
 */

import java.sql.*;
import javax.swing.JOptionPane;
import Data.connect;
public class Client {
    private static Connection conn = new connect().configDB();
    
    public static void Tambah(String No, String Nama, String NIK, String NoTelp,
            String Alamat, String Pekerjaan, String Status, String Tgl){
        String SQL = "insert into client values (?,?,?,?,?,?,?,?)";
        try{
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, No);
                State.setString(2, Nama);
                State.setString(3, NIK);
                State.setString(4, NoTelp);
                State.setString(5, Alamat);
                State.setString(6, Pekerjaan);
                State.setString(7, Status);
                State.setString(8, Tgl);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");                
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal Disimpan " +e);
        }
    }
    
    public static void Ubah(String No, String Nama, String NIK, String NoTelp, 
            String Alamat, String Pekerjaan, String Status, String Tgl){
        String SQL = "update client set Nama=?, NIK=?, NoTelp=?, Alamat=?, "
                + "Pekerjaan=?, Status=?, Tgl=? where NoClient='"+No+"'";
        try{
            PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, Nama);
                State.setString(2, NIK);
                State.setString(3, NoTelp);
                State.setString(4, Alamat);
                State.setString(5, Pekerjaan);
                State.setString(6, Status);
                State.setString(7, Tgl);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal DiUbah " +e);
        }
    }
    
    public static void Hapus(String No){
        int ok = JOptionPane.showConfirmDialog(null, "Hapus","Request Confirmation",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String SQL = "DELETE FROM Client where NoClient = '"+No+"'";
            try{
                PreparedStatement State = conn.prepareStatement(SQL);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil DiHapus");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Data gagal DiHapus " +e);
            }
        }
    }
}
