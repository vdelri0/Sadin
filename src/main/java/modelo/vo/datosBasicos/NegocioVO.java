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
public class NegocioVO {
    private int codigo; 
    private String nombre;
    private String propietario;
    private String direccion;
    private String ciudad;
    private String telefonos;
    private String nit;
    private String usuario; 
    private Date fecha; 

    public NegocioVO() {
    }

    public NegocioVO(int codigo, String nombre, String propietario, String direccion, String ciudad, String telefonos, String nit) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.propietario = propietario;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefonos = telefonos;
        this.nit = nit;
    }

    public NegocioVO(String nombre, String propietario, String direccion, String ciudad, String telefonos, String nit) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefonos = telefonos;
        this.nit = nit;
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

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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
