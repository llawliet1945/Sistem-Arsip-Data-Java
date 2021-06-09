package Data;
/*
    @author llawl
 */
import java.sql.*;
import javax.swing.JOptionPane;
import Data.connect;
public class LJA {
    private static Connection conn = new connect().configDB();
    public static void Tambah(String No, String Akta, String Hibah, String APHB, String APHT,
            String SKMHT, int Jumlah){
        String SQL = "insert into lja values (?,?,?,?,?,?,?)";
        try{
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, No);
                State.setString(2, Akta);
                State.setString(3, Hibah);
                State.setString(4, APHB);
                State.setString(5, APHT);
                State.setString(6, SKMHT);
                State.setInt(7, Jumlah);                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");                
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal Disimpan " +e);
        }
    }
    
    public static void Ubah(String No, String Akta, String Hibah, String APHB, String APHT,
            String SKMHT, int Jumlah){
        String SQL = "update lja set Akta=?, Hibah=?, APHB=?, "
                + " APHT=?, SKMHT=?, Jumlah=? where No='"+No+"'";
        try{
            PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, Akta);
                State.setString(2, Hibah);
                State.setString(3, APHB);
                State.setString(4, APHT);
                State.setString(5, SKMHT);
                State.setInt(6, Jumlah);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal DiUbah " +e);
        }
    }
    
    public static void Hapus(String No){
        int ok = JOptionPane.showConfirmDialog(null, "Hapus","Request Confirmation",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String SQL = "DELETE FROM lja where No = '"+No+"'";
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
