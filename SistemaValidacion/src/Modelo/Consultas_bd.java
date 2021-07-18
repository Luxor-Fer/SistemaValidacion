/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemavalidacion.ConeccionSQL;

/**
 *
 * @author Mauricio
 */
public class Consultas_bd {
    ResultSet dato;
    Statement st;
    Connection cn;
    public Consultas_bd() {
       ConeccionSQL con= new ConeccionSQL();
       cn=con.conectar();
       }
    
    public Usuario_Modelo consultarUsuario(String cedula){
        String consulta = "Select * from usuario where CED_USU='"+cedula+"'";
        Usuario_Modelo usu = null;
        try {
            st= cn.createStatement();
            dato =st.executeQuery(consulta);
            if (!dato.next()) {
                return null;
            }
                usu = new Usuario_Modelo();
                usu.setCedula(dato.getString(1));
                usu.setNombre(dato.getString(2));
                usu.setApellido(dato.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usu;
    }
    public Activo_Modelo consultarActivoPorId(int id){
        String consulta = "Select * from activos where ID_ACT="+id;
        Activo_Modelo act = null;
        try {
            st= cn.createStatement();
            dato =st.executeQuery(consulta);
            if (!dato.next()) {
                return null;
            }
                act = new Activo_Modelo();
                act.setId(dato.getInt(1));
                act.setUsuario(new Consultas_bd().consultarUsuario(dato.getString(2)));
                act.setNombre(dato.getString(3));
                act.setObservacion(dato.getString(4));
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return act;
    }
    public ArrayList<Activo_Modelo> consultarActivosPorUsuario(String cedula){
        ArrayList<Activo_Modelo> acts= new ArrayList();
        String consulta = "Select * from activos where CED_USU_PER='"+cedula+"'";
        Activo_Modelo act = null;
        try {
            st= cn.createStatement();
            dato =st.executeQuery(consulta);
            while (dato.next()) {
                act = new Activo_Modelo();
                act.setId(dato.getInt(1));
                act.setUsuario(new Consultas_bd().consultarUsuario(dato.getString(2)));
                act.setNombre(dato.getString(3));
                act.setObservacion(dato.getString(4));
                acts.add(act);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acts;
    }
    public ArrayList<Usuario_Modelo> consultarUsuarios(){
        ArrayList<Usuario_Modelo> usus= new ArrayList();
        String consulta = "Select * from usuario";
        Usuario_Modelo usu;
        try{
            st=cn.createStatement();
            dato =st.executeQuery(consulta);
            while(dato.next()){
                usu=new Usuario_Modelo();
               usu.setCedula(dato.getString(1));
               usu.setNombre(dato.getString(2));
               usu.setApellido(dato.getString(3));
               usus.add(usu);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usus;
        
    }
            
    
}
