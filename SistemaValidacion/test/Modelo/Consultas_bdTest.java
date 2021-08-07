/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Consumo_WS.Consultas_bd;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mauricio
 */
public class Consultas_bdTest {
    
    public Consultas_bdTest() {
    }

    @Test
    public void testConsultarAppiRest() {
        
        Consultas_bd cns= new Consultas_bd();
        String res= cns.pruebaConeccionApi();
        System.out.println(res);
        assertEquals("ok", res);
        
    }


    
}
