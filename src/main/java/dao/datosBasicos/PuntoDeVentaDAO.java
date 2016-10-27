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
import modelo.vo.datosBasicos.PuntoDeVentaVO;
import utilidades.Dao;

/**
 * Realiza las transacciones con la base de datos respecto a la tabla puntosDeVenta.
 * @author Victor Del Rio Prens
 */
public class PuntoDeVentaDAO {
    private final String crearPuntoDeVenta = "src/main/resources/queries/datosBasicos/puntosDeVenta/crearPuntoDeVenta.sql";
    private final String eliminarPuntoDeVenta = "src/main/resources/queries/datosBasicos/puntosDeVenta/eliminarPuntoDeVenta.sql";
    private final String editarPuntoDeVenta = "src/main/resources/queries/datosBasicos/puntosDeVenta/editarPuntoDeVenta.sql";
    private final String buscarTodosLosPuntosDeVenta = "src/main/resources/queries/datosBasicos/puntosDeVenta/buscarTodosLosPuntosDeVenta.sql";
    private final String puntoDeVentaNoCreado = "Problemas al crear el puntoDeVenta";
    private final String puntoDeVentaNoEliminado = "Problemas para eliminar el puntoDeVenta";
    private final String puntoDeVentaNoEditado = "problemas para editar el puntoDeVenta";
    private final String puntosDeVentaNoBuscados = "Problemas para buscar los puntosDeVenta";
    Conexion conexion;
    
    /**
     * Crea un nuevo objeto dentro de la tabla puntosDeVenta.
     * @param puntoDeVenta
     * @return 
     */
    public boolean crear(PuntoDeVentaVO puntoDeVenta) {
        boolean creado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearPuntoDeVenta));
            estatuto.setString(1, puntoDeVenta.getNombre());
            estatuto.setString(2, puntoDeVenta.getDireccion());
            estatuto.setString(3, puntoDeVenta.getTelefonos());
            estatuto.setString(4, puntoDeVenta.getFax());
            estatuto.setString(5, puntoDeVenta.getEmail());
            estatuto.setString(6, puntoDeVenta.getResponsable());
            estatuto.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, puntoDeVentaNoCreado, e);
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
     * Elimina un objeto dentro de la tabla puntosDeVenta.
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo) {
        boolean eliminado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarPuntoDeVenta));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, puntoDeVentaNoEliminado, e);
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
     * Edita un objeto dentro de la tabla puntosDeVenta.
     * @param puntoDeVenta
     * @return 
     */
    public boolean editar(PuntoDeVentaVO puntoDeVenta) {
        boolean editado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarPuntoDeVenta));
            estatuto.setString(1, puntoDeVenta.getNombre());
            estatuto.setString(2, puntoDeVenta.getDireccion());
            estatuto.setString(3, puntoDeVenta.getTelefonos());
            estatuto.setString(4, puntoDeVenta.getFax());
            estatuto.setString(5, puntoDeVenta.getEmail());
            estatuto.setString(6, puntoDeVenta.getResponsable());
            estatuto.setInt(7, puntoDeVenta.getCodigo());
            estatuto.executeUpdate();
            editado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, puntoDeVentaNoEditado, e);
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
     * Retorna todos los objetos dentro de la tabla puntosDeVenta
     * @return 
     */
    public List<PuntoDeVentaVO> buscarTodo() {
        List<PuntoDeVentaVO> puntosDeVenta = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodosLosPuntosDeVenta));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                PuntoDeVentaVO puntoDeVenta = new PuntoDeVentaVO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
                puntosDeVenta.add(puntoDeVenta);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, puntosDeVentaNoBuscados, e);
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
        return puntosDeVenta;
    }
}
