/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Categoria;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author Alumno
 */
public class CategoriaDao {
    public static boolean registrar(Categoria cat){
        try{
            String SQL="INSERT INTO categorias(nombre) values(?)";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            st.setString(1, cat.getNombre());
            if(st.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex){
            return false;
        }
    }
    
    public static ArrayList<Categoria> lister(){
        try{
            String SQL="SELECT*FROM categorias";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            //st.setString(1, cat.getNombre());
            ResultSet resultado= st.executeQuery();
            ArrayList<Categoria> lista=null;
            Categoria cat;
                while(resultado.next()){
                    cat= new Categoria();
                    cat.setCodigo(resultado.getInt("codigo"));
                    cat.setNombre(resultado.getString("nombre"));
                    lista.add(cat);
                }
           return lista;
    } catch (SQLException ex){
        return null;
    }
    }
    
    public static boolean actualizar(Categoria cat){
        try{
            String SQL="UPDATE categorias SET nombre=? WHERE codigo=? ";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            st.setInt(2, cat.getCodigo());
            st.setString(1, cat.getNombre());
            if(st.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex){
            return false;
        }
    }
    
    public static boolean eliminar(Categoria cat) throws ClassNotFoundException{
        try{
            String SQL="DELETE categorias WHERE codigo=?";
            Connection con= Conexion.conectar();
            PreparedStatement st= con.prepareStatement(SQL);
            st.setInt(1, cat.getCodigo());
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
