package br.com.mind.comum.validacao;

import java.util.List;
import java.util.Optional;

import br.com.mind.comum.domain.Categoria;
import br.com.mind.comum.domain.Tabela;
import br.com.mind.comum.exception.DataException;
import br.com.mind.comum.exception.ObjectNotFoundException;

public abstract class Validar {

	public static void objectNotFound( Optional< ? > obj, Long id ) {
		if( !obj.isPresent() ) {
			throw new ObjectNotFoundException("Nenhum registro para: " + id
					+ "" + Categoria.class.getName());
		}
	}
	
	public static void objectListNotFound( List< ? > list ) {
		if( list.isEmpty() ) {
			throw new ObjectNotFoundException( "Nenhum registro encontrado." );
		}
	}
	
	public static void objectNotSave( Tabela obj ) {
		if( obj.getId() == null ) {
			throw new DataException( "Falha ao cadastrar." );
		}
	}
	
}
