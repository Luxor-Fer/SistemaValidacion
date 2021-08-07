/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavalidacion;

import Consumo_WS.Consultas_bd;
import Modelo.*;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author windows
 */
public class SistemaValidacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Consultas_bd cb= new Consultas_bd();
        ArrayList<Empleado> uss;
        uss=cb.consultarEmpleados();
        int tamaño= uss.size();
        int i=0;
        System.out.println(tamaño);
        while(i<tamaño){
            System.out.println(uss.get(i).getCedula()+" "+uss.get(i).getNombre());
            
            i++;
        }
        
        ArrayList<Activo> activos;
        activos=cb.consultarActivosPorUsuario("1804816104");
        int tam=activos.size();
        int j=0;
        System.out.println("tamaño de j es"+tam);
        while(i<tam){
            System.out.println(activos.get(i).getNombre());
            j++;
        }
                
    }
    
}
