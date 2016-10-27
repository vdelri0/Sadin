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
import modelo.vo.datosBasicos.VendedorVO;
import utilidades.Dao;

/**
 * Realiza las transacciones con la base de datos respecto a la tabla vendedores.
 * @author Victor Del Rio Prens
 */
public class VendedorDAO {
    private final String crearVendedor = "src/main/resources/queries/datosBasicos/vendedores/crearVendedor.sql";
    private final String eliminarVendedor = "src/main/resources/queries/datosBasicos/vendedores/eliminarVendedor.sql";
    private final String editarVendedor = "src/main/resources/queries/datosBasicos/vendedores/editarVendedor.sql";
    private final String buscarTodosLosVendedores = "src/main/resources/queries/datosBasicos/vendedores/buscarTodosLosVendedores.sql";
    private final String vendedorNoCreado = "Problemas al crear el vendedor";
    private final String vendedorNoEliminado = "Problemas para eliminar el vendedor";
    private final String vendedorNoEditado = "problemas para editar el vendedor";
    private final String vendedoresNoBuscados = "Problemas para buscar los vendedores";
    Conexion conexion;
    
    /**
     * Crea un nuevo objeto dentro de la tabla vendedores.
     * @param vendedor
     * @return 
     */
    public boolean crear(VendedorVO vendedor) {
        boolean creado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearVendedor));
            estatuto.setString(1, vendedor.getNombre());
            estatuto.setString(2, vendedor.getSiglas());
            estatuto.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, vendedorNoCreado, e);
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
     * Elimina un objeto dentro de la tabla vendedores.
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo) {
        boolean eliminado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarVendedor));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, vendedorNoEliminado, e);
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
     * Edita un objeto dentro de la tabla vendedores.
     * @param vendedor
     * @return 
     */
    public boolean editar(VendedorVO vendedor) {
        boolean editado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarVendedor));
            estatuto.setString(1, vendedor.getNombre());
            estatuto.setString(2, vendedor.getSiglas());
            estatuto.setInt(3, vendedor.getCodigo());
            estatuto.executeUpdate();
            editado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, vendedorNoEditado, e);
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
     * Retorna todos los objetos dentro de la tabla vendedores.
     * @return 
     */
    public List<VendedorVO> buscarTodo() {
        List<VendedorVO> vendedores = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodosLosVendedores));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                VendedorVO vendedor = new VendedorVO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                vendedores.add(vendedor);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, vendedoresNoBuscados, e);
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
        return vendedores;
    }
}
