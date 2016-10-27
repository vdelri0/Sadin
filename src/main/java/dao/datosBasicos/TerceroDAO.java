/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.datosBasicos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.vo.datosBasicos.EmpresaVO;
import modelo.vo.datosBasicos.TerceroVO;
import utilidades.Dao;

/**
 * Realiza las transacciones con la base de datos respecto a la tabla terceros.
 * @author Victor Del Rio Prens
 */
public class TerceroDAO {
    private final String crearTercero = "src/main/resources/queries/datosBasicos/terceros/crearTercero.sql";
    private final String eliminarTercero = "src/main/resources/queries/datosBasicos/terceros/eliminarTercero.sql";
    private final String editarTercero = "src/main/resources/queries/datosBasicos/terceros/editarTercero.sql";
    private final String buscarTodosLosTerceros = "src/main/resources/queries/datosBasicos/terceros/buscarTodosLosTerceros.sql";
    private final String terceroNoCreado = "Problemas al crear el tercero";
    private final String terceroNoEliminado = "Problemas para eliminar el tercero";
    private final String terceroNoEditado = "problemas para editar el tercero";
    private final String tercerosNoBuscados = "Problemas para buscar los terceros";
    Conexion conexion;
    
    /**
     * Crea un nuevo objeto dentro de la tabla terceros.
     * @param tercero
     * @return 
     */
    public boolean crear(TerceroVO tercero) {
        boolean creado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearTercero));
            estatuto.setString(1, tercero.getNombre());
            estatuto.setString(2, tercero.getDireccion());
            estatuto.setString(3, tercero.getTelefonos());
            estatuto.setInt(4, tercero.getEmpresa().getCodigo());
            estatuto.setString(5, tercero.getEmpresa().getNombre());
            estatuto.setDate(6, new Date(tercero.getFechaNacimiento().getTime()));
            estatuto.setString(7, tercero.getEmail());
            estatuto.setString(8, tercero.getCelular());
            estatuto.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, terceroNoCreado, e);
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
     * Elimina un objeto dentro de la tabla terceros.
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo) {
        boolean eliminado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarTercero));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, terceroNoEliminado, e);
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
     * Edita un objeto dentro de la tabla terceros.
     * @param tercero
     * @return 
     */
    public boolean editar(TerceroVO tercero) {
        boolean editado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarTercero));
            estatuto.setString(1, tercero.getNombre());
            estatuto.setString(2, tercero.getDireccion());
            estatuto.setString(3, tercero.getTelefonos());
            estatuto.setInt(4, tercero.getEmpresa().getCodigo());
            estatuto.setString(5, tercero.getEmpresa().getNombre());
            estatuto.setDate(6, new Date(tercero.getFechaNacimiento().getTime()));
            estatuto.setString(7, tercero.getEmail());
            estatuto.setString(8, tercero.getCelular());
            estatuto.setInt(9, tercero.getCedula());
            estatuto.executeUpdate();
            editado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, terceroNoEditado, e);
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
     * Retorna todos los objetos dentro de la tabla terceros.
     * @return 
     */
    public List<TerceroVO> buscarTodo() {
        List<TerceroVO> terceros = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodosLosTerceros));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                EmpresaVO empresa = new EmpresaVO(resultSet.getInt(5),resultSet.getString(6));
                TerceroVO tercero = new TerceroVO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), empresa, resultSet.getDate(7), resultSet.getString(8), resultSet.getString(9));
                terceros.add(tercero);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, tercerosNoBuscados, e);
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
        return terceros;
    }
}
