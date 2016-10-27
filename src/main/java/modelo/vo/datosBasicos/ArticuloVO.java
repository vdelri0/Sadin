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
public class ArticuloVO {
    private int codigo; 
    private String nombre;
    private String referencia;
    private String presentacion;
    private UnidadDeMedidaVO unidadDeMedida;
    private long unidadesPorCaja;
    private int codigoDeLinea; 
    private String cuentaDeIngreso;
    private String cuentaDeCosto;
    private long promedioDeCosto;
    private long precioDeVenta;
    private long enero;
    private long febrero;
    private long marzo;
    private long abril;
    private long mayo;
    private long junio;
    private long julio;
    private long agosto;
    private long septiembre;
    private long octubre;
    private long noviembre;
    private long diciembre;
    private String usuario;
    private Date fecha;

    public ArticuloVO() {
    }

    public ArticuloVO(int codigo, String nombre, String referencia, String presentacion, long unidadesPorCaja, int codigoDeLinea, String cuentaDeIngreso, String cuentaDeCosto, long promedioDeCosto, long precioDeVenta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.referencia = referencia;
        this.presentacion = presentacion;
        this.unidadesPorCaja = unidadesPorCaja;
        this.codigoDeLinea = codigoDeLinea;
        this.cuentaDeIngreso = cuentaDeIngreso;
        this.cuentaDeCosto = cuentaDeCosto;
        this.promedioDeCosto = promedioDeCosto;
        this.precioDeVenta = precioDeVenta;
    }

    public ArticuloVO(String nombre, String referencia, String presentacion, UnidadDeMedidaVO unidadDeMedida, long unidadesPorCaja, int codigoDeLinea, String cuentaDeIngreso, String cuentaDeCosto, long promedioDeCosto, long precioDeVenta) {
        this.nombre = nombre;
        this.referencia = referencia;
        this.presentacion = presentacion;
        this.unidadDeMedida = unidadDeMedida;
        this.unidadesPorCaja = unidadesPorCaja;
        this.codigoDeLinea = codigoDeLinea;
        this.cuentaDeIngreso = cuentaDeIngreso;
        this.cuentaDeCosto = cuentaDeCosto;
        this.promedioDeCosto = promedioDeCosto;
        this.precioDeVenta = precioDeVenta;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public UnidadDeMedidaVO getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(UnidadDeMedidaVO unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public long getUnidadesPorCaja() {
        return unidadesPorCaja;
    }

    public void setUnidadesPorCaja(long unidadesPorCaja) {
        this.unidadesPorCaja = unidadesPorCaja;
    }

    public int getCodigoDeLinea() {
        return codigoDeLinea;
    }

    public void setCodigoDeLinea(int codigoDeLinea) {
        this.codigoDeLinea = codigoDeLinea;
    }

    public String getCuentaDeIngreso() {
        return cuentaDeIngreso;
    }

    public void setCuentaDeIngreso(String cuentaDeIngreso) {
        this.cuentaDeIngreso = cuentaDeIngreso;
    }

    public String getCuentaDeCosto() {
        return cuentaDeCosto;
    }

    public void setCuentaDeCosto(String cuentaDeCosto) {
        this.cuentaDeCosto = cuentaDeCosto;
    }

    public long getPromedioDeCosto() {
        return promedioDeCosto;
    }

    public void setPromedioDeCosto(long promedioDeCosto) {
        this.promedioDeCosto = promedioDeCosto;
    }

    public long getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(long precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    public long getEnero() {
        return enero;
    }

    public void setEnero(long enero) {
        this.enero = enero;
    }

    public long getFebrero() {
        return febrero;
    }

    public void setFebrero(long febrero) {
        this.febrero = febrero;
    }

    public long getMarzo() {
        return marzo;
    }

    public void setMarzo(long marzo) {
        this.marzo = marzo;
    }

    public long getAbril() {
        return abril;
    }

    public void setAbril(long abril) {
        this.abril = abril;
    }

    public long getMayo() {
        return mayo;
    }

    public void setMayo(long mayo) {
        this.mayo = mayo;
    }

    public long getJunio() {
        return junio;
    }

    public void setJunio(long junio) {
        this.junio = junio;
    }

    public long getJulio() {
        return julio;
    }

    public void setJulio(long julio) {
        this.julio = julio;
    }

    public long getAgosto() {
        return agosto;
    }

    public void setAgosto(long agosto) {
        this.agosto = agosto;
    }

    public long getSeptiembre() {
        return septiembre;
    }

    public void setSeptiembre(long septiembre) {
        this.septiembre = septiembre;
    }

    public long getOctubre() {
        return octubre;
    }

    public void setOctubre(long octubre) {
        this.octubre = octubre;
    }

    public long getNoviembre() {
        return noviembre;
    }

    public void setNoviembre(long noviembre) {
        this.noviembre = noviembre;
    }

    public long getDiciembre() {
        return diciembre;
    }

    public void setDiciembre(long diciembre) {
        this.diciembre = diciembre;
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
