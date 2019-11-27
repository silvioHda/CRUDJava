package com.silvioIgnacio.pojos;

/**
 *
 * @author Iván Ignacio
 */
public class Usuario {
    
    /**
     * Atributos de la clase Usuario
     */
    private int idUsuario;
    private String nombre;
    private String apellidos;
    private String password;
    private String fechaNacimiento;
    private String registro;

    /**
     * Constructores de la clase Usuario
     */
    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, 
            String apellidos, String password, 
            String fechaNacimiento, String registro) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.registro = registro;
    }

    public Usuario(String nombre, String password,
            String fechaNacimiento) {
        this.nombre = nombre;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
    
}
