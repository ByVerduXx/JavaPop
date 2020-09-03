
package javapop;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utilidad {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static ArrayList<Venta> ventas = new ArrayList<>();
    private static Cliente cliente;
    private static Venta venta;
    private static Cliente logged;
    
    
    public static void setClientes(ArrayList<Cliente> c){
        clientes = c;
    }
    public static void setProductos(ArrayList<Producto> p){
        productos = p;
    }
    public static void setVentas(ArrayList<Venta> v){
        ventas = v;
    }
//ordenamos los clientes, productos y ventas y los devolvemos
    
    public static ArrayList<Cliente> getClientes() {
        Comparator NomCliComp = new Comparator() {
            
            @Override
            public int compare(Object o1, Object o2) {
                Cliente c1 = (Cliente) o1;
                Cliente c2 = (Cliente) o2;
                return c1.getNombre().compareTo(c2.getNombre());
            }
        };
        Collections.sort(clientes, NomCliComp);
        return clientes;
    }
    
    public static ArrayList<Producto> getProductos() {
        Comparator NomProdComp = new Comparator() {
            
            @Override
            public int compare(Object o1, Object o2) {
                Producto p1 = (Producto) o1;
                Producto p2 = (Producto) o2;
                return p1.getTitulo().compareTo(p2.getTitulo());
            }
        };
        Collections.sort(productos, NomProdComp);
        return productos;
    }

    public static ArrayList<Venta> getVentas() {
        Comparator FechVentComp = new Comparator() {
            
            @Override
            public int compare(Object o1, Object o2) {
                Venta v1 = (Venta) o1;
                Venta v2 = (Venta) o2;
                return v1.getFecha().compareTo(v2.getFecha());
            }
        };
        Collections.sort(ventas, FechVentComp);
        return ventas;
    }

    public static Cliente getLogged() {
        return logged;
    }

    public static void setLogged(Cliente logged) {
        Utilidad.logged = logged;
    }
    
    /** Da de alta un cliente
     * @param c
     * @return  boolean */
    public static boolean registroCliente(Cliente c){
        if (!clientes.contains(c)){
            clientes.add(c);
            return true;
        }
        else{
            return false;
        }
    }
    
    /** Da de baja un cliente
     * @param c
     * @return  boolean */
    public static boolean bajaCliente(Cliente c){
        if (clientes.contains(c)){
            int i;
            ArrayList<Producto> prods = c.getProductos();
            
            for (i = 0;i<prods.size();i++){ //si eliminamos a un cliente tenemos que eliminar tambien todos sus productos
                Producto producto = prods.get(i);
                productos.remove(producto);
            }
            clientes.remove(c);
            return true;
        }
        else {return false;}
    }
    
    /** Da de alta un producto, añadiendolo tambien al array de productos del cliente logeado
     * @param p
     * @return  boolean */
    public static boolean subirProducto(Producto p){
        boolean verifica = false;
        
        if (!productos.contains(p)){
            if (logged.añadirProducto(p)){ 
                Utilidad.productos.add(p);
                verifica = true;
            }
        }
        return verifica;
    }
    
    /** Da de alta un producto, añadiendolo tambien al array de productos de un cliente específico
     * @param c
     * @param p
     * @return  boolean */
    public static boolean subirProducto(Cliente c, Producto p){
        boolean verifica = false;
        
        if (!productos.contains(p)){
            if (c.añadirProducto(p)){ 
                Utilidad.productos.add(p);
                verifica = true;
            }
        }
        return verifica;
    }
    
    /** Elimina un producto, eliminandolo tambien del array de productos de un cliente específico
     * @param c
     * @param p
     * @return  boolean */
    public static boolean eliminarProducto(Cliente c, Producto p){ 
        boolean verifica = false; 
        
        if (productos.contains(p)){
            c.borrarProducto(p);
            productos.remove(p);
            verifica = true;
        }
        return verifica;
    }
    
    /** Logea a un cliente, seteandolo como logged.
     * @param correo
     * @param pass
     * @return  boolean */
    public static boolean login(String correo, String pass){
        boolean verifica = false;
        String email, contra;
        
        for (int i = 0;i<clientes.size();i++){
            email = clientes.get(i).getCorreo();
            contra = clientes.get(i).getClave();
            if (correo.equals(email) && pass.equals(contra)){
                setLogged(clientes.get(i)); //ponemos al cliente loggeado en logged, para saber que cliente está interactuando
                verifica = true;
                break;
                
            }
        }
        return verifica;
    }
    
    /** Ordena un arraylist de productos en funcion de la categoria y las palabras clave, pero sin tener en cuenta el C.P. Función pensada para el admin
     * @param busqueda
     * @param categoria
     * @return  resultado */
    public static ArrayList<Producto> busquedaProductosAdmin(String busqueda, String categoria){ 
        //la del admin no la ordena por urgentes
        ArrayList<Producto> resultado = new ArrayList();
        ArrayList<String> palabras = new ArrayList();
        StringTokenizer tokens = new StringTokenizer(busqueda);
        
        if (busqueda.equals("")){
            for (Producto producto : productos){
                if (producto.getCategoria().equals(categoria)){
                    if(!resultado.contains(producto)){
                        resultado.add(producto);
                    }
                }
            }
        }
        else{
            while (tokens.hasMoreTokens()){
                palabras.add(tokens.nextToken());
            }

            for (String palabra : palabras){
                for (Producto producto : productos){
                    String txt = producto.getTitulo();
                    if (txt.contains(palabra) && producto.getCategoria().equals(categoria)){
                        if (!resultado.contains(producto)){
                            resultado.add(producto);
                        }
                    }
                }
            }
        }
        return resultado;
    }
    
    /** Ordena un arraylist de productos en funcion de la categoria y las palabras clave teniendo en cuenta el C.P y la urgencia de los productos
     * @param busqueda
     * @param categoria
     * @return  resultado */
    public static ArrayList<Producto> busquedaProductos(String busqueda, String categoria){ 
        
        ArrayList<Producto> resultado = new ArrayList();
        
        ArrayList<Producto> urgente = new ArrayList();
        ArrayList<Producto> noUrgente = new ArrayList();
        
        ArrayList<Producto> urgenteOrd = new ArrayList();
        ArrayList<Producto> noUrgenteOrd = new ArrayList();
        
        ArrayList<String> palabras = new ArrayList();
        StringTokenizer tokens = new StringTokenizer(busqueda);
        
        if (busqueda.equals("")){
            for (Producto producto : productos){
                if (producto.getCategoria().equals(categoria)){
                    if (producto.isUrgente()){
                        if(!urgente.contains(producto)){
                            urgente.add(producto);
                        }
                    }
                    else{
                        if(!noUrgente.contains(producto)){
                            noUrgente.add(producto);
                        }
                    }
                }
            }
        }
        else{
            while (tokens.hasMoreTokens()){
                palabras.add(tokens.nextToken());
            }

            for (String palabra : palabras){
                for (Producto producto : productos){
                    String txt = producto.getTitulo();
                    if (txt.contains(palabra) && producto.getCategoria().equals(categoria)){
                        if(producto.isUrgente()){
                            if (!urgente.contains(producto)){
                                urgente.add(producto);
                            }
                        }
                        else{
                            if (!noUrgente.contains(producto)){
                                noUrgente.add(producto);
                            }
                        }
                    }
                }
            }
        }
        String codigo = logged.getPostal();
        codigo = codigo.substring(0, 3);
        for(Producto prod : urgente){
            String aux = prod.getPostal().substring(0, 3);
            if (codigo.equals(aux)){
                if (!urgenteOrd.contains(prod)){
                    urgenteOrd.add(prod);
                }
            }
        }
        for(Producto prod : noUrgente){
            String aux = prod.getPostal().substring(0, 3);
            if (codigo.equals(aux)){
                if (!noUrgenteOrd.contains(prod)){
                    noUrgenteOrd.add(prod);
                }
            }
        }
        codigo = codigo.substring(0,2);
        
        for(Producto prod : urgente){
            String aux = prod.getPostal().substring(0, 2);
            if (codigo.equals(aux)){
                if (!urgenteOrd.contains(prod)){
                    urgenteOrd.add(prod);
                }
            }
        }
        for(Producto prod : noUrgente){
            String aux = prod.getPostal().substring(0, 2);
            if (codigo.equals(aux)){
                if (!noUrgenteOrd.contains(prod)){
                    noUrgenteOrd.add(prod);
                }
            }
        }
        
        codigo = codigo.substring(0,1);
        
        for(Producto prod : urgente){
            String aux = prod.getPostal().substring(0, 1);
            if (codigo.equals(aux)){
                if (!urgenteOrd.contains(prod)){
                    urgenteOrd.add(prod);
                }
            }
        }
        for(Producto prod : noUrgente){
            String aux = prod.getPostal().substring(0, 1);
            if (codigo.equals(aux)){
                if (!noUrgenteOrd.contains(prod)){
                    noUrgenteOrd.add(prod);
                }
            }
        }
        
        for(Producto prod : urgente){

            if (!urgenteOrd.contains(prod)){
                urgenteOrd.add(prod);
            }
            
        }
        for(Producto prod : noUrgente){
            if (!noUrgenteOrd.contains(prod)){
                noUrgenteOrd.add(prod);
            }
            
        }
        for (Producto prod : urgenteOrd){
            if(!resultado.contains(prod)){
                resultado.add(prod);
            }  
        }
        for (Producto prod : noUrgenteOrd){
            if(!resultado.contains(prod)){
                resultado.add(prod);
            }  
        }  
        return resultado;
    }
    
    /** Comprueba si los productos urgentes han pasado sus 7 días y si es así los cambia a no urgentes */
    public static void comprobarUrgente(){
        LocalDate fechaActual = LocalDate.now();
        for (Producto producto : productos){
            if(producto.isUrgente()){
                LocalDate fechaSubida = producto.getFecha();
                fechaSubida.plusDays(7);
                if(fechaSubida.compareTo(fechaActual)== 1){
                    producto.setUrgente(false);
                }
            }
        }
    }
    
    /** Si el vendedor acepta la compra, el producto pasa a eliminarse, se crea una venta y se genera la ficha de la venta.
     * @param vendedor
     * @param producto
     * @param aceptar
     * @return  boolean */
    public static boolean compraProducto(Cliente vendedor, Producto producto, boolean aceptar){
        //el cliente comprador es el logeado, por tanto no es necesario ponerlo de argumento
        boolean vendido = false;
        
        if(aceptar){
            LocalDate fecha = LocalDate.now();
            String nombreVend,dniVend,nombreComp,dniComp;
            nombreVend = vendedor.getNombre();
            dniVend = vendedor.getDni();
            nombreComp = logged.getNombre();
            dniComp = logged.getDni();
            
            venta = new Venta(fecha,producto,nombreVend,dniVend,nombreComp,dniComp);
            if (eliminarProducto(vendedor,producto)){
                vendido = true;
                ventas.add(venta);
                generarFicha(venta);
            }
            
               
        }
        return vendido;
    }
    
    /** Mejora un cliente a cliente profesional
     * @param c
     * @param descripcion
     * @param web
     * @param tlf
     * @param horario
     * @return  boolean */
    public static boolean mejoraCliente(Cliente c, String descripcion, String web, long tlf, String horario){
        String correo, clave, dni, nombre, postal, ciudad, tarjeta;
        ArrayList<Producto> prods;
        try{
            correo = c.getCorreo();
            clave = c.getClave();
            dni = c.getDni();
            nombre = c.getNombre();
            postal = c.getPostal();
            ciudad = c.getCiudad();
            tarjeta = c.getTarjeta();
            prods = c.getProductos();
            cliente = new ClientePro(correo, clave, dni, nombre, postal, ciudad, tarjeta, descripcion, horario, tlf, web);
            cliente.setProductos(prods);
            clientes.remove(c);
            clientes.add(cliente);
            setLogged(cliente);
            return true;
            }
        catch(Exception e){
            return false;
        }
    }
    
    /** Cambia los datos de un cliente profesional
     * @param c
     * @param descripcion
     * @param web
     * @param tlf
     * @param horario
     * @return  boolean */
    public static boolean modificarDatosPro(ClientePro c, String descripcion, String web, long tlf, String horario ){
        try{
            c.setDescripcion(descripcion);
            c.setWeb(web);
            c.setTlf(tlf);
            c.setHorario(horario);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    /** Busca las ventas realizadas a partir de una fecha dada
     * @param fecha
     * @return  ordenadas */
    public static ArrayList<Venta> busquedaVentas(LocalDate fecha){
        ArrayList<Venta> ordenadas = new ArrayList();
        Comparator VentaCompara = new Comparator(){
             @Override
            public int compare(Object o1, Object o2) {
                Venta v1 = (Venta) o1;
                Venta v2 = (Venta) o2;
                return v1.getFecha().compareTo(v2.getFecha());
            }
        };
        Collections.sort(ventas, VentaCompara);
        Venta vent = new Venta();
        vent.setFecha(fecha);
        int pos = Collections.binarySearch(ventas, vent, VentaCompara); 
        if(pos >= 0){
            for (int i = pos; i<ventas.size();i++){
                ordenadas.add(ventas.get(i));
            }
        }
        else{
            pos = (pos+1)*(-1);
            for (int i = pos; i<ventas.size();i++){
                ordenadas.add(ventas.get(i));
            }
        }
        return ordenadas;
    }
    
    /** Devuelve todas las ventas realizadas ordenadas por fecha
     * @return  ordenadas */
    public static ArrayList<Venta> busquedaVentas(){
        ArrayList<Venta> ordenadas = new ArrayList();
        Comparator VentaCompara = new Comparator(){
             @Override
            public int compare(Object o1, Object o2) {
                Venta v1 = (Venta) o1;
                Venta v2 = (Venta) o2;
                return v1.getFecha().compareTo(v2.getFecha());
            }
        };
        ordenadas = ventas;
        Collections.sort(ordenadas, VentaCompara);
        
        return ordenadas;
    }
    
    /** Crea un fichero de texto de tipo "nombreDelProducto.txt" con los datos de la venta
     * @param v*/
    public static void generarFicha(Venta v){
        PrintWriter salida;
        try {
            salida = new PrintWriter(new BufferedWriter(new FileWriter(v.getProducto().getTitulo() + ".txt")));
        
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
        String fn = v.getFecha().format(formatoCorto);
        
        salida.println("-------------------------------- Ficha Venta --------------------------------");
        salida.println("\n");
        salida.println("Fecha de la venta: " + fn);
        salida.println("\n");
        salida.println("Datos del producto: " + v.getProducto().toString());
        salida.println("\n");
        salida.println("Datos del vendedor:");
        salida.println("Nombre: " + v.getNombreVend());
        salida.println("DNI: " + v.getDniVend());
        salida.println("\n");
        salida.println("Datos del comprador:");
        salida.println("Nombre: " + v.getNombreComp());
        salida.println("DNI: " + v.getDniComp());
        salida.println("\n");
        salida.println("-------------------------------------------------------------------------------");
        salida.close();
        }
        catch (IOException ex) {
            Logger.getLogger(Utilidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /** Carga los datos de los clientes, productos y ventas de los ficheros */
    public static void cargarDatos() {
        try {

            FileInputStream istreamCli = new FileInputStream("clientes.dat");
            ObjectInputStream oisCli = new ObjectInputStream(istreamCli);
            
            clientes = (ArrayList) oisCli.readObject();
            istreamCli.close();
            
            FileInputStream istreamProd = new FileInputStream("productos.dat");
            ObjectInputStream oisProd = new ObjectInputStream(istreamProd);
            
            productos = (ArrayList) oisProd.readObject();
            istreamProd.close();
            
            FileInputStream istreamVent = new FileInputStream("ventas.dat");
            ObjectInputStream oisVent = new ObjectInputStream(istreamVent);
            
            ventas = (ArrayList) oisVent.readObject();
            istreamVent.close();  
            
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos
    
    /** Guarda los datos de los clientes, productos y ventas en los ficheros */
    public static void guardarDatos() {
        try {

            if (!clientes.isEmpty()) {
                
                FileOutputStream ostreamCli = new FileOutputStream("clientes.dat");
                ObjectOutputStream oosCli = new ObjectOutputStream(ostreamCli);
                
                oosCli.writeObject(clientes);
                ostreamCli.close();
            } 
            if (!productos.isEmpty()){
                FileOutputStream ostreamProd = new FileOutputStream("productos.dat");
                ObjectOutputStream oosCli = new ObjectOutputStream(ostreamProd);
                
                oosCli.writeObject(productos);
                ostreamProd.close();
            }
            if (!ventas.isEmpty()){
                FileOutputStream ostreamVent = new FileOutputStream("ventas.dat");
                ObjectOutputStream oosVent = new ObjectOutputStream(ostreamVent);
                
                oosVent.writeObject(ventas);
                ostreamVent.close();
            }
            else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarDatos
}
