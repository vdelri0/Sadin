/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.ProveedorDAO;
import java.util.List;
import modelo.vo.datosBasicos.ProveedorVO;

/**
 * Realiza el manejo de toda la informacion de los proveedores
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class Proveedor {
    public static final ProveedorDAO proveedorDao = new ProveedorDAO();
    
    /**
     * Envia la informacion del proveedor a la capa DAO para que sea creado
     * @param cajero
     * @return 
     */
    public static boolean crear(ProveedorVO cajero) {
        return proveedorDao.crear(cajero);
    }

    /**
     * Envia la informacion del codigo del proveedor a la capa DAO para que sea eliminado
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo) {
        return proveedorDao.eliminar(codigo);
    }

    /**
     * Envia la informacion del proveedor a la capa DAO para que sea editado
     * @param cajero
     * @return 
     */
    public static boolean editar(ProveedorVO cajero) {
        return proveedorDao.editar(cajero);
    }

    /**
     * Recibe los proveedores existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<ProveedorVO> buscarTodo() {
        return proveedorDao.buscarTodo();
    }
}
