/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JamesApp;

/**
 *
 * @author jrgir
 */
public class Usuarios {

    private String Username;
    private String password;
    private String nombre;
    private int edad;
    private boolean tipo;

    public Usuarios(String Username, String password, String nombre, int edad, boolean tipo) {
        this.Username = Username;
        this.password = password;
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "Username=" + Username + ", password=" + password + ", nombre=" + nombre + ", edad=" + edad + ", tipo=" + tipo + '}';
    }

    
    
}
