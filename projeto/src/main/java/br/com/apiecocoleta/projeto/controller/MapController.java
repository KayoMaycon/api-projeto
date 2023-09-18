package br.com.apiecocoleta.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {
    
    @GetMapping("/showMap")
    public String mapa() {
        return "mapa";
    }
}
