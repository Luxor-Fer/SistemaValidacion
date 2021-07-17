/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavalidacion;

import java.sql.Connection;
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
        
    }
    
}
