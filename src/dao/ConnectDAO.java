/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConnectDAO {
        public Connection connectDB(){
        
        try {
        
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ bancoDeDadosUC11 ",
                    "root",
                    "Pc_070906");
            return conn;
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + e.getMessage());
            return null;
        }
        
    
        }
}
