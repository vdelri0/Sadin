/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.datosBasicos.EmpresaDAO;
import java.util.List;
import modelo.vo.datosBasicos.EmpresaVO;

/**
 * Realiza el manejo de toda la informacion de las empresas
 * desde la capa de la logica hasta la capa DAO
 * @author Victor Del Rio Prens
 */
public class Empresa {
    public static final EmpresaDAO empresaDao = new EmpresaDAO();
    
    /**
     * Envia la informacion de la empresa a la capa DAO para que sea creada
     * @param empresa
     * @return 
     */
    public static boolean crear(EmpresaVO empresa){
        return empresaDao.crear(empresa);
    }
    
    /**
     * Envia la informacion del codigo de la empresa a la capa DAO para que sea eliminada
     * @param codigo
     * @return 
     */
    public static boolean eliminar(int codigo){
        return empresaDao.eliminar(codigo);
    }
    
    /**
     * Envia la informacion de la empresa a la capa DAO para que sea editada
     * @param empresa
     * @return 
     */
    public static boolean editar(EmpresaVO empresa) {
        return empresaDao.editar(empresa);
    }
    
    /**
     * Recibe las empresas existentes en la base de datos haciendo uso de la capa DAO
     * @return 
     */
    public static List<EmpresaVO> buscarTodo() {
       return empresaDao.buscarTodo();
    }
}
