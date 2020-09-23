package br.com.mind.comum.resource;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mind.comum.domain.Linguagem;
import br.com.mind.comum.service.LinguagemService;

@CrossOrigin("*")
@RestController
@RequestMapping("/comum/linguagens")
public class LinguagemResource {
	private static final Logger Log = LogManager.getLogger( LinguagemResource.class );
	
	private LinguagemService service;
	
	@Autowired
	public LinguagemResource( LinguagemService service ) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity< List<Linguagem> > getList() {
		Log.info( "Start resource getList " );
		
		return service.getList();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity< Linguagem > getObj( @PathVariable Long id ) {
		Log.info( "Start resource getObj, {}", id );
		
		return service.getObj( id );
	}
	
	@PostMapping
	public ResponseEntity< Linguagem > save( @RequestBody Linguagem obj ) {
		Log.info( "Start resource save, {}", obj );
		
		return service.save( obj );
	}
	
	@PutMapping
	public ResponseEntity< Linguagem > update( @RequestBody Linguagem obj ) {
		Log.info( "Start resource update, {}", obj );
		
		return service.update( obj );
	}
	
	@DeleteMapping( "/{id}" )
	public ResponseEntity< String > delete( @PathVariable Long id ) {
		Log.info( "Start resource delete, {}", id );
		
		return service.delete( id );
	}
	
}
