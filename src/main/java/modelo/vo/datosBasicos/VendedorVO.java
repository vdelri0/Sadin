/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo.datosBasicos;

import java.util.Date;

/**
 *
 * @author Victor Del Rio Prens
 */
public class VendedorVO {
    private int codigo;
    private String nombre;
    private String siglas;
    private String usuario;
    private Date fecha;

    public VendedorVO() {
    }

    public VendedorVO(int codigo, String nombre, String siglas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.siglas = siglas;
    }

    public VendedorVO(String nombre, String siglas) {
        this.nombre = nombre;
        this.siglas = siglas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
