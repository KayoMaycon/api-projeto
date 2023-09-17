package br.com.apiecocoleta.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apiecocoleta.projeto.model.Usuario;

public interface IUsuario extends JpaRepository<Usuario, Integer>{
    public Usuario findBynomeOrEmail(String nome, String email);
}
