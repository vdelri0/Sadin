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
import modelo.vo.datosBasicos.FuenteDeIngresosVO;
import utilidades.Dao;

/**
 * Realiza las transacciones con la base de datos respecto a la tabla fuentesDeIngresos.
 * @author Victor Del Rio Prens
 */
public class FuenteDeIngresosDAO {
    private final String crearFuenteDeIngresos = "src/main/resources/queries/datosBasicos/fuentesDeIngresos/crearFuenteDeIngresos.sql";
    private final String eliminarFuenteDeIngresos = "src/main/resources/queries/datosBasicos/fuentesDeIngresos/eliminarFuenteDeIngresos.sql";
    private final String editarFuenteDeIngresos = "src/main/resources/queries/datosBasicos/fuentesDeIngresos/editarFuenteDeIngresos.sql";
    private final String buscarTodasLasFuentesDeIngresos = "src/main/resources/queries/datosBasicos/fuentesDeIngresos/buscarTodasLasFuentesDeIngresos.sql";
    private final String fuenteDeIngresosNoCreada = "Problemas al crear la fuenteDeIngresos";
    private final String fuenteDeIngresosNoEliminada = "Problemas para eliminar la fuenteDeIngresos";
    private final String fuenteDeIngresosNoEditada = "problemas para editar la fuenteDeIngresos";
    private final String fuentesDeIngresosNoBuscadas = "Problemas para buscar las fuentesDeIngresos";
    Conexion conexion;
    
    /**
     * Crea un nuevo objeto dentro de la tabla fuentesDeIngresos.
     * @param fuentesDeIngresos
     * @return 
     */
    public boolean crear(FuenteDeIngresosVO fuentesDeIngresos) {
        boolean creado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearFuenteDeIngresos));
            estatuto.setString(1, fuentesDeIngresos.getNombre());
            estatuto.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, fuenteDeIngresosNoCreada, e);
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
     * Elimina un objeto dentro de la tabla fuentesDeIngresos
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo) {
        boolean eliminado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarFuenteDeIngresos));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, fuenteDeIngresosNoEliminada, e);
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
     * Edita un objeto dentro de la tabla fuentesDeIngresos
     * @param cajero
     * @return 
     */
    public boolean editar(FuenteDeIngresosVO cajero) {
        boolean editado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarFuenteDeIngresos));
            estatuto.setString(1, cajero.getNombre());
            estatuto.setInt(2, cajero.getCodigo());
            estatuto.executeUpdate();
            editado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, fuenteDeIngresosNoEditada, e);
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
     * Retorna todos los objetos dentro de la tabla fuentesDeIngresos
     * @return 
     */
    public List<FuenteDeIngresosVO> buscarTodo() {
        List<FuenteDeIngresosVO> fuentesDeIngresos = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodasLasFuentesDeIngresos));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                FuenteDeIngresosVO fuenteDeIngresos = new FuenteDeIngresosVO(resultSet.getInt(1), resultSet.getString(2));
                fuentesDeIngresos.add(fuenteDeIngresos);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, fuentesDeIngresosNoBuscadas, e);
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
        return fuentesDeIngresos;
    }
}
