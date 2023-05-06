package br.com.apiclientes.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {
	@PostMapping
	public void post() {
		//TO DO
	}
	
	@PutMapping
	public void put() {
		//TO DO
	}
	
	@DeleteMapping
	public void delete() {
		//TO DO
	}
	
	@GetMapping
	public void get() {
		
	}
		
	
}
