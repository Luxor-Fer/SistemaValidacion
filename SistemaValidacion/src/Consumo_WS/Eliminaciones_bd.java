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
public class Eliminaciones_bd extends Path_ApiRest{

    ResultSet dato;
    Statement st;
    Connection cn;
    int idRes;
    int resDetVal;

    public Eliminaciones_bd() {
        ConeccionSQL con = new ConeccionSQL();
        cn = con.conectar();
    }

    public int eliminarEmpValidacion(int id) {
        try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            JSONObject usuarios = new JSONObject(status.getResult());
                            idRes = usuarios.getInt("result");
                        } catch (Exception e) {
                        }
                    }
                    throw new UnsupportedOperationException("Not suported yet");
                }
            });

            cliente.excecute(getBaseURL_Validaciones()+"eliminarEmpValById="+id);
        } catch (Exception e) {
        }
        return idRes;
    }
    public int eliminarValidacion(int id) {
        try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.isSuccess()) {
                        try {
                            JSONObject usuarios = new JSONObject(status.getResult());
                            idRes = usuarios.getInt("result");
                        } catch (Exception e) {
                        }
                    }
                    throw new UnsupportedOperationException("Not suported yet");
                }
            });

            cliente.excecute(getBaseURL_Validaciones()+"eliminarValidacionById="+id);
        } catch (Exception e) {
        }
        return idRes;
    }
    
}
