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

        while (opcao != 6) {

            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar nova tarefa");
            System.out.println("2 - Visualizar tarefas");
            System.out.println("3 - Editar tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Marcar tarefa como concluída");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpa buffer

            
           switch (opcao) {
                case 1 : 
                    System.out.print("Digite o Título:  ");
                    String titulo = sc.nextLine();
                    
                    System.out.print("Digite a Descrição:  ");
                    String descricao = sc.nextLine();
                    
                    Tarefa tarefa = new Tarefa(titulo, descricao);
                    TarefaServico.adicionarTarefa(tarefa);
                    
                    System.out.println("Nova Tarefa Adiconada Com Sucesso!!");
                    break;
                    
                case 2 :
                    TarefaServico.listarTarefa();
                    break;
                    
                case 3 :
                    System.out.print("Digite o ID da Tarefa para edita-la:  ");
                    int editarId = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Digite o novo Título: ");
                    String novoTitulo = sc.nextLine();
                    
                     System.out.print("Digite a nova Descrição: ");
                    String novaDescricao = sc.nextLine();
                    
                    boolean editar = TarefaServico.editarTarefa(editarId, novoTitulo, novaDescricao);
                    
                    if(editar){
                        System.out.println("Tarefa editada! ");
                    } else {
                        System.out.println("A tarefa com esse ID não foi encontrada. ");
                    }
                    break;
                  
                case 4: 
                    System.out.println("Digite o ID da tarefa para remove-la:  ");
                    int removeId = sc.nextInt();
                    sc.nextLine();
                    
                    boolean remover = TarefaServico.removerTarefa(removeId);
                    
                    if(remove){
                        System.out.println("Tarefa Removida! ");
                    } else {
                        System.out.println("A tarefa com esse ID não foi encontrada. ");
                    }
                    break;
                    
                case 5:
                    System.out.println("Digite o ID da tarefa pa conclui-la: ");
                    int complatar = sc.nextInt();
                    sc.nextLine();
                    
                    boolean completar = TarefaServico.completarTarefa(completar);
                    
                    if(completar){
                        System.out.println("Tarefa Removida! ");
                    } else {
                        System.out.println("A tarefa com esse ID não foi encontrada. ");
                    }
                    break;
                     
                case 6 :
                    System.out.println("Encerrando...");
                    sc.close(); 
               
                    break;
                    
                default:  System.out.println("Opção inválida. Escolha de 1 a 6.");
            }
        }  // Fim do Menu While 
    }
}
