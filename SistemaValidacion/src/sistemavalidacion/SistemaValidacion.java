/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavalidacion;

import Modelo.Activo_Modelo;
import Modelo.Consultas_bd;
import Modelo.Usuario_Modelo;
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
        ConeccionSQL cc = new ConeccionSQL();
        Connection cn = cc.conectar();
        
        Activo_Modelo am= new Activo_Modelo();
        Consultas_bd cbd= new Consultas_bd();
        Usuario_Modelo us= cbd.consultarUsuario("1804816104");
        int cantActivos=us.getCantidadActivos();
        ArrayList<Activo_Modelo> acts= us.getActivos();
        int i=0;
        System.out.println("ID:"+us.getCedula()+"   Activos:"+cantActivos);
        System.out.println("USUARIO:"+us.getNombre());
        System.out.println("--------------------------------------------");
        System.out.printf("%-15S%-25S\n","DETALLE","OBSERVACION");
        System.out.println("--------------------------------------------");
        while(i<cantActivos){
            System.out.printf("%-15S%-25S\n",acts.get(i).getNombre(),acts.get(i).getObservacion());
            i++;
        }
        
        
    }
    
}
