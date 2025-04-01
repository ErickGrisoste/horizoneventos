package br.com.erick.horizoneventos.service;

import br.com.erick.horizoneventos.dto.UsuarioDTO;
import br.com.erick.horizoneventos.model.Evento;
import br.com.erick.horizoneventos.model.Usuario;
import br.com.erick.horizoneventos.repository.EventoRepository;
import br.com.erick.horizoneventos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Evento criarEvento(Evento evento, Long usuarioId){
        Usuario host = usuarioRepository.findById(usuarioId)
                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        evento.setHost(host);
        return eventoRepository.save(evento);
    }

    public Usuario cadastrarUsuario(UsuarioDTO usuarioDTO){
        if(usuarioRepository.findByEmailContainingIgnoreCase(usuarioDTO.email()).isPresent()){
            throw new RuntimeException("Email já cadastrado!");
        } else {
            Usuario usuario = new Usuario();
            usuario.setEmail(usuarioDTO.email());
            usuario.setNome(usuarioDTO.nome());
            usuario.setSenha(usuarioDTO.senha());

            return usuarioRepository.save(usuario);
        }
    }



}
