/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.datosBasicos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.vo.datosBasicos.EmpresaVO;
import utilidades.Dao;

/**
 * Realiza las transacciones con la base de datos respecto a la tabla empresas.
 * @author Victor Del Rio Prens
 */
public class EmpresaDAO {
    private final String crearEmpresa = "src/main/resources/queries/datosBasicos/empresas/crearEmpresa.sql";
    private final String eliminarEmpresa = "src/main/resources/queries/datosBasicos/empresas/eliminarEmpresa.sql";
    private final String editarEmpresa = "src/main/resources/queries/datosBasicos/empresas/editarEmpresa.sql";
    private final String buscarTodasLasEmpresas = "src/main/resources/queries/datosBasicos/empresas/buscarTodasLasEmpresas.sql";
    private final String empresaNoCreada = "Problemas al crear la empresa";
    private final String empresaNoEliminada = "Problemas para eliminar la empresa";
    private final String empresaNoEditada = "problemas para editar la empresa";
    private final String empresasNoBuscadas = "Problemas para buscar las empresas";
    Conexion conexion;

    /**
     * Crea un nuevo objeto dentro de la tabla empresas
     * @param empresa
     * @return 
     */
    public boolean crear(EmpresaVO empresa) {
        boolean creada = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearEmpresa));
            estatuto.setString(1, empresa.getNombre());
            estatuto.executeUpdate();
            creada = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, empresaNoCreada, e);
        } finally {
            try {
                if(estatuto != null){
                    estatuto.close();
                }
                if(conexion != null){
                    conexion.desconectar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return creada;
    }
    
    /**
     * Elimina un objeto dentro de la tabla empresas
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo){
        boolean eliminada = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarEmpresa));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminada = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, empresaNoEliminada, e);
        } finally {
            try {
                if(estatuto != null){
                    estatuto.close();
                }
                if(conexion != null){
                    conexion.desconectar();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return eliminada;
    }

    /**
     * Edita un objeto dentro de la tabla empresas
     * @param empresa
     * @return 
     */
    public boolean editar(EmpresaVO empresa) {
        boolean editada = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarEmpresa));
            estatuto.setString(1, empresa.getNombre());
            estatuto.setInt(2, empresa.getCodigo());
            estatuto.executeUpdate();
            editada = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, empresaNoEditada, e);
        } finally {
            try {
                if(estatuto != null){
                    estatuto.close();
                }
                if(conexion != null){
                    conexion.desconectar();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return editada;
    }
    
    /**
     * Retorna todos los objetos dentro de la tabla empresas
     * @return 
     */
    public List<EmpresaVO> buscarTodo() {
        List<EmpresaVO> empresas = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodasLasEmpresas));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                EmpresaVO empresa = new EmpresaVO(resultSet.getInt(1), resultSet.getString(2));
                empresas.add(empresa);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, empresasNoBuscadas, e);
        } finally {
            try {
                if(resultSet != null){
                    resultSet.close();
                }
                if(estatuto != null){
                    estatuto.close();
                }
                if(conexion != null){
                    conexion.desconectar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empresas;
    }
}
