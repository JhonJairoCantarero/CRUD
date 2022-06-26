package com.example.crud.Procesos;


import java.io.Serializable;

public class contactos implements Serializable {
    private Integer id;
    private String nombres;
    private String apellido;
    private Integer edad;
    private String correo;
    private String direccion;

    public contactos() {

    }
    public contactos(Integer id, String nombres, String apellido, Integer edad, String correo, String direccion) {
        this.id = id;
        this.nombres = nombres;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.correo = direccion;
    }

}