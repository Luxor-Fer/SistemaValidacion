/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Mauricio
 */
public class ActivoValidacion {
    int Id;
    EmpleadoValidacion idEmpVal;
    Activo idActivo;
    int Estado;
    String Observacion;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public EmpleadoValidacion getIdEmpVal() {
        return idEmpVal;
    }

    public void setIdEmpVal(EmpleadoValidacion idEmpVal) {
        this.idEmpVal = idEmpVal;
    }

    public Activo getIdActivo() {
        return idActivo;
    }

    public void setIdActivo(Activo idActivo) {
        this.idActivo = idActivo;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }
    
    
    
}
