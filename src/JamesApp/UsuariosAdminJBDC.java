/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JamesApp;

import JDBC.Dba;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author jrgir
 */
public class UsuariosAdminJBDC {

    Dba db = new Dba("./Usuarios.mdb");

    public UsuariosAdminJBDC() {
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
    
    public void modificar(String Username, String password, String nombre, int edad, String tipo, JTable tabla ){
    
    db.conectar();
        try {
           db.query.execute("update User set  Usuario="+Username+",Nombre="+nombre+" Password="+password+", Edad="+edad+") where"+tabla.isBackgroundSet());
            db.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();

    
    
    }
    

}
