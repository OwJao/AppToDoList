/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ucb.aplicativo.cli;

/**
 *
 * @author JOAO
 */
import java.util.Scanner;
import java.util.ArrayList;

public class AppToDoList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> tarefas = new ArrayList<>();
        int opcao = 0; // Amazena a escolha do usuario

        System.out.println("\n? TO DO LIST \n");

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
                case 1 -> cadastrarTarefa(sc, tarefas);
                case 2 -> visualizarTarefas(tarefas);
                case 3 -> editarTarefa(sc, tarefas);
                case 4 -> excluirTarefa(sc, tarefas);
                case 5 -> marcarComoConcluida(sc, tarefas);
                case 6 -> System.out.println(" Saindo");
                default -> System.out.println("Opção inválida. Escolha de 1 a 6.");
            }
        }  // Fim do Menu While 

        sc.close(); // Apaga o Scanner
    
     }
}
