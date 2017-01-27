import es.albarregas.dao.AbstractDAO;
import es.albarregas.dao.UsuarioDAO;
import es.albarregas.modelo.Compra;
import es.albarregas.modelo.Direccion;
import es.albarregas.modelo.Producto;
import es.albarregas.modelo.Usuario;
import java.util.List;

import org.hibernate.HibernateException;


public class App {

    
    public static void main(String[] args) {

  //   crearUsuarios();
//        buscarUsuario();
//      creaCompras();
//        buscaUsuariosProductosInactivos();
     //   get();
    }
    
    private static void crearUsuarios(){
        System.out.println("Voy a crear los usuarios");
        try {
            
            AbstractDAO.almacenaEntidad(new Usuario("Usuario 1", "estudioso", "desvelado"));
            System.out.println("despues");
            AbstractDAO.almacenaEntidad(new Usuario("Usuario 2", "caperucita", "loboFeroz"));
            AbstractDAO.almacenaEntidad(new Usuario("Usuario 3", "empleado", "probreza"));
            AbstractDAO.almacenaEntidad(new Usuario("Usuario 4", "jesus", "12345"));
        } catch(HibernateException he){
            System.err.println("Ocurrió un error al agregar usuarios...");
            he.printStackTrace();
        }
    }
    
    private static void buscarUsuario(){
        Usuario usuario = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        try{
            usuario = usuarioDAO.getUsuario("caperucita", "loboFeroz");
        } catch(HibernateException he){
            System.err.println("Ocurrió un error al recuperar el usuario");
            he.printStackTrace();
        }
        if(usuario == null){
            System.out.println("No se encontró el usuario");
        } else {
            System.out.println("El usuario es: " + usuario.getNombre());
        }
    }
    
    private static void creaCompras() {
        Producto libros    = new Producto("Libro",  "ABC123456", 120.00F);
        Producto iPads     = new Producto("iPad",   "RAF755576", 1315.45F);
        Producto televisor = new Producto("T.V.",   "AOF765984", 379.64F);
        Producto postales  = new Producto("Postal", "ELF",       15.65F);
        Producto juegos    = new Producto("Videojuego", "MEN", 158.24F);

        libros.setEstado(Producto.Estatus.INACTIVO);
        postales.setEstado(Producto.Estatus.INACTIVO);

        Usuario usuario1 = new Usuario("Usuario de Prueba numero 1", "estudioso", "desvelado");
        usuario1.setDireccion(new Direccion("calle principal", "12345"));

        Usuario usuario2 = new Usuario("Usuario de Prueba numero 2", "caperucita", "loboFeroz");
        usuario2.setDireccion(new Direccion("primera avenida", "AVR75"));

        Usuario usuario3 = new Usuario("Usuario de Prueba numero 3", "empleado", "infelicidad");
        usuario3.setDireccion(new Direccion("puesta del sol", "12345"));

        Usuario usuario4 = new Usuario("Usuario de Prueba numero 4", "usuarioComun", "password");
        usuario4.setDireccion(new Direccion("Este 145", null));

        Compra compraUsuario1 = new Compra();
        compraUsuario1.addProducto(libros);
        usuario1.addCompra(compraUsuario1);

        compraUsuario1 = new Compra();
        compraUsuario1.addProducto(televisor);
        compraUsuario1.addProducto(juegos);
        usuario1.addCompra(compraUsuario1);

        Compra compraUsuario2 = new Compra();
        compraUsuario2.addProducto(iPads);
        compraUsuario2.addProducto(televisor);
        compraUsuario2.addProducto(juegos);
        usuario2.addCompra(compraUsuario2);

        Compra compraUsuario3 = new Compra();
        compraUsuario3.addProducto(iPads);
        compraUsuario3.addProducto(televisor);
        usuario3.addCompra(compraUsuario3);

        compraUsuario3 = new Compra();
        compraUsuario3.addProducto(postales);
        compraUsuario3.addProducto(juegos);
        usuario3.addCompra(compraUsuario3);

        Compra compraUsuario4 = new Compra();
        compraUsuario4.addProducto(libros);
        usuario4.addCompra(compraUsuario4);

        try {
            AbstractDAO.almacenaEntidad(libros);
            AbstractDAO.almacenaEntidad(iPads);
            AbstractDAO.almacenaEntidad(televisor);
            AbstractDAO.almacenaEntidad(postales);
            AbstractDAO.almacenaEntidad(juegos);

            AbstractDAO.almacenaEntidad(usuario1);
            AbstractDAO.almacenaEntidad(usuario2);
            AbstractDAO.almacenaEntidad(usuario3);
            AbstractDAO.almacenaEntidad(usuario4);
        }
        catch (HibernateException he) {
            System.err.println("Ocurrió un error al agregar los usuarios...");
            he.printStackTrace();
        }
    }
    
    private static void buscaUsuariosProductosInactivos() {
        List<Usuario> listaUsuarios = new UsuarioDAO().getUsuariosConComprasInactivas("12345");

        for(int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuarioActual = listaUsuarios.get(i);
            
            System.out.println("\nUsuario: " + usuarioActual.getNombre());

            List<Compra> listaCompras = usuarioActual.getCompras();

            for(int numeroCompra = 0; numeroCompra < listaCompras.size(); numeroCompra++){
                List<Producto> listaProductos = listaCompras.get(numeroCompra).getProductos();

                for(int numeroProducto = 0; numeroProducto < listaProductos.size(); numeroProducto++){
                    Producto producto = listaProductos.get(numeroProducto);

                    System.out.println("\t" + producto.getNombre());
                }
            }
        }
    }
    
    private static void get(){
//        Usuario usuario = AbstractDAO.getEntidad(2, Usuario.class);
        Producto producto = AbstractDAO.getEntidad(1, Producto.class);
        System.out.println("Nombre: " + producto.getNombre());
        List<Producto> productos = AbstractDAO.getListaEntidades(Producto.class);
        for(Producto pr : productos){
            System.out.println("* Producto: " + pr.getNombre() + " - " + pr.getPrecio());
        }
    }
    
    
}
