package es.jesushm.daoFactory;

import es.jesushm.dao.IGenericoDAO;
import es.jesushm.dao.IProfesorDAO;


public abstract class DAOFactory {

    /*public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int FICHERO = 3;*/
    
    public abstract IProfesorDAO getGenericoDAO();
    public abstract IGenericoDAO getProfesorDAO();
    
    public static DAOFactory getDAOFactory(){
        DAOFactory daof = new MySQLDAOFactory();
        
        /*switch(tipo){
            case MYSQL:
                daof = new MySQLDAOFactory();
                break;
            case ORACLE:
                daof = new OracleDAOFactory();
                break;
            case FICHERO:
                daof = new FicheroDAOFactory();
                break;
        }*/
        
        return daof;
    }    
}
