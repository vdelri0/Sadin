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
import modelo.vo.datosBasicos.NegocioVO;
import utilidades.Dao;

/**
 * Realiza las transacciones con la base de datos respecto a la tabla negocios.
 * @author Victor Del Rio Prens
 */
public class NegocioDAO {
    private final String crearNegocio = "src/main/resources/queries/datosBasicos/negocios/crearNegocio.sql";
    private final String eliminarNegocio = "src/main/resources/queries/datosBasicos/negocios/eliminarNegocio.sql";
    private final String editarNegocio = "src/main/resources/queries/datosBasicos/negocios/editarNegocio.sql";
    private final String buscarTodosLosNegocios = "src/main/resources/queries/datosBasicos/negocios/buscarTodosLosNegocios.sql";
    private final String negocioNoCreado = "Problemas al crear el negocio";
    private final String negocioNoEliminado = "Problemas para eliminar el negocio";
    private final String negocioNoEditado = "problemas para editar el negocio";
    private final String negociosNoBuscados = "Problemas para buscar los negocios";
    Conexion conexion;
    
    /**
     * Crea un nuevo objeto dentro de la tabla negocios
     * @param negocio
     * @return 
     */
    public boolean crear(NegocioVO negocio) {
        boolean creado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearNegocio));
            estatuto.setString(1, negocio.getNombre());
            estatuto.setString(2, negocio.getPropietario());
            estatuto.setString(3, negocio.getDireccion());
            estatuto.setString(4, negocio.getCiudad());
            estatuto.setString(5, negocio.getTelefonos());
            estatuto.setString(6, negocio.getNit());
            estatuto.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, negocioNoCreado, e);
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
     * Elimina un objeto dentro de la tabla negocios
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo) {
        boolean eliminado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarNegocio));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, negocioNoEliminado, e);
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
     * Edita un objeto dentro de la tabla negocios
     * @param negocio
     * @return 
     */
    public boolean editar(NegocioVO negocio) {
        boolean editado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarNegocio));
            estatuto.setString(1, negocio.getNombre());
            estatuto.setString(2, negocio.getPropietario());
            estatuto.setString(3, negocio.getDireccion());
            estatuto.setString(4, negocio.getCiudad());
            estatuto.setString(5, negocio.getTelefonos());
            estatuto.setString(6, negocio.getNit());
            estatuto.setInt(7, negocio.getCodigo());
            estatuto.executeUpdate();
            editado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, negocioNoEditado, e);
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
     * Retorna todos los objetos dentro de la tabla negocios
     * @return 
     */
    public List<NegocioVO> buscarTodo() {
        List<NegocioVO> negocios = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodosLosNegocios));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                NegocioVO negocio = new NegocioVO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
                negocios.add(negocio);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, negociosNoBuscados, e);
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
        return negocios;
    }

}
