package com.nttdata.bootcamp.retopromethus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.retopromethus.builder.UsuarioBuilder;
import com.nttdata.bootcamp.retopromethus.repository.Usuario;

@RestController
public class UsuarioController {

	private List<Usuario> listado =new ArrayList<>();
	
	@GetMapping("/usuario/{nombre}")
	public String getUsuario(@PathVariable String nombre) {
		Usuario usuario= new UsuarioBuilder().build(nombre,null,null,null);
		
		return "hola "+ usuario.toString();
	}
	
	@GetMapping("/usuario")
	public ResponseEntity<Usuario> getUsuarioParam(@RequestParam String nombre) {
		Usuario usuario= new UsuarioBuilder().build(nombre,null,null,null);
		
		return new ResponseEntity<Usuario>(usuario , HttpStatus.OK);
	}
	
	@PostMapping("/usuario/{nombre}")
	public Usuario post(@PathVariable String nombre) {
		Usuario usuario= new UsuarioBuilder().build(nombre,null,null,null);
		listado.add(usuario);
		return usuario;
	}
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> pruebaUser() {
		
		return new ResponseEntity<List<Usuario>>(listado , HttpStatus.OK);
	}
}
