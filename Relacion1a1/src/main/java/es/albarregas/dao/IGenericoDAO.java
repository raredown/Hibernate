package es.albarregas.dao;

import java.util.List;


public interface IGenericoDAO {
    
    public void add(Object objeto);
    public List<Object> get(String entidad);
//    public Object getOne(int pk);
//    public ArrayList<Alumno> getAlumnosEquipo();
    public void update(Object objeto);
    public void delete(Object objeto);
//    public void closeConnection();
    
}