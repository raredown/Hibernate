/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jesushm.dao;

import es.jesushm.modelos.Profesor;
import es.jesushm.persistencia.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author jesus
 */
public class ProfesorDAO implements IProfesorDAO {

    @Override
    public Profesor getOne(int pk) {
        Profesor profesor = new Profesor();
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            profesor = (Profesor) sesion.get(Profesor.class, pk);
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
        return profesor;
    }

}
