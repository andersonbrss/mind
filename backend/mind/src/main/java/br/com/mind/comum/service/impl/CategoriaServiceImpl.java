package br.com.mind.comum.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.mind.comum.dao.CategoriaDao;
import br.com.mind.comum.domain.Categoria;
import br.com.mind.comum.service.CategoriaService;
import br.com.mind.comum.validacao.Validar;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	private static final Logger Log = LogManager.getLogger( CategoriaService.class );
	
	private CategoriaDao dao;
	
	@Autowired
	public CategoriaServiceImpl( CategoriaDao dao  ) {
		this.dao = dao;
	}

	@Override
	public ResponseEntity<Categoria> getObj(Long id) {
		Log.info( "Start service categoriaServiceImpl method getObj: {}", id );
		
		Optional< Categoria > categoria = dao.findById( id );
		Validar.objectNotFound( categoria, id );
		
		return new ResponseEntity< Categoria >(categoria.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Categoria>> getList() {
		Log.info( "Start service categoriaServiceImpl method getList" );
		
		List< Categoria > categoriaList = dao.findAll();
		Validar.objectListNotFound( categoriaList );
		
		return new ResponseEntity< List< Categoria >>( categoriaList, HttpStatus.OK );
	}

	@Transactional
	@Override
	public ResponseEntity<Categoria> save(Categoria obj) {
		Log.info( "Start service categoriaServiceImpl method save: {}", obj );
		
		obj = dao.save( obj );
		Validar.objectNotId( obj );
		
		return new ResponseEntity< Categoria >( obj, HttpStatus.OK );
	}

	@Override
	@Transactional
	public ResponseEntity<Categoria> update(Categoria obj) {
		Log.info( "Start service categoriaServiceImpl method update: {}", obj );
		
		Validar.objectNotId( obj );
		obj = dao.save( obj );
		
		return new ResponseEntity< Categoria >( obj, HttpStatus.OK );
	}

	@Override
	@Transactional
	public ResponseEntity<String> delete(Long id) {
		Log.info( "Start service categoriaServiceImpl method delete: {}", id );
		
		dao.deleteById( id );
		
		return new ResponseEntity< >( "Operação realizada com sucesso, objeto removido", HttpStatus.OK );
	}

}
