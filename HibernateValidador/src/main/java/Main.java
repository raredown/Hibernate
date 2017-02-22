
import es.albarregas.modelo.Profesor;
import es.albarregas.modelo.Usuario;
import javax.validation.ConstraintViolationException;
import javax.validation.ConstraintViolation;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        new org.hibernate.tool.hbm2ddl.SchemaExport(configuration).setOutputFile("script.sql").setDelimiter(";").create(true, false);   
        
        {
            System.out.println("----------- Mensajes de error personalizado localmente -----------");
            Session session = sessionFactory.openSession();
            Profesor profesor = new Profesor("carlos", null, "Gomez");

            try {
                session.beginTransaction();

                session.save(profesor);

                session.getTransaction().commit();
            } catch (ConstraintViolationException cve) {
                session.getTransaction().rollback();
                System.out.println("No se ha podido insertar el profesor debido a los siguientes errores:");
                for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
                    System.out.println("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage());
                }                
            }
            session.close();
        }        
        
//        {
//            System.out.println("----------- Aun sale el mensaje original en nombre -----------");
//            Session session = sessionFactory.openSession();
//            Profesor profesor = new Profesor(null, null, "Gomez");
//
//        
//            try {
//                session.beginTransaction();
//
//                session.save(profesor);
//
//                session.getTransaction().commit();
//            } catch (ConstraintViolationException cve) {
//                session.getTransaction().rollback();
//                System.out.println("No se ha podido insertar el profesor debido a los siguientes errores:");
//                for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
//                    System.out.println("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage());
//                }                
//            }
//            session.close();
//        }         
//
//        
//       
//        
//        {
//            System.out.println("----------- Expresion en JavaScript -----------");
//            Session session = sessionFactory.openSession();
//            Usuario usuario = new Usuario("luis","Luis","Ramirez","Cano","1234567","12345678");
//
//            try {
//                session.beginTransaction();
//
//                session.save(usuario);
//
//                session.getTransaction().commit();
//            } catch (javax.validation.ConstraintViolationException cve) {
//                session.getTransaction().rollback();
//                System.out.println("No se ha podido insertar el profesor debido a los siguientes errores:");
//                for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
//                    System.out.println("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage());
//                }                
//            }
//            
//            session.close();
//        }        
//
//        {
//            System.out.println("----------- Validación por métodos -----------");
//            Session session = sessionFactory.openSession();
//            Usuario usuario = new Usuario("luisramirez","Luis","Ramirez","Cano","luisramirez","luisramirez");
//
//            try {
//                session.beginTransaction();
//
//                session.save(usuario);
//
//                session.getTransaction().commit();
//            } catch (javax.validation.ConstraintViolationException cve) {
//                session.getTransaction().rollback();
//                System.out.println("No se ha podido insertar el profesor debido a los siguientes errores:");
//                for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
//                    System.out.println("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage());
//                }                
//            }
//            
//            session.close();
//        } 
//        
//        {
//            System.out.println("----------- Añadir usuario lramirez -----------");
//            Session session = sessionFactory.openSession();
//            Usuario usuario = new Usuario("lramirez","Luis","Ramirez","Cano","12345678","12345678");
//
//            try {
//                session.beginTransaction();
//
//                session.save(usuario);
//
//                session.getTransaction().commit();
//            } catch (javax.validation.ConstraintViolationException cve) {
//                session.getTransaction().rollback();
//                System.out.println("No se ha podido insertar el profesor debido a los siguientes errores:");
//                for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
//                    System.out.println("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage());
//                }                
//            } catch (org.hibernate.exception.ConstraintViolationException cve) {
//                session.getTransaction().rollback();
//                System.out.println("No se ha podido insertar el profesor debido al siguiente error:");
//                System.out.println("El valor ya existe."+cve.getLocalizedMessage());
//            }
//            
//            session.close();
//        }        
//        
// 
//        {
//            System.out.println("----------- Volver a añadir usuario lramirez -----------");
//            Session session = sessionFactory.openSession();
//            Usuario usuario = new Usuario("lramirez","Luis","Ramirez","Cano","12345678","12345678");
//
//            try {
//                session.beginTransaction();
//
//                session.save(usuario);
//
//                session.getTransaction().commit();
//            } catch (javax.validation.ConstraintViolationException cve) {
//                session.getTransaction().rollback();
//                System.out.println("No se ha podido insertar el profesor debido a los siguientes errores:");
//                for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
//                    System.out.println("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage());
//                }                
//            } catch (org.hibernate.exception.ConstraintViolationException cve) {
//                session.getTransaction().rollback();
//                System.out.println("No se ha podido insertar el profesor debido al siguiente error:");
//                System.out.println("El valor ya existe."+cve.getLocalizedMessage());
//            }
//            
//            session.close();
//        }
        
        
        sessionFactory.close();
    }
}
