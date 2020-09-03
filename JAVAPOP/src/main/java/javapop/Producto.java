
package javapop;
import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;
import javax.swing.ImageIcon;

public class Producto implements Serializable, Comparable<Producto> {
    
    private String titulo;
    private String descripcion;
    private String categoria;
    private String estado;
    private double precio;
    private LocalDate fecha;
    private ImageIcon imagen;
    private String postal;
    private String ciudad;
    private boolean urgente;
    private Cliente client;
    
    //constructores

    public Producto(String titulo, String descripcion, String categoria, String estado, double precio, LocalDate fecha, ImageIcon imagen, String postal, String ciudad, boolean urgente, Cliente client) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
        this.fecha = fecha;
        this.imagen = imagen;
        this.postal = postal;
        this.ciudad = ciudad;
        this.urgente = urgente;
        this.client = client;
    }

    public Producto(String titulo, String descripcion, String categoria, String estado, double precio, LocalDate fecha, boolean urgente, Cliente client) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
        this.fecha = fecha;
        this.urgente = urgente;
        this.client = client;
        this.postal = client.getPostal();
        this.ciudad = client.getCiudad();
    }
    
    

    public Producto() {
    }
    
    //métodos

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.urgente != other.urgente) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.postal, other.postal)) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        return true;
    }


    

 

    @Override
    public int compareTo(Producto p) {
        return titulo.compareTo(p.titulo);
    }

    @Override
    public String toString() {
        return "Titulo-> " + titulo+"\n"+
               "Descripcion-> " + descripcion+"\n"+
               "Categoria-> " + categoria+"\n"+
               "Estado-> " + estado+"\n"+
               "Precio-> " + precio + "€"+"\n"+
               "Urgente-> " + urgente+"\n"+
               "Propietario->" + client.getNombre()+"\n" + 
               "Ubicación ->" + postal + ", " + ciudad;
    }
        
}
