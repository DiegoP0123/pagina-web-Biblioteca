/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Editoriales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class EditorialesDao {
    public static boolean registrar(Editoriales edi){
        try{
            String SQL="INSERT INTO editoriales(nit,nombre,telefono,direccion,"
                    + "email,sitioweb) values(?,?,?,?,?,?)";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            st.setString(1, edi.getNit());
            st.setString(2, edi.getNombre());
            st.setString(3, edi.getTelefono());
            st.setString(4, edi.getDireccion());
            st.setString(5, edi.getEmail());
            st.setString(6, edi.getSitioweb());
            if(st.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex){
            return false;
        }
    }
    
    public static ArrayList<Editoriales> lister(){
        try{
            String SQL="SELECT*FROM EDITORIALES";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            //st.setString(1, cat.getNombre());
            ResultSet resultado= st.executeQuery();
            ArrayList<Editoriales> lista=null;
            Editoriales edi;
                while(resultado.next()){
                    edi= new Editoriales();
                    edi.setNit(resultado.getString("nit"));
                    edi.setNombre(resultado.getString("nombre"));
                    edi.setTelefono(resultado.getString("telefono"));
                    edi.setDireccion(resultado.getString("direccion"));
                    edi.setEmail(resultado.getString("email"));
                    edi.setSitioweb(resultado.getString("sitioweb"));
                    
                    lista.add(edi);
                }
           return lista;
    } catch (SQLException ex){
        return null;
    }
    }
    
    public static boolean actualizar(Editoriales edi){
        try{
            String SQL="UPDATE categorias SET nombre=? telefono=? "
                    + "direccion=? email=? sitio_web=? WHERE nit=?";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            st.setString(1, edi.getNombre());
            st.setString(2, edi.getTelefono());
            st.setString(3, edi.getDireccion());
            st.setString(4, edi.getEmail());
            st.setString(5, edi.getSitioweb());
            st.setString(6, edi.getNit());
            if(st.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex){
            return false;
        }
    }
    
    public static boolean eliminar(Editoriales edi){
        try{
            String SQL="DELETE categorias WHERE nit=?";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            st.setString(1, edi.getNit());
            if (st.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
    }catch (SQLException ex){
        return false;
    }
    }
}
