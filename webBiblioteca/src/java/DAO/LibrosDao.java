/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Libros;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class LibrosDao {
    public static boolean registrar(Libros lib){
        try{
            String SQL="INSERT INTO editoriales(isbn,titulo,descripcion, "
                    + "nombre_autor,publicacion, fecha_registro, "
                    + "codigo_categoria,nit_editorial) values(?,?,?,?,?,?,?,?)";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            st.setString(1, lib.getIsbn());
            st.setString(2, lib.getTitulo());
            st.setString(3, lib.getDescription());
            st.setString(4, lib.getNombre_autor());
            st.setDate(5, (Date) lib.getPublicacion());
            st.setDate(6, (Date) lib.getFecha_registro());
            st.setInt(7, lib.getCodigo_categoria());
            st.setString(8, lib.getNit_editorial());
            if(st.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex){
            return false;
        }
    }
    
    public static ArrayList<Libros> lister(){
        try{
            String SQL="SELECT*FROM libros";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            //st.setString(1, cat.getNombre());
            ResultSet resultado= st.executeQuery();
            ArrayList<Libros> lista=null;
            Libros lib;
                while(resultado.next()){
                    lib= new Libros();
                    lib.setIsbn(resultado.getString("isbn"));
                    lib.setTitulo(resultado.getString("titulo"));
                    lib.setDescription(resultado.getString("descripcion"));
                    lib.setNombre_autor(resultado.getString("nombre_autor"));
                    lib.setPublicacion(resultado.getDate("publicacion"));
                    lib.setFecha_registro(resultado.getDate("descripcion"));
                    lib.setCodigo_categoria(resultado.getInt("codigo_categoria"));
                    lib.setNit_editorial(resultado.getString("nit_editorial"));
                    lista.add(lib);
                }
           return lista;
    } catch (SQLException ex){
        return null;
    }
    }
    
    public static boolean actualizar(Libros lib){
        try{
            String SQL="UPDATE libros SET titulo=?, descripcion=?, "
                    + "nombre_autor=?, publicacion=? descripcion=?,"
                    + "codigo_categoria=?, nit_editorial=?  WHERE isbn=?";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            st.setString(1, lib.getTitulo());
            st.setString(2, lib.getDescription());
            if(st.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex){
            return false;
        }
    }
    
    public static boolean eliminar(Libros lib) throws ClassNotFoundException{
        try{
            String SQL="DELETE categorias WHERE isbn=?";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            st.setString(1, lib.getIsbn());
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
