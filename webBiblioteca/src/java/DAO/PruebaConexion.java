/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

public class PruebaConexion {
    
    public static void main (String[]args){
        Conexion con = new Conexion();
        
        if(con!=null){
            System.out.println("Conectado");
        } else {
            System.out.println("Desconectado");
        }
    }
}
