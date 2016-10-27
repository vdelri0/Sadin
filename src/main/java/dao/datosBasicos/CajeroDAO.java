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
import modelo.vo.datosBasicos.CajeroVO;
import utilidades.Dao;

/**
 * Realiza las transacciones con la base de datos respecto a la tabla cajeros.
 * @author Victor Del Rio Prens
 */
public class CajeroDAO {
    private final String crearCajero = "src/main/resources/queries/datosBasicos/cajeros/crearCajero.sql";
    private final String eliminarCajero = "src/main/resources/queries/datosBasicos/cajeros/eliminarCajero.sql";
    private final String editarCajero = "src/main/resources/queries/datosBasicos/cajeros/editarCajero.sql";
    private final String buscarTodosLosCajeros = "src/main/resources/queries/datosBasicos/cajeros/buscarTodosLosCajeros.sql";
    private final String cajeroNoCreado = "Problemas al crear el cajero";
    private final String cajeroNoEliminado = "Problemas para eliminar el cajero";
    private final String cajeroNoEditado = "problemas para editar el cajero";
    private final String cajerosNoBuscados = "Problemas para buscar los cajeros";
    Conexion conexion;
    
    /**
     * Crea un nuevo objeto dentro de la tabla cajeros.
     * @param cajero
     * @return 
     */
    public boolean crear(CajeroVO cajero) {
        boolean creado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearCajero));
            estatuto.setString(1, cajero.getNombre());
            estatuto.setString(2, cajero.getSiglas());
            estatuto.setString(3, cajero.getPrefijo());
            estatuto.setString(4, cajero.getRangoInicial());
            estatuto.setString(5, cajero.getRangoFinal());
            estatuto.setString(6, cajero.getUltimoConsecutivo());
            estatuto.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, cajeroNoCreado, e);
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
     * Elimina un objeto dentro de la tabla cajeros.
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo) {
        boolean eliminado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarCajero));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, cajeroNoEliminado, e);
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
     * Edita un objeto dentro de la tabla cajeros.
     * @param cajero
     * @return 
     */
    public boolean editar(CajeroVO cajero) {
        boolean editado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarCajero));
            estatuto.setString(1, cajero.getNombre());
            estatuto.setString(2, cajero.getSiglas());
            estatuto.setString(3, cajero.getPrefijo());
            estatuto.setString(4, cajero.getRangoInicial());
            estatuto.setString(5, cajero.getRangoFinal());
            estatuto.setString(6, cajero.getUltimoConsecutivo());
            estatuto.setInt(7, cajero.getCodigo());
            estatuto.executeUpdate();
            editado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, cajeroNoEditado, e);
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
     * Retorna todos los objetos dentro de la tabla cajeros.
     * @return 
     */
    public List<CajeroVO> buscarTodo() {
        List<CajeroVO> cajeros = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodosLosCajeros));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                CajeroVO cajero = new CajeroVO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
                cajeros.add(cajero);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, cajerosNoBuscados, e);
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
        return cajeros;
    }

}
