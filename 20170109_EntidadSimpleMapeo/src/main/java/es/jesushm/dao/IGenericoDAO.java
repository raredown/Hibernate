/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jesushm.dao;

import java.util.List;

/**
 *
 * @author jesus
 */
public interface IGenericoDAO {

    public void add(Object objeto);

    public List<Object> get(String entidad);

    public void update(Object objeto);

    public void delete(Object objeto);
}
