package es.albarregas.dao;

import java.io.Serializable;
import java.util.List;


public interface IGenericoDAO<T> {
    
    public void add(T objeto);
    public <T> List<T> get(String entidad);
    public <T> T getOne(Serializable pk, Class<T> claseEntidad);
//    public ArrayList<Alumno> getAlumnosEquipo();
    public void update(T objeto);
    public void delete(T objeto);
//    public void closeConnection();
    
}