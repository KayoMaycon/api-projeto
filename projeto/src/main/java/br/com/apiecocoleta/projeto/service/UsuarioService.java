package br.com.apiecocoleta.projeto.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.apiecocoleta.projeto.dto.UsuarioDto;
import br.com.apiecocoleta.projeto.model.Usuario;

import br.com.apiecocoleta.projeto.repository.IUsuario;
import br.com.apiecocoleta.projeto.security.Token;
import br.com.apiecocoleta.projeto.security.TokenUtil;
import jakarta.validation.Valid;

@Service
public class UsuarioService {

    private IUsuario repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuario() {
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criaUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }

    public Usuario editarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }

    public Boolean excluirUsuario(Integer id) {
        repository.deleteById(id);
        return true;
    }

    public Boolean validarSenha(Usuario usuario) {
        String senha = repository.getReferenceById(usuario.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        return valid;
    }

    public Token gerarToken(@Valid UsuarioDto usuario) {
        Usuario user = repository.findBynomeOrEmail(usuario.getNome(), usuario.getEmail());
        if(user != null) {
            Boolean valid = passwordEncoder.matches(usuario.getSenha(), usuario.getSenha());
            if(valid) {
                return new Token(TokenUtil.createToken(user));
            }
        }
        return null;
    }
}
