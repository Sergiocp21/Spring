package org.servlets.primerproyecto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
    @GetMapping("/saludo")
    public String saludoBasico() {
        return "Hola";
    }
}
