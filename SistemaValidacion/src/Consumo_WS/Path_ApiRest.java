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
        return baseURL+"auth?";
    }
    public String getBaseURL_Activos() {
        return baseURL+"Activo?";
    }
    public String getBaseURL_Empleados() {
        return baseURL+"Empleado?";
    }
    public String getBaseURL_Validaciones() {
        return baseURL+"Validaciones?";
    }
    
    
}
