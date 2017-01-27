package es.albarregas.dao;

import es.albarregas.modelo.HibernateUtil;
import es.albarregas.modelo.Producto;
import es.albarregas.modelo.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDAO extends AbstractDAO {
    
    public Usuario getUsuario(String username, String password) throws HibernateException {
        
        Usuario usuario = null;
        Session s = HibernateUtil.createSessionFactory().openSession();
       try {
            iniciaOperacion();

        s.beginTransaction();
            Query consulta = s.createQuery("from Usuario u where u.username = :nombreUsuario and u.password = :password");
            consulta.setParameter("nombreUsuario", username);
            consulta.setParameter("password", password);
            usuario = (Usuario)consulta.uniqueResult();
        } catch(HibernateException he){
            manejaException(he);

        } finally {
            terminaOperacion();
        }
        
        return usuario;
        
    }
    
    public List<Usuario> getUsuariosConComprasInactivas(String codigoPostal) throws HibernateException {
        List<Usuario> listaUsuarios = null;

        try {
            iniciaOperacion();

            Query query = getSession().createQuery("SELECT u FROM Usuario u JOIN FETCH u.compras c JOIN c.productos p WHERE p.estado = ? AND u.direccion.codigoPostal = ?");
            query.setParameter(0, Producto.Estatus.INACTIVO);
            query.setParameter(1, codigoPostal);
            
            listaUsuarios = query.list();

        }catch(HibernateException he){
            he.printStackTrace();
            manejaException(he);
        }finally {
            terminaOperacion();
        }

        return listaUsuarios;
    }
    
}
