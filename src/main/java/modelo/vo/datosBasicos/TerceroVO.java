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
public class TerceroVO {
    private int cedula;
    private String nombre;
    private String direccion;
    private String telefonos;
    private EmpresaVO empresa;
    private Date fechaNacimiento;
    private String email;
    private String celular;
    private String usuario;
    private Date fecha;

    public TerceroVO() {
    }

    public TerceroVO(int cedula, String nombre, String direccion, String telefonos, EmpresaVO empresa, Date fechaNacimiento, String email, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.empresa = empresa;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.celular = celular;
    }

    public TerceroVO(String nombre, String direccion, String telefonos, EmpresaVO empresa, Date fechaNacimiento, String email, String celular) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.empresa = empresa;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.celular = celular;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    public EmpresaVO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaVO empresa) {
        this.empresa = empresa;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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
