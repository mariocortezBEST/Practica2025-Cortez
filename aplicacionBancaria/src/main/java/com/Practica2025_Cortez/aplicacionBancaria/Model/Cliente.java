package com.Practica2025_Cortez.aplicacionBancaria.Model;

public class Cliente {
    private Long id;              // Generado en forma serial
    private String dni;
    private String nombreUsuario;
    private String clave;
    private String nombre;
    private String domicilio;
    private String correoElectronico;
    private boolean estado;       // habilitado (true) / inhabilitado (false)

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con parámetros (sin ID)
    public Cliente(String dni, String nombreUsuario, String clave, String nombre,
                  String domicilio, String correoElectronico, boolean estado) {
        this.dni = dni;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.correoElectronico = correoElectronico;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", estado=" + estado +
                '}';
    }
}