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
import modelo.vo.datosBasicos.AgenciaVO;
import utilidades.Dao;

/**
 *
 * @author Victor Del Rio Prens
 */
public class AgenciaDAO {
    private final String crearAgencia = "src/main/resources/queries/datosBasicos/agencias/crearAgencia.sql";
    private final String eliminarAgencia = "src/main/resources/queries/datosBasicos/agencias/eliminarAgencia.sql";
    private final String editarAgencia = "src/main/resources/queries/datosBasicos/agencias/editarAgencia.sql";
    private final String buscarTodasLasAgencias = "src/main/resources/queries/datosBasicos/agencias/buscarTodasLasAgencias.sql";
    private final String agenciaNoCreada = "Problemas al crear la agencia";
    private final String agenciaNoEliminada = "Problemas para eliminar la agencia";
    private final String agenciaNoEditada = "problemas para editar la agencia";
    private final String agenciasNoBuscadas = "Problemas para buscar las agencias";
    Conexion conexion;

    /**
     * Crea un nuevo objeto dentro de la tabla bodegas
     * @param agencia
     * @return 
     */
    public boolean crear(AgenciaVO agencia) {
        boolean creada = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearAgencia));
            estatuto.setString(1, agencia.getNombre());
            estatuto.setString(2, agencia.getDireccion());
            estatuto.setString(3, agencia.getTelefono());
            estatuto.setString(4, agencia.getFax());
            estatuto.setString(5, agencia.getEmail());
            estatuto.setString(6, agencia.getResponsable());
            estatuto.executeUpdate();
            creada = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, agenciaNoCreada, e);
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
     * Elimina un objeto dentro de la tabla agencias
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo){
        boolean eliminada = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarAgencia));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminada = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, agenciaNoEliminada, e);
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
     * Edita un objeto dentro de la tabla agencias
     * @param agencia
     * @return 
     */
    public boolean editar(AgenciaVO agencia) {
        boolean editada = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarAgencia));
            estatuto.setString(1, agencia.getNombre());
            estatuto.setString(2, agencia.getDireccion());
            estatuto.setString(3, agencia.getTelefono());
            estatuto.setString(4, agencia.getFax());
            estatuto.setString(5, agencia.getEmail());
            estatuto.setString(6, agencia.getResponsable());
            estatuto.setInt(7, agencia.getCodigo());
            estatuto.executeUpdate();
            editada = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, agenciaNoEditada, e);
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
     * Retorna todos los objetos dentro de la tabla agencias
     * @return 
     */
    public List<AgenciaVO> buscarTodo() {
        List<AgenciaVO> agencias = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodasLasAgencias));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                AgenciaVO agencia = new AgenciaVO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
                agencias.add(agencia);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, agenciasNoBuscadas, e);
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
        return agencias;
    }
}
