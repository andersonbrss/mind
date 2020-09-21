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

import br.com.mind.comum.domain.Categoria;
import br.com.mind.comum.service.CategoriaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/comum/categoria")
public class CategoriaResource {
	private static final Logger Log = LogManager.getLogger(CategoriaResource.class.getName());

	private CategoriaService service;
	
	@Autowired
	public CategoriaResource( CategoriaService service ) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity< List<Categoria> > getList() {
		Log.info( "Start resource getList from categoria " );
		
		return service.getList();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity< Categoria > getCategoria( @PathVariable("id") Long id ) {
		Log.info( "Start resource getCategoria from id categoria: {}", id );
		
		return service.getObj( id );
	}
	
	@PostMapping
	public ResponseEntity< Categoria > save( @RequestBody Categoria categoria ) {
		Log.info( "Start resource save from categoria: {}", categoria );
		
		return service.save( categoria );
	}
	
	@PutMapping
	public ResponseEntity< Categoria > update( @RequestBody Categoria categoria ) {
		Log.info( "Start resource update from categoria: {}", categoria );
		
		return service.update( categoria );
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity< String > delete( @PathVariable Long id ) {
		Log.info( "Start resouce delete from id categoria: {}", id );
		
		return service.delete( id );
	}
	
}

//Class<?> clazz =  Class.forName( comum.getTabela() );
//obj = (Tabela) clazz.getConstructor().newInstance( comum.getId(), comum.getNmCategoria() );
