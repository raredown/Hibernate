package es.albarregas.modelo;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.Ejb3ConfigurationObjectFactory;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {


    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    

    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        
        
//        Configuration configuration = new AnnotationConfiguration();
        
        
        
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        return sessionFactory;
    }
    

    
}
