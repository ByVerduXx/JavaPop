
package javapop;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class Venta implements Serializable, Comparable<Venta> {
    //Atributos
    private LocalDate fecha;
    private Producto producto;
    private String nombreVend;
    private String dniVend;
    private String nombreComp;
    private String dniComp;
    
    //Contructores

    public Venta(LocalDate fecha, Producto producto, String nombreVend, String dniVend, String nombreComp, String dniComp) {
        this.fecha = fecha;
        this.producto = producto;
        this.nombreVend = nombreVend;
        this.dniVend = dniVend;
        this.nombreComp = nombreComp;
        this.dniComp = dniComp;
    }

    public Venta() {
    }
    
    //métodos

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getNombreVend() {
        return nombreVend;
    }

    public void setNombreVend(String nombreVend) {
        this.nombreVend = nombreVend;
    }

    public String getNombreComp() {
        return nombreComp;
    }

    public void setNombreComp(String nombreComp) {
        this.nombreComp = nombreComp;
    }

    public String getDniComp() {
        return dniComp;
    }

    public void setDniComp(String dniComp) {
        this.dniComp = dniComp;
    }

    public String getDniVend() {
        return dniVend;
    }

    public void setDniVend(String dniVend) {
        this.dniVend = dniVend;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.dniVend);
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
        final Venta other = (Venta) obj;
        if (!Objects.equals(this.nombreVend, other.nombreVend)) {
            return false;
        }
        if (!Objects.equals(this.dniVend, other.dniVend)) {
            return false;
        }
        if (!Objects.equals(this.nombreComp, other.nombreComp)) {
            return false;
        }
        if (!Objects.equals(this.dniComp, other.dniComp)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }


    @Override
    public int compareTo(Venta v) {
        return fecha.compareTo(v.getFecha());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
        String fn = fecha.format(formatoCorto);
        return "Venta realizada a fecha de "+fn+"\n"+
                "Producto comprado->"+producto.getTitulo()+"\n"+
                "Comprador->"+nombreComp+" con DNI "+dniComp+"\n"+
                "Vendedor->"+nombreVend+" con DNI "+dniVend;
    }
    
    
}
