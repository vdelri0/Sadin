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
public class UnidadDeMedidaVO {
    private int codigo;
    private String descripcion;
    private String siglas;
    private String usuario;
    private Date fecha;

    public UnidadDeMedidaVO() {
    }

    public UnidadDeMedidaVO(int codigo, String descripcion, String siglas) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.siglas = siglas;
    }

    public UnidadDeMedidaVO(String descripcion, String siglas) {
        this.descripcion = descripcion;
        this.siglas = siglas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
