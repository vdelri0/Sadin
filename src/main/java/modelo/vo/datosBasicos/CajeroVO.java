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
public class CajeroVO {
    private int codigo;
    private String nombre;
    private String siglas;
    private String prefijo;
    private String rangoInicial;
    private String rangoFinal;
    private String ultimoConsecutivo;
    private String usuario;
    private Date fecha;
    
    public CajeroVO(){}

    public CajeroVO(int codigo, String nombre, String siglas, String prefijo, String rangoInicial, String rangoFinal, String ultimoConsecutivo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.siglas = siglas;
        this.prefijo = prefijo;
        this.rangoInicial = rangoInicial;
        this.rangoFinal = rangoFinal;
        this.ultimoConsecutivo = ultimoConsecutivo;
    }
    
    public CajeroVO(String nombre, String siglas, String prefijo, String rangoInicial, String rangoFinal, String ultimoConsecutivo) {
        this.nombre = nombre;
        this.siglas = siglas;
        this.prefijo = prefijo;
        this.rangoInicial = rangoInicial;
        this.rangoFinal = rangoFinal;
        this.ultimoConsecutivo = ultimoConsecutivo;
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

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getRangoInicial() {
        return rangoInicial;
    }

    public void setRangoInicial(String rangoInicial) {
        this.rangoInicial = rangoInicial;
    }

    public String getRangoFinal() {
        return rangoFinal;
    }

    public void setRangoFinal(String rangoFinal) {
        this.rangoFinal = rangoFinal;
    }

    public String getUltimoConsecutivo() {
        return ultimoConsecutivo;
    }

    public void setUltimoConsecutivo(String ultimoConsecutivo) {
        this.ultimoConsecutivo = ultimoConsecutivo;
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
