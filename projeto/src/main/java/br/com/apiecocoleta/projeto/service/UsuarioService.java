package br.com.apiecocoleta.projeto.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private final IUsuario repository;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuario() {
        List<Usuario> lista = repository.findAll();
        logger.info("Usuário: " + getLogado() + " Listando Usuários");
        return lista;
    }

    public Usuario criaUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        logger.info("Usuário: " + getLogado() + " Criando Usuário");
        return usuarioNovo;
    }

    public Usuario editarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        logger.info("Usuário: " + getLogado() + " Editando Usuário" + usuario.getNome());
        return usuarioNovo;
    }

    public Boolean excluirUsuario(Integer id) {
        repository.deleteById(id);
        logger.info("Usuário: " + getLogado() + " Excluindo Usuário");
        return true;
    }

    public Token gerarToken(@Valid UsuarioDto usuario) {
        Usuario user = repository.findBynomeOrEmail(usuario.getNome(), usuario.getEmail());
        if(user != null) {
            Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha());
            if(valid) {
                return new Token(TokenUtil.createToken(user));
            }
        }
        return null;
    }

    private String getLogado() {
        Authentication userLogado = SecurityContextHolder.getContext().getAuthentication();
        if(!(userLogado instanceof AnonymousAuthenticationToken)) {
            return userLogado.getName();
        }
        return "Null";
    }
}
