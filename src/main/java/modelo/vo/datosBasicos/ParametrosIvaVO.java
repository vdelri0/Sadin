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
public class ParametrosIvaVO {
    private int codigo;
    private int porcentaje;
    private char aplicarParaTodos;
    private String usuario;
    private Date fecha;

    public ParametrosIvaVO() {
    }

    public ParametrosIvaVO(int codigo, int porcentaje, char aplicarParaTodos) {
        this.codigo = codigo;
        this.porcentaje = porcentaje;
        this.aplicarParaTodos = aplicarParaTodos;
    }
    
    public ParametrosIvaVO(int porcentaje, char aplicarParaTodos) {
        this.porcentaje = porcentaje;
        this.aplicarParaTodos = aplicarParaTodos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public char getAplicarParaTodos() {
        return aplicarParaTodos;
    }

    public void setAplicarParaTodos(char aplicarParaTodos) {
        this.aplicarParaTodos = aplicarParaTodos;
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
