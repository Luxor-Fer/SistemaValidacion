/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavalidacion;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mauricio
 */
public class ConeccionSQLTest {
    
    public ConeccionSQLTest() {
    }

    @Test
    public void testConectar() throws SQLException {
        System.out.println("Prueba de conección");
        ConeccionSQL con = new ConeccionSQL();
        Connection prueba= con.conectar();
         boolean res=prueba.isValid(0);
         int i=0;
         if(res){
             i=1;
         }
        assertEquals(1, i);
        
    }
    
}
