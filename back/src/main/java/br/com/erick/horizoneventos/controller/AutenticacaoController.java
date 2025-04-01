package br.com.erick.horizoneventos.controller;

import br.com.erick.horizoneventos.dto.UsuarioDTO;
import br.com.erick.horizoneventos.model.Usuario;
import br.com.erick.horizoneventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private EventoService service;

    @PostMapping("/registrar")
    public void cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = service.cadastrarUsuario(usuarioDTO);
    }

}
