package com.sistecma.springdesdecero.demoboot;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
	@Autowired
	RepositorioCliente repoCliente;
	
	@GetMapping("/obtenerClientePorId/{id}")
	public Optional<Cliente> obtenerClientePorId(@PathVariable(value="id") Long id){
		return Optional.of(repoCliente.obtenerClientePorId(id));
	}
	
	@PostMapping("/agregarCliente")
	public long agregarCliente(@RequestBody Cliente cliente){
		return repoCliente.agregarCliente(cliente);
	}
	
}
