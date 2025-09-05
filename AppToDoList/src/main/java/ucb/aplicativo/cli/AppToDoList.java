/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ucb.aplicativo.cli;

/**
 *
 * @author JOAO
 */
import java.util.Scanner;
import ucb.aplicativo.control.TarefaServico;
import ucb.aplicativo.model.Tarefa;


public class AppToDoList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TarefaServico tarefaservico = new TarefaServico();
      
        int opcao = 0; // Amazena a escolha do usuario

        System.out.println("\n?------ TO DO LIST----- \n");

        while (opcao != 7) {

            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar nova tarefa");
            System.out.println("2 - Visualizar tarefas");
            System.out.println("3 - Editar tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Marcar tarefa como concluída");
            System.out.println("6 - Visualizar tarefas concluídas");
             System.out.println("7 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpa buffer

            
           switch (opcao) {
                case 1 : 
                    System.out.print("Digite o Título:  ");
                    String titulo = sc.nextLine();
                    
                    System.out.print("Digite a Descrição:  ");
                    String descricao = sc.nextLine();
                    
                    Tarefa tarefa = tarefaservico.criar(titulo, descricao);
                    
                    
                    System.out.println("Nova Tarefa Adiconada Com Sucesso!!" + tarefa.obterId());
                    break;
                    
                case 2 :
                   
                    List<Tarefa> TarefaServico = tarefaservico.listar();
                    
                    if (tarefaservico.isEmpty()){
                        System.out.println("Nenhama tarefa cadastrada.");
                    } else {
                        System.out.println("-----Lista de Tarefas-----");
                        for (Tarefa t : TarefaServico){
                            System.out.println("ID: " + t.obterId());
                            System.out.println("Titulo: " + t.getTitulo());
                            System.out.println("Descrição:  " + t.getDescricao());
                            System.out.println("Data de Criação: " + t.getdataAgoraFormatadapt());
                            System.out.println("----------------------------" );
                        }
                    }
                    break;
                    
                case 3 :
                    System.out.print("Digite o ID da Tarefa para edita-la:  ");
                    long editarId = sc.nextLong();
                    sc.nextLine();
                    
                    System.out.print("Digite o novo Título: ");
                    String novoTitulo = sc.nextLine();
                    
                     System.out.print("Digite a nova Descrição: ");
                    String novaDescricao = sc.nextLine();
                    
                    boolean editou = tarefaservico.atualizar(editarId, novoTitulo, novaDescricao, false);
                    
                    if(editou){
                        System.out.println("Tarefa editada! ");
                    } else {
                        System.out.println("A tarefa com esse ID não foi encontrada. ");
                    }
                    break;
                  
                case 4: 
                    System.out.println("Digite o ID da tarefa para remove-la:  ");
                    long removeId = sc.nextLong();
                    sc.nextLine();
                    
                    boolean removido = tarefaservico.remover(removeId);
                    
                    if(removido){
                        System.out.println("Tarefa Removida! ");
                    } else {
                        System.out.println("A tarefa com esse ID não foi encontrada. ");
                    }
                    break;
                    
                case 5:
                    System.out.println("Digite o ID da tarefa pa conclui-la: ");
                    long complatarId = sc.nextLong();
                    sc.nextLine();
                    
                    boolean completou = tarefaservico.atualizar(completarId);
                    
                    if(completou){
                        System.out.println("Tarefa Concluida! ");
                    } else {
                        System.out.println("A tarefa com esse ID não foi encontrada. ");
                    }
                    break;
                     
                case 6 :
                    
                    break;
                    
                case 7 :
                    System.out.println("Encerrando...");
                    sc.close(); 
               
                    break
                    
                default:  System.out.println("Opção inválida. Escolha de 1 a 7.");
            }
        }  // Fim do Menu While 
    }
}
