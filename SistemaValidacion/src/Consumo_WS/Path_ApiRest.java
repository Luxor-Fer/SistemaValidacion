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
public class Path_ApiRest {
    private final String baseURL="http://localhost/sisvalidacion/restApi/";
    
    public String getBaseURL() {
        return baseURL;
    }
    public String getBaseURL_Usuarios() {
        //Metodos:
        //u->IdUsuario,p->Password->Retorna Array Respuesta (estado:valor, result:usuario||Mensaje)
        //userById->IdUsuario->Retorna Array Respuesta (estado:valor, result:usuario)
        return baseURL+"auth?";
    }
    public String getBaseURL_Activos() {
        //Metodos:
        //activosByUser->Cedula->Retorna Array Respuesta (estado:valor, result:Array Activos)
        //activoByCodigo->idActivo->Retorna Array Respuesta (estado:valor, result:Activo)   
        return baseURL+"Activo?";
    }
    public String getBaseURL_Empleados() {
        return baseURL+"Empleado?";
    }
    public String getBaseURL_Validaciones() {
        return baseURL+"Validaciones?";
    }
    
    
}
