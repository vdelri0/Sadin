/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Agencia;
import modelo.Articulo;
import modelo.Bodega;
import modelo.Cajero;
import modelo.Empresa;
import modelo.FuenteDeIngresos;
import modelo.LineaDeArticulos;
import modelo.Negocio;
import modelo.ParametrosIva;
import modelo.Proveedor;
import modelo.PuntoDeVenta;
import modelo.ResolucionDian;
import modelo.Tercero;
import modelo.UnidadDeMedida;
import modelo.Vendedor;
import modelo.vo.datosBasicos.AgenciaVO;
import modelo.vo.datosBasicos.ArticuloVO;
import modelo.vo.datosBasicos.BodegaVO;
import modelo.vo.datosBasicos.CajeroVO;
import modelo.vo.datosBasicos.EmpresaVO;
import modelo.vo.datosBasicos.FuenteDeIngresosVO;
import modelo.vo.datosBasicos.LineaDeArticulosVO;
import modelo.vo.datosBasicos.NegocioVO;
import modelo.vo.datosBasicos.ParametrosIvaVO;
import modelo.vo.datosBasicos.ProveedorVO;
import modelo.vo.datosBasicos.PuntoDeVentaVO;
import modelo.vo.datosBasicos.ResolucionDianVO;
import modelo.vo.datosBasicos.TerceroVO;
import modelo.vo.datosBasicos.UnidadDeMedidaVO;
import modelo.vo.datosBasicos.VendedorVO;
import vista.VentanaPrincipal;

/**
 * Es el puente entra la vista y el modelo, asi como las capas subyacentes.
 * @author Victor Del Rio Prens
 */
public class Coordinador {
    VentanaPrincipal ventanaPrincipal;
    
    /*Metodos para el manejo de las agencias*/

