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

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class UsuarioController {
	private Counter  counter;

	public UsuarioController(MeterRegistry registry) {
		
		this.counter =  Counter.builder("invocaciones.usuario").description("Invocaciones Totales de UsuarioController").register(registry);
	}
	private List<Usuario> listado =new ArrayList<>();
	
	@GetMapping("/usuario/{nombre}")
	public String getUsuario(@PathVariable String nombre) {
		Usuario usuario= new UsuarioBuilder().build(nombre,null,null,null);
		counter.increment();
		return "hola "+ usuario.toString();
	}
	
	@GetMapping("/usuario")
	public ResponseEntity<Usuario> getUsuarioParam(@RequestParam String nombre) {
		Usuario usuario= new UsuarioBuilder().build(nombre,null,null,null);
		counter.increment();
		return new ResponseEntity<Usuario>(usuario , HttpStatus.OK);
	}
	
	@PostMapping("/usuario/{nombre}")
	public Usuario post(@PathVariable String nombre) {
		Usuario usuario= new UsuarioBuilder().build(nombre,null,null,null);
		listado.add(usuario);
		counter.increment();
		return usuario;
	}
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> pruebaUser() {
		counter.increment();
		return new ResponseEntity<List<Usuario>>(listado , HttpStatus.OK);
	}
}
