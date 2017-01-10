/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jesushm.dao;

import es.jesushm.modelos.Profesor;

/**
 *
 * @author jesus
 */
public interface IProfesorDAO {
    public Profesor getOne(int pk);
}
