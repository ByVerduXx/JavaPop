
package javapop;

import java.io.Serializable;
import java.util.Objects;

public class Admin implements Serializable{
    
    private final String clave;
    private final String correo;
    
    //constructor
    public Admin(){
        this.clave = "admin";
        this.correo = "admin@javapop.com";            
    }
    //metodos
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.clave);
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
        final Admin other = (Admin) obj;
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Admin{" + "clave=" + clave + ", correo=" + correo + '}';
    }
    
}
