package com.Practica2025_Cortez.aplicacionBancaria.Service;

import java.util.List;

import com.Practica2025_Cortez.aplicacionBancaria.Model.Cliente;

public interface ClienteService {
    
    // Guardar un cliente
    Cliente guardarCliente(Cliente cliente);
    
    // Buscar un cliente por su DNI
    Cliente buscarPorDni(String dni);
    
    // Listar todos los clientes
    List<Cliente> listarTodos();
    
    // Eliminar un cliente por su ID
    void eliminarCliente(Long id);
    
    // Verificar si existe un cliente con ese DNI
    boolean existePorDni(String dni);
}