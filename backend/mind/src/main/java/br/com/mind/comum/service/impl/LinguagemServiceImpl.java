package br.com.mind.comum.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.mind.comum.dao.LinguagemDao;
import br.com.mind.comum.domain.Linguagem;
import br.com.mind.comum.service.LinguagemService;
import br.com.mind.comum.util.Validar;

@Service
public class LinguagemServiceImpl implements LinguagemService {
	private static final Logger Log = LogManager.getLogger( LinguagemServiceImpl.class );
	
	private LinguagemDao dao;
	
	@Autowired
	public LinguagemServiceImpl( LinguagemDao dao ) {
		this.dao = dao;
	}
	
	@Override
	public ResponseEntity<Linguagem> getObj(Long id) {
		Log.info( "Start service getObj, {}", id );
		
		Optional< Linguagem > obj = dao.findById( id );
		Validar.objectNotFound( obj, id );
		
		return new ResponseEntity<>( obj.get(), HttpStatus.OK );
	}

	@Override
	public ResponseEntity<List<Linguagem>> getList() {
		Log.info( "Start service getList" );
		
		List< Linguagem > list =  dao.findAll();
		Validar.objectListNotFound( list );
		
		return new ResponseEntity<>( list, HttpStatus.OK );
	}

	@Override
	public ResponseEntity<Linguagem> save(Linguagem obj) {
		Log.info( "Start service save, {}", obj );
		
		obj = dao.save( obj );
		Validar.objectNotId( obj );
		
		return new ResponseEntity<>( obj, HttpStatus.CREATED );
	}

	@Override
	public ResponseEntity<Linguagem> update(Linguagem obj) {
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
