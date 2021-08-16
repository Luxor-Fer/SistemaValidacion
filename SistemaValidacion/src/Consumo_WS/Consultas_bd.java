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
public class Consultas_bd extends Path_ApiRest {
    ResultSet dato;
    Statement st;
    Connection cn;
    String respuesta;
    Usuario log;
    String msgLog;
    int cantActivos;
    int cantEmpleados;
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
            
            cliente.excecute(getBaseURL_Usuarios()+"u="+usuario+"&p="+pass);
        } catch (Exception e) {
        }
        return msgLog;
    }
    public Usuario getLogin(){
        return this.log;
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
            
            cliente.excecute(getBaseURL_Usuarios()+"userById="+id);
        } catch (Exception e) {
        }
        return log;
    }
    public Validacion obtenerValidacionById(int id){
        Validacion val= new Validacion();
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
                            JSONObject ob= arrayRes.getJSONObject(0);                      
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
                            val.setUsuarioCrea(new Consultas_bd().obtenerUsuarioById(ob.getInt("ID_USU_CVAL")));
                            int UsuarioActualiza= ob.getInt("ID_USU_AVAL");
                            if(UsuarioActualiza!=0){
                                val.setUsuarioActualiza(new Consultas_bd().obtenerUsuarioById(UsuarioActualiza));
                            }
                            val.setEstado(ob.getString("EST_VAL"));
                            val.setObservacion(ob.getString("OBS_VAL"));
                                                      
                        }
                            
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute(getBaseURL_Validaciones()+"validacionById="+id);
        } catch (Exception e) {
        }
        return val;
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
            
            cliente.excecute(getBaseURL_Empleados()+"empleado="+cedula);
        } catch (Exception e) {
        }
        return usus.get(0);
    }
    public Activo obtenerActivoByCodigo(String codigo){
        Activo act= new Activo();
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
                          
                            act.setCodigo(ob.getString("COD_ACT"));
                            act.setNombre(ob.getString("NOM_ACT"));
                            act.setEmpleado(new Consultas_bd().consultarEmpleado(ob.getString("CED_EMP_ACT")));
                            act.setObservacion(ob.getString("OBS_ACT"));
                            
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute(getBaseURL_Activos()+"activoByCodigo="+codigo);
        } catch (Exception e) {
        }
        return act;
    }
    public EmpleadoValidacion obtenerEmpleadoValidacionById(int id){
        EmpleadoValidacion empv= new EmpleadoValidacion();
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
                            empv.setId(ob.getInt("Id"));
                            empv.setIdValidacion( new Consultas_bd().obtenerValidacionById(ob.getInt("ID_VAL_EMPV")));
                            empv.setIdEmpleado(new Consultas_bd().consultarEmpleado(ob.getString("CED_EMP_EMPV")));
                            empv.setObservacion(ob.getString("OBS_EMPV"));
                      
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute(getBaseURL_Validaciones()+"EmpleadoValidacionById="+id);
        } catch (Exception e) {
        }
        return empv;
    }
    public ActivoValidacion obtenerActivoValidacionById(int id){
        ActivoValidacion actv= new ActivoValidacion();
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
                            actv.setId(ob.getInt("Id"));
                            actv.setIdEmpVal(new Consultas_bd().obtenerEmpleadoValidacionById(ob.getInt("ID_EMPV_ACTV")));
                            actv.setIdActivo(new Consultas_bd().obtenerActivoByCodigo(ob.getString("ID_ACT_ACTV")));
                            actv.setEstado(ob.getInt("EST_ACTV"));
                            actv.setObservacion(ob.getString("OBS_ACTV"));
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute(getBaseURL_Validaciones()+"ActivoValidacionById="+id);
        } catch (Exception e) {
        }
        return actv;
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
            
            cliente.excecute(getBaseURL_Activos()+"activosByUser="+cedula);
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
            
            cliente.excecute(getBaseURL_Empleados()+"empleadoss");
        } catch (Exception e) {
                //return null;
        }
        return usus;
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
                            Date fechaCrea= new SimpleDateFormat("yyyy-MM-dd").parse(ob.getString("FEC_CRE_VAL"));
                            val.setFechaCreacion(fechaCrea);
                            String fechaActualiza= ob.getString("FEC_ACT_VAL");
                            if(!fechaActualiza.equals("0")){
                               Date fechaAct= new SimpleDateFormat("yyyy-MM-dd").parse(fechaActualiza);
                                val.setFechaActualizacion(fechaAct);
                            }
                            val.setUsuarioCrea(new Consultas_bd().obtenerUsuarioById(ob.getInt("ID_USU_CVAL")));
                            int UsuarioActualiza= ob.getInt("ID_USU_AVAL");
                            if(UsuarioActualiza!=0){
                                val.setUsuarioActualiza(new Consultas_bd().obtenerUsuarioById(UsuarioActualiza));
                            }
                            val.setEstado(ob.getString("EST_VAL"));
                            val.setObservacion(ob.getString("OBS_VAL"));
                            
                            vals.add(val);
                            i++;
                        }
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute(getBaseURL_Validaciones()+"ValidacionesByEstado="+estado);
            
        } catch (Exception e) {
                //return null;
        }
        return vals;
    }
    public ArrayList<EmpleadoValidacion> consultarEmpleadosValByIdVal(int idVal){
        ArrayList<EmpleadoValidacion> empvs= new ArrayList();
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
                            EmpleadoValidacion empv;
                            empv= new EmpleadoValidacion();
                            empv.setId(ob.getInt("Id"));
                            empv.setIdValidacion( new Consultas_bd().obtenerValidacionById(ob.getInt("ID_VAL_EMPV")));
                            empv.setIdEmpleado(new Consultas_bd().consultarEmpleado(ob.getString("CED_EMP_EMPV")));
                            empv.setObservacion(ob.getString("OBS_EMPV"));
                            empvs.add(empv);
                            i++;
                        }
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute(getBaseURL_Validaciones()+"EmpleadosValidacionByIdVal=1&ID_VAL="+idVal);
        } catch (Exception e) {
                //return null;
        }
        return empvs;
    }
    public ArrayList<ActivoValidacion> consultarActivosValByIdEmpVal(int idEmpVal){
        ArrayList<ActivoValidacion> actvs= new ArrayList();
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
                            ActivoValidacion actv= new ActivoValidacion();
                            actv.setId(ob.getInt("Id"));
                            actv.setIdEmpVal(new Consultas_bd().obtenerEmpleadoValidacionById(ob.getInt("ID_EMPV_ACTV")));
                            actv.setIdActivo(new Consultas_bd().obtenerActivoByCodigo(ob.getString("ID_ACT_ACTV")));
                            actv.setEstado(ob.getInt("EST_ACTV"));
                            actv.setObservacion(ob.getString("OBS_ACTV"));
                            actvs.add(actv);
                            i++;
                        }
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute(getBaseURL_Validaciones()+"ActivosValidacionByIdEmpVal="+idEmpVal);
        } catch (Exception e) {
                //return null;
        }
        return actvs;
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
            
            cliente.excecute(getBaseURL_Validaciones()+"Test");
        } catch (Exception e) {
                //return null;
        }
        return respuesta;
    }
    
    public int getCantEmpleadosValidacionByIdVal(int idVal){
        cantEmpleados=0;
        ActivoValidacion actv= new ActivoValidacion();
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
                            cantEmpleados=ob.getInt("CANT_EMP");
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute(getBaseURL_Validaciones()+"cantEmpleadosValidacionByIdVal="+idVal);
        } catch (Exception e) {
        }
        return cantEmpleados;
    }
    public int getCantActivosValidacionByIdVal(int idVal){
        cantActivos=0;
        ActivoValidacion actv= new ActivoValidacion();
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
                            cantActivos=ob.getInt("CANT_ACT");
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute(getBaseURL_Validaciones()+"cantActivosValidacionByIdVal="+idVal);
        } catch (Exception e) {
        }
        return cantActivos;
    }
    public int getCantActivosValidacionByIdEmpVal(int idEmpVal){
        cantActivos=0;
        ActivoValidacion actv= new ActivoValidacion();
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
                            cantActivos=ob.getInt("CANT_ACT");
                    } catch (Exception e) {
                    }
                }
                throw new UnsupportedOperationException("Not suported yet");
                }
            });
            
            cliente.excecute(getBaseURL_Validaciones()+"cantActivosValidacionByIdEmpVal="+idEmpVal);
        } catch (Exception e) {
        }
        return cantActivos;
    }
}
