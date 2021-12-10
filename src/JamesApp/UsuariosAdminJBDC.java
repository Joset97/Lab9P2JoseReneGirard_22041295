/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JamesApp;

import JDBC.Dba;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author jrgir
 */
public class UsuariosAdminJBDC {

    Dba db = new Dba("./Usuarios.mdb");
    ArrayList<Usuarios> us;

    public UsuariosAdminJBDC() {
        us = new ArrayList();
    }

    public void Agregar(String Username, String password, String nombre, int edad, String tipo) {

        //agregar
        db.conectar();
        try {

            db.query.execute("INSERT INTO User"
                    + " (Usuario,Nombre,Password,Edad,Tipo)"
                    + " VALUES ('" + Username + "', '" + nombre + "', '" + password + "', '" + edad + "', '" + tipo + "')");
            db.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();

    }

    public void modificar(String Username, String password, String nombre, int edad, String tipo, JTable tabla) {

        db.conectar();
        try {
            db.query.execute("update User set  Usuario=" + Username + ",Nombre=" + nombre + " Password=" + password + ", Edad=" + edad + ") where" + tabla.isBackgroundSet());
            db.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();

    }

    public void eliminar(JTable tabla) {

        db.conectar();
        try {
            db.query.execute("delete from User where" + tabla.isBackgroundSet());
            db.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();

    }
    public void actualizarARL(){
    
        us= new ArrayList();
             db.conectar();
         try {
         db.query.execute("select * from User");
         ResultSet rs = db.query.getResultSet();           
         while (rs.next()) {
             
             String username= rs.getString(1);
             String nombre= rs.getString(2);
             String password = rs.getString(3);
             int Edad= rs.getInt(4);
             String tipo= rs.getString(5);
             
        us.add(new Usuarios(username, password, nombre, Edad, tipo));
         
         }            
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
         db.desconectar();
    
    }

    public ArrayList<Usuarios> getUs() {
        return us;
    }

    public void setUs(ArrayList<Usuarios> us) {
        this.us = us;
    }

}
