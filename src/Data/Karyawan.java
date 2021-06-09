package Data;
/*
    @author llawl
 */
import java.sql.*;
import javax.swing.JOptionPane;
import Data.connect;
public class Karyawan {
    private static Connection conn = new connect().configDB();
    public static void Tambah(String No, String Nama, String Email, String NoTelp, String Alamat, String Tempat, String Tgl, String Agama, String Jabatan){
        String SQL = "insert into karyawan values (?,?,?,?,?,?,?,?,?)";
        try{
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, No);
                State.setString(2, Nama);
                State.setString(3, Email);
                State.setString(4, NoTelp);
                State.setString(5, Alamat);
                State.setString(6, Tempat);
                State.setString(7, Tgl);
                State.setString(8, Agama);
                State.setString(9, Jabatan);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");                
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal Disimpan " +e);
        }
    }
    
    public static void Ubah(String No, String Nama, String Email, String NoTelp, String Alamat, String Tempat, String Tgl, String Agama, String Jabatan){
        String SQL = "update karyawan set Nama=?, Email=?, NoTelp=?, Alamat=?, "
                + "Tempat=?, TglLahir=?, Agama=?, Jabatan=? where NoInduk='"+No+"'";
        try{
            PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, Nama);
                State.setString(2, Email);
                State.setString(3, NoTelp);
                State.setString(4, Alamat);
                State.setString(5, Tempat);
                State.setString(6, Tgl);
                State.setString(7, Agama);
                State.setString(8, Jabatan);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal DiUbah " +e);
        }
    }
    
    public static void Hapus(String No){
        int ok = JOptionPane.showConfirmDialog(null, "Hapus","Request Confirmation",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String SQL = "DELETE FROM karyawan where NoInduk = '"+No+"'";
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
