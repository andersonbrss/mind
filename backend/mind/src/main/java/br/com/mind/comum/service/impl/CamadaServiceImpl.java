package br.com.mind.comum.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.mind.comum.dao.CamadaDao;
import br.com.mind.comum.domain.Camada;
import br.com.mind.comum.service.CamadaService;
import br.com.mind.comum.validacao.Validar;

public class CamadaServiceImpl implements CamadaService {
	private static final Logger Log  = LogManager.getLogger( CamadaServiceImpl.class );
	
	private CamadaDao dao;
	
	@Autowired
	public CamadaServiceImpl( CamadaDao dao ) {
		this.dao = dao;
	}

	@Override
	public ResponseEntity<Camada> getObj(Long id) {
		Log.info( "Start service getObj, {}", id );
		
		Optional< Camada > obj = dao.findById( id );
		Validar.objectNotFound( obj, id );
		
		return new ResponseEntity<>( obj.get(), HttpStatus.OK );
	}

	@Override
	public ResponseEntity<List<Camada>> getList() {
		Log.info( "Start service getList " );
		
		List<Camada> camadaList = dao.findAll();
		Validar.objectListNotFound( camadaList );
		
		return new ResponseEntity< >( camadaList, HttpStatus.OK );
	}

	@Override
	public ResponseEntity<Camada> save(Camada obj) {
		Log.info( "Start service save, {}", obj );
		
		obj = dao.save( obj );
		Validar.objectNotId( obj );
		
		return new ResponseEntity<>( obj, HttpStatus.CREATED );
	}

	@Override
	public ResponseEntity<Camada> update(Camada obj) {
		Log.info( "Start service update, {}", obj );
		
		Validar.objectNotId( obj );
		dao.save( obj );
		
		return new ResponseEntity<>( obj, HttpStatus.OK );
	}

	@Override
	public ResponseEntity<String> delete(Long id) {
		Log.info( "Start service delete, {}", id );
		
		dao.deleteById( id );
		
		return new ResponseEntity<>( "Operação realizada com sucesso, registro removido.", HttpStatus.OK );
	}

}
