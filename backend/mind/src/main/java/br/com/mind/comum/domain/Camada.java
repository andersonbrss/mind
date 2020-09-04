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
@Table( name = "tb_camada", schema = "db_mind" )
public class Camada extends Tabela {
	private static final long serialVersionUID = -4255510249107923798L;

	@Column( name = "nm_camada", length = 200 )
	@Size( max = 500, message = "O dado passou o limite de tamanho do campo.")
	@NotBlank( message = "O campo do nome da camada e obrigatório.")
	private String nmCamada;
	
	@Builder
	public Camada( Long id, String nmCamada ) {
		super( id );
		this.nmCamada = nmCamada;
	}
	
}
