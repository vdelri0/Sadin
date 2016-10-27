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
public class PuntoDeVentaVO {
    private int codigo;
    private String nombre;
    private String direccion;
    private String telefonos;
    private String fax;
    private String email;
    private String responsable;
    private String usuario;
    private Date fecha;

    public PuntoDeVentaVO() {
    }
    
    public PuntoDeVentaVO(int codigo, String nombre, String direccion, String telefonos, String fax, String email, String responsable) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.fax = fax;
        this.email = email;
        this.responsable = responsable;
    }

    public PuntoDeVentaVO(String nombre, String direccion, String telefonos, String fax, String email, String responsable) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.fax = fax;
        this.email = email;
        this.responsable = responsable;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
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
