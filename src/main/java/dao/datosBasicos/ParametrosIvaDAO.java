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
import modelo.vo.datosBasicos.ParametrosIvaVO;
import utilidades.Dao;

/**
 * Realiza las transacciones con la base de datos respecto a la tabla cajeros.
 * @author Victor Del Rio Prens
 */
public class ParametrosIvaDAO {
    private final String crearParametrosIva = "src/main/resources/queries/datosBasicos/parametrosIva/crearParametrosIva.sql";
    private final String eliminarParametrosIva = "src/main/resources/queries/datosBasicos/parametrosIva/eliminarParametrosIva.sql";
    private final String editarParametrosIva = "src/main/resources/queries/datosBasicos/parametrosIva/editarParametrosIva.sql";
    private final String buscarTodosLosParametrosIvas = "src/main/resources/queries/datosBasicos/parametrosIva/buscarTodosLosParametrosIva.sql";
    private final String parametrosIvaNoCreados = "Problemas al crear el parametrosIva";
    private final String parametrosIvaNoEliminados = "Problemas para eliminar el parametrosIva";
    private final String parametrosIvaNoEditados = "problemas para editar el parametrosIva";
    private final String parametrosIvaNoBuscados = "Problemas para buscar los parametrosIva";
    Conexion conexion;
    
    /**
     * Crea un nuevo objeto dentro de la tabla parametrosIVA.
     * @param parametrosIva
     * @return 
     */
    public boolean crear(ParametrosIvaVO parametrosIva) {
        boolean creado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearParametrosIva));
            estatuto.setInt(1, parametrosIva.getPorcentaje());
            estatuto.setString(2, String.valueOf(parametrosIva.getAplicarParaTodos()));
            estatuto.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, parametrosIvaNoCreados, e);
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
     * Elimina un objeto dentro de la tabla parametrosIVA.
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo) {
        boolean eliminado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarParametrosIva));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, parametrosIvaNoEliminados, e);
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
     * Edita un objeto dentro de la tabla parametrosIVA.
     * @param parametrosIva
     * @return 
     */
    public boolean editar(ParametrosIvaVO parametrosIva) {
        boolean editado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarParametrosIva));
            estatuto.setInt(1, parametrosIva.getPorcentaje());
            estatuto.setString(2, String.valueOf(parametrosIva.getAplicarParaTodos()));
            estatuto.setInt(3, parametrosIva.getCodigo());
            estatuto.executeUpdate();
            editado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, parametrosIvaNoEditados, e);
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
     * Retorna todos los objetos dentro de la tabla parametrosIVA.
     * @return 
     */
    public List<ParametrosIvaVO> buscarTodo() {
        List<ParametrosIvaVO> conjuntoParametrosIva = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodosLosParametrosIvas));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                ParametrosIvaVO parametrosIva = new ParametrosIvaVO(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3).charAt(0));
                conjuntoParametrosIva.add(parametrosIva);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, parametrosIvaNoBuscados, e);
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
        return conjuntoParametrosIva;
    }
}
