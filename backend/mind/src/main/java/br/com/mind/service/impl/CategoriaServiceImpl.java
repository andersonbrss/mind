package br.com.mind.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.mind.comum.domain.Categoria;
import br.com.mind.comum.util.Log;
import br.com.mind.comum.validacao.Validar;
import br.com.mind.dao.CategoriaDao;
import br.com.mind.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaDao dao;
	
	@Autowired
	public CategoriaServiceImpl( CategoriaDao dao  ) {
		this.dao = dao;
	}

	@Override
	public ResponseEntity<Categoria> getObj(Long id) {
		Log.info( "CategoriaServiceImpl method getObj: " + id );
		
		Optional< Categoria > categoria = dao.findById( id );
		Validar.objectNotFound( categoria, id );
		
		return new ResponseEntity< Categoria >(categoria.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Categoria>> getList() {
		Log.info( "CategoriaServiceImpl method getList" );
		
		List< Categoria > categoriaList = dao.findAll();
		Validar.objectListNotFound( categoriaList );
		
		return new ResponseEntity< List< Categoria >>( categoriaList, HttpStatus.OK );
	}

	@Transactional
	@Override
	public ResponseEntity<Categoria> save(Categoria obj) {
		Log.info( "CategoriaServiceImpl method save: " + obj );
		
		obj = dao.save( obj );
		Validar.objectNotSave( obj );
		
		return new ResponseEntity< Categoria >( obj, HttpStatus.OK );
	}

	@Override
	public ResponseEntity<Categoria> update(Categoria obj) {
		Log.info( "CategoriaServiceImpl method update: " + obj );
		
		return null;
	}

	@Override
	public ResponseEntity<String> delete(Long id) {
		Log.info( "CategoriaServiceImpl method delete: " + id );
		
		return null;
	}

}
