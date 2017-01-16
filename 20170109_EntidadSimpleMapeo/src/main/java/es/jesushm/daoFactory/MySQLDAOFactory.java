package es.jesushm.daoFactory;

import es.jesushm.dao.IGenericoDAO;
import es.jesushm.dao.IProfesorDAO;
import es.jesushm.dao.ProfesorDAO;
import es.jesushm.dao.GenericoDAO;


public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IProfesorDAO getProfesorDAO(){
        return new ProfesorDAO();
    }


    @Override
    public IGenericoDAO getGenericoDAO() {
         return new GenericoDAO();
    }
    
}
