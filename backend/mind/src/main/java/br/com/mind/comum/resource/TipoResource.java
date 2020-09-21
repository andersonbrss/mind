package br.com.mind.comum.resource;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.mind.comum.domain.Tipo;
import br.com.mind.comum.service.TipoService;

public class TipoResource {
	private static final Logger Log = LogManager.getLogger( TipoResource.class );
	
	private TipoService service;
	
	@Autowired
	public TipoResource( TipoService service ) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity< List<Tipo> > getList() {
		Log.info( "Start resource getList" );
		
		return service.getList();
	}
	
	@GetMapping( "/{id}" )
	public ResponseEntity< Tipo > getTipo( @PathVariable Long id ) {
		Log.info( "Start resource getTipo, {}", id );
		
		return service.getObj( id );
	}
	
	@PostMapping
	public ResponseEntity< Tipo > save( @RequestBody Tipo obj ) {
		Log.info( "Start resource save, {}", obj );
		
		return service.save( obj );
	}
	
	@PutMapping
	public ResponseEntity< Tipo > update( @RequestBody Tipo obj ) {
		Log.info( "Start resource update, {}", obj );
		
		return service.update( obj );
	}
	
	@DeleteMapping( "/{id}" )
	public ResponseEntity< String > delete( @PathVariable Long id ) {
		Log.info( "Start resource delete, {}", id );
		
		return service.delete( id );
	}
	
}
