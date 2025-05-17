package com.Practica2025_Cortez.aplicacionBancaria.Service;

import org.springframework.stereotype.Service;

import com.Practica2025_Cortez.aplicacionBancaria.Model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    // Lista para almacenar los clientes en memoria
    private final List<Cliente> clientes = new ArrayList<>();
    
    // Generador de IDs seriales
    private final AtomicLong contador = new AtomicLong();
    
    @Override
    public Cliente guardarCliente(Cliente cliente) {
        // Asignar un ID único si no tiene uno asignado
        if (cliente.getId() == null) {
            cliente.setId(contador.incrementAndGet());
        }
        clientes.add(cliente);
        return cliente;
    }
    
    @Override
    public Cliente buscarPorDni(String dni) {
        return clientes.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }
    
    @Override
    public void eliminarCliente(Long id) {
        clientes.removeIf(c -> c.getId().equals(id));
    }
    
    @Override
    public boolean existePorDni(String dni) {
        return clientes.stream()
                .anyMatch(c -> c.getDni().equals(dni));
    }
}