/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.VentanaPrincipal;

/**
 * Inicializa los servicios del sistema
 * @author Victor Del Rio Prens
 */
public class Principal {
    private Coordinador coordinador;
    private VentanaPrincipal ventanaPrincipal;
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.iniciar();
    }

    private void iniciar() {
        /*Se instancian los objetos*/
        coordinador = new Coordinador();
        ventanaPrincipal = new VentanaPrincipal();
        
        
        /*Definimos las relaciones entre las clases*/
        ventanaPrincipal.setCoordinador(coordinador);
        
        /*Definimos las relaciones con la clase coordinador*/
        coordinador.setVentanaPrincipal(ventanaPrincipal);
        
        /*Definimos aspectos especificos de los objetos instanciados*/
        ventanaPrincipal.setVisible(true);
        
    }
    
}
