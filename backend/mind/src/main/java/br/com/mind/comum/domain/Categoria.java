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
@Table( name = "tb_categoria", schema = "db_mind" )
public class Categoria extends Tabela {
	private static final long serialVersionUID = -9026128325469435482L;
	
	@NotBlank( message = "O campo do nome e obrigatório." )
	@Size( max = 500, message = "O dado passou o limite de tamanho do campo." )
	@Column( name = "nm_categoria", length = 500)
	private String nmCategoria;

	@Builder
	public Categoria( Long id, String nmCategoria ) {
		super( id );
		this.nmCategoria = nmCategoria;
	}
	
}
