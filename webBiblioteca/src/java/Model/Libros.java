/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Alumno
 */
public class Libros implements Serializable{
    private String isbn;
    private String titulo;
    private String description;
    private String nombre_autor;
    private Date publicacion;
    private Date fecha_registro;
    private int codigo_categoria;
    private String nit_editorial;

    public Libros() {
        this.isbn = "";
        this.titulo = "";
        this.description = "";
        this.nombre_autor = "";
        this.publicacion = null;
        this.fecha_registro = null;
        this.codigo_categoria = 0;
        this.nit_editorial = "";
    }
    public Libros(String isbn, String titulo, String description, String nombre_autor, Date publicacion, Date fecha_registro, int codigo_categoria, String nit_editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.description = description;
        this.nombre_autor = nombre_autor;
        this.publicacion = publicacion;
        this.fecha_registro = fecha_registro;
        this.codigo_categoria = codigo_categoria;
        this.nit_editorial = nit_editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public Date getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Date publicacion) {
        this.publicacion = publicacion;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(int codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }

    public String getNit_editorial() {
        return nit_editorial;
    }

    public void setNit_editorial(String nit_editorial) {
        this.nit_editorial = nit_editorial;
    }

    public String getlsbn() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
