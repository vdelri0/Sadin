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
import modelo.vo.datosBasicos.LineaDeArticulosVO;
import utilidades.Dao;

/**
 *
 * @author Victor Del Rio Prens
 */
public class LineaDeArticulosDAO {
    private final String crearLineaDeArticulos = "src/main/resources/queries/datosBasicos/lineasDeArticulos/crearLineaDeArticulos.sql";
    private final String eliminarLineaDeArticulos = "src/main/resources/queries/datosBasicos/lineasDeArticulos/eliminarLineaDeArticulos.sql";
    private final String editarLineaDeArticulos = "src/main/resources/queries/datosBasicos/lineasDeArticulos/editarLineaDeArticulos.sql";
    private final String buscarTodasLasLineaDeArticulos = "src/main/resources/queries/datosBasicos/lineasDeArticulos/buscarTodasLasLineasDeArticulos.sql";
    private final String lineaDeArticulosNoCreada = "Problemas al crear la lineaDeArticulos";
    private final String lineaDeArticulosNoEliminada = "Problemas para eliminar la lineaDeArticulos";
    private final String lineaDeArticulosNoEditada = "problemas para editar la lineaDeArticulos";
    private final String lineaDeArticulosNoBuscadas = "Problemas para buscar las lineasDeArticuloss";
    Conexion conexion;
    
    /**
     * Crear un nuevo objeto en la tabla lineasArticulos
     * @param lineaDeArticulos
     * @return 
     */
    public boolean crear(LineaDeArticulosVO lineaDeArticulos) {
        boolean creada = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearLineaDeArticulos));
            estatuto.setString(1, lineaDeArticulos.getDescripcion());
            estatuto.executeUpdate();
            creada = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, lineaDeArticulosNoCreada, e);
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
     * Edita un objeto dentro de la tabla lineasArticulos
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo) {
        boolean eliminada = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarLineaDeArticulos));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminada = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, lineaDeArticulosNoEliminada, e);
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
     * Edita un objeto dentro de la tabla lineasArticulos
     * @param lineaDeArticulos
     * @return 
     */
    public boolean editar(LineaDeArticulosVO lineaDeArticulos) {
        boolean editada = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarLineaDeArticulos));
            estatuto.setString(1, lineaDeArticulos.getDescripcion());
            estatuto.setInt(2, lineaDeArticulos.getCodigo());
            estatuto.executeUpdate();
            editada = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, lineaDeArticulosNoEditada, e);
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
     * Retorna todos los objetos dentro de la tabla lineasArticulos
     * @return 
     */
    public List<LineaDeArticulosVO> buscarTodo() {
        List<LineaDeArticulosVO> lineasDeArticulos = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodasLasLineaDeArticulos));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                LineaDeArticulosVO lineaDeArticulos = new LineaDeArticulosVO(resultSet.getInt(1), resultSet.getString(2));
                lineasDeArticulos.add(lineaDeArticulos);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, lineaDeArticulosNoBuscadas, e);
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
        return lineasDeArticulos;
    }
    
}
