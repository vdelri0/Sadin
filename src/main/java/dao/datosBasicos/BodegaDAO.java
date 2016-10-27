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
import modelo.vo.datosBasicos.BodegaVO;
import utilidades.Dao;

/**
 * Realiza las transacciones con la base de datos respecto a la tabla bodegas
 * @author Victor Del Rio Prens
 */
public class BodegaDAO {
    private final String crearBodega = "src/main/resources/queries/datosBasicos/bodegas/crearBodega.sql";
    private final String eliminarBodega = "src/main/resources/queries/datosBasicos/bodegas/eliminarBodega.sql";
    private final String editarBodega = "src/main/resources/queries/datosBasicos/bodegas/editarBodega.sql";
    private final String buscarTodasLasBodegas = "src/main/resources/queries/datosBasicos/bodegas/buscarTodasLasBodegas.sql";
    private final String bodegaNoCreada = "Problemas al crear la bodega";
    private final String bodegaNoEliminada = "Problemas para eliminar la bodega";
    private final String bodegaNoEditada = "problemas para editar la bodega";
    private final String bodegasNoBuscadas = "Problemas para buscar las bodegas";
    Conexion conexion;

    /**
     * Crea un nuevo objeto dentro de la tabla bodegas
     * @param bodega
     * @return 
     */
    public boolean crear(BodegaVO bodega) {
        boolean creada = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearBodega));
            estatuto.setString(1, bodega.getNombre());
            estatuto.setString(2, bodega.getDireccion());
            estatuto.setString(3, bodega.getResponsable());
            estatuto.setString(4, bodega.getTelefonos());
            estatuto.executeUpdate();
            creada = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, bodegaNoCreada, e);
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
     * Elimina un objeto dentro de la tabla bodegas
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo){
        boolean eliminada = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarBodega));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminada = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, bodegaNoEliminada, e);
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
     * Edita un objeto dentro de la tabla bodegas
     * @param bodega
     * @return 
     */
    public boolean editar(BodegaVO bodega) {
        boolean editada = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarBodega));
            estatuto.setString(1, bodega.getNombre());
            estatuto.setString(2, bodega.getDireccion());
            estatuto.setString(3, bodega.getResponsable());
            estatuto.setString(4, bodega.getTelefonos());
            estatuto.setInt(5, bodega.getCodigo());
            estatuto.executeUpdate();
            editada = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, bodegaNoEditada, e);
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
     * Retorna todos los objetos dentro de la tabla bodegas
     * @return 
     */
    public List<BodegaVO> buscarTodo() {
        List<BodegaVO> bodegas = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodasLasBodegas));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                BodegaVO bodega = new BodegaVO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                bodegas.add(bodega);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, bodegasNoBuscadas, e);
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
        return bodegas;
    }

}
