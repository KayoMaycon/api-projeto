package br.com.apiecocoleta.projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.apiecocoleta.projeto.model.Descarte;
import br.com.apiecocoleta.projeto.repository.IDescarte;

@Service
public class DescarteService {
    private IDescarte repository;

    public DescarteService(IDescarte repository) {
        this.repository = repository;
    }

    public List<Descarte> listarDescarte() {
        List<Descarte> lista = repository.findAll();
        return lista;
    }

    public Descarte criarDescarte(Descarte descarte) {
        Descarte novoDescarte = repository.save(descarte);
        return novoDescarte;
    }

    public Descarte editarDescarte(Descarte descarte) {
        Descarte novoDescarte = repository.save(descarte);
        return novoDescarte;
    }

    public Boolean excluirDescarte(Integer id) {
        repository.deleteById(id);
        return true;
    }


    
}
