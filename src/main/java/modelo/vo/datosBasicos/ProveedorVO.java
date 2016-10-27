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
public class ProveedorVO {
    int codigo;
    private String nombre;
    private String nit;
    private String direccion;
    private String telefonos;
    private String representante;
    private String email;
    private String fax;
    private String cuentaContable;
    private String usuario;
    private Date fecha;

    public ProveedorVO() {
    }

    public ProveedorVO(int codigo, String nombre, String nit, String direccion, String telefonos, String representante, String email, String fax, String cuentaContable) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.representante = representante;
        this.email = email;
        this.fax = fax;
        this.cuentaContable = cuentaContable;
    }

    public ProveedorVO(String nombre, String nit, String direccion, String telefonos, String representante, String email, String fax, String cuentaContable) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.representante = representante;
        this.email = email;
        this.fax = fax;
        this.cuentaContable = cuentaContable;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(String cuentaContable) {
        this.cuentaContable = cuentaContable;
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
