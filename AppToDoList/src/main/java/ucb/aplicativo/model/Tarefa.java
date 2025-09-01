package modelo; // Sugestão: renomear o pacote para "modelo" também

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao; // Renomeado para maior clareza
    private boolean completa;

    public Tarefa() {
        this.dataCriacao = LocalDateTime.now();
        this.completa = false;
    }

    public Tarefa(Long id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = false;
        this.dataCriacao = LocalDateTime.now();
    }

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = false;
        this.dataCriacao = LocalDateTime.now();
    }

    public Tarefa(Long id, String titulo, String descricao, boolean completa, LocalDateTime dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = completa;
        this.dataCriacao = dataCriacao;
    }

    // --- MÉTODOS DE ACESSO (GETTERS E SETTERS) ---

    public Long obterId() {
        return id;
    }

    public void definirId(Long id) {
        this.id = id;
    }

    public String obterTitulo() {
        return titulo;
    }

    public void definirTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String obterDescricao() {
        return descricao;
    }

    public void definirDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime obterDataCriacao() {
        return dataCriacao;
    }

    public void definirDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean obterCompleta() {
        return completa;
    }

    public void definirCompleta(boolean completa) {
        this.completa = completa;
    }

    // --- FIM DOS MÉTODOS DE ACESSO ---


    public void marcarComoCompleta() {
        this.completa = true;
    }

    @Override
    public String toString() {
        // Formata a data para o padrão brasileiro para ficar mais legível
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        return "Tarefa {" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", completa=" + (completa ? "Sim" : "Não") +
                ", dataCriacao=" + dataCriacao.format(formatador) +
                '}';
    }
}