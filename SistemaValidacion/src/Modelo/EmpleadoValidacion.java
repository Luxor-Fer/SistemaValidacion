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
public class EmpleadoValidacion {
    int Id;
    Validacion idValidacion;
    Empleado idEmpleado;
    String Observacion;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Validacion getIdValidacion() {
        return idValidacion;
    }

    public void setIdValidacion(Validacion idValidacion) {
        this.idValidacion = idValidacion;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }
    public ArrayList<ActivoValidacion> getActivosValidacion(){
        ArrayList<ActivoValidacion> activos= new ArrayList();
       return new Consultas_bd().consultarActivosValByIdEmpVal(this.Id);
    }
    public int cantidadActivos(){
        return new Consultas_bd().getCantActivosValidacionByIdEmpVal(this.Id);
    }
    
    
    
}
