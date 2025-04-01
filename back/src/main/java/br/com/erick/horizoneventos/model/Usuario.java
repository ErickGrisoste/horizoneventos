package br.com.erick.horizoneventos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String telefone;
    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Evento> eventosCriados;
    @ManyToMany
    private List<Evento> eventosInscritos;
    @Column(unique = true)
    private String email;
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Evento> getEventosCriados() {
        return eventosCriados;
    }

    public void setEventosCriados(List<Evento> eventosCriados) {
        this.eventosCriados = eventosCriados;
    }

    public List<Evento> getEventosInscritos() {
        return eventosInscritos;
    }

    public void setEventosInscritos(List<Evento> eventosInscritos) {
        this.eventosInscritos = eventosInscritos;
    }
}
