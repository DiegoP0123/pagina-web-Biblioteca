/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class Conexion{
    
    public static Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Biblioteca","root","");
        } catch (SQLException | ClassNotFoundException ex ) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
        return null;
    }
        
}

   
