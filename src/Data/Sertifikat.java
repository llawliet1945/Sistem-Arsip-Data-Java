package Data;

/*
 * @author llawl
 */
import java.sql.*;
import javax.swing.JOptionPane;
import Data.connect;
public class Sertifikat {
    private static Connection conn = new connect().configDB();
    public static void Tambah(String No, String Nama, String Letak, String Surat, int Luas){
        String SQL = "insert into sertifikat values (?,?,?,?,?)";
        try{
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, No);
                State.setString(2, Nama);
                State.setString(3, Letak);
                State.setString(4, Surat);
                State.setInt(5, Luas);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");                
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal Disimpan " +e);
        }
    }
    
    public static void Ubah(String No, String Nama, String Letak, String Surat, int Luas){
        String SQL = "update sertifikat set Nama=?, Letak_Tanah=?, Surat_Ukur=?, "
                + " Luas_Tanah=? where NoUrut='"+No+"'";
        try{
            PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, Nama);
                State.setString(2, Letak);
                State.setString(3, Surat);
                State.setInt(4, Luas);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal DiUbah " +e);
        }
    }
    
    public static void Hapus(String No){
        int ok = JOptionPane.showConfirmDialog(null, "Hapus","Request Confirmation",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String SQL = "DELETE FROM sertifikat where NoUrut = '"+No+"'";
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
