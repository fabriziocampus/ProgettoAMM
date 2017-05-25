/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Fabrizio
 */
public class UtenteRegistratoFactory {
    
    
    private static UtenteRegistratoFactory singleton;

    public static UtenteRegistratoFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteRegistratoFactory();
        }
        return singleton;
    }
    
    private String connectionString;
      
      public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }

    private ArrayList<UtenteRegistrato> listaUtenti = new ArrayList<UtenteRegistrato>();


    public UtenteRegistrato getUtenteById(int id) {
       
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "fabrizio", "fabrizio");
            
            String query = 
                      "select * from UtenteRegistrato "
                    + "where UtenteRegistrato_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                UtenteRegistrato current = new UtenteRegistrato();
                current.setId(res.getInt("UtenteRegistrato_id"));
                current.setNome(res.getString("UtenteRegistrato_name"));
                current.setCognome(res.getString("UtenteRegistrato_surname"));
                current.setUrlimg(res.getString("UrlImg"));
                current.setData(res.getString("Date"));
                current.setFrase(res.getString("Frase"));
                current.setEmail(res.getString("Email"));
                current.setPassword(res.getString("Password"));
                current.setConfermapsw(res.getString("ConfermaPsw"));
            

                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password){
   try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "fabrizio", "fabrizio");
            
            String query = 
                      "select UtenteRegistrato_id from UtenteRegistrato "
                    + "where UtenteRegistrato_name = ? and Password = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, user);
            stmt.setString(2, password);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                int id = res.getInt("UtenteRegistrato_id");

                stmt.close();
                conn.close();
                return id;
                //return 1;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
}

}
