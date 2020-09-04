package br.com.mind.comum.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface AbstractService< E > {

	ResponseEntity< E > getObj( Long id );
	
	ResponseEntity< List< E >> getList();
	
	ResponseEntity< E > save( E obj );
	
	ResponseEntity< E > update( E obj );
	
	ResponseEntity< String > delete( Long id );
	
}
