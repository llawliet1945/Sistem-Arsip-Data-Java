package Data;
/*
    @author llawl
 */
import java.sql.*;
import javax.swing.JOptionPane;
import Data.connect;
public class Document {
    private static Connection conn = new connect().configDB();
    public static void Tambah(String No, String NamPen, String NikPen, String NamPem,
        String NikPem, String Tgl, int Luas, long Harga){
        String SQL = "insert into Document values (?,?,?,?,?,?,?,?)";
        try{
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, No);
                State.setString(2, NamPen);
                State.setString(3, NikPen);
                State.setString(4, NamPem);
                State.setString(5, NikPem);
                State.setString(6, Tgl);
                State.setInt(7, Luas);
                State.setLong(8, Harga);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");                
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal Disimpan " +e);
        }
    }
    
    public static void Ubah(String No, String NamPen, String NikPen, String NamPem,
        String NikPem, String Tgl, int Luas, long Harga){
        String SQL = "update document set Nama_Penjual=?, NIK_Penjual=?, Nama_Pembeli=?, "
                + "NIK_Pembeli=?, Tgl=?, Luas=?, Harga=? where NoDocument='"+No+"'";
        try{
            PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, NamPen);
                State.setString(2, NikPen);
                State.setString(3, NamPem);
                State.setString(4, NikPem);
                State.setString(5, Tgl);
                State.setInt(6, Luas);
                State.setLong(7, Harga);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal DiUbah " +e);
        }
    }
    
    public static void Hapus(String No){
        int ok = JOptionPane.showConfirmDialog(null, "Hapus","Request Confirmation",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String SQL = "DELETE FROM Document where NoDocument = '"+No+"'";
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
