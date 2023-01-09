/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implements;

import Pojo.Akun;
import Pojo.Pegawai;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.ConnectionManager;
import Service.AkunService;

/**
 *
 * @author DARARI
 */
public class AkunImplements implements AkunService{
     private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
   
    

    @Override
    public Pegawai login(String username, String password) {
       Pegawai pegawai = null;
        Akun akun = null;
        String sql = "SELECT pw.id, pw.nama, pw.umur,pw.jenis_kelamin,pw.departemen,pw.nomor_telepon,pw.alamat, "
                + "ak.id, ak.email, ak.username,ak.password, ak.level "
                + "FROM pegawai pw, akun ak "
                + "WHERE pw.id_akun = ak.id_akun "
                + "AND ak.username = '"+username+"' "
                + "AND ak.password = '"+password+"'";
         conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                pegawai = new Pegawai();
                pegawai.setId(rs.getInt("id"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.setUmur(rs.getInt("umur"));
                pegawai.setJenisKelamin(rs.getString("jenis_kelamin"));
                pegawai.setNomorTelepon(rs.getString("nomor_telepon"));
                pegawai.setAlamat(rs.getString("alamat"));
                akun = new Akun();
                akun.setId(rs.getInt("id"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                akun.setPassword(rs.getString("password"));
                akun.setLevel(rs.getString("level"));
                pegawai.setAkun(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiImplement.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return pegawai;
    }
    
}
   
        


