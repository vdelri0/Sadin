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
import modelo.vo.datosBasicos.ArticuloVO;
import utilidades.Dao;

/**
 * Realiza las transacciones con la base de datos respecto a la tabla articulos.
 * @author Victor Del Rio Prens
 */
public class ArticuloDAO {
    private final String crearArticulo = "src/main/resources/queries/datosBasicos/articulos/crearArticulo.sql";
    private final String eliminarArticulo = "src/main/resources/queries/datosBasicos/articulos/eliminarArticulo.sql";
    private final String editarArticulo = "src/main/resources/queries/datosBasicos/articulos/editarArticulo.sql";
    private final String buscarTodosLosArticulos = "src/main/resources/queries/datosBasicos/articulos/buscarTodosLosArticulos.sql";
    private final String articuloNoCreado = "Problemas al crear el articulo";
    private final String articuloNoEliminado = "Problemas para eliminar el articulo";
    private final String articuloNoEditado = "problemas para editar el articulo";
    private final String articulosNoBuscados = "Problemas para buscar los articulos";
    Conexion conexion;
    
    /**
     * Crea un nuevo objeto dentro de la tabla articulos.
     * @param articulo
     * @return 
     */
    public boolean crear(ArticuloVO articulo) {
        boolean creado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearArticulo));
            estatuto.setString(1, articulo.getNombre());
            estatuto.setString(2, articulo.getReferencia());
            estatuto.setString(3, articulo.getPresentacion());
            estatuto.setString(4, articulo.getUnidadDeMedida().getSiglas());
            estatuto.setLong(5, articulo.getUnidadesPorCaja());
            estatuto.setInt(6, articulo.getCodigoDeLinea());
            estatuto.setString(7, articulo.getCuentaDeIngreso());
            estatuto.setString(8, articulo.getCuentaDeCosto());
            estatuto.setLong(9, articulo.getPromedioDeCosto());
            estatuto.setLong(10, articulo.getPrecioDeVenta());
            estatuto.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, articuloNoCreado, e);
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
     * Elimina un objeto dentro de la tabla articulos.
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo) {
        boolean eliminado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarArticulo));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, articuloNoEliminado, e);
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
     * Edita un objeto dentro de la tabla articulos.
     * @param articulo
     * @return 
     */
    public boolean editar(ArticuloVO articulo) {
        boolean editado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarArticulo));
            estatuto.setString(1, articulo.getNombre());
            estatuto.setString(2, articulo.getReferencia());
            estatuto.setString(3, articulo.getPresentacion());
            estatuto.setString(4, articulo.getUnidadDeMedida().getSiglas());
            estatuto.setLong(5, articulo.getUnidadesPorCaja());
            estatuto.setInt(6, articulo.getCodigoDeLinea());
            estatuto.setString(7, articulo.getCuentaDeIngreso());
            estatuto.setString(8, articulo.getCuentaDeCosto());
            estatuto.setLong(9, articulo.getPromedioDeCosto());
            estatuto.setLong(10, articulo.getPrecioDeVenta());
            estatuto.setInt(11, articulo.getCodigo());
            estatuto.executeUpdate();
            editado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, articuloNoEditado, e);
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
     * Retorna todos los objetos dentro de la tabla articulos.
     * @return 
     */
    public List<ArticuloVO> buscarTodo() {
        List<ArticuloVO> articulos = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodosLosArticulos));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                ArticuloVO articulo = new ArticuloVO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getLong(5), resultSet.getInt(6), resultSet.getString(7), resultSet.getString(8), resultSet.getLong(9), resultSet.getLong(10));
                articulos.add(articulo);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, articulosNoBuscados, e);
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
        return articulos;
    }
}
