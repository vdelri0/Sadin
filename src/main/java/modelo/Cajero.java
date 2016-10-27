/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.CajeroDAO;
import java.util.List;
import modelo.vo.datosBasicos.CajeroVO;

/**
 * Realiza el manejo de toda la informacion de los cajeros
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class Cajero {
    public static final CajeroDAO cajeroDao = new CajeroDAO();
    
    /**
     * Envia la informacion del cajero a la capa DAO para que sea creado
     * @param cajero
     * @return 
     */
    public static boolean crear(CajeroVO cajero) {
        return cajeroDao.crear(cajero);
    }

    /**
     * Envia la informacion del codigo del cajero a la capa DAO para que sea eliminado
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo) {
        return cajeroDao.eliminar(codigo);
    }

    /**
     * Envia la informacion del cajero a la capa DAO para que sea editado
     * @param cajero
     * @return 
     */
    public static boolean editar(CajeroVO cajero) {
        return cajeroDao.editar(cajero);
    }

    /**
     * Recibe los cajeros existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<CajeroVO> buscarTodo() {
        return cajeroDao.buscarTodo();
    }
    
}
