/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JamesApp;

import JDBC.Dba;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jrgir
 */
public class UsuariosAdminJBDC {
    
    Dba db = new Dba("./Usuarios.mdb");

    public UsuariosAdminJBDC() {
    }
    
    public void Agregar(String Username, String password, String nombre, int edad, String tipo){
    
            //agregar
      
        db.conectar();
        try {
       
            db.query.execute("INSERT INTO User"
                    + " (cuenta,nombre)"
                    + " VALUES ('" + c + "', '" + n + "')");
            db.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();
        

    
    
    
    }
    
    
    
    
    
}
