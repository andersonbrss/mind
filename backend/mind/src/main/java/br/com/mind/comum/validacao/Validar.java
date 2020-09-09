package br.com.mind.comum.validacao;

import java.util.List;
import java.util.Optional;

import br.com.mind.comum.domain.Tabela;
import br.com.mind.comum.exception.DataException;
import br.com.mind.comum.exception.ObjectNotFoundException;
import br.com.mind.comum.util.Log;

public abstract class Validar {

	public static void objectNotFound( Optional< ? > obj, Long id ) {
		if( !obj.isPresent() ) {
			Log.error( "Error objeto não encontrado: " + obj.getClass().getName() + ", id: " + id );
			throw new ObjectNotFoundException("Nenhum registro para: " + id );
		}
	}
	
	public static void objectListNotFound( List< ? > list ) {
		if( list.isEmpty() ) {
			throw new ObjectNotFoundException( "Nenhum registro encontrado." );
		}
	}
	
	public static void objectNotId( Tabela obj ) {
		if( obj.getId() == null ) {
			Log.error( "Error ao salvar objeto: " + obj.getClass().getName() );
			throw new DataException( "Falha ao cadastrar." );
		}
	}
	
}
