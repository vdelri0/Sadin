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
import modelo.vo.datosBasicos.ResolucionDianVO;
import utilidades.Dao;

/**
 * Realiza las transacciones con la base de datos respecto a la tabla resolucionesDian.
 * @author Victor Del Rio Prens
 */
public class ResolucionDianDAO {
    private final String crearResolucionDian = "src/main/resources/queries/datosBasicos/resolucionesDian/crearResolucionDian.sql";
    private final String eliminarResolucionDian = "src/main/resources/queries/datosBasicos/resolucionesDian/eliminarResolucionDian.sql";
    private final String editarResolucionDian = "src/main/resources/queries/datosBasicos/resolucionesDian/editarResolucionDian.sql";
    private final String buscarTodasLasResolucionesDian = "src/main/resources/queries/datosBasicos/resolucionesDian/buscarTodasLasResolucionesDian.sql";
    private final String resolucionDianNoCreada = "Problemas al crear la resolucionDian";
    private final String resolucionDianNoEliminada = "Problemas para eliminar la resolucionDian";
    private final String resolucionDianNoEditada = "problemas para editar la resolucionDian";
    private final String resolucionesDianNoBuscadas = "Problemas para buscar las resolucionesDian";
    Conexion conexion;
    
    /**
     * Crea un nuevo objeto dentro de la tabla resolucionesDian.
     * @param resolucionDian
     * @return 
     */
    public boolean crear(ResolucionDianVO resolucionDian) {
        boolean creado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearResolucionDian));
            estatuto.setString(1, resolucionDian.getTipoRegistro());
            estatuto.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, resolucionDianNoCreada, e);
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
     * Elimina un objeto dentro de la tabla resolucionesDian.
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo) {
        boolean eliminado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarResolucionDian));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, resolucionDianNoEliminada, e);
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
     * Edita un objeto dentro de la tabla resolucionesDian.
     * @param resolucionDian
     * @return 
     */
    public boolean editar(ResolucionDianVO resolucionDian) {
        boolean editado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarResolucionDian));
            estatuto.setString(1, resolucionDian.getTipoRegistro());
            estatuto.setInt(2, resolucionDian.getCodigo());
            estatuto.executeUpdate();
            editado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, resolucionDianNoEditada, e);
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
     * Retorna todos los objetos dentro de la tabla resolucionesDian.
     * @return 
     */
    public List<ResolucionDianVO> buscarTodo() {
        List<ResolucionDianVO> resolucionesDian = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodasLasResolucionesDian));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                ResolucionDianVO resolucionDian = new ResolucionDianVO(resultSet.getInt(1), resultSet.getString(2));
                resolucionesDian.add(resolucionDian);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, resolucionesDianNoBuscadas, e);
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
        return resolucionesDian;
    }
}
