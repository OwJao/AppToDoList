/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.control;

import java.util.List; /*Modelo de lista*/
import java.util.ArrayList; /*Implementar o List*/
import java.util.Collections; /*Dica da IA para evitar que usem, por exemplo, "tarefa.add(...)" fora do Control.*/
import ucb.aplicativo.model.Tarefa; /*Importando dados passados pela Tarefa*/

/**
 *
 * @author JOAO
 */
public class TarefaServico {
    private final List<Tarefa> tarefas = new ArrayList<>();
    private Long idAutomatico = 1L; /*Quero que comece a contar pelo 1*/
    
    public Tarefa criar(String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(idAutomatico++, titulo, descricao);
        tarefas.add(tarefa);
        return tarefa;
    }
    
    public Tarefa criar(String titulo) {
        return criar(titulo, "Sem descrição");
    }
    
    public List<Tarefa> listar() {
        return Collections.unmodifiableList(tarefas);
    }
    
    public boolean atualizar(Long id, String novoTitulo, String novaDescricao, boolean completa) {
        for (Tarefa t : tarefas) {
            if (t.getId().equals(id)) {
                t.setTitulo(novoTitulo);
                t.setDescricao(novaDescricao);
                t.setCompleta(completa);
                return true;
            }
        }
        return false;
    
   }
   public boolean remover(Long id) {
        return tarefas.removeIf(t -> t.getId().equals(id));
    }
   
   public boolean completarTarefa(Long id) {
        for (Tarefa t : tarefas) {
            if (t.getId().equals(id)) {
                t.setCompleta(true); // apenas altero o status para 'true'
                return true;
            }
        }
        return false; // retorna false se não encontrar a tarefa informada
    }
}


    

