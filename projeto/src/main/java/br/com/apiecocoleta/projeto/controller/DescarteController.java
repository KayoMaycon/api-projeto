package br.com.apiecocoleta.projeto.controller;
/* 
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apiecocoleta.projeto.model.Descarte;
import br.com.apiecocoleta.projeto.service.DescarteService;

@RestController
@CrossOrigin("*")
@RequestMapping("/descartes")
public class DescarteController {

    private DescarteService descarteService;

    public DescarteController(DescarteService descarteService) {
        this.descarteService = descarteService;
    }

    @GetMapping
    public ResponseEntity<List<Descarte>> listarDescartes() {
        return ResponseEntity.status(200).body(descarteService.listarDescarte());
    }

    @PostMapping
    public ResponseEntity<Descarte> criarDescartes(@RequestBody Descarte descarte) {
        return ResponseEntity.status(201).body(descarteService.criarDescarte(descarte));
    }

    @PutMapping
    public ResponseEntity<Descarte> editarDescartes(@RequestBody Descarte descarte) {
        return ResponseEntity.status(200).body(descarteService.editarDescarte(descarte));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirDescartes(@PathVariable Integer id) {
        descarteService.excluirDescarte(id);
        return ResponseEntity.status(204).build();
    }

}*/
