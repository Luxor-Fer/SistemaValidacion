/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumo_WS;

/**
 *
 * @author Mauricio
 */
public class Pruebas {
    public static void main(String[] args) {
        Consultas_bd cs= new Consultas_bd();
        System.out.println(cs.consultarEmpleados().size());
        System.out.println(cs.consultarEmpleados().toString());
        //System.out.println(cs.consultarEmpleados().get(2).getCedula());
        //System.out.println(cs.consultarActivosPorUsuario("1804293825").size());
        
        
        
    }
}
