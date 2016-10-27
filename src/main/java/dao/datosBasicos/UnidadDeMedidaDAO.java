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
import modelo.vo.datosBasicos.UnidadDeMedidaVO;
import utilidades.Dao;

/**
 * Realiza las transacciones con la base de datos respecto a la tabla unidadesDeMedida.
 * @author Victor Del Rio Prens
 */
public class UnidadDeMedidaDAO {
    private final String crearUnidadDeMedida = "src/main/resources/queries/datosBasicos/unidadesDeMedida/crearUnidadDeMedida.sql";
    private final String eliminarUnidadDeMedida = "src/main/resources/queries/datosBasicos/unidadesDeMedida/eliminarUnidadDeMedida.sql";
    private final String editarUnidadDeMedida = "src/main/resources/queries/datosBasicos/unidadesDeMedida/editarUnidadDeMedida.sql";
    private final String buscarTodasLasUnidadesDeMedida = "src/main/resources/queries/datosBasicos/unidadesDeMedida/buscarTodasLasUnidadesDeMedida.sql";
    private final String unidadDeMedidaNoCreada = "Problemas al crear la unidadDeMedida";
    private final String unidadDeMedidaNoEliminada = "Problemas para eliminar la unidadDeMedida";
    private final String unidadDeMedidaNoEditada = "problemas para editar la unidadDeMedida";
    private final String unidadesDeMedidaNoBuscadas = "Problemas para buscar las unidadesDeMedida";
    Conexion conexion;
    
    /**
     * Crea un nuevo objeto dentro de la tabla unidadesDeMedida.
     * @param unidadDeMedida
     * @return 
     */
    public boolean crear(UnidadDeMedidaVO unidadDeMedida) {
        boolean creado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearUnidadDeMedida));
            estatuto.setString(1, unidadDeMedida.getDescripcion());
            estatuto.setString(2, unidadDeMedida.getSiglas());
            estatuto.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, unidadDeMedidaNoCreada, e);
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
        return creado;
    }

    /**
     * Elimina un objeto dentro de la tabla unidadesDeMedida
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo) {
        boolean eliminado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarUnidadDeMedida));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, unidadDeMedidaNoEliminada, e);
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
        return eliminado;
    }

    /**
     * Edita un objeto dentro de la tabla unidadesDeMedida
     * @param unidadDeMedida
     * @return 
     */
    public boolean editar(UnidadDeMedidaVO unidadDeMedida) {
        boolean editado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarUnidadDeMedida));
            estatuto.setString(1, unidadDeMedida.getDescripcion());
            estatuto.setString(2, unidadDeMedida.getSiglas());
            estatuto.setInt(3, unidadDeMedida.getCodigo());
            estatuto.executeUpdate();
            editado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, unidadDeMedidaNoEditada, e);
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
        return editado;
    }

    /**
     * Retorna todos los objetos dentro de la tabla unidadesDeMedida
     * @return 
     */
    public List<UnidadDeMedidaVO> buscarTodo() {
        List<UnidadDeMedidaVO> unidadesDeMedida = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodasLasUnidadesDeMedida));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                UnidadDeMedidaVO unidadDeMedida = new UnidadDeMedidaVO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                unidadesDeMedida.add(unidadDeMedida);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, unidadesDeMedidaNoBuscadas, e);
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
        return unidadesDeMedida;
    }
}
