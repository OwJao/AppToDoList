/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author JOAO
 */
import java.time.LocalDateTime;

public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataAgora;
    private boolean completa;

    public Tarefa() {
        this.dataAgora = LocalDateTime.now();
        this.completa = false;
    }

    public Tarefa(Long id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = false;
        this.dataAgora = LocalDateTime.now();
    }

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = false;
        this.dataAgora = LocalDateTime.now();
    }

    public Tarefa(Long id, String titulo, String descricao, boolean completa, LocalDateTime dataAgora) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = completa;
        this.dataAgora = dataAgora;
    }

    @Override
    public String toString() {
        return "Tarefa {" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", completa=" + (completa ? "Sim" : "Não") +
                ", dataCriacao=" + dataAgora +
                '}';
    }
}

