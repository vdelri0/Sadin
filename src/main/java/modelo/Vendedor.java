/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.VendedorDAO;
import java.util.List;
import modelo.vo.datosBasicos.VendedorVO;

/**
 * Realiza el manejo de toda la informacion de los vendedores      
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class Vendedor {
    public static final VendedorDAO vendedorDao = new VendedorDAO();
    
    /**
     * Envia la informacion del vendedor a la capa DAO para que sea creada
     * @param vendedor
     * @return 
     */
    public static boolean crear(VendedorVO vendedor){
        return vendedorDao.crear(vendedor);
    }
    
    /**
     * Envia la informacion del codigo del vendedor a la capa DAO para que sea eliminada
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo){
        return vendedorDao.eliminar(codigo);
    }
    
    /**
     * Envia la informacion del vendedor a la capa DAO para que sea editada
     * @param vendedor
     * @return 
     */
    public static boolean editar(VendedorVO vendedor) {
        return vendedorDao.editar(vendedor);
    }
    
    /**
     * Recibe los vendedores existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<VendedorVO> buscarTodo() {
       return vendedorDao.buscarTodo();
    }
}
