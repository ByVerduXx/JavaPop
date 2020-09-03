
package javapop;

import java.io.Serializable;


public class ClientePro extends Cliente implements Serializable {
    
    private String descripcion;
    private String horario;
    private long tlf;
    private String web;
    
    //constructores

    public ClientePro(String correo, String clave, String dni, String nombre, String postal, String ciudad, String tarjeta, String descripcion, String horario, long tlf, String web) {
        super(correo, clave, dni, nombre, postal, ciudad, tarjeta);
        this.descripcion = descripcion;
        this.horario = horario;
        this.tlf = tlf;
        this.web = web;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public long getTlf() {
        return tlf;
    }

    public void setTlf(long tlf) {
        this.tlf = tlf;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Override
    public String toString() {
        return super.toString() + "\n#Datos del cliente profesional#\n"
                + "Descripción->" + descripcion + "\n"
                + "Horario->" + horario + "\n"
                + "Telefono->" + tlf + "\n"
                + "Web->" + web;
    }
    
}