    /**
     *
     * @param agencia
     * @return
     */
    public boolean crearAgencia(AgenciaVO agencia){
        return Agencia.crear(agencia);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarAgencia(int codigo) {
        return Agencia.eliminar(codigo);
    }
    
    /**
     *
     * @param agencia
     * @return
     */
    public boolean editarAgencia(AgenciaVO agencia) {
        return Agencia.editar(agencia);
    }
    
    /**
     *
     * @return
     */
    public List<AgenciaVO> buscarTodasLasAgencias(){
        return Agencia.buscarTodo();
    }
    
    /*Metodos para el manejo de los articulos*/

    /**
     *
     * @param articulo
     * @return
     */
    public boolean crearArticulo(ArticuloVO articulo) {
        return Articulo.crear(articulo);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarArticulo(int codigo){
        return Articulo.eliminar(codigo);
    }
    
    /**
     *
     * @param articulo
     * @return
     */
    public boolean editarArticulo(ArticuloVO articulo){
        return Articulo.editar(articulo);
    }
    
    /**
     *
     * @return
     */
    public List<ArticuloVO> buscarTodosLosArticulos(){
        return Articulo.buscarTodo();
    }
    
    /*Metodos para el manejo de las bodegas*/

    /**
     *
     * @param bodega
     * @return
     */
    public boolean crearBodega(BodegaVO bodega){
        return Bodega.crear(bodega);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarBodega(int codigo) {
        return Bodega.eliminar(codigo);
    }
    
    /**
     *
     * @param bodega
     * @return
     */
    public boolean editarBodega(BodegaVO bodega) {
        return Bodega.editar(bodega);
    }
    
    /**
     *
     * @return
     */
    public List<BodegaVO> buscarTodasLasBodegas(){
        return Bodega.buscarTodo();
    }
    
    /*metodos para el manejo de los cajeros*/

    /**
     *
     * @param cajero
     * @return
     */
    public boolean crearCajero(CajeroVO cajero) {
        return Cajero.crear(cajero);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarCajero(int codigo){
        return Cajero.eliminar(codigo);
    }
    
    /**
     *
     * @param cajero
     * @return
     */
    public boolean editarCajero(CajeroVO cajero){
        return Cajero.editar(cajero);
    }
    
    /**
     *
     * @return
     */
    public List<CajeroVO> buscarTodosLosCajeros(){
        return Cajero.buscarTodo();
    }
    
    /*Metodos para el manejo de las empresas*/

    /**
     *
     * @param empresa
     * @return
     */
    public boolean crearEmpresa(EmpresaVO empresa){
        return Empresa.crear(empresa);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarEmpresa(int codigo) {
        return Empresa.eliminar(codigo);
    }
    
    /**
     *
     * @param empresa
     * @return
     */
    public boolean editarEmpresa(EmpresaVO empresa) {
        return Empresa.editar(empresa);
    }
    
    /**
     *
     * @return
     */
    public List<EmpresaVO> buscarTodasLasEmpresas(){
        return Empresa.buscarTodo();
    }
    
    /*Metodos para el manejo de las fuentes de ingresos*/

    /**
     *
     * @param fuenteDeIngresos
     * @return
     */
    public boolean crearFuenteDeIngresos(FuenteDeIngresosVO fuenteDeIngresos){
        return FuenteDeIngresos.crear(fuenteDeIngresos);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarFuenteDeIngresos(int codigo) {
        return FuenteDeIngresos.eliminar(codigo);
    }
    
    /**
     *
     * @param fuenteDeIngresos
     * @return
     */
    public boolean editarFuenteDeIngresos(FuenteDeIngresosVO fuenteDeIngresos) {
        return FuenteDeIngresos.editar(fuenteDeIngresos);
    }
    
    /**
     *
     * @return
     */
    public List<FuenteDeIngresosVO> buscarTodasLasFuentesDeIngresos(){
        return FuenteDeIngresos.buscarTodo();
    }
    
    /*Metodos para el manejo de las lineas de articulos*/

    /**
     *
     * @param lineaDeArticulos
     * @return
     */
    public boolean crearLineaDeArticulos(LineaDeArticulosVO lineaDeArticulos) {
        return LineaDeArticulos.crear(lineaDeArticulos);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarLineaDeArticulos(int codigo) {
        return LineaDeArticulos.eliminar(codigo);
    }
    
    /**
     *
     * @param lineaDeArticulos
     * @return
     */
    public boolean editarLineaDeArticulos(LineaDeArticulosVO lineaDeArticulos) {
        return LineaDeArticulos.editar(lineaDeArticulos);
    }

    /**
     *
     * @return
     */
    public List<LineaDeArticulosVO> buscarTodasLasLineasDeArticulos() {
        return LineaDeArticulos.buscarTodo();
    }
    
    /*Metodos para el manejo de los negocios*/

    /**
     *
     * @param negocio
     * @return
     */
    public boolean crearNegocio(NegocioVO negocio) {
        return Negocio.crear(negocio);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarNegocio(int codigo){
        return Negocio.eliminar(codigo);
    }
    
    /**
     *
     * @param negocio
     * @return
     */
    public boolean editarNegocio(NegocioVO negocio){
        return Negocio.editar(negocio);
    }
    
    /**
     *
     * @return
     */
    public List<NegocioVO> buscarTodosLosNegocios(){
        return Negocio.buscarTodo();
    }
    
    /*Metodos para el manejo de los parametros IVA*/

    /**
     *
     * @param parametrosIva
     * @return
     */
    public boolean crearParametrosIva(ParametrosIvaVO parametrosIva) {
        return ParametrosIva.crear(parametrosIva);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarParametrosIva(int codigo){
        return ParametrosIva.eliminar(codigo);
    }
    
    /**
     *
     * @param parametrosIva
     * @return
     */
    public boolean editarParametrosIva(ParametrosIvaVO parametrosIva){
        return ParametrosIva.editar(parametrosIva);
    }
    
    /**
     *
     * @return
     */
    public List<ParametrosIvaVO> buscarTodosLosParametrosIva(){
        return ParametrosIva.buscarTodo();
    }
    
    /*Metodos para el manejo de los proveedores*/

    /**
     *
     * @param proveedor
     * @return
     */
    public boolean crearProveedor(ProveedorVO proveedor) {
        return Proveedor.crear(proveedor);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarProveedor(int codigo){
        return Proveedor.eliminar(codigo);
    }
    
    /**
     *
     * @param proveedor
     * @return
     */
    public boolean editarProveedor(ProveedorVO proveedor) {
        return Proveedor.editar(proveedor);
    }

    /**
     *
     * @return
     */
    public List<ProveedorVO> buscarTodosLosProveedores() {
        return Proveedor.buscarTodo();
    }
    
    /*Metodos para el manejo de los puntos de venta*/

    /**
     *
     * @param puntoDeVenta
     * @return
     */
    public boolean crearPuntoDeVenta(PuntoDeVentaVO puntoDeVenta) {
        return PuntoDeVenta.crear(puntoDeVenta);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarPuntoDeVenta(int codigo){
        return PuntoDeVenta.eliminar(codigo);
    }
    
    /**
     *
     * @param puntoDeVenta
     * @return
     */
    public boolean editarPuntoDeVenta(PuntoDeVentaVO puntoDeVenta){
        return PuntoDeVenta.editar(puntoDeVenta);
    }
    
    /**
     *
     * @return
     */
    public List<PuntoDeVentaVO> buscarTodosLosPuntosDeVenta(){
        return PuntoDeVenta.buscarTodo();
    }
    
    /*Metodos para el manejo de las resoluciones DIAN*/

    /**
     *
     * @param resolucionDian
     * @return
     */
    public boolean crearResolucionDian(ResolucionDianVO resolucionDian){
        return ResolucionDian.crear(resolucionDian);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarResolucionDian(int codigo) {
        return ResolucionDian.eliminar(codigo);
    }
    
    /**
     *
     * @param resolucionDian
     * @return
     */
    public boolean editarResolucionDian(ResolucionDianVO resolucionDian) {
        return ResolucionDian.editar(resolucionDian);
    }
    
    /**
     *
     * @return
     */
    public List<ResolucionDianVO> buscarTodasLasResolucionesDian(){
        return ResolucionDian.buscarTodo();
    }
    
    /*Metodos para el manejo de los Terceros*/

    /**
     *
     * @param tercero
     * @return
     */
    public boolean crearTercero(TerceroVO tercero) {
        return Tercero.crear(tercero);
    }
    
    /**
     *
     * @param cedula
     * @return
     */
    public boolean eliminarTercero(int cedula){
        return Tercero.eliminar(cedula);
    }
    
    /**
     *
     * @param tercero
     * @return
     */
    public boolean editarTercero(TerceroVO tercero){
        return Tercero.editar(tercero);
    }
    
    /**
     *
     * @return
     */
    public List<TerceroVO> buscarTodosLosTerceros(){
        return Tercero.buscarTodo();
    }
    
    /*Metodos para el manejo de las unidades de medida*/

    /**
     *
     * @param unidadDeMedida
     * @return
     */
    public boolean crearUnidadDeMedida(UnidadDeMedidaVO unidadDeMedida){
        return UnidadDeMedida.crear(unidadDeMedida);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarUnidadDeMedida(int codigo) {
        return UnidadDeMedida.eliminar(codigo);
    }
    
    /**
     *
     * @param unidadDeMedida
     * @return
     */
    public boolean editarUnidadDeMedida(UnidadDeMedidaVO unidadDeMedida) {
        return UnidadDeMedida.editar(unidadDeMedida);
    }
    
    /**
     *
     * @return
     */
    public List<UnidadDeMedidaVO> buscarTodasLasUnidadesDeMedida(){
        return UnidadDeMedida.buscarTodo();
    }
    
    /*Metodos para el manejo de los vendedores*/

    /**
     *
     * @param vendedor
     * @return
     */
    public boolean crearVendedor(VendedorVO vendedor) {
        return Vendedor.crear(vendedor);
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean eliminarVendedor(int codigo){
        return Vendedor.eliminar(codigo);
    }
    
    /**
     *
     * @param vendedor
     * @return
     */
    public boolean editarVendedor(VendedorVO vendedor){
        return Vendedor.editar(vendedor);
    }
    
    /**
     *
     * @return
     */
    public List<VendedorVO> buscarTodosLosVendedores(){
        return Vendedor.buscarTodo();
    }
    
    /*Metodos de acceso*/

    /**
     *
     * @return
     */
    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    /**
     *
     * @param ventanaPrincipal
     */
    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }
    
}
