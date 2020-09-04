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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "tb_linguagem", schema = "db_mind" )
public class Linguagem extends Tabela {
	private static final long serialVersionUID = 7092197955025519594L;

	@Column( name = "nm_linguagem", length = 200 )
	@Size( max = 500, message = "O campo nome da linguagem passaou o limite de tamanho." )
	@NotBlank( message = "O campo nome da linguagem e obrigatório." )
	private String nmLinguagem;
	
	@Builder
	public Linguagem( Long id, String nmLinguagem ) {
		super( id );
		this.nmLinguagem = nmLinguagem;
	}
}
