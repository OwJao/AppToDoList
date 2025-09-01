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
    private int idAutomatico = 1; /*Quero que comece a contar pelo 1*/
    
    public Tarefa criar(String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(idAutomatico++, titulo, descricao);
        tarefas.add(tarefa);
        return tarefa;
    }
    
    public List<Tarefa> listar() {
        return Collections.unmodifiableList(tarefas);
    }
    
}
