/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilidades.BaseDatos;

/**
 *
 * @author ppetk
 */
public class CBPropiedad {
    String propiedad;
    int id;
    String PreparedStatement;
    String ResultSet;
    PreparedStatement ps;
    ResultSet rs;
    
    public CBPropiedad(CBPropiedad cbp){
        this(cbp.getPropiedad(), cbp.getId(), cbp.getResultSet());
    }

    public CBPropiedad(String propiedad, int id, String PreparedStatement, String ResultSet) {
        this.propiedad = propiedad;
        this.id = id;
        this.PreparedStatement = PreparedStatement;
        this.ResultSet = ResultSet;
    }

    public CBPropiedad(String propiedad, int id, String ResultSet) {
        this.propiedad = propiedad;
        this.id = id;
        this.ResultSet = ResultSet;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreparedStatement() {
        return PreparedStatement;
    }

    public void setPreparedStatement(String PreparedStatement) {
        this.PreparedStatement = PreparedStatement;
    }

    public String getResultSet() {
        return ResultSet;
    }

    public void setResultSet(String ResultSet) {
        this.ResultSet = ResultSet;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    public void execute() throws SQLException{
        Connection connection = BaseDatos.getConnection();
        this.rs = connection.createStatement().executeQuery(this.ResultSet);
    }
    
    public void executeps() throws SQLException{
        Connection connection = BaseDatos.getConnection();
        this.ps = connection.prepareStatement(this.PreparedStatement);
        this.rs = ps.executeQuery(this.ResultSet);
    }
}