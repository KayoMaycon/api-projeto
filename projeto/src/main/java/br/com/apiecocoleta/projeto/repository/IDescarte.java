package br.com.apiecocoleta.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apiecocoleta.projeto.model.Descarte;

public interface IDescarte extends JpaRepository<Descarte, Integer>{
    
}
