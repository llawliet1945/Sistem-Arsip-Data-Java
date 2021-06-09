package Data;
/*
    @author llawl
 */
import java.sql.*;
import javax.swing.JOptionPane;
import Data.connect;
public class LB {
    private static Connection conn = new connect().configDB();
    public static void Tambah(String No, String AJB, String Tgl, String BPH, 
            String Nampen, String Nampem, String JNH, String Letak, int Luas,
            long Harga, String NOP, String NJOP, String SSP, String SSB){
        String SQL = "insert into lb values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, No);
                State.setString(2, AJB);
                State.setString(3, Tgl);
                State.setString(4, BPH);
                State.setString(5, Nampen);
                State.setString(6, Nampem);
                State.setString(7, JNH);
                State.setString(8, Letak);
                State.setInt(9, Luas);
                State.setLong(10, Harga);
                State.setString(11, NOP);
                State.setString(12, NJOP);
                State.setString(13, SSP);
                State.setString(14, SSB);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");                
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal Disimpan " +e);
        }
    }
    
    public static void Ubah(String No, String AJB, String Tgl, String BPH, 
            String Nampen, String Nampem, String JNH, String Letak, int Luas,
            long Harga, String NOP, String NJOP, String SSP, String SSB){
        String SQL = "update lb set AJB=?, Tgl=?, BPH=?, NamPen=?, "
                + "NamPem=?, JNH=?, Letak=?, Luas=?, Harga=?, NOP=?, NJOP=?, "
                + "SSP=?, SSB=? where NoUrut='"+No+"'";
        try{
            PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, AJB);
                State.setString(2, Tgl);
                State.setString(3, BPH);
                State.setString(4, Nampen);
                State.setString(5, Nampem);
                State.setString(6, JNH);
                State.setString(7, Letak);
                State.setInt(8, Luas);
                State.setLong(9, Harga);
                State.setString(10, NOP);
                State.setString(11, NJOP);
                State.setString(12, SSP);
                State.setString(13, SSB);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal DiUbah " +e);
        }
    }
    
    public static void Hapus(String No){
        int ok = JOptionPane.showConfirmDialog(null, "Hapus","Request Confirmation",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String SQL = "DELETE FROM lb where NoUrut = '"+No+"'";
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
