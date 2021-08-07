/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumo_WS;

import Modelo.*;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import com.devazt.networking.HttpClient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    String respuesta;
    Usuario log;
    String msgLog;
    public Consultas_bd() {
       ConeccionSQL con= new ConeccionSQL();
       cn=con.conectar();
       }
    
    

    public String Login(String usuario, String pass){
            try { 
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete(){
            @Override
            public void onComplete(Response status){
                if(status.isSuccess())
                {
                    try {
                        JSONObject usuarios= new JSONObject(status.getResult());
                        String res=usuarios.getString("status");
                        if(res.equals("ok")){
                            JSONArray arrayRes= usuarios.getJSONArray("result");
                            JSONObject objeto= arrayRes.getJSONObject(0);
                            System.out.println("entro a llenar usu");                            
                            log= new Usuario(objeto.getInt("Id"),objeto.getString("NOM_USU"), objeto.getString("COR_USU"),objeto.getString("PAS_USU"));
                            msgLog="ok";                           
                        }else{
                            
                            log=null;
                            msgLog=usuarios.getJSONObject("result").getString("error_msg");
                        }
                            
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute("http://localhost/sisvalidacion/restApi/auth?u="+usuario+"&p="+pass);
        } catch (Exception e) {
        }
        return msgLog;
    }
    public Usuario obtenerUsuarioById(int id){
            try { 
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete(){
            @Override
            public void onComplete(Response status){
                if(status.isSuccess())
                {
                    try {
                        JSONObject usuarios= new JSONObject(status.getResult());
                        String res=usuarios.getString("status");
                        if(res.equals("ok")){
                            JSONArray arrayRes= usuarios.getJSONArray("result");
                            JSONObject objeto= arrayRes.getJSONObject(0);
                            System.out.println("entro a llenar usu");                            
                            log= new Usuario(objeto.getInt("Id"),objeto.getString("NOM_USU"), objeto.getString("COR_USU"),objeto.getString("PAS_USU"));
                            msgLog="ok";                           
                        }else{
                            
                            log=null;
                            msgLog=usuarios.getJSONObject("result").getString("error_msg");
                        }
                            
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute("http://localhost/sisvalidacion/restApi/auth?userById="+id);
        } catch (Exception e) {
        }
        return log;
    }
    public Usuario getLogin(){
        return this.log;
    }
    public Empleado consultarEmpleado(String cedula){
        ArrayList<Empleado> usus= new ArrayList();
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
                            Empleado usu;
                            usu=new Empleado();
                            usu.setCedula(ob.getString("CED_EMP"));
                            usu.setNombre(ob.getString("NOM_EMP"));
                            usu.setApellido(ob.getString("APE_EMP"));
                            usus.add(usu);
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute("http://localhost/sisvalidacion/restApi/Empleado?empleado="+cedula);
        } catch (Exception e) {
        }
        return usus.get(0);
    }
    public ArrayList<Activo> consultarActivosPorUsuario(String cedula){
        ArrayList<Activo> acts= new ArrayList();
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
                            Activo act;
                            act=new Activo();
                            act.setCodigo(ob.getString("COD_ACT"));
                            act.setEmpleado(new Consultas_bd().consultarEmpleado(ob.getString("CED_EMP_ACT")));
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
            
            cliente.excecute("http://localhost/sisvalidacion/restApi/Activo?activosByUser="+cedula);
        } catch (Exception e) {
        }
        return acts;
    }    
    public ArrayList<Empleado> consultarEmpleados(){
        ArrayList<Empleado> usus= new ArrayList();
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
                            Empleado usu;
                            usu=new Empleado();
                            usu.setCedula(ob.getString("CED_EMP"));
                            usu.setNombre(ob.getString("NOM_EMP"));
                            usu.setApellido(ob.getString("APE_EMP"));
                            usus.add(usu);
                            i++;
                        }
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute("http://localhost/sisvalidacion/restApi/Empleado?empleadoss");
        } catch (Exception e) {
                //return null;
        }
        return usus;
    }
    public String pruebaConeccionApi(){
            try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete(){
            @Override
            public void onComplete(Response status){
                if(status.isSuccess())
                {
                    try {
                        JSONObject res= new JSONObject(status.getResult());
                        respuesta= res.getString("status");
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute("http://localhost/sisvalidacion/restApi/Validaciones?Test");
        } catch (Exception e) {
                //return null;
        }
        return respuesta;
    }
    public ArrayList<Validacion> consultarValidaciones(String estado){
        ArrayList<Validacion> vals= new ArrayList();
            try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete(){
            @Override
            public void onComplete(Response status){
                if(status.isSuccess())
                {
                    try {
                        JSONArray ususs = new JSONArray(status.getResult());
                        int i=0;
                        while(i<ususs.length()){
                            JSONObject ob= ususs.getJSONObject(i);
                            Validacion val;
                            val= new Validacion();
                            val.setId(ob.getInt("Id"));
                            val.setNombre(ob.getString("NOM_VAL"));
                            val.setDescripcion(ob.getString("DES_VAL"));
                            Date fechaCrea= new SimpleDateFormat("yyyy/dd/MM").parse(ob.getString("FEC_CRE_VAL"));
                            val.setFechaCreacion(fechaCrea);
                            String fechaActualiza= ob.getString("FEC_ACT_VAL");
                            if(fechaActualiza!="0"){
                               Date fechaAct= new SimpleDateFormat("yyyy/dd/MM").parse(fechaActualiza);
                                val.setFechaActualizacion(fechaAct);
                            }
//                            val.getUsuarioCrea(ob.getString("ID_USU_CVAL"));
//                            
//                            usu=new Empleado();
//                            usu.setCedula(ob.getString("Id"));
//                            usu.setNombre(ob.getString("NOM_EMP"));
//                            usu.setApellido(ob.getString("APE_EMP"));
//                            usus.add(usu);
//                            i++;
                        }
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute("http://localhost/sisvalidacion/restApi/Empleado?empleadoss");
        } catch (Exception e) {
                //return null;
        }
        return vals;
    }    
}
