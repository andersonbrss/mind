package br.com.mind.comum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mind.comum.domain.Tipo;

@Repository
public interface TipoDao extends JpaRepository<Tipo, Long> {

}
