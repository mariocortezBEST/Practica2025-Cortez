package com.Practica2025_Cortez.aplicacionBancaria.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.Practica2025_Cortez.aplicacionBancaria.Model.Cliente;
import com.Practica2025_Cortez.aplicacionBancaria.Service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    private final ClienteService clienteService;
    
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    // Página principal
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    // Mostrar formulario para crear cliente
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente-form";
    }
    
    // Guardar un nuevo cliente
    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente, BindingResult result, Model model) {
        // Validaciones básicas
        if (cliente.getDni() == null || cliente.getDni().isEmpty()) {
            result.rejectValue("dni", "error.cliente", "El DNI no puede estar vacío");
            return "cliente-form";
        }
        
        // Verificar si ya existe un cliente con ese DNI
        if (clienteService.existePorDni(cliente.getDni())) {
            result.rejectValue("dni", "error.cliente", "Ya existe un cliente con ese DNI");
            return "cliente-form";
        }
        
        // Estado por defecto: habilitado
        cliente.setEstado(true);
        
        // Guardar el cliente
        clienteService.guardarCliente(cliente);
        
        // Redireccionar a la lista de clientes
        return "redirect:/clientes/lista";
    }
    
    // Listar todos los clientes
    @GetMapping("/lista")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "cliente-lista";
    }
    
    // Mostrar formulario para buscar cliente por DNI
    @GetMapping("/buscar")
    public String mostrarFormularioBuscar() {
        return "cliente-buscar";
    }
    
    // Buscar cliente por DNI
    @PostMapping("/buscar")
    public String buscarClientePorDni(@RequestParam String dni, Model model) {
        Cliente cliente = clienteService.buscarPorDni(dni);
        
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            model.addAttribute("encontrado", true);
        } else {
            model.addAttribute("encontrado", false);
            model.addAttribute("mensaje", "No se encontró ningún cliente con el DNI: " + dni);
        }
        
        return "cliente-buscar";
    }
    
    // Eliminar cliente
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return "redirect:/clientes/lista";
    }
}