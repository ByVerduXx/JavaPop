
package javapop;
import java.io.Serializable;
import java.util.*;


public class Cliente implements Serializable, Comparable<Cliente> {
    
    private String correo;
    private String clave;
    private String dni;
    private String nombre;
    private String postal;
    private String ciudad;
    private String tarjeta;
    private ArrayList<Producto> productos;
    
    //constructores

    public Cliente(String correo, String clave, String dni, String nombre, String postal, String ciudad, String tarjeta) {
        this.correo = correo;
        this.clave = clave;
        this.dni = dni;
        this.nombre = nombre;
        this.postal = postal;
        this.ciudad = ciudad;
        this.tarjeta = tarjeta;
        this.productos = new ArrayList<>();
    }
    
    public Cliente(){
    }
    
    //metodos

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    public boolean añadirProducto(Producto p){
        if (!this.productos.contains(p)){
            this.productos.add(p);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean borrarProducto(Producto p){
        if (this.productos.contains(p)){
            this.productos.remove(p);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "DNI->" + dni + "\n"
             + "Nombre->" + nombre + "\n"
             + "Correo electronico->" + correo + "\n"
             + "Contraseña->" + clave + "\n"
             + "Código Postal->" + postal + "\n"
             + "Localidad->" + ciudad + "\n"
             + "Tarjeta de Crédito->" + tarjeta;
    }

    @Override
    public int compareTo(Cliente c) {
        return dni.compareTo(c.dni);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.dni);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.dni, other.dni) && !Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return true;
    }


    
    
}
