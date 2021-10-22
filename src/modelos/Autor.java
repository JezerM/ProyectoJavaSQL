/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

public class Autor {
    
    private int idAutor;
    private String nombrePila;
    private String apellidoPaterno;
    private int estado;

   
    public Autor(int idAutor, String nombrePila, String apellidoPaterno, int estado) {
        this.idAutor = idAutor;
        this.nombrePila = nombrePila;
        this.apellidoPaterno = apellidoPaterno;
        this.estado = estado;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombrePila() {
        return nombrePila;
    }

    public void setNombrePila(String nombrePila) {
        this.nombrePila = nombrePila;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
 
    
    
    
}