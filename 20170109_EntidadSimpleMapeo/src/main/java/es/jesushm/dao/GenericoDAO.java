/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jesushm.dao;

import es.jesushm.modelos.Profesor;
import es.jesushm.persistencia.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author jesus
 */
public class GenericoDAO implements IGenericoDAO {

    @Override
    public void add(Object objeto) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(objeto);
            sesion.getTransaction().commit();
        } catch (org.hibernate.JDBCException jdbce) {
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        
    }

    @Override
    public List<Object> get(String entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
