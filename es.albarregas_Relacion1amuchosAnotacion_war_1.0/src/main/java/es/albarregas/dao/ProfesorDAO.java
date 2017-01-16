package es.albarregas.dao;

import es.albarregas.modelo.Profesor;
import es.albarregas.persistencia.HibernateUtil;

import java.util.List;

import org.hibernate.Session;


public class ProfesorDAO implements IProfesorDAO {

//    @Override
//    public void add(Profesor profesor) {
//        Session sesion = null;
//        try {
//            sesion = HibernateUtil.getSessionFactory().openSession();
//            sesion.beginTransaction();
//            sesion.save(profesor);
//            sesion.getTransaction().commit();
//        } catch(org.hibernate.JDBCException jdbce){
//            if(sesion != null){
//                sesion.getTransaction().rollback();
//            }
//        } finally {
//            if(sesion != null){
//                sesion.close();
//            }
//        }
//    }
//
//    @Override
//    public List<Profesor> get(String entidad) {
//        List<Profesor> listado = null;
//        Session sesion = null;
//        try {
//            sesion = HibernateUtil.getSessionFactory().openSession();
//            sesion.beginTransaction();
//            listado = sesion.createQuery(" from " + entidad).list();
//            sesion.getTransaction().commit();
//        } catch(org.hibernate.JDBCException jdbce){
//            if(sesion != null){
//                sesion.getTransaction().rollback();
//            }
//        } finally {
//            if(sesion != null){
//                sesion.close();
//            }
//        }
//        return listado;
//    }
//
//    @Override
//    public void delete(Profesor profesor) {
//        Session sesion = null;
//        try {
//            sesion = HibernateUtil.getSessionFactory().openSession();
//            sesion.beginTransaction();
//            sesion.delete(profesor);
//            sesion.getTransaction().commit();
//        } catch(org.hibernate.JDBCException jdbce){
//            if(sesion != null){
//                sesion.getTransaction().rollback();
//            }
//        } finally {
//            if(sesion != null){
//                sesion.close();
//            }
//        }
//    }

    @Override
    public Profesor getOne(int pk) {
        Profesor profesor = new Profesor();
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            profesor = (Profesor)sesion.get(Profesor.class, pk);
            sesion.getTransaction().commit();
        } catch(org.hibernate.JDBCException jdbce){
            if(sesion != null){
                sesion.getTransaction().rollback();
            }
        } finally {
            if(sesion != null){
                sesion.close();
            }
        }
        return profesor;
    }

//    @Override
//    public void update(Profesor profesor) {
//        Session sesion = null;
//        try {
//            sesion = HibernateUtil.getSessionFactory().openSession();
//            sesion.beginTransaction();
//            sesion.update(profesor);
//            sesion.getTransaction().commit();
//        } catch(org.hibernate.JDBCException jdbce){
//            if(sesion != null){
//                sesion.getTransaction().rollback();
//            }
//        } finally {
//            if(sesion != null){
//                sesion.close();
//            }
//        }
//    }

}
