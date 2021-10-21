package com.nttdata.bootcamp.retopromethus.actuator;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.nttdata.bootcamp.retopromethus.builder.UsuarioBuilder;
import com.nttdata.bootcamp.retopromethus.repository.Usuario;

@Component
@RestControllerEndpoint(id= "customRetoEndPoint")
public class CustomActuator {
	
	@GetMapping("/usuario")
	public ResponseEntity<Usuario> getUsuarioEndpoint(){
		Usuario usuario= new UsuarioBuilder().build("Pepe", "Colanda", "945089283", "La Laguna");
		
		return new ResponseEntity<Usuario>(usuario , HttpStatus.OK);
		
	}
}
