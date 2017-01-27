
import es.albarregas.modelo.Usuario;
import es.albarregas.modelo.Direccion;
import es.albarregas.modelo.Permiso;
import es.albarregas.modelo.HibernateUtil;
import es.albarregas.modelo.Permiso.Estado;
import es.albarregas.modelo.UsuarioDireccion;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jesus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new Main();
    }
    

    
    public Main(){
        // Inserciones
  // int id = insertDatos();
  nombreYcosas();
        
        // Consulta y salida por pantalla
//        listVuelo();
//        
//        // Modificación de los atributos
//        updateVuelo(id);
//        
//        // Se vuelve a consultar
//        listVuelo();

       // getNombresYPasswords();
        
        getUsuarioDireccion();
        
       // cuentaPermisos();
        
    }
    
    private int insertDatos(){
        // Se obtiene la sesion
        Session s = HibernateUtil.createSessionFactory().openSession();
        s.beginTransaction();
        
        
        Direccion direccion1 = new Direccion("Calle 1","12345");
        Direccion direccion2 = new Direccion("Calle 2","54321");
        Permiso permiso1 = new Permiso("Lectura de archivos",Estado.PENDIENTE);
        Permiso permiso2 = new Permiso("Creación de archivos",Estado.PENDIENTE);
        Permiso permiso3 = new Permiso("Eliminación de archivos",Estado.ACTIVO);
        Permiso permiso4 = new Permiso("Modificación de archivos",Estado.ACTIVO);
        Permiso permiso5 = new Permiso("Sin permisos",Estado.INACTIVO);
        List<Permiso> permisos1= new ArrayList<>();
        permisos1.add(permiso1);
        permisos1.add(permiso2);
        Usuario usuario1 = new Usuario("usuario 1","usur-1","abcdefg",new Date(),direccion1, permisos1);
        List<Permiso> permisos2= new ArrayList<>();
        permisos2.add(permiso3);
        permisos2.add(permiso4);
        Usuario usuario2 = new Usuario("usuario 2","usur-2","dabdser",new Date(),direccion2, permisos2);
        List<Permiso> permisos3= new ArrayList<>();
        permisos3.add(permiso5);
        Usuario usuario3 = new Usuario("usuario 3","usur-3","pouebrf",new Date(),null, permisos3);
        // Almacenamos en la base de datos
        s.save(direccion1);
        s.save(direccion2);
        s.save(permiso1);
        s.save(permiso2);
        s.save(permiso3);
        s.save(permiso4);
        s.save(permiso5);
        s.save(usuario1);
        s.save(usuario2);
        s.save(usuario3);
//        s.save(vuelo1);
        s.getTransaction().commit();
        
        s.close();
        
        return permiso1.getId();
                
    }
    

    private void getNombresYPasswords(){
        Session s = HibernateUtil.createSessionFactory().openSession();
        s.beginTransaction();
        
        Query query = s.createQuery("select new map(u.id as identificador, u.nombre as nombre, u.password as pass) from Usuario as u");
        List<Map>listaResultados = query.list();
        
        for(int i = 0; i < listaResultados.size(); i++){
            Map mapa = listaResultados.get(i);
            System.out.println("Datos del mapa " + i);
            Set llaves = mapa.keySet();
            Iterator<String> it = llaves.iterator();
            while(it.hasNext()){
                String llave = it.next();
                System.out.println("\tLlave: " + llave + ", valor: " + mapa.get(llave));
            }
        }
        s.getTransaction().commit();
        
        s.close();
    }
    
    private void getUsuarioDireccion(){
        Session s = HibernateUtil.createSessionFactory().openSession();
        s.beginTransaction();
        
        Query query = s.createQuery("select new es.albarregas.modelo.UsuarioDireccion(u.nombre, d.calle, d.codigoPostal, count(p)) from Usuario as u left outer join u.direccion as d left outer join u.permisos as p group by u.nombre");
    
        List<UsuarioDireccion> listaResultados = query.list();
        
        for(int i = 0; i < listaResultados.size(); i++){
            UsuarioDireccion usuarioDireccion = listaResultados.get(i);
            System.out.println("* " + usuarioDireccion.getNombre() + ", dirección: " + usuarioDireccion.getCalle() + " - " + usuarioDireccion.getCodigoPostal() + ", permisos: " + usuarioDireccion.getNumeroPermisos());
        }
        
        s.getTransaction().commit();
        
        s.close();
        
    }
    
    private void cuentaPermisos(){
        Session s = HibernateUtil.createSessionFactory().openSession();
        s.beginTransaction();
        
        Query query = s.createQuery("select p.estado, count(p.estado) from Permiso p group by p.estado");
        List<Object[]> datos = query.list();
        
        for(int i = 0; i < datos.size(); i++){
            Object[] datoActual = datos.get(i);
            
            System.out.println(datoActual[0] + "(" + datoActual[1] + ")");
        }
        
        s.getTransaction().commit();
        
        s.close();
    }
        private void nombreYcosas(){
        Session s = HibernateUtil.createSessionFactory().openSession();
        s.beginTransaction();
        
        Query query = s.createQuery("SELECT u.nombre, u.password,u.direccion.calle FROM Usuario as u");
        List<Object[]> datos = query.list();
        
        for(int i = 0; i < datos.size(); i++){
            Object[] datoActual = datos.get(i);
            
            System.out.println(datoActual[0] + " " + datoActual[1] + " "+datoActual[2]);
        }
        
        s.getTransaction().commit();
        
        s.close();
    }
    
}
    

