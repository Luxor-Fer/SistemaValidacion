/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import com.devazt.networking.HttpClient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
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
        ArrayList<Usuario_Modelo> usus=new ArrayList();
            try { 
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete(){
            @Override
            public void onComplete(Response status){
                if(status.isSuccess())
                {
                    try {
                        JSONObject usuarios= new JSONObject(status.getResult());
                        JSONArray ususs= usuarios.getJSONArray("result");
                        int i=0;
                            JSONObject ob= ususs.getJSONObject(i);
                            Usuario_Modelo usu;
                            usu=new Usuario_Modelo();
                            usu.setCedula(ob.getString("CED_USU"));
                            usu.setNombre(ob.getString("NOM_USU"));
                            usu.setApellido(ob.getString("APE_USU"));
                            usus.add(usu);
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute("http://localhost/sisvalidacion/restApi/usuario?usuario="+cedula);
        } catch (Exception e) {
        }
        return usus.get(0);
    } 
    
    public ArrayList<Activo_Modelo> consultarActivosPorUsuario(String cedula){
        ArrayList<Activo_Modelo> acts= new ArrayList();
            try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete(){
            @Override
            public void onComplete(Response status){
                if(status.isSuccess())
                {
                    try {
                        JSONObject activos= new JSONObject(status.getResult());
                        JSONArray actss= activos.getJSONArray("result");
                        int i=0;
                        while(i<actss.length()){
                            JSONObject ob= actss.getJSONObject(i);
                            Activo_Modelo act;
                            act=new Activo_Modelo();
                            act.setId(ob.getInt("ID_ACT"));
                            act.setUsuario( new Consultas_bd().consultarUsuario(ob.getString("CED_USU_PER")));
                            act.setNombre(ob.getString("NOM_ACT"));
                            act.setObservacion(ob.getString("OBS_ACT"));    
                            acts.add(act);
                            i++;
                        }
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute("http://localhost/sisvalidacion/restApi/activo?activosByUser="+cedula);
        } catch (Exception e) {
        }
        return acts;
    }    

    
    public ArrayList<Usuario_Modelo> consultarUsuarios(){
        ArrayList<Usuario_Modelo> usus= new ArrayList();
            try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete(){
            @Override
            public void onComplete(Response status){
                if(status.isSuccess())
                {
                    try {
                        JSONObject usuarios= new JSONObject(status.getResult());
                        JSONArray ususs= usuarios.getJSONArray("result");
                        int i=0;
                        while(i<ususs.length()){
                            JSONObject ob= ususs.getJSONObject(i);
                            Usuario_Modelo usu;
                            usu=new Usuario_Modelo();
                            usu.setCedula(ob.getString("CED_USU"));
                            usu.setNombre(ob.getString("NOM_USU"));
                            usu.setApellido(ob.getString("APE_USU"));
                            usus.add(usu);
                            i++;
                        }
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute("http://localhost/sisvalidacion/restApi/usuario?usuarioss");
        } catch (Exception e) {
                //return null;
        }
        return usus;
    }    
}
