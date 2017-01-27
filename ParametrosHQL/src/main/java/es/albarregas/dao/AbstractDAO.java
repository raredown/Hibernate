package es.albarregas.dao;

import java.io.Serializable;
import java.util.List;
import es.albarregas.modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public abstract class AbstractDAO {
    
    private Session sesion;
    
    protected void iniciaOperacion(){
        
        sesion = HibernateUtil.createSessionFactory().openSession();
        System.out.println("He creado el objeto session de HibernateUtil");
        sesion.getTransaction().begin();
        System.out.println("Finalizo iniciaOperacion");
    }
    
    protected void terminaOperacion() {
        sesion.getTransaction().commit();
        sesion.close();
        
    }
    
    protected void manejaException(HibernateException he) throws HibernateException {
        sesion.getTransaction().rollback();
        throw he;
    }
    
    protected Session getSession(){
        return sesion;
    }
    

    @SuppressWarnings("empty-statement")
    public static void almacenaEntidad(Object entidad) throws HibernateException {
        AbstractDAO objeto = new AbstractDAO(){};
        Session sesion = HibernateUtil.createSessionFactory().openSession();;
        try {
//            objeto.iniciaOperacion();
//            sesion = HibernateUtil.createSessionFactory().openSession();
        System.out.println("He creado el objeto session de HibernateUtil");
        sesion.getTransaction().begin();
            System.out.println("Acabo de iniciar operación");
//            objeto.getSession().saveOrUpdate(entidad);
//            objeto.getSession().flush();
sesion.saveOrUpdate(entidad);
sesion.flush();
        } catch(HibernateException he){
//            objeto.manejaException(he);
sesion.getTransaction().rollback();
        } finally {
//            objeto.terminaOperacion();
sesion.getTransaction().commit();
        sesion.close();

        }
    }
    
    public static <T> T getEntidad(Serializable id, Class<T> claseEntidad) throws HibernateException {
       AbstractDAO objeto = new AbstractDAO(){};
       T objetoRecuperado = null;

       try {
           objeto.iniciaOperacion();
           objetoRecuperado = (T)objeto.getSession().get(claseEntidad, id);

       } catch(HibernateException he){
           objeto.manejaException(he);

       } finally {
           objeto.terminaOperacion();
       }
       return objetoRecuperado;
    }
    
    public static <T> List<T> getListaEntidades(Class<T> claseEntidad) throws HibernateException {
        AbstractDAO objeto = new AbstractDAO(){};
        List<T> listaResultado = null;

        try {
            objeto.iniciaOperacion();
            listaResultado = objeto.getSession().createQuery("FROM " + claseEntidad.getSimpleName()).list();

        } catch (HibernateException he){
            objeto.manejaException(he);

        } finally {
            objeto.terminaOperacion();
        }
        return listaResultado;
    }
    
}
