/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumo_WS;

import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import com.devazt.networking.HttpClient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONObject;
import sistemavalidacion.ConeccionSQL;

/**
 *
 * @author Mauricio
 */
public class Inserciones_bd {

    ResultSet dato;
    Statement st;
    Connection cn;
    int idValidacion;
    int resDetVal;

    public Inserciones_bd() {
        ConeccionSQL con = new ConeccionSQL();
        cn = con.conectar();
    }

    public int insertarValidacion(String nombre, String descripcion, int idUsuario) {
        descripcion= descripcion.replaceAll(" ", "_");
        nombre= nombre.replaceAll(" ", "_");
        System.out.println("Nombre:"+nombre+" Descripcion:"+descripcion);
        idValidacion = 0;
        try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            JSONObject usuarios = new JSONObject(status.getResult());
                            idValidacion = usuarios.getInt("result");
                        } catch (Exception e) {
                        }
                    }
                    throw new UnsupportedOperationException("Not suported yet");
                }
            });

            cliente.excecute("http://localhost/sisvalidacion/restApi/Validaciones?insertarValidacion=1&Nombre="+nombre+"&Descripcion="+descripcion+"&idUsuario="+idUsuario);
        } catch (Exception e) {
        }
        return idValidacion;
    }
    public int insertarValidacionDetalle(int idValidacion, String idEmpleado) {
        resDetVal=0;
        try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            JSONObject detalleValidacion = new JSONObject(status.getResult());
                            resDetVal = detalleValidacion.getInt("result");
                        } catch (Exception e) {
                        }
                    }
                    throw new UnsupportedOperationException("Not suported yet");
                }
            });

            cliente.excecute("http://localhost/sisvalidacion/restApi/Validaciones?idValidacion="+idValidacion+"&idEmpleado="+idEmpleado);
            
        } catch (Exception e) {
        }
        return resDetVal;
    }
    public static void main(String[] args) {
        Inserciones_bd in= new Inserciones_bd();
        
    }
}
