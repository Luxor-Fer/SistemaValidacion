/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavalidacion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author windows
 */
public class ConeccionSQL {
    Connection connect=null;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/sis_validacion","root","");
            //System.out.println("conectado");
            //JOptionPane.showInternalMessageDialog(null, "Se conecto a la base de datos");
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "no se conecto a la bd: "+ ex);
            System.out.println(ex);
        }
        return connect;
    }
}

