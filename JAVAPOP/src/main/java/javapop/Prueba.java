
package javapop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;
import static javapop.Utilidad.*;


public class Prueba {


    public static void main(String[] args) throws IOException {
        
        cargarDatos();
        comprobarUrgente(); //si alguno de los productos urgentes ha pasado los 7 dias se cambiará a no urgente
        
        String categorias[] = {"Moda y accesorios", "TV, audio y foto", "Móviles y telefonía", "Informática y electrónica", "Consolas y videojuegos", "Deporte y ocio"};
        String estado[] = {"Nuevo", "Como nuevo", "Bueno", "Aceptable", "Regular"};
        
        LocalDate fecha = LocalDate.of(2020,04,05);
        
        Cliente c1 = new Cliente("c1@gmail.com","1234", "09102432K", "Daniel Verduras", "28806", "Alcala de Henares", "1234-4567-7890-9876");
        Cliente c2 = new Cliente("c2@gmail.com","12345", "09102432L", "Buenas Tardes", "28806", "Alcala de Henares", "1234-4567-7890-9878");
        Cliente c3 = new Cliente("davidfernandezsanz@gmail.com", "hola1234", "09104353L", "David Fernandez", "50000", "Alcalá de Henares", "8765-8658-4685-3425");
        Cliente c4 = new Cliente("c4@gmail.com", "123456", "09887632Ñ", "Juan García", "28659", "Torrejón de Ardoz", "876586584685");
        
        Producto p1 = new Producto("Ordenador portatil", "Muy bueno", "Informática y electrónica", "Nuevo", 600.34, fecha, false, c1);
        Producto pr2 = new Producto("Cámara", "Hace fotos", "TV, audio y foto", "Nuevo", 400, fecha, true, c1);
        Producto prod3 = new Producto("Teclado", "Pa escribir", "Informática y electrónica", "Nuevo", 60, fecha, true, c2);
        Producto p4 = new Producto("Ratón", "Pal pc", "Informática y electrónica", "Nuevo", 30, fecha, true, c3);
        Producto pprod5 = new Producto("Cascos", "Pa escuchar", "Informática y electrónica", "Nuevo", 50, fecha, false, c3);
        Producto p6 = new Producto("Nintendo DS", "Pa jugar", "Consolas y videojuegos", "Bueno", 100, fecha, false, c3);
        Producto p7 = new Producto("Teclado Gaming", "Pal pc", "Consolas y videojuegos", "Nuevo", 70, fecha, true, c4);
        
        registroCliente(c1);
        registroCliente(c2);
        registroCliente(c3);
        registroCliente(c4);
        
        
        subirProducto(c1,p1);
        subirProducto(c1,pr2);
        subirProducto(c2,prod3);
        subirProducto(c3,p4);
        subirProducto(c3,pprod5);
        subirProducto(c3,p6);
        subirProducto(c4,p7);
        
        
        Scanner sc = new Scanner(System.in);
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int opc, opc2,  num, intento = 0;
        String email, pass;
        
        
        System.out.println("Bienvenido a JavaPop");
        System.out.println("---------------------");
        System.out.println("¿Desea registrar algún cliente? Si es así pulse 1. De lo contrario pulse cualquier número para continuar.");
        opc = sc.nextInt();
        String dni,
                nombre,
                correo,
                clave,
                postal,
                ciudad,
                cc;
        if (opc == 1) {

            System.out.println("Registro de Cliente Estándar");
            System.out.println("-----------------------------");
            System.out.println("¿Cuantos clientes desea registrar?");
            num = sc.nextInt();
            Cliente clientes[] = new Cliente[num];
            for (int i = 0; i < num; i++) {
                System.out.println("Registro Cliente " + (i + 1));
                System.out.println("------------------------");
                System.out.println("DNI->");
                dni = rd.readLine();
                System.out.println("Nombre->");
                nombre = rd.readLine();
                System.out.println("Correo->");
                correo = rd.readLine();
                System.out.println("Contraseña->");
                clave = rd.readLine();
                System.out.println("Código Postal->");
                postal = rd.readLine();
                System.out.println("Ciudad->");
                ciudad = rd.readLine();
                System.out.println("Tarjeta de crédito->");
                cc = rd.readLine();
                clientes[i] = new Cliente(correo, clave, dni, nombre, postal, ciudad, cc) {
                };
                registroCliente(clientes[i]);

            }

            if (num > 1) {

                System.out.println("Usuarios registrados correctamente");
                System.out.println("\n");

            }
            else if (num == 1) {

                System.out.println("Usuario registrado correctamente");
                System.out.println("\n");
            }
        
        
        
        }
        
        System.out.println("Bienvenido al inicio de Sesión de JavaPop");
        System.out.println("-----------------------------------------");
        System.out.println("1.Iniciar sesion como Admin");
        System.out.println("2.Iniciar sesion como Cliente");
        opc2 = sc.nextInt();
        if (opc2 == 1) {
            int opc4, clientebaja, xd;
            System.out.println("Tienes 3 intentos para iniciar sesión");
            while (intento < 3) {

                System.out.println("Email->");
                email = sc.next();
                System.out.println("Contraseña->");
                pass = sc.next();
                if (email.equals("admin@javapop.com") && pass.equals("admin")){
                    break;    
                }
                else{intento++;}
            }

            System.out.println("----------------------------");
            System.out.println("Bienvenido Admin");

            System.out.println("¿Qué desea hacer?");
            while (opc != 4) {

                System.out.println("1-Consulta de usuarios");
                System.out.println("2-Consulta de productos");
                System.out.println("3-Mostrar ventas");
                System.out.println("4-Salir");
                opc4 = sc.nextInt();
                if (opc4 == 1) {
                    ArrayList<Cliente> clients = new ArrayList();
                    int v;
                    v = 0;
                    System.out.println("Clientes de JavaPop");
                    System.out.println("----------------------");
                    clients = getClientes();
                    for (Cliente cl : clients) {

                        System.out.println("Cliente " + v);
                        System.out.println("-------------");
                        System.out.println(cl.toString());
                        System.out.println("--------------");
                        v++;
                    }

                    System.out.println("¿Desea dar de baja algún cliente? 1.SI 2.NO");
                    xd = sc.nextInt();
                    if (xd == 1) {

                        System.out.println("Que cliente deseas dar de baja->");
                        clientebaja = sc.nextInt();

                        if (bajaCliente(clients.get(clientebaja))){
                            System.out.println("Cliente dado de baja con éxito\n");
                        }
                        else{System.out.println("Ha habido un error...\n");}
                    } 

                }

                else if (opc4 == 2) {
                boolean borrado = false;
                int opcion, delete;
                Cliente cl;
                ArrayList<Producto> consulta = new ArrayList<>();
                String busqueda, busq;
                System.out.println("Consulta de Productos JavaPop");
                System.out.println("-----------------------------");
                
                System.out.println("Elige una categoria para buscar productos->");
                    for (int i = 0; i < categorias.length; i++) {

                        System.out.println(i + " - " + categorias[i]);

                    }
                    opcion = sc.nextInt();
                    busqueda = categorias[opcion];
                    System.out.println("Palabra clave(0 para mostrar todos los articulos de dicha categoría)->");
                    System.out.println("");
                    busq = rd.readLine();
                    if(busq.equals("0")){busq = "";}
                    consulta = busquedaProductosAdmin(busq, busqueda);
                    if (!consulta.isEmpty()){
                        for (int j = 0; j < consulta.size(); j++) {

                            System.out.println("Producto " + j);
                            System.out.println("--------------");
                            System.out.println(consulta.get(j).toString());
                            System.out.println("------------------------");

                        }

                        System.out.println("Selecciona el producto a borrar->");
                        delete = sc.nextInt();
                        System.out.println("Vas a borrar el producto " + consulta.get(delete).getTitulo());
                        cl = consulta.get(delete).getClient();
                        borrado = eliminarProducto(cl, consulta.get(delete));

                        if (borrado) {

                            System.out.println("Producto dado de baja con éxito");
                        } else {

                            System.out.println("Se ha producido un error");

                        }
                    }

                } else if (opc4 == 3) {
                    int vent;
                    ArrayList<Venta> result = new ArrayList<>();
                    result = getVentas();
                    System.out.println("Ventana de gestion de compras");
                    System.out.println("-----------------------------");
                    System.out.println("1. Mostras todas las ventas realizadas");
                    System.out.println("2. Ventas a partir de una fecha");
                    vent = sc.nextInt();
                    if (vent == 1) {

                        System.out.println("Todas las ventas realizadas en JavaPop");
                        System.out.println("--------------------------------------");
                        for (int i = 0; i < result.size(); i++) {
                            System.out.println("Venta" + (i + 1));
                            System.out.println("--------------");
                            System.out.println(result.get(i));
                            System.out.println("-------------");
                        }

                    } else if (vent == 2) {

                        ArrayList<Venta> resultado = new ArrayList<>();
                        int dia, mes, año, i;
                        i = 0;
                        System.out.println("Año->");
                        año = sc.nextInt();
                        System.out.println("Mes->");
                        mes = sc.nextInt();
                        System.out.println("Día->");
                        dia = sc.nextInt();
                        LocalDate fechaBusqueda = LocalDate.of(año, mes, dia);
                        resultado = busquedaVentas(fechaBusqueda);
                        for (Venta venta : resultado) {
                            System.out.println("Venta " + i);
                            System.out.println("-----------");
                            System.out.println(venta.toString());
                            System.out.println("------------");
                            i++;

                        }

                    }

                } else if (opc4 == 4) {

                    System.exit(0);

                }
            }
        }
        else if (opc2 == 2) {
            System.out.println("Iniciar sesion como cliente");
            System.out.println("---------------------------");
            System.out.println("Tienes intentos ilimitados para iniciar la sesión");
            System.out.println("Le recomendamos usar c1@gmail.com y contraseña 1234 aunque puede usar cualquier otro");
            boolean logeado = false;
            while (!logeado){

                System.out.println("Email->");
                email = rd.readLine();
                System.out.println("Contraseña->");
                pass = rd.readLine();
                
                if(login(email, pass)){
                    logeado = true;
                    System.out.println("Bienvenido a JavaPop, " + getLogged().getNombre());
                }
                else{
                    System.out.println("Usuario o contraseña incorrectos, inténtelo de nuevo.");
                }
            }    
             
            int opc5;
            do {
                Cliente actual = getLogged();
                System.out.println("-------------------------");
                System.out.println("¿Que desea hacer?");
                System.out.println("1-Conviertete en Cliente Profesional y ten la posibilidad de cambiar tus datos!");
                System.out.println("2-Dar de alta un nuevo producto");
                System.out.println("3-Dar de baja un producto");
                System.out.println("4-Busqueda de un producto");
                System.out.println("5-Salir");
                opc5 = sc.nextInt();
                if (opc5 == 1) {
                    String desc, web, hora, tlf;

                    System.out.println("¿Deseas pagar una tasa de 30€ y pasar a ser un Cliente Profesional?   1.SI 2.NO");
                    int prof = sc.nextInt();
                    if (prof == 1) {

                        System.out.println("*Se han cargado 30 euros a tu tarjeta de crédito " + getLogged().getTarjeta());
                        System.out.println("Necesitamos los siguientes datos para convertirte en cliente profesional->");
                        System.out.println("Descripcion->");
                        desc = rd.readLine();
                        System.out.println("Tu página web->");
                        web = rd.readLine();
                        System.out.println("Horario de apertura->");
                        hora = rd.readLine();
                        System.out.println("Telefono->");
                        tlf = rd.readLine();
                        long tlfl = Long.parseLong(tlf);
                        if(mejoraCliente(actual,desc,web,tlfl,hora)){
                        System.out.println("¡Enhorabuena ya eres un Cliente Profesional en Java Pop!");
                        }
                        else{
                            System.out.println("Ha habido algun error, inténtelo más tarde.");
                        }
                    }
                } 
                else if (opc5 == 2) {

                    String tit, descrip, est, cat;
                    int urg;
                    double precio;
                    cat = "";
                    est = "";
                    System.out.println("Alta de nuevos productos");
                    System.out.println("------------------------");
                    System.out.println("¿Cuantos productos desea registrar?");
                    int dim = sc.nextInt();

                    for (int i = 0; i < dim; i++) {
                        System.out.println("Datos del Producto " + (i + 1));
                        System.out.println("------------------------");
                        System.out.println("Titulo del producto->");
                        tit = rd.readLine();
                        System.out.println("Descripcion del producto->");
                        descrip = rd.readLine();
                        System.out.println("Estados de un producto");
                        System.out.println("----------------------");
                        System.out.println("1. Nuevo");
                        System.out.println("2. Como nuevo");
                        System.out.println("3. Bueno");
                        System.out.println("4. Aceptable");
                        System.out.println("5. Regular");
                        int esta = sc.nextInt();
                        switch (esta) {
                            case 1:

                                est = estado[0];
                                break;
                            case 2:

                                est = estado[1];
                                break;
                            case 3:

                                est = estado[2];
                                break;
                            case 4:

                                est = estado[3];
                                break;
                            case 5:

                                est = estado[4];
                                break;

                        }

                        System.out.println("Precio del producto->");
                        precio = sc.nextDouble();
                        System.out.println("Categoria disponibles de un producto");
                        System.out.println("------------------------------------");
                        System.out.println("1. Moda y accesorios");
                        System.out.println("2. TV,audio y foot");
                        System.out.println("3. Móviles y telefonía");
                        System.out.println("4. Informática y electronica");
                        System.out.println("5. Consolas y videojuegos");
                        System.out.println("6. Deporte y ocio");
                        int cate = sc.nextInt();
                        switch (cate) {
                            case 1:

                                cat = categorias[0];
                                break;
                            case 2:

                                cat = categorias[1];
                                break;
                            case 3:

                                cat = categorias[2];
                                break;
                            case 4:

                                cat = categorias[3];
                                break;
                            case 5:

                                cat = categorias[4];
                                break;
                            case 6:

                                cat = categorias[5];
                                break;

                        }
                        
                        System.out.println("Deseas pagar una comisión de 5 € y marcar tu producto como 'urgente'?'(1.SI 2.NO)->");
                        urg = sc.nextInt();
                        boolean urgente;
                        if (urg == 1) {
                            urgente = true;      
                        } else {
                            urgente = false;
                        }
                        LocalDate fechaactu = LocalDate.now();
                        Producto prod = new Producto(tit, descrip, cat, est, precio, fechaactu, urgente,actual);
                        subirProducto(prod);
                    }

                    if (dim > 1) {
                        System.out.println("Productos registrados con exito");

                    } else if (dim == 1) {

                        System.out.println("Producto dado de alta");

                    }

                } else if (opc5 == 3) {
                    int x;
                    ArrayList<Producto> baja = new ArrayList<>();
                    baja = actual.getProductos();
                    System.out.println("Estos son tus productos");
                    System.out.println("-----------------------");

                    for (int i = 0; i < baja.size(); i++) {

                        System.out.println("Producto " + i);
                        System.out.println("-----------");
                        System.out.println(baja.get(i).toString());
                        System.out.println("------------------");

                    }
                    System.out.println("¿Que productos deseas dar de baja?->");
                    x = sc.nextInt();
                    if(eliminarProducto(actual, baja.get(x))){
                        System.out.println("Producto dado de baja con éxito");
                    }
                    else{
                        System.out.println("Ha habido un error, inténtelo de nuevo más tarde");
                    }

                } else if (opc5 == 4) {
                    ArrayList<Producto> listado = new ArrayList<>();
                    Cliente vend;
                    int x, y, z;
                    boolean aceptar;
                    String cate, cla;

                    System.out.println("Bienvenido al Mercado de JavaPop ");
                    System.out.println("---------------------------------");

                    for (int i = 0; i < categorias.length; i++) {

                        System.out.println(i + " - " + categorias[i]);

                    }
                    System.out.println("¿En que categoria estarías interesado?->");
                    x = sc.nextInt();
                    cate = categorias[x];
                    System.out.println("Palabras clave(0 para mostrar todos los productos de esa categoria)->");
                    cla = rd.readLine();
                    if(cla.equals("0")){cla = "";}
                    listado = busquedaProductos(cla, cate);
                    for (int i = 0; i < listado.size(); i++) {
                        System.out.println("----------------------");
                        System.out.println(i + " - " + listado.get(i));
                        System.out.println("----------------------");
                    }

                    System.out.println("Que producto deseas comprar?->");
                    y = sc.nextInt();
                    if(!listado.get(y).getClient().equals(actual)){
                        System.out.println("El usuario " + actual.getNombre() + " le esta haciendo una oferta de " + listado.get(y).getPrecio() + " por su producto " + listado.get(y).getTitulo() + ", deseas aceptarlo? 1.SI 2.NO");
                        z = sc.nextInt();
                        if (z == 1) {

                            aceptar = true;
                        } else {

                            aceptar = false;

                        }
                        vend = listado.get(y).getClient();
                        if (compraProducto(vend, listado.get(y), aceptar)){
                            System.out.println("Producto vendido con éxito, se ha generado una ficha con los datos de la venta.");
                        }
                        else{
                            System.out.println("Ha habido un error, inténtelo de nuevo más tarde.");
                        }
                    }
                    else{
                        System.out.println("No puedes comprarte un producto a ti mismo");
                    }

                }
            } while (opc5 != 5);

        }

        guardarDatos();
    }
    
}
