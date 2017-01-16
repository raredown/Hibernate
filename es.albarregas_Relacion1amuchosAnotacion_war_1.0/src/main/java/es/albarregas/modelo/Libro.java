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
public class Libro implements Serializable {

    private int idLibro;
    private String titulo;

    public Libro() {
    }

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
