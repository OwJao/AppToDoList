/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ucb.aplicativo.cli;

/**
 *
 * @author JOAO
 */
import java.util.List;
import java.util.Scanner;
import ucb.aplicativo.control.TarefaServico;
import ucb.aplicativo.model.Tarefa;


public class AppToDoList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TarefaServico tarefaservico = new TarefaServico();
      
        int opcao = 0; // Amazena a escolha do usuario

        System.out.println("\n?------ TO DO LIST----- \n");

        while (opcao != 6) {

            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar nova tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Atualizar tarefa");
            System.out.println("4 - Remover tarefa");
            System.out.println("5 - Marcar tarefa como concluída");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpa buffer

            
           switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o Título da tarefa (obrigatório): ");
                    String titulo = sc.nextLine();

                    System.out.print("Digite a Descrição (opcional, pressione Enter para pular): ");
                    String descricao = sc.nextLine();

                    if (titulo.isBlank()) {
                        System.out.println("Erro: O título é obrigatório.");
                    } else if (descricao.isBlank()) {
                        tarefaservico.criar(titulo);
                        System.out.println("\nTarefa adicionada com sucesso!");
                    } else {
                        tarefaservico.criar(titulo, descricao);
                        System.out.println("\nTarefa adicionada com sucesso!");
                    }
                }
                    
                case 2 -> {
                    List<Tarefa> tarefas = tarefaservico.listar();
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        System.out.println("\n--- Lista de Tarefas ---");
                        for (Tarefa t : tarefas) {
                            System.out.println(t);
                        }
                        System.out.println("----------------------");
                    }
                }
                    
                case 3 -> {
                    System.out.print("Digite o ID da Tarefa para edita-la:  ");
                    Long editarId = sc.nextLong();
                    sc.nextLine();
                    
                    System.out.print("Digite o novo Título: ");
                    String novoTitulo = sc.nextLine();
                    
                    System.out.print("Digite a nova Descrição: ");
                    String novaDescricao = sc.nextLine();
                    
                    boolean editar = tarefaservico.atualizar(editarId, novoTitulo, novaDescricao, false);
                    
                    if(editar){
                        System.out.println("Tarefa editada! ");
                    } else {
                        System.out.println("A tarefa com esse ID não foi encontrada. ");
                    }
                }
                  
                case 4 -> { 
                    System.out.println("Digite o ID da tarefa para remove-la:  ");
                    Long removeId = sc.nextLong();
                    sc.nextLine();
                    
                    boolean remover = tarefaservico.remover(removeId);
                    
                    if(remover){
                        System.out.println("Tarefa Removida! ");
                    } else {
                        System.out.println("A tarefa com esse ID não foi encontrada. ");
                    }
                }
                    
                case 5 -> {
                    System.out.println("Digite o ID da tarefa para concluí-la: ");
                    Long completarId = sc.nextLong();
                    sc.nextLine();
                    
                    boolean completar = tarefaservico.completarTarefa(completarId);
                    
                    if(completar){
                        System.out.println("Tarefa Completada! ");
                    } else {
                        System.out.println("A tarefa com esse ID não foi encontrada. ");
                    }
                }
                     
                case 6 -> {
                    System.out.println("Encerrando...");
                    sc.close();
                    return;
                }
                    
                default -> System.out.println("Opção inválida. Escolha de 1 a 6.");
            }
        }  // Fim do Menu While 
    }
}
