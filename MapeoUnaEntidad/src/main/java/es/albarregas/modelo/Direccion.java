/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.modelo;

import java.io.Serializable;

/**
 *
 * @author Daw2
 */
public class Direccion implements Serializable {
    private int idDirec;
    private String calle;
    private int numero;
    private String poblacion;
    private String provincia;

    public int getIdDirec() {
        return idDirec;
    }

    public void setIdDirec(int idDirec) {
        this.idDirec = idDirec;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
}
