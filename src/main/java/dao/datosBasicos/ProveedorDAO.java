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
import modelo.vo.datosBasicos.ProveedorVO;
import utilidades.Dao;

/**
 * Realiza las transacciones con la base de datos respecto a la tabla proveedores.
 * @author Victor Del Rio Prens
 */
public class ProveedorDAO {
    private final String crearProveedor = "src/main/resources/queries/datosBasicos/proveedores/crearProveedor.sql";
    private final String eliminarProveedor = "src/main/resources/queries/datosBasicos/proveedores/eliminarProveedor.sql";
    private final String editarProveedor = "src/main/resources/queries/datosBasicos/proveedores/editarProveedor.sql";
    private final String buscarTodosLosProveedores = "src/main/resources/queries/datosBasicos/proveedores/buscarTodosLosProveedores.sql";
    private final String proveedorNoCreado = "Problemas al crear el proveedor";
    private final String proveedorNoEliminado = "Problemas para eliminar el proveedor";
    private final String proveedorNoEditado = "problemas para editar el proveedor";
    private final String proveedoresNoBuscados = "Problemas para buscar los proveedores";
    Conexion conexion;

    /**
     * Crea un nuevo objeto dentro de la tabla proveedores
     * @param proveedor
     * @return 
     */
    public boolean crear(ProveedorVO proveedor) {
        boolean creado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(crearProveedor));
            estatuto.setString(1, proveedor.getNombre());
            estatuto.setString(2, proveedor.getNit());
            estatuto.setString(3, proveedor.getDireccion());
            estatuto.setString(4, proveedor.getTelefonos());
            estatuto.setString(5, proveedor.getRepresentante());
            estatuto.setString(6, proveedor.getEmail());
            estatuto.setString(7, proveedor.getFax());
            estatuto.setString(8, proveedor.getCuentaContable());
            estatuto.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, proveedorNoCreado, e);
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
     * Elimina un objeto dentro de la tabla proveedores
     * @param codigo
     * @return 
     */
    public boolean eliminar(int codigo) {
        boolean eliminado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(eliminarProveedor));
            estatuto.setInt(1, codigo);
            estatuto.executeUpdate();
            eliminado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, proveedorNoEliminado, e);
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
     * Edita un objeto dentro de la tabla proveedores
     * @param proveedor
     * @return 
     */
    public boolean editar(ProveedorVO proveedor) {
        boolean editado = false;
        PreparedStatement estatuto = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(editarProveedor));
            estatuto.setString(1, proveedor.getNombre());
            estatuto.setString(2, proveedor.getNit());
            estatuto.setString(3, proveedor.getDireccion());
            estatuto.setString(4, proveedor.getTelefonos());
            estatuto.setString(5, proveedor.getRepresentante());
            estatuto.setString(6, proveedor.getEmail());
            estatuto.setString(7, proveedor.getFax());
            estatuto.setString(8, proveedor.getCuentaContable());
            estatuto.setInt(9, proveedor.getCodigo());
            estatuto.executeUpdate();
            editado = true;
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, proveedorNoEditado, e);
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
     * Retorna todos los objetos dentro de la tabla proveedores
     * @return 
     */
    public List<ProveedorVO> buscarTodo() {
        List<ProveedorVO> cajeros = new ArrayList<>();
        PreparedStatement estatuto = null;
        ResultSet resultSet = null;
        conexion = new Conexion();
        try {
            conexion.conectar();
            estatuto = conexion.getConexion().prepareStatement(Dao.retornarQuery(buscarTodosLosProveedores));
            resultSet = estatuto.executeQuery();
            while (resultSet.next()) {
                ProveedorVO cajero = new ProveedorVO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9));
                cajeros.add(cajero);
            }
        } catch (SQLException e) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.WARNING, proveedoresNoBuscados, e);
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
