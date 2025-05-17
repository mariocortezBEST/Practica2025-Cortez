package com.Practica2025_Cortez.aplicacionBancaria.Model;

import java.time.LocalDate;

public class Cuenta {
    private Long id;              // Generado en forma serial
    private String numeroCuenta;
    private Cliente cliente;
    private LocalDate fechaIngreso;
    private double saldoActual;
    private boolean estado;       // habilitado (true) / inhabilitado (false)
    private double limiteExtraccion;

    // Constructor vacío
    public Cuenta() {
    }

    // Constructor con parámetros (sin ID)
    public Cuenta(String numeroCuenta, Cliente cliente, LocalDate fechaIngreso, 
                 double saldoActual, boolean estado, double limiteExtraccion) {
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.fechaIngreso = fechaIngreso;
        this.saldoActual = saldoActual;
        this.estado = estado;
        this.limiteExtraccion = limiteExtraccion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getLimiteExtraccion() {
        return limiteExtraccion;
    }

    public void setLimiteExtraccion(double limiteExtraccion) {
        this.limiteExtraccion = limiteExtraccion;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", cliente=" + cliente +
                ", fechaIngreso=" + fechaIngreso +
                ", saldoActual=" + saldoActual +
                ", estado=" + estado +
                ", limiteExtraccion=" + limiteExtraccion +
                '}';
    }
}