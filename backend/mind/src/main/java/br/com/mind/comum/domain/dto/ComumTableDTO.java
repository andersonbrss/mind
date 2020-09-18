package br.com.mind.comum.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComumTableDTO {

	private Long id;
	private String nmCategoria;
	private String tabela;
	
}
