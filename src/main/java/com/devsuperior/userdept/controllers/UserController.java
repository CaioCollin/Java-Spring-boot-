package com.devsuperior.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.userdept.entitiesDTO.Cliente;
import com.devsuperior.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	// procurar todos os usuario
	@GetMapping
	public List<Cliente> finAll() {
		List<Cliente> result = repository.findAll();
		return result;
	}

	// procurar por um id
	@GetMapping(value = "/{id}")
	public Cliente finById(@PathVariable Long id) {
		Cliente result = repository.findById(id).get();
		return result;
	}

	// salvar novo usuario no banco
	@PostMapping
	public Cliente insert(@RequestBody Cliente cliente) {
		Cliente result = repository.save(cliente);
		return result;
	}

	// deletando usuario 
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}


	// put atualização novos valores
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id , @RequestBody Cliente cliente){
		
		if(!repository.existsById(id)){
			return  ResponseEntity.notFound().build();
		}
		
		cliente.setId(id);
		cliente = repository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	
	//cadastrar usuario
	@PostMapping("/cadastro")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente add(@RequestBody Cliente cliente) {
		cliente.getDataAtual();
		return repository.save(cliente);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
