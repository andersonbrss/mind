package br.com.mind.comum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mind.comum.domain.Linguagem;

@Repository
public interface LinguagemDao extends JpaRepository< Linguagem, Long > {

}
