package br.com.mind.comum.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.mind.comum.dao.TipoDao;
import br.com.mind.comum.domain.Tipo;
import br.com.mind.comum.service.TipoService;
import br.com.mind.comum.validacao.Validar;

public class TipoServiceImpl implements TipoService {
	private static final Logger Log = LogManager.getLogger( TipoServiceImpl.class );

	private TipoDao dao;
	
	@Autowired
	public TipoServiceImpl( TipoDao dao ) {
		this.dao = dao;
	}
	
	@Override
	public ResponseEntity<Tipo> getObj(Long id) {
		Log.info( "Start service getObj, {}", id );
		
		Optional< Tipo > obj = dao.findById( id );
		Validar.objectNotFound( obj, id );
		
		return new ResponseEntity< >( obj.get(), HttpStatus.OK );
	}

	@Override
	public ResponseEntity<List<Tipo>> getList() {
		Log.info( "Start service getList" );
		
		List<Tipo> list = dao.findAll();
		Validar.objectListNotFound( list );
		
		return new ResponseEntity<>( list, HttpStatus.OK );
	}

	@Override
	public ResponseEntity<Tipo> save(Tipo obj) {
		Log.info( "Start service save, {}", obj );
		
		obj = dao.save( obj );
		Validar.objectNotId( obj );
		
		return new ResponseEntity<>( obj, HttpStatus.CREATED );
	}

	@Override
	public ResponseEntity<Tipo> update(Tipo obj) {
		Log.info( "Start service update, {}", obj );
		
		Validar.objectNotId( obj );
		obj = dao.save( obj );
		
		return new ResponseEntity<>( obj, HttpStatus.OK );
	}

	@Override
	public ResponseEntity<String> delete(Long id) {
		Log.info( "Start service delete, {}", id );
		
		dao.deleteById( id );
		
		return new ResponseEntity<>( "Registro removido com sucesso.", HttpStatus.OK );
	}

}
