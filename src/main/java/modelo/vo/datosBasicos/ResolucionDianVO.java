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
public class ResolucionDianVO {
    private int codigo;
    private String tipoRegistro;
    private String usuario;
    private Date fecha;

    public ResolucionDianVO() {
    }

    public ResolucionDianVO(int codigo, String tipoRegistro) {
        this.codigo = codigo;
        this.tipoRegistro = tipoRegistro;
    }

    public ResolucionDianVO(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
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
