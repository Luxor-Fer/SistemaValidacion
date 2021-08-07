/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Consumo_WS.Consultas_bd;
import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public class Empleado {
    String cedula;
    String nombre;
    String apellido;
    ArrayList<Activo> activos;
    
    public Empleado(){
        
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void cargarActivos(){
        this.activos= new ArrayList();
        this.activos= new Consultas_bd().consultarActivosPorUsuario(cedula);
    }
    public ArrayList<Activo> getActivos(){
        cargarActivos();
        return this.activos;
    }
    public int getCantidadActivos(){
        cargarActivos();
        return activos.size();
    }
    
    
}
