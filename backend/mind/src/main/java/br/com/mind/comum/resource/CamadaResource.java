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

import br.com.mind.comum.domain.Camada;
import br.com.mind.comum.service.CamadaService;

@CrossOrigin("*")
@RestController
@RequestMapping( "/comum/camadas" )
public class CamadaResource {
	private static final Logger Log = LogManager.getLogger( CamadaResource.class );
	
	private CamadaService service;
	
	@Autowired
	public CamadaResource( CamadaService service ) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity< List<Camada> > getList() {
		Log.info( "Start resource getList" );
		
		return service.getList();
	}
	
	@GetMapping( "/{id}" )
	public ResponseEntity< Camada > getCamada( @PathVariable("id") Long id ) {
		Log.info( "Start resource getCamada, {}", id );
		
		return service.getObj( id );
	}
	
	@PostMapping
	public ResponseEntity< Camada > save( @RequestBody Camada camada ) {
		Log.info( "Start resource save, {}", camada );
		
		return service.save( camada );
	}
	
	@PutMapping
	public ResponseEntity< Camada > update( @RequestBody Camada camada ) {
		Log.info( "Start resource update, {}", camada );
		
		return service.update( camada );
	}
	
	@DeleteMapping( "/{id}" )
	public ResponseEntity< String > delete( @PathVariable Long id ) {
		Log.info( "Start resource delete, {}", id );
		
		return service.delete( id );
	}
}
