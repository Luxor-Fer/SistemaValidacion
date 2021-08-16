/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Consumo_WS.Consultas_bd;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mauricio
 */
public class Validacion {
    int Id;
    String Nombre;
    String Descripcion;
    Date FechaCreacion;
    Date FechaActualizacion;
    Usuario UsuarioCrea;
    Usuario UsuarioActualiza;
    String Estado;

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    String Observacion;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public Date getFechaActualizacion() {
        return FechaActualizacion;
    }

    public void setFechaActualizacion(Date FechaActualizacion) {
        this.FechaActualizacion = FechaActualizacion;
    }

    public Usuario getUsuarioCrea() {
        return UsuarioCrea;
    }

    public void setUsuarioCrea(Usuario UsuarioCrea) {
        this.UsuarioCrea = UsuarioCrea;
    }

    public Usuario getUsuarioActualiza() {
        return UsuarioActualiza;
    }

    public void setUsuarioActualiza(Usuario UsuarioActualiza) {
        this.UsuarioActualiza = UsuarioActualiza;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }
    public int cantidadEmpleados(){
        Consultas_bd cns= new Consultas_bd();
        return cns.getCantEmpleadosValidacionByIdVal(this.Id);
    }
    
    public ArrayList<EmpleadoValidacion> getEmpleadosValidacion(){
        Consultas_bd cns= new Consultas_bd();
        return cns.consultarEmpleadosValByIdVal(this.Id);
    }
    public int cantidadActivos(){
        Consultas_bd cns= new Consultas_bd();
        return cns.getCantActivosValidacionByIdVal(this.Id);
    }
   
    
}
