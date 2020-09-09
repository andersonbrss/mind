package br.com.mind.comum.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "tb_tipo", schema = "db_mind" )
public class Tipo extends Tabela {
	private static final long serialVersionUID = 3709890179787936596L;
	
	@Column( name = "nm_tipo", length = 200 )
	@Size( max = 200, message = "O campo nome do tipo passou o limite de tamanho." )
	@NotBlank( message = "O campo nome do tipo e obrigatório." )
	private String nmTipo;
	
	@Builder
	public Tipo( Long id, String nmTipo ) {
		super( id );
		this.nmTipo = nmTipo;
	}
	
}
