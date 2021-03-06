/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JamesApp;

import JBDC.Dba;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author jrgir
 */
public class UsuariosAdminJBDC {

    Dba db;
    ArrayList<Usuarios> us;

    public UsuariosAdminJBDC(String base) {
        us = new ArrayList();
         db = new Dba(base);
    }

    public void Agregar(String Username, String password, String nombre, int edad, String tipo) {

        //agregar
        db.conectar();
        try {

            db.query.execute("INSERT INTO Usuarios"
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
            db.query.execute("update Usuarios set  Usuario=" + Username + ",Nombre=" + nombre + " Password=" + password + ", Edad=" + edad + ") where" + tabla.isBackgroundSet());
            db.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();

    }

    public void eliminar(JTextField tabla) {

        String username=tabla.getText();
        
        db.conectar();
        try {
            db.query.execute("delete from Usuarios where Usuario='" + username + "'" );
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
         db.query.execute("select * from Usuarios");
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
