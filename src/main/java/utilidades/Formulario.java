/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Maneja todas las operaciones utilitarias que estan relacionadas con formularios
 * @author Victor Del Rio Prens
 */
public class Formulario {
    private final static String respuestaNoDefinida = "No se pudo obtener la respuesta del comboBox";
    
    /**
     * Habilita un conjunto de objetos pertenecientes a una clase especifica
     * @param habilitados
     * @param objetos
     * @param clase 
     */
    public static void habilitarDeshabilitarElementos(boolean habilitados, List<Object> objetos, Class clase){
        if(!objetos.isEmpty()){
            for (Object objeto : objetos) {
                if(clase.isInstance(objeto)){
                    JComponent componente = (JComponent)objeto;
                    componente.setEnabled(habilitados);
                }
            }
        }
    }
    
    /**
     * Obtiene los elementos de un formulario que pertenecen a una clase especifica 
     * @param clase
     * @param objetos
     * @return 
     */
    public static List<Object> obtenerElementos(Class clase, Object[] objetos){
        List<Object> instancias = new ArrayList<>();
        if(objetos != null){
            for (Object objeto : objetos) {
                if(JRootPane.class.isInstance(objeto)){
                    JRootPane panelRaiz = (JRootPane) objeto;
                    Container panelContenedor = panelRaiz.getContentPane();
                    Component[] elementos = panelContenedor.getComponents();
                    for (Component elemento : elementos) {
                        if(clase.isInstance(elemento)){
                            instancias.add(elemento);
                        }
                    }
                }
            }
        }
        return instancias;
    }
    
    /**
     * Toma todos los campos que se encuentran dentro de la lista de objetos y los limpia.
     * @param campos 
     */
    public static void limpiarCampos(List<Object> campos){
        for (Object objetoCampo : campos) {
            if(JTextField.class.isInstance(objetoCampo)){
                JTextField campo = (JTextField) objetoCampo;
                campo.setText(null);
            }
        }
    }
    

        
    
    /**
     * Toma todos los campos y botones, y los deshabilita o habilita
     * @param habilitarCampos
     * @param habilitarBotones
     * @param campos
     * @param botones 
     */
    public static void modificarEstadosElementos(boolean habilitarCampos, boolean habilitarBotones, List<Object> campos, List<Object> botones){
        habilitarDeshabilitarElementos(habilitarCampos, campos, JTextField.class);
        habilitarDeshabilitarElementos(habilitarBotones, botones, JButton.class);
    }
    
    /**
     * Toma todos los campos presentes en el formulario, y valida que no exista
     * ningun campo vacio.
     * @param campos
     * @return 
     */
    public static boolean validarCamposVacios(List<Object> campos){
        boolean valido = true;
        String mensaje = "Por favor llene todos los campos.";
        for (Object objeto : campos) {
            JTextField campo = (JTextField) objeto;
            if(campo.getText().length() == 0 || campo.getText() == null){
                valido = false;
            }
        }
        if(!valido){
            JOptionPane.showMessageDialog(null, mensaje);
        }
        return valido;
    }
    
    /**
     * elimina todas las filas de la tabla de una en una.
     * @param model 
     */
    public static void eliminarTodasLasFilas(DefaultTableModel model){
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    /**
     * Toma un objeto de un comboBox y lo convierte en una respuesta afirmativa o 
     * negativa dependiendo de lo que encuentre
     * @param respuesta
     * @return 
     */
    public static char definirRespuestaComboBox(Object respuesta) {
        char valor = 0;
        try {
            switch((String)respuesta){
                case "Si": valor = 'S';
                case "No": valor = 'N';
            }
        } catch (Exception e) {
            Logger.getLogger(Formulario.class.getName()).log(Level.WARNING, respuestaNoDefinida, e);
        }
        return valor;
    }
}
